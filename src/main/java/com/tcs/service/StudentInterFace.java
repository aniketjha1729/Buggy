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
	public void addStudent(Student student) throws StudentNotRegisteredException; 
	public List getAllStudents() throws SQLException;
	public Student getStudentById(int id) throws SQLException;
	public Student deleteStudent(int id) throws SQLException;
	public Student updateStudent(int id, Student student) throws SQLException;
	public boolean loginStudent(String studentEmail, String studentPassword) throws UserNotFoundException;
	
}
