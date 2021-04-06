package com.zsh.Domian;

import java.sql.Timestamp;
import java.util.List;

public class StudySpace {
	
	private Integer space_id;
	private String space_name;
	private String space_describe;
	private Integer space_top;//1表示置顶，0表示普通
	private Integer space_collectCount;//统计收藏数
	private List spaceCollectList;//存储此空间被那些用户收藏
	private Integer space_laudCount;//统计点赞数
	private Integer space_status;//1表示公开，0表示私有	
	private Timestamp space_createtime;		
	private Timestamp space_updatetime;
	private String space_picture;
	private Integer user_id;
	private String userName;
	
	public StudySpace() {
		super();
	}
	
	public Integer getSpace_id() {
		return space_id;
	}
	public void setSpace_id(Integer space_id) {
		this.space_id = space_id;
	}

	public String getSpace_name() {
		return space_name;
	}
	public void setSpace_name(String space_name) {
		this.space_name = space_name;
	}
	public String getSpace_describe() {
		return space_describe;
	}
	public void setSpace_describe(String space_describe) {
		this.space_describe = space_describe;
	}
	public Integer getSpace_top() {
		return space_top;
	}
	public void setSpace_top(Integer space_top) {
		this.space_top = space_top;
	}
	public Integer getSpace_collectCount() {
		return space_collectCount;
	}

	public void setSpace_collectCount(Integer space_collectCount) {
		this.space_collectCount = space_collectCount;
	}
	
	public List getSpaceCollectList() {
		return spaceCollectList;
	}

	public void setSpaceCollectList(List spaceCollectList) {
		this.spaceCollectList = spaceCollectList;
	}

	public Integer getSpace_laudCount() {
		return space_laudCount;
	}

	public void setSpace_laudCount(Integer space_laudCount) {
		this.space_laudCount = space_laudCount;
	}

	public Integer getSpace_status() {
		return space_status;
	}

	public void setSpace_status(Integer space_status) {
		this.space_status = space_status;
	}

	
	public Timestamp getSpace_createtime() {
		return space_createtime;
	}

	public void setSpace_createtime(Timestamp space_createtime) {
		this.space_createtime = space_createtime;
	}

	public Timestamp getSpace_updatetime() {
		return space_updatetime;
	}
	public void setSpace_updatetime(Timestamp space_updatetime) {
		this.space_updatetime = space_updatetime;
	}	
	public String getSpace_picture() {
		return space_picture;
	}
	public void setSpace_picture(String space_picture) {		
		this.space_picture = space_picture;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
