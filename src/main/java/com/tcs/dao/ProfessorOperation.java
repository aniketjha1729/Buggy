/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.tcs.bean.Professor;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.utils.DBUtils;

/**
 * @author Aniket
 *
 */
@Repository
public class ProfessorOperation implements ProfessorDAOInterFace {

	@Override
	public boolean addProfessor(Professor professor) throws StudentNotRegisteredException {
		Connection connection = DBUtils.getConnection();
		// TODO Auto-generated method stub
		try {
			System.out.println(professor.toString());	
//			System.out.println(student.getStudentId()+""+student.getStudentDept()+""+student.getStudentName());
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);
			preparedStatement.setInt(1, professor.getProfessorId());
			preparedStatement.setString(2, professor.getProfessorDept());
			preparedStatement.setString(3, professor.getProfessorName());
			preparedStatement.setString(4, professor.getProfessorEmail());
			preparedStatement.setString(5, professor.getProfessorMobile());
			preparedStatement.setString(6, professor.getProfessorPasword());
			System.out.println(preparedStatement);
			int rowAffected=preparedStatement.executeUpdate();
			System.out.println(rowAffected);
		} catch (Exception ex) {
			throw new StudentNotRegisteredException(professor.getProfessorName());
		} 
		return true;
	}

}
