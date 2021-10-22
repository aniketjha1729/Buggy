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
	public boolean addProfessor(Professor professor) throws StudentNotRegisteredException;
	public boolean professorLogin(String professorEmail, String professorPasword) throws UserNotFoundException;
}
