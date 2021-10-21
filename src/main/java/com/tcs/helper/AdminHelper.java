/**
 * 
 */
package com.tcs.helper;

import java.util.List;

import com.tcs.bean.Course;

/**
 * @author Aniket
 *
 */
public class AdminHelper {
	public static boolean isValidNewCourse(Course newCourse, List<Course> courseList) {
		for(Course course : courseList) {
			if(newCourse.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
				return false; 
			}
		}
		return true;
	}
}
