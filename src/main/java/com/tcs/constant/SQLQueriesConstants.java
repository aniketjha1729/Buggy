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
		
}
