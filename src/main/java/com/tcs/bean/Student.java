/**
 * 
 */
package com.tcs.bean;

/**
 * @author Aniket
 *
 */
public class Student{
	private int studentId;
	private String studentDept;
	private String studentName;
	private String studentEmail;
	private String studentMobile;
	private String studentGender;
	private String studentPasword;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentDept, String studentName, String studentEmail, String studentMobile,
			String studentGender, String studentPasword) {
		super();
		this.studentId = studentId;
		this.studentDept = studentDept;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentMobile = studentMobile;
		this.studentGender = studentGender;
		this.studentPasword = studentPasword;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentDept
	 */
	public String getStudentDept() {
		return studentDept;
	}

	/**
	 * @param studentDept the studentDept to set
	 */
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentEmail
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/**
	 * @param studentEmail the studentEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * @return the studentMobile
	 */
	public String getStudentMobile() {
		return studentMobile;
	}

	/**
	 * @param studentMobile the studentMobile to set
	 */
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	/**
	 * @return the studentGender
	 */
	public String getStudentGender() {
		return studentGender;
	}

	/**
	 * @param studentGender the studentGender to set
	 */
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	/**
	 * @return the studentPasword
	 */
	public String getStudentPasword() {
		return studentPasword;
	}

	/**
	 * @param studentPasword the studentPasword to set
	 */
	public void setStudentPasword(String studentPasword) {
		this.studentPasword = studentPasword;
	}
}
