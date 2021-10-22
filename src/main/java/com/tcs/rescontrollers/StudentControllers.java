/**
 * 
 */
package com.tcs.rescontrollers;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Student;
import com.tcs.exception.UserNotFoundException;
import com.tcs.service.StudentInterFace;


/**
 * @author Aniket
 *
 */
@RestController
@CrossOrigin
public class StudentControllers {
	
	@Autowired
	private StudentInterFace students;
	
	@RequestMapping(method = RequestMethod.POST,value = "/students",consumes = {
	        "application/JSON"})
	public Response register(@RequestBody  Student student){
		try{
			System.out.println(student.toString());
			students.addStudent(student);
		}catch(Exception ex){
			System.out.println(ex);
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		return Response.status(201).entity("Registration Successful for "+student.getStudentId()).build(); 
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/students")
	public List getStudents() throws SQLException {
		return students.getAllStudents();
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ResponseEntity getCustomer(@PathVariable("id") int id) throws SQLException {

		Student studentId = students.getStudentById(id);
		if (studentId == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(studentId, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/student/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable int id) throws SQLException {
		Student stud = students.deleteStudent(id);
		if (null == stud) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/student/{id}",method=RequestMethod.PUT)
	public ResponseEntity updateCustomer(@PathVariable int id, @RequestBody Student student) throws SQLException {
		Student updateInfoStudent = students.updateStudent(id, student);
		if (null == updateInfoStudent) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity loginStudent(@QueryParam("studentEmail") String studentEmail,@QueryParam("studentPassword") String studentPassword) throws UserNotFoundException {
		boolean loginStatus = students.loginStudent(studentEmail, studentPassword);
//		System.out.println(studentEmail+" "+studentPassword);
		if (loginStatus) {	
			return new ResponseEntity("Login Successful", HttpStatus.OK);
		}else {
			return new ResponseEntity("User Name or Password is incorrect ", HttpStatus.NOT_FOUND);
		}
	}
}
