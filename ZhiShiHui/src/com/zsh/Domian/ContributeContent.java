package com.zsh.Domian;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class ContributeContent {
	Integer content_id;//贡献的回复记录
	Integer devotion_recordnum;//贡献回复楼id
	Long devotion_likenum;//点赞数
	Long devotion_dislikenum;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date devotion_createdate;//更新回复时间
	String devotion_content;//贡献的回复内容
	Integer devotion_id;//贡献回复帖id
	Integer user_id;//贡献回复者id
	User user;
	ContributeDomain contribute;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ContributeDomain getContribute() {
		return contribute;
	}
	public void setContribute(ContributeDomain contribute) {
		this.contribute = contribute;
	}
	@Override
	public String toString() {
		return "ContributeContent [content_id=" + content_id
				+ ", devotion_content=" + devotion_content
				+ ", devotion_createdate=" + devotion_createdate
				+ ", devotion_dislikenum=" + devotion_dislikenum
				+ ", devotion_id=" + devotion_id + ", devotion_likenum="
				+ devotion_likenum + ", devotion_recordnum="
				+ devotion_recordnum + ", user_id=" + user_id + "]";
	}
	public Integer getContent_id() {
		return content_id;
	}
	public void setContent_id(Integer contentId) {
		content_id = contentId;
	}
	public Integer getDevotion_recordnum() {
		return devotion_recordnum;
	}
	public void setDevotion_recordnum(Integer devotionRecordnum) {
		devotion_recordnum = devotionRecordnum;
	}
	public Long getDevotion_likenum() {
		return devotion_likenum;
	}
	public void setDevotion_likenum(Long devotionLikenum) {
		devotion_likenum = devotionLikenum;
	}
	public Long getDevotion_dislikenum() {
		return devotion_dislikenum;
	}
	public void setDevotion_dislikenum(Long devotionDislikenum) {
		devotion_dislikenum = devotionDislikenum;
	}
	public Date getDevotion_createdate() {
		return devotion_createdate;
	}
	public void setDevotion_createdate(Date devotionCreatedate) {
		devotion_createdate = devotionCreatedate;
	}
	public String getDevotion_content() {
		return devotion_content;
	}
	public void setDevotion_content(String devotionContent) {
		devotion_content = devotionContent;
	}
	public Integer getDevotion_id() {
		return devotion_id;
	}
	public void setDevotion_id(Integer devotionId) {
		devotion_id = devotionId;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}

}
