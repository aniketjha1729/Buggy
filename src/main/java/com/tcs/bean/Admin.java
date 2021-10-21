/**
 * 
 */
package com.tcs.bean;

/**
 * @author Aniket
 *
 */
public class Admin {
	private int adminUserId;
	private String adminuserName;
	private String adminPassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminUserId, String adminuserName, String adminPassword) {
		super();
		this.adminUserId = adminUserId;
		this.adminuserName = adminuserName;
		this.adminPassword = adminPassword;
	}
	/**
	 * @return the adminUserId
	 */
	public int getAdminUserId() {
		return adminUserId;
	}
	/**
	 * @param adminUserId the adminUserId to set
	 */
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return adminuserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.adminuserName = adminuserName;
	}
	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
