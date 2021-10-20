/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Student;
import com.tcs.exception.StudentNotRegisteredException;

/**
 * @author Aniket
 *
 */
public interface StudentInterFace {
	public void addStudent(Student student) throws StudentNotRegisteredException; 
	public List getAllStudents() throws SQLException;
	public Student getStudentById(int id) throws SQLException;
	public Student deleteStudent(int id) throws SQLException;
	
}
