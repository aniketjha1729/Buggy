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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Student;
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
	
	
	@GetMapping("/customers")
	public int getCustomers() {
	return 0;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/users",consumes = {
	        "application/JSON"})
	public Response register(@RequestBody  Student student){
		try{
			System.out.println(student.toString());
			students.addStudent(student);
		}catch(Exception ex){
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		return Response.status(201).entity("Registration Successful for "+student.getStudentId()).build(); 
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public List getStudents() throws SQLException {
		return students.getAllStudents();
	}
}
