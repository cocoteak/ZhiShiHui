package com.zsh.Domian;

public class User {
	Integer user_id;
	String user_name;
	String user_phone;
	String user_pwd;
	String user_email;
	Integer user_job;
	String user_dept;
	String user_homepage;
	String user_myself;
	String user_picture;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String userPhone) {
		user_phone = userPhone;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String userPwd) {
		user_pwd = userPwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	public Integer getUser_job() {
		return user_job;
	}
	public void setUser_job(Integer userJob) {
		user_job = userJob;
	}
	public String getUser_dept() {
		return user_dept;
	}
	public void setUser_dept(String userDept) {
		user_dept = userDept;
	}
	public String getUser_homepage() {
		return user_homepage;
	}
	public void setUser_homepage(String userHomepage) {
		user_homepage = userHomepage;
	}
	public String getUser_myself() {
		return user_myself;
	}
	public void setUser_myself(String userMyself) {
		user_myself = userMyself;
	}
	public String getUser_picture() {
		return user_picture;
	}
	public void setUser_picture(String userPicture) {
		user_picture = userPicture;
	}
	@Override
	public String toString() {
		return "User [user_dept=" + user_dept + ", user_email=" + user_email
				+ ", user_homepage=" + user_homepage + ", user_job=" + user_job
				+ ", user_myself=" + user_myself + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", user_picture="
				+ user_picture + ", user_pwd=" + user_pwd + "]";
	}

	
}
