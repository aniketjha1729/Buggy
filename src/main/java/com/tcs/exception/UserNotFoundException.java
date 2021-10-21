/**
 * 
 */
package com.tcs.exception;

/**
 * @author Aniket
 *
 */
public class UserNotFoundException extends Exception {
	private String studentEmail;

	/***
	 * Getter function for UserId
	 * @param userId
	 */
	public UserNotFoundException(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "User with emialId: " + studentEmail + " not found.";
	}
}
