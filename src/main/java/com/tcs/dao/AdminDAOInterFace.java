/**
 * 
 */
package com.tcs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Course;
import com.tcs.exception.CourseFoundException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
public interface AdminDAOInterFace {

	boolean adminLogin(String adminuserName, String adminPassword) throws UserNotFoundException;
	List<Course> viewCourse();
	void addCourse(Course course) throws CourseFoundException;
	List allCourses() throws SQLException;
	void assignCourse(String courseCode, String instructorId) throws UserNotFoundException;
	Course deleteCourse(String courseCode) throws SQLException;
	List Professors() throws SQLException;

}
