package com.zsh.Domian;

import java.util.Date;
import java.util.List;

public class ResourceContent {
	private Integer resource_content_id;	/* ��Դ�ظ���һ����¼����ʵ������ */
	private Integer resource_recordnum;		/* ��Դ�ظ�¥ */
	private String resource_reply;			/* ��Դ���ӻظ����� */
	private Date resource_updatedate;		/* ��Դ�ظ�ʱ�� */
	private String resource_likenum;		/* ��Դ�ظ�¥�ĵ�����*/
	private String resource_dislikenum;		/*��Դ�ظ�¥�ı�����*/
	private Integer resource_id;			/*  ��Դ��id */
	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private Integer user_id;				/*  ��Դ���ظ���id */
	private Integer reply_user_id;			/*  ���ظ���id */
	private Integer reply_resource_id;   	/*  ���ظ�������id */

	private List<ResourceContent> replyContents;
	public Integer getResource_content_id() {
		return resource_content_id;
	}
	public void setResource_content_id(Integer resource_content_id) {
		this.resource_content_id = resource_content_id;
	}
	public Integer getResource_recordnum() {
		return resource_recordnum;
	}
	public void setResource_recordnum(Integer resource_recordnum) {
		this.resource_recordnum = resource_recordnum;
	}
	public String getResource_reply() {
		return resource_reply;
	}
	public void setResource_reply(String resource_reply) {
		this.resource_reply = resource_reply;
	}
	public Date getResource_updatedate() {
		return resource_updatedate;
	}
	public void setResource_updatedate(Date resource_updatedate) {
		this.resource_updatedate = resource_updatedate;
	}
	
	public String getResource_likenum() {
		return resource_likenum;
	}
	public void setResource_likenum(String resource_likenum) {
		this.resource_likenum = resource_likenum;
	}
	public String getResource_dislikenum() {
		return resource_dislikenum;
	}
	public void setResource_dislikenum(String resource_dislikenum) {
		this.resource_dislikenum = resource_dislikenum;
	}
	public Integer getResource_id() {
		return resource_id;
	}
	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getReply_user_id() {
		return reply_user_id;
	}
	public void setReply_user_id(Integer reply_user_id) {
		this.reply_user_id = reply_user_id;
	}

	public Integer getReply_resource_id() {
		return reply_resource_id;
	}

	public void setReply_resource_id(Integer reply_resource_id) {
		this.reply_resource_id = reply_resource_id;
	}

	public List<ResourceContent> getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(List<ResourceContent> replyContents) {
		this.replyContents = replyContents;
	}
}
