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
	/**
	 * Admin login using SQL commands
	 * 
	 * @param adminuserName
	 * @param adminPassword
	 * @throws UserNotFoundException
	 */
	boolean loginAdmin(String adminuserName, String adminPassword) throws UserNotFoundException;

	/**
	 * Admin viewing all Courses using SQL commands
	 * 
	 * @throws NoCourseFoundException
	 */
	List<Course> viewCourses();

	/**
	 * Admin adding new courses using SQL commands
	 * 
	 * @param course
	 * @throws CourseFoundException
	 */
	void addCourse(Course course, List<Course> courseList) throws CourseFoundException;

	/**
	 * Admin viewing all Courses using SQL commands
	 * 
	 * @throws NoCourseFoundException
	 */
	List getAllCourses() throws SQLException;

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
	List getAllProfessors() throws SQLException;

	/**
	 * Admin approval for professor using SQL commands
	 * 
	 * @param professorId
	 * @param approved
	 * @throws SQLException
	 */
	void approveProfessor(int professorId, String approved) throws UserNotFoundException;

    void approveStudent(int studentId, String approved) throws UserNotFoundException;

}
