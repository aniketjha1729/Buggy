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

	void addProfessor(Professor professor) throws StudentNotRegisteredException;
	boolean loginProfessor(String professorEmail, String professorPasword) throws UserNotFoundException ;

}
