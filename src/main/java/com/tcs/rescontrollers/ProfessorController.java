/**
 * 
 */
package com.tcs.rescontrollers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.service.ProfessorInterFace;
import com.tcs.service.StudentInterFace;

/**
 * @author Aniket
 *
 */
@RestController
@CrossOrigin
public class ProfessorController {
	
	@Autowired
	private ProfessorInterFace professors;
	
	@RequestMapping(method = RequestMethod.POST,value = "/professor",consumes = {
    "application/JSON"})
	public Response registerProfessor(@RequestBody  Professor professor){
		try{
			System.out.println(professor.toString());
			professors.addProfessor(professor);
		}catch(Exception ex){
			System.out.println(ex);
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		return Response.status(201).entity("Registration Successful for "+professor.getProfessorId()).build(); 
	}
}
