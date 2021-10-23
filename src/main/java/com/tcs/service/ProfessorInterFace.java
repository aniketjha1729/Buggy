/**
 * 
 */
package com.tcs.service;

import com.tcs.bean.Professor;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
public interface ProfessorInterFace {
	/**
	 * Professor registring using SQL commands
	 * @param professor
	 * @throws ProfessorNotRegisteredException 
	 */
	void addProfessor(Professor professor) throws StudentNotRegisteredException;
	
	
	
	/**
	 * Professor login using SQL commands
	 * @param professorEmail
	 * @param professorPasword
	 * @throws UserNotFoundException 
	 */
	boolean loginProfessor(String professorEmail, String professorPasword) throws UserNotFoundException ;

}
