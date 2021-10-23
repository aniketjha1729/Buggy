/**
 * 
 */
package com.tcs.bean;

/**
 * @author Aniket
 *
 */
public class Course {
	private int courseId;
	private String courseCode;
	private String courseName;
	private String instructorId;
	private int seats = 10;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId,String courseCode, String courseName, String instructorId, int seats ) {
		super();
		this.courseId=courseId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.instructorId = instructorId;
		this.seats = seats;
	}
	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	/**
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
}
