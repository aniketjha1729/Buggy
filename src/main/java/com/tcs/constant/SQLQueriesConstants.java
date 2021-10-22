/**
 * 
 */
package com.tcs.constant;

/**
 * @author Aniket
 *
 */
public class SQLQueriesConstants {
	//Student Queries:-
	public static final String ADD_STUDENT="insert into students (studentId,studentName,studentDept,studentEmail,studentMobile,studentGender,studentPassword) values (?,?,?,?,?,?,?)";
	public static final String FETCH_STUDENT="select * from students";
	public static final String VIEW_SELECTED_STUDENT = "select * from students where studentId= ";
	public static final String DELETE_SELECTED_ID_STUDENT_DATA = "delete from students where studentId= ?";
	public static final String STUDENT_VERIFY_CREDENTIALS="select studentPassword from students where studentEmail= ?";
	public static final String STUDENT_UPDATE_RECORD="update students set studentRollNo=?, studentDept=? where studentId=?";
	//Admin Queries:-
	public static final String ADMIN_VERIFY_CREDENTIALS="select adminPassword from admin where adminuserName= ?";
	public static final String ADMIN_VIEW_COURSES="select courseCode,courseName from courses";
	public static final String ADMIN_ADD_COURSE = "insert into courses(courseId,courseCode,courseName) values (?, ?, ?)";
	public static final String ADMIN_FETCH_COURSES="select * from courses";
	public static final String ADMIN_ADMIN_ASSIGNCOURSES="update courses set instructorId = ? where courseCode = ?";
	public static final String ADMIN_DELETE_COURSE = "delete from courses where courseCode= ?";
	public static final String ADMIN_SELECTED_COURSE = "select * from courses where courseCode= ";
	//Professor Queries:-
	public static final String ADD_PROFESSOR="insert into professors (professorId,professorDept,professorName,professorEmail,professorMobile,professorPasword) values (?,?,?,?,?,?)";
	public static final String PROFESSOR_VERIFY_CREDENTIALS="select professorPasword from professors where professorEmail= ?";
}
