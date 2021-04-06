package com.zsh.Domian;

import java.util.Date;

public class Post {
	  Integer post_id ;                          /*����id*/
	  String post_title;                         /*���ӱ���*/
	  String post_content;                       /*��������*/
	  String post_label;                         /*���ӱ�ǩ*/
	  String post_reminder;                      /*�����ر�������*/
	  Integer post_ifrefined;                    /*�����Ƿ�Ϊ������*/
	  String post_collection;                    /*�����ر�������*/
	  String post_likenum;                      /*���ӵ�����*/
	  String post_dislikenum;                   /*���Ӳ���*/
	  Date post_createtime;  				     /*���Ӵ���ʱ��*/
	  
	  //���
	  User user;
	  Integer user_id;
	  StudySpace studySpace;
	  Integer space_id;
	  
	@Override
	public String toString() {
		return "Post [post_collection=" + post_collection + ", post_content="
				+ post_content + ", post_createtime=" + post_createtime
				+ ", post_dislikenum=" + post_dislikenum + ", post_id="
				+ post_id + ", post_ifrefined=" + post_ifrefined
				+ ", post_label=" + post_label + ", post_likenum="
				+ post_likenum + ", post_reminder=" + post_reminder
				+ ", post_title=" + post_title + ", space_id=" + space_id
				+ ", studySpace=" + studySpace + ", user=" + user
				+ ", user_id=" + user_id + "]";
	}


	public StudySpace getStudySpace() {
		return studySpace;
	}


	public void setStudySpace(StudySpace studySpace) {
		this.studySpace = studySpace;
	}


	public Integer getSpace_id() {
		return space_id;
	}


	public void setSpace_id(Integer spaceId) {
		space_id = spaceId;
	}


	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer postId) {
		post_id = postId;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String postTitle) {
		post_title = postTitle;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String postContent) {
		post_content = postContent;
	}
	public String getPost_label() {
		return post_label;
	}
	public void setPost_label(String postLabel) {
		post_label = postLabel;
	}
	public String getPost_reminder() {
		return post_reminder;
	}
	public void setPost_reminder(String postReminder) {
		post_reminder = postReminder;
	}
	public Integer getPost_ifrefined() {
		return post_ifrefined;
	}
	public void setPost_ifrefined(Integer postIfrefined) {
		post_ifrefined = postIfrefined;
	}
	public String getPost_likenum() {
		return post_likenum;
	}
	public void setPost_likenum(String postLikenum) {
		post_likenum = postLikenum;
	}
	public String getPost_dislikenum() {
		return post_dislikenum;
	}
	public void setPost_dislikenum(String postDislikenum) {
		post_dislikenum = postDislikenum;
	}
	public Date getPost_createtime() {
		return post_createtime;
	}
	public void setPost_createtime(Date postCreatetime) {
		post_createtime = postCreatetime;
	}
	public String getPost_collection() {
		return post_collection;
	}
	public void setPost_collection(String postCollection) {
		post_collection = postCollection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	  
	

}
