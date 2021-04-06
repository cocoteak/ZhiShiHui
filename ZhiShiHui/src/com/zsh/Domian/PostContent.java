package com.zsh.Domian;

import java.util.Date;

public class PostContent {
	  Integer content_id ;                          /*数据库记录编号,无实际意义*/
	  Integer content_recordnum ;                   /*回复楼数*/
	  String content_reply;                         /*回复内容*/
	  String content_likenum;                       /*回复点赞数*/
	  String content_dislikenum;                    /*回复踩数*/
	  Date   content_updatetime;  				    /*回复创建时间*/
	  Integer post_id ;                             /*回复帖子id*/
	  Post post;									/*回复的帖子*/
	  Integer reply_user_id;                        /*被回复者id*/
	  
	  //外键
	  User user;
	  Integer user_id;
	
	
	@Override
	public String toString() {
		return "PostContent [content_dislikenum=" + content_dislikenum
				+ ", content_id=" + content_id + ", content_likenum="
				+ content_likenum + ", content_recordnum=" + content_recordnum
				+ ", content_reply=" + content_reply + ", content_updatetime="
				+ content_updatetime + ", post=" + post + ", post_id="
				+ post_id + ", reply_user_id=" + reply_user_id + ", user="
				+ user + ", user_id=" + user_id + "]";
	}
	
	public Integer getContent_id() {
		return content_id;
	}
	public void setContent_id(Integer contentId) {
		content_id = contentId;
	}
	public Integer getContent_recordnum() {
		return content_recordnum;
	}
	public void setContent_recordnum(Integer contentRecordnum) {
		content_recordnum = contentRecordnum;
	}
	public String getContent_reply() {
		return content_reply;
	}
	public void setContent_reply(String contentReply) {
		content_reply = contentReply;
	}
	public String getContent_likenum() {
		return content_likenum;
	}
	public void setContent_likenum(String contentLikenum) {
		content_likenum = contentLikenum;
	}
	public String getContent_dislikenum() {
		return content_dislikenum;
	}
	public void setContent_dislikenum(String contentDislikenum) {
		content_dislikenum = contentDislikenum;
	}
	public Date getContent_updatetime() {
		return content_updatetime;
	}
	public void setContent_updatetime(Date contentUpdatetime) {
		content_updatetime = contentUpdatetime;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer postId) {
		post_id = postId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Integer getReply_user_id() {
		return reply_user_id;
	}
	public void setReply_user_id(Integer replyUserId) {
		reply_user_id = replyUserId;
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
