/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Grade;
import com.tcs.bean.Student;
import com.tcs.dao.StudentDAOInterFace;
import com.tcs.exception.StudentNotRegisteredException;
import com.tcs.exception.UserNotFoundException;

/**
 * @author Aniket
 *
 */
@Component
public class StudentServiceOperation implements StudentInterFace {

	@Autowired
	private StudentDAOInterFace students;

	@Override
	public void addStudent(Student student) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub

		try {
			students.addStudent(student);
		} catch (StudentNotRegisteredException ex) {
			throw ex;
		}

	}

	@Override
	public List getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		return students.allStudentsList();
	}

	@Override
	public Student getStudentById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return students.getStudentById(id);

	}

	@Override
	public Student deleteStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		return students.deleteStudent(id);
	}

	@Override
	public Student updateStudent(int id, Student student) throws SQLException {
		// TODO Auto-generated method stub
		return students.update(id, student);
	}

	@Override
	public boolean loginStudent(String studentEmail, String studentPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return students.studentLogin(studentEmail, studentPassword);
	}

	@Override
	public void registerForCourse(int studentId, int courseId) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		try {
			students.registerForCourse(studentId, courseId);
		} catch (StudentNotRegisteredException ex) {
			throw ex;
		}
	}

	@Override
	public List getMyCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return students.myCourses(studentId);
	}

	@Override
	public double getMyFee(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return students.getMyFee(studentId);
	}

	@Override
	public List<Grade> myGradeCard(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return students.myGradeCard(studentId);
	}

	

}
