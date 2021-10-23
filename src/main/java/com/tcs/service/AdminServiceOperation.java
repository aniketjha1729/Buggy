/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Course;
import com.tcs.dao.AdminDAOInterFace;
import com.tcs.dao.StudentDAOInterFace;
import com.tcs.exception.CourseFoundException;
import com.tcs.exception.UserNotFoundException;
import com.tcs.helper.AdminHelper;

/**
 * @author Aniket
 *
 */
@Component
public class AdminServiceOperation implements AdminInterFace {
	
	@Autowired
	private AdminDAOInterFace admin;

	@Override
	public boolean loginAdmin(String adminuserName, String adminPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return admin.adminLogin(adminuserName, adminPassword);
	}

	

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		return admin.viewCourse();
	}

	@Override
	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException {
		// TODO Auto-generated method stub
		if(!AdminHelper.isValidNewCourse(course, courseList)) {
			System.out.println(course+" already present in catalog!");
			throw new CourseFoundException(course.getCourseCode());
		}
		try {
			admin.addCourse(course);
		}
		catch(CourseFoundException e) {
			throw e;
		}
	}



	@Override
	public List getAllCourses() throws SQLException {
		// TODO Auto-generated method stub
		return admin.allCourses();
	}



	@Override
	public void assignCourse(String courseCode, String instructorId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			admin.assignCourse(courseCode, instructorId);
		}
		catch(UserNotFoundException e) {
			throw e;
		}
	}



	@Override
	public Course deleteCourse(String courseCode) throws SQLException {
		// TODO Auto-generated method stub
		return admin.deleteCourse(courseCode);
	}



	@Override
	public List getAllProfessors() throws SQLException {
		// TODO Auto-generated method stub
		return admin.Professors();
	}

}
