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
	/**
	 * Admin login using SQL commands
	 * 
	 * @param adminuserName
	 * @param adminPassword
	 * @throws UserNotFoundException
	 */
	boolean adminLogin(String adminuserName, String adminPassword) throws UserNotFoundException;

	/**
	 * Admin viewing all Courses using SQL commands
	 * 
	 * @throws NoCourseFoundException
	 */
	List<Course> viewCourse();

	/**
	 * Admin adding new courses using SQL commands
	 * 
	 * @param course
	 * @throws CourseFoundException
	 */
	void addCourse(Course course) throws CourseFoundException;

	/**
	 * Admin viewing all Courses using SQL commands
	 * 
	 * @throws SQLException
	 */
	List allCourses() throws SQLException;

	/**
	 * Admin assigning courses using SQL commands
	 * 
	 * @param courseCode
	 * @param instructorId
	 * @throws UserNotFoundException
	 */
	void assignCourse(String courseCode, String instructorId) throws UserNotFoundException;

	/**
	 * Admin delte course using SQL commands
	 * 
	 * @param courseCode
	 * @throws SQLException
	 */
	Course deleteCourse(String courseCode) throws SQLException;

	/**
	 * Admin listing all professor using SQL commands
	 * 
	 * @throws SQLException
	 */
	List Professors() throws SQLException;

	void approveProfessor(int professorId, String approved) throws UserNotFoundException;

    void approveStudent(int studentId, String approved) throws UserNotFoundException;

}
