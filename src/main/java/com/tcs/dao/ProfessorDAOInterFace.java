/**
 * 
 */
package com.tcs.dao;

import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.exception.StudentNotRegisteredException;

/**
 * @author Aniket
 *
 */
public interface ProfessorDAOInterFace {
	public boolean addProfessor(Professor professor) throws StudentNotRegisteredException;

}
