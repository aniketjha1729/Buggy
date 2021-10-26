package com.aniket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;
import com.aniket.bean.Student;
import com.aniket.constant.SQLQueriesConstants;
import com.aniket.exception.StudentNotRegisteredException;
import com.aniket.utils.DBUtils;

@Repository
public class StudentDaoOperation implements StudentDaoInterface {
	Connection connection = DBUtils.getConnection();

	@Override
	public boolean addStudent(Student student) throws StudentNotRegisteredException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			preparedStatement.setString(1, student.getUserId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getRole().toString());
			preparedStatement.setString(5, student.getGender().toString());
			preparedStatement.setString(6, student.getAddress());
			preparedStatement.setString(7, student.getCountry());
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected == 1) {
				// add the student record
				// "insert into student (userId,branchName,batch,isApproved) values (?,?,?,?)";
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
				preparedStatementStudent.setString(1, student.getUserId());
				preparedStatementStudent.setString(2, student.getBranchName());
				preparedStatementStudent.setInt(3, student.getBatch());
				preparedStatementStudent.setBoolean(4, false);
				preparedStatementStudent.executeUpdate();
			}
		} catch (Exception ex) {
			throw new StudentNotRegisteredException(student.getName());
		}
		return true;
	}
}
