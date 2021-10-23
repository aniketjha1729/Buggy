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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tcs.bean.Course;
import com.tcs.bean.Professor;
import com.tcs.bean.Student;
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
	//cofig apache log4J
	private static Logger logger=Logger.getLogger(AdminOperation.class);
	
	Connection connection = DBUtils.getConnection();
	@Override
	public boolean adminLogin(String adminuserName, String adminPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADMIN_VERIFY_CREDENTIALS);
			preparedStatement.setString(1,adminuserName);
			logger.debug(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			logger.debug(resultSet);
			if(!resultSet.next()) {
				logger.info("inside resultSet");
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
			logger.error(ex.getMessage());
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
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADMIN_ADD_COURSE);
			preparedStatement.setInt(1, course.getCourseId());
			preparedStatement.setString(2, course.getCourseCode());
			preparedStatement.setString(3, course.getCourseName());
			int resultSet = preparedStatement.executeUpdate();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	@Override
	public List allCourses() throws SQLException {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstants.ADMIN_FETCH_COURSES);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			courses.add(new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)
					,rs.getInt(6),rs.getString(5)));
		}
		return courses;
	}
	@Override
	public void assignCourse(String courseCode, String instructorId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstants.ADMIN_ADMIN_ASSIGNCOURSES);
			stmt.setString(1,instructorId);
			stmt.setString(2,courseCode);
			int row = stmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se);
		}
	}
	@Override
	public Course deleteCourse(String courseCode) throws SQLException {
		// TODO Auto-generated method stub
		String s = SQLQueriesConstants.ADMIN_SELECTED_COURSE+"'"+courseCode+"'";	
		PreparedStatement stmt = connection.prepareStatement(s);
		ResultSet rs= stmt.executeQuery();
		stmt = connection.prepareStatement(SQLQueriesConstants.ADMIN_DELETE_COURSE);
		stmt.setString(1, courseCode);
		stmt.execute();
		if (rs.next())
			return new Course();
		return null;
	}
	@Override
	public List Professors() throws SQLException {
		// TODO Auto-generated method stub
		List<Professor> professorList= new ArrayList<>();
		PreparedStatement stmt = connection.prepareStatement(SQLQueriesConstants.ADMIN_FETCH_PROFESSORS);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			professorList.add(new Professor(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6)));
		}
		return professorList;
	}
	
}
