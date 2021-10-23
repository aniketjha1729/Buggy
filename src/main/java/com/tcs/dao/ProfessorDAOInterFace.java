/**
 * 
 */
package com.tcs.dao;

import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
public interface ProfessorDAOInterFace {
	/**
	 * Professor registring using SQL commands
	 * @param professor
	 * @throws ProfessorNotRegisteredException 
	 */
	public boolean addProfessor(Professor professor) throws StudentNotRegisteredException;
	
	
	/**
	 * Professor login using SQL commands
	 * @param professorEmail
	 * @param professorPasword
	 * @throws UserNotFoundException 
	 */
	public boolean professorLogin(String professorEmail, String professorPasword) throws UserNotFoundException;
}
