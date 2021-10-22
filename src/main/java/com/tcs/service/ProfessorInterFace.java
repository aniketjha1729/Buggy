/**
 * 
 */
package com.tcs.service;

import com.tcs.bean.Professor;
import com.tcs.exception.StudentNotRegisteredException;

/**
 * @author Aniket
 *
 */
public interface ProfessorInterFace {

	void addProfessor(Professor professor) throws StudentNotRegisteredException; ;

}
