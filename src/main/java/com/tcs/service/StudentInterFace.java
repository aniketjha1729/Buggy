/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Student;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
public interface StudentInterFace {
	/**
	 * Student registring using SQL commands
	 * @param student
	 * @throws StudentNotRegisteredException 
	 */
	public void addStudent(Student student) throws StudentNotRegisteredException; 
	
	
	
	/**
	 * Students listing all peers login using SQL commands
	 * @throws SQLException 
	 */
	public List getAllStudents() throws SQLException;
	
	
	/**
	 * Sudents can see their profile SQL commands
	 * @param SQLException
	 * @throws SQLException 
	 */
	public Student getStudentById(int id) throws SQLException;
	
	
	
	/**
	 * Student can delete Profile  using SQL commands
	 * @param id
	 * @throws SQLException 
	 */
	public Student deleteStudent(int id) throws SQLException;
	
	
	/**
	 * Stduent updating using SQL commands
	 * @param id
	 * @param student
	 * @throws SQLException 
	 */
	public Student updateStudent(int id, Student student) throws SQLException;
	
	
	/**
	 * Student  login using SQL commands
	 * @param studentEmail
	 * @param studentPassword
	 * @throws UserNotFoundException 
	 */
	public boolean loginStudent(String studentEmail, String studentPassword) throws UserNotFoundException;
	
	
	
	/**
	 * Student Registring for new Course using SQL commands
	 * @param studentId
	 * @param courseId
	 * @throws StudentNotRegisteredException 
	 */
	public void registerForCourse(int studentId, int courseId) throws StudentNotRegisteredException;
	
	
	
	/**
	 * Students can view his/her registered courses  SQL commands
	 * @param studentId
	 * @throws SQLException 
	 */
	public List getMyCourses(int studentId) throws SQLException;
}
