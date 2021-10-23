/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.tcs.bean.Professor;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;
import com.tcs.utils.DBUtils;

/**
 * @author Aniket
 *
 */
@Repository
public class ProfessorOperation implements ProfessorDAOInterFace {
	Connection connection = DBUtils.getConnection();
	@Override
	public boolean addProfessor(Professor professor) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);
			preparedStatement.setInt(1, professor.getProfessorId());
			preparedStatement.setString(2, professor.getProfessorDept());
			preparedStatement.setString(3, professor.getProfessorName());
			preparedStatement.setString(4, professor.getProfessorEmail());
			preparedStatement.setString(5, professor.getProfessorMobile());
			preparedStatement.setString(6, professor.getProfessorPasword());
			int rowAffected=preparedStatement.executeUpdate();
		} catch (Exception ex) {
			throw new StudentNotRegisteredException(professor.getProfessorName());
		} 
		return true;
	}

	@Override
	public boolean professorLogin(String professorEmail, String professorPasword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.PROFESSOR_VERIFY_CREDENTIALS);
			preparedStatement.setString(1,professorEmail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				System.out.println("hello");
				throw new UserNotFoundException(professorEmail);
			}else if(professorPasword.equals(resultSet.getString("professorPasword"))){
				return true;
			}else{
				return false;
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}

}
