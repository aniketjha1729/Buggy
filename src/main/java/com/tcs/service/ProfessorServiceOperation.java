/**
 * 
 */
package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Professor;
import com.tcs.dao.ProfessorDAOInterFace;
import com.tcs.dao.StudentDAOInterFace;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
@Component
public class ProfessorServiceOperation implements ProfessorInterFace {

	@Autowired
	private ProfessorDAOInterFace professors;

	@Override
	public void addProfessor(Professor professor) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		try {
			professors.addProfessor(professor);
		} catch (StudentNotRegisteredException ex) {
			throw ex;
		}
	}

	@Override
	public boolean loginProfessor(String professorEmail, String professorPasword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return professors.professorLogin(professorEmail, professorPasword);
	}

	@Override
	public String addGrade(int studentId, int courseId, String grade) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return professors.addGrade(studentId,courseId,grade);
	}
}
