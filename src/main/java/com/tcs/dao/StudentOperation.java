/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.bean.Student;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.utils.DBUtils;

/**
 * @author Aniket
 *
 */
@Repository
public class StudentOperation implements StudentDAOInterFace {
	Connection connection = DBUtils.getConnection();
	
	
	@Override
	public boolean addStudent(Student student) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println(student.toString());	
			System.out.println(student.getStudentId()+""+student.getStudentDept()+""+student.getStudentName());
			// open db connection
			
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
			
			preparedStatement.setLong(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentDept());
			preparedStatement.setString(4, student.getStudentEmail());
			preparedStatement.setString(5, student.getStudentMobile());
			preparedStatement.setString(6, student.getStudentMobile());
			preparedStatement.setString(7, student.getStudentPasword());
			
			
			int rowAffected=preparedStatement.executeUpdate();
			System.out.println(rowAffected);
			
			

		} catch (Exception ex) {
			throw new StudentNotRegisteredException(student.getStudentName());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "SQL error");
				e.printStackTrace();
			}
		}
		return true;
		
	}

	@Override
	public List allStudentsList() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstants.FETCH_STUDENT);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			students.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		return students;
		
	}

}
