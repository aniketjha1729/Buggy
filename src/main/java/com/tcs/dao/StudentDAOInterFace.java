/**
 * 
 */
package com.tcs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Student;
import com.tcs.exception.StudentNotRegisteredException;

/**
 * @author Aniket
 *
 */
public interface StudentDAOInterFace {
	public boolean addStudent(Student student) throws StudentNotRegisteredException;
	public List allStudentsList() throws SQLException;
	public Student getStudentById(int id) throws SQLException;
	public Student deleteStudent(int id) throws SQLException;
}
