package com.zsh.Domian;

import java.util.Date;

public class Resources {
	private Integer resource_id;	    //��Դid
	private String resource_title;	    //��Դ����
	private String resource_content;	//��Դ����
	private String resource_describe;  //��Դ����
	private String resource_label;	    //��Դ��ǩ
	private String resource_file_path;   //��Դ��ַ
	private Integer user_id;		    //������id
	User user;
	private Integer space_id;
	private Integer resource_if_refined; //��Դ�Ƿ�Ϊ������Դ
	private Integer resource_if_main;	//��Դ�Ƿ�Ϊ������Դ
	private Date resource_create_date;	//��Դ����ʱ��
	private String resource_like_num;     //��Դ������
	private String resource_dislike_num;  //��Դ����
	private String resource_collection_ids;	 //��Դ�ղ���
	private String resource_like_ids;   // �ֶε�����id  ���ŷָ�

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public String getResource_title() {
		return resource_title;
	}

	public void setResource_title(String resource_title) {
		this.resource_title = resource_title;
	}

	public String getResource_content() {
		return resource_content;
	}

	public void setResource_content(String resource_content) {
		this.resource_content = resource_content;
	}

	public String getResource_describe() {
		return resource_describe;
	}

	public void setResource_describe(String resource_describe) {
		this.resource_describe = resource_describe;
	}


	public String getResource_label() {
		return resource_label;
	}

	public void setResource_label(String resource_label) {
		this.resource_label = resource_label;
	}

	public void setResource_file_path(String resource_file_path) {
		this.resource_file_path = resource_file_path;
	}
	
	public String getResource_file_path() {
		return resource_file_path;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getSpace_id() {
		return space_id;
	}

	public void setSpace_id(Integer space_id) {
		this.space_id = space_id;
	}

	public Integer getResource_if_refined() {
		return resource_if_refined;
	}

	public void setResource_if_refined(Integer resource_if_refined) {
		this.resource_if_refined = resource_if_refined;
	}

	public Integer getResource_if_main() {
		return resource_if_main;
	}

	public void setResource_if_main(Integer resource_if_main) {
		this.resource_if_main = resource_if_main;
	}

	public Date getResource_create_date() {
		return resource_create_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setResource_create_date(Date resource_create_date) {
		this.resource_create_date = resource_create_date;
	}

	public String getResource_like_num() {
		return resource_like_num;
	}

	public void setResource_like_num(String resource_like_num) {
		this.resource_like_num = resource_like_num;
	}

	public String getResource_dislike_num() {
		return resource_dislike_num;
	}

	public void setResource_dislike_num(String resource_dislike_num) {
		this.resource_dislike_num = resource_dislike_num;
	}

	public String getResource_collection_ids() {
		return resource_collection_ids;
	}

	public void setResource_collection_ids(String resource_collection_ids) {
		this.resource_collection_ids = resource_collection_ids;
	}

	public String getResource_like_ids() {
		return resource_like_ids;
	}

	public void setResource_like_ids(String resource_like_ids) {
		this.resource_like_ids = resource_like_ids;
	}
}