/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Course;
import com.tcs.exception.CourseFoundException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
public interface AdminInterFace {
	boolean loginAdmin(String adminuserName, String adminPassword) throws UserNotFoundException;
	List<Course> viewCourses();
	void addCourse(Course course, List<Course> courseList) throws CourseFoundException;
	List getAllCourses() throws SQLException;
	void assignCourse(String courseCode, String instructorId) throws UserNotFoundException ;
	Course deleteCourse(String courseCode) throws SQLException;;
	
}
