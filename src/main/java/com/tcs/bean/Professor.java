/**
 * 
 */
package com.tcs.bean;

/**
 * @author Aniket
 *
 */
public class Professor {
	private int professorId;
	private String professorDept;
	private String professorName;
	private String professorEmail;
	private String professorMobile;
	private String professorPasword;
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professor(int professorId, String professorDept, String professorName, String professorEmail,
			String professorMobile, String professorPasword) {
		super();
		this.professorId = professorId;
		this.professorDept = professorDept;
		this.professorName = professorName;
		this.professorEmail = professorEmail;
		this.professorMobile = professorMobile;
		this.professorPasword = professorPasword;
	}
	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	/**
	 * @return the professorDept
	 */
	public String getProfessorDept() {
		return professorDept;
	}
	/**
	 * @param professorDept the professorDept to set
	 */
	public void setProfessorDept(String professorDept) {
		this.professorDept = professorDept;
	}
	/**
	 * @return the professorName
	 */
	public String getProfessorName() {
		return professorName;
	}
	/**
	 * @param professorName the professorName to set
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	/**
	 * @return the professorEmail
	 */
	public String getProfessorEmail() {
		return professorEmail;
	}
	/**
	 * @param professorEmail the professorEmail to set
	 */
	public void setProfessorEmail(String professorEmail) {
		this.professorEmail = professorEmail;
	}
	/**
	 * @return the professorMobile
	 */
	public String getProfessorMobile() {
		return professorMobile;
	}
	/**
	 * @param professorMobile the professorMobile to set
	 */
	public void setProfessorMobile(String professorMobile) {
		this.professorMobile = professorMobile;
	}
	/**
	 * @return the studentPasword
	 */
	public String getProfessorPasword() {
		return professorPasword;
	}
	/**
	 * @param studentPasword the studentPasword to set
	 */
	public void setProfessorPasword(String professorPasword) {
		this.professorPasword = professorPasword;
	}
}
