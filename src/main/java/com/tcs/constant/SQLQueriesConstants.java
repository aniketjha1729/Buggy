/**
 * 
 */
package com.tcs.constant;

/**
 * @author Aniket
 *
 */
public class SQLQueriesConstants {
	public static final String ADD_STUDENT="insert into students (studentId,studentName,studentDept,studentEmail,studentMobile,studentGender,studentPasword) values (?,?,?,?,?,?,?)";
	public static final String FETCH_STUDENT="select * from students";
	public static final String VIEW_SELECTED_STUDENT = "select * from students where studentId= ";
	public static final String DELETE_SELECTED_ID_STUDENT_DATA = "delete from students where studentId= ?";
	public static final String VERIFY_CREDENTIALS="select studentPassword from students where studentEmail= ?";
}
