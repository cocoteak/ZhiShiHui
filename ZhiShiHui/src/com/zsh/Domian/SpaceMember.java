package com.zsh.Domian;

import java.sql.Timestamp;

public class SpaceMember {
	private Integer space_member_id;
	private Integer space_id;
	private Integer user_id;
	private Integer space_member_status;//0表示成员，1表示管理者，2表示创建者
	private Timestamp space_member_createtime;
	private String userPicture;
	private User user;
	
	public SpaceMember() {
		super();
	}
	public Integer getSpace_member_id() {
		return space_member_id;
	}
	public void setSpace_member_id(Integer space_member_id) {
		this.space_member_id = space_member_id;
	}
	public Integer getSpace_id() {
		return space_id;
	}
	public void setSpace_id(Integer space_id) {
		this.space_id = space_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getSpace_member_status() {
		return space_member_status;
	}
	public void setSpace_member_status(Integer space_member_status) {
		this.space_member_status = space_member_status;
	}
	public Timestamp getSpace_member_createtime() {
		return space_member_createtime;
	}
	public void setSpace_member_createtime(Timestamp space_member_createtime) {
		this.space_member_createtime = space_member_createtime;
	}
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
}
