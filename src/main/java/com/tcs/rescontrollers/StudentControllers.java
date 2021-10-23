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
import com.tcs.exception.StudentNotRegisteredException;
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
	
	
	/**
	 * Student registring using SQL commands
	 * @param student
	 */
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
	
	
	
	
	/**
	 * Students listing all peers login using SQL commands
	 * @throws SQLException 
	 */
	@RequestMapping(method=RequestMethod.GET,value="/students")
	public List getStudents() throws SQLException {
		return students.getAllStudents();
	}
	
	
	
	/**
	 * Sudents can see their profile SQL commands
	 * @param SQLException
	 * @throws SQLException 
	 */
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ResponseEntity getCustomer(@PathVariable("id") int id) throws SQLException {
		Student studentId = students.getStudentById(id);
		if (studentId == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(studentId, HttpStatus.OK);
	}
	
	
	
	
	/**
	 * Student can delete Profile  using SQL commands
	 * @param id
	 * @throws SQLException 
	 */
	@RequestMapping(value="/delete/student/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable int id) throws SQLException {
		Student stud = students.deleteStudent(id);
		if (null == stud) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	
	
	
	/**
	 * Stduent updating using SQL commands
	 * @param id
	 * @param student
	 * @throws SQLException 
	 */
	@RequestMapping(value="/update/student/{id}",method=RequestMethod.PUT)
	public ResponseEntity updateCustomer(@PathVariable int id, @RequestBody Student student) throws SQLException {
		Student updateInfoStudent = students.updateStudent(id, student);
		if (null == updateInfoStudent) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student, HttpStatus.OK);
	}
	
	
	
	
	/**
	 * Student  login using SQL commands
	 * @param studentEmail
	 * @param studentPassword
	 * @throws UserNotFoundException 
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity loginStudent(@QueryParam("studentEmail") String studentEmail,@QueryParam("studentPassword") String studentPassword) throws UserNotFoundException {
		boolean loginStatus = students.loginStudent(studentEmail, studentPassword);
		if (loginStatus) {	
			return new ResponseEntity("Login Successful", HttpStatus.OK);
		}else {
			return new ResponseEntity("User Name or Password is incorrect ", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	/**
	 * Student Registring for new Course using SQL commands
	 * @param studentId
	 * @param courseId
	 */
	@RequestMapping(value="/student/addCourse",method=RequestMethod.POST)
	public Response registerForCourse(@QueryParam("studentId") int studentId,@QueryParam("courseId") int courseId) {
		try{
			students.registerForCourse(studentId,courseId);
		}catch(Exception ex){
			System.out.println(ex);
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		return Response.status(201).entity("Registration Successful for "+studentId).build(); 
	}
	
	
	
	
	/**
	 * Students can view his/her registered courses  SQL commands
	 * @param studentId
	 * @throws SQLException 
	 */
	@RequestMapping(value="/student/mycourse",method=RequestMethod.GET)
	public List getMyCourses(@QueryParam("studentId") int studentId) throws SQLException {
		return students.getMyCourses(studentId);
	}
}
