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

import com.tcs.bean.Course;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.CourseFoundException;
import com.tcs.exception.UserNotFoundException;
import com.tcs.utils.DBUtils;

/**
 * @author Aniket
 *
 */
@Repository
public class AdminOperation implements AdminDAOInterFace {
	Connection connection = DBUtils.getConnection();
	@Override
	public boolean adminLogin(String adminuserName, String adminPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADMIN_VERIFY_CREDENTIALS);
			preparedStatement.setString(1,adminuserName);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			if(!resultSet.next()) {
				//System.out.println("hello");
				throw new UserNotFoundException(adminuserName);}
			else if(adminPassword.equals(resultSet.getString("adminPassword")))
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return false;
		
	}
	@Override
	public List<Course> viewCourse(){
		// TODO Auto-generated method stub
		List<Course> courseList = new ArrayList<>();
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADMIN_VIEW_COURSES);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseCode(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				courseList.add(course);
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		return courseList;
	}
	
	@Override
	public void addCourse(Course course) throws CourseFoundException {
		// TODO Auto-generated method stub
		try {
//			System.out.println("hello here in dao");
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADMIN_ADD_COURSE);
			preparedStatement.setInt(1, course.getCourseId());
			preparedStatement.setString(2, course.getCourseCode());
			preparedStatement.setString(3, course.getCourseName());
//			System.out.println(preparedStatement);
			int resultSet = preparedStatement.executeUpdate();
//			System.out.println(resultSet);
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}
	
}
