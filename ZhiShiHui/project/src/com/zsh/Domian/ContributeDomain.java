package com.zsh.Domian;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class ContributeDomain {
		
		Integer user_id;//�������޸���id
		Integer resource_id;//��Դ��id
		Integer devotion_id;//��Դ�ĸ��¼�¼
		
		String resource_title;//���µ���Դ
		String resource_filePath;//��Դ�ļ�����·��
		String resource_content;//��Դ�޸�����
		Integer status;
		String resource_describe;//��Դ����
		String resource_label;//��Դ��ǩ
		 @DateTimeFormat(pattern="yyyy-MM-dd")
		Date devotion_createdate;
			User user;
//			ResourceDomain resource;
		 
		
		public Date getDevotion_createdate() {
			return devotion_createdate;
		}
		@Override
		public String toString() {
			return "ContributeDomain [devotion_createdate="
					+ devotion_createdate + ", devotion_id=" + devotion_id
					+ ", resource_content=" + resource_content
					+ ", resource_describe=" + resource_describe
					+ ", resource_filePath=" + resource_filePath
					+ ", resource_id=" + resource_id + ", resource_label="
					+ resource_label + ", resource_title=" + resource_title
					+ ", status=" + status + ", user=" + user + ", user_id="
					+ user_id + "]";
		}
		public void setDevotion_createdate(Date devotionCreatedate) {
			devotion_createdate = devotionCreatedate;
		}
	
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public void setResource_describe(String resourceDescribe) {
			resource_describe = resourceDescribe;
		}
		
		//Integer devotion_recordnum;//����¥id
		public Integer getUser_id() {
			return user_id;
		}

		public void setUser_id(Integer userId) {
			user_id = userId;
		}
		public Integer getResource_id() {
			return resource_id;
		}
		public void setResource_id(Integer resourceId) {
			resource_id = resourceId;
		}
		public Integer getDevotion_id() {
			return devotion_id;
		}
		public void setDevotion_id(Integer devotionId) {
			devotion_id = devotionId;
		}
		public String getResource_title() {
			return resource_title;
		}
		public void setResource_title(String resourceTitle) {
			resource_title = resourceTitle;
		}
		public String getResource_filePath() {
			return resource_filePath;
		}
		public void setResource_filePath(String resourceFilePath) {
			resource_filePath = resourceFilePath;
		}
		public String getResource_content() {
			return resource_content;
		}
		public void setResource_content(String resourceContent) {
			resource_content = resourceContent;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getResource_describe() {
			return resource_describe;
		}
		public void setResource_describle(String resourceDescribe) {
			resource_describe = resourceDescribe;
		}
		public String getResource_label() {
			return resource_label;
		}
		public void setResource_label(String resourceLabel) {
			resource_label = resourceLabel;
		}
		
//		@DateTimeFormat(pattern="yyyy-MM-dd")
//		Date devotion_createdate;//���¹���ʱ��
		
	//	String remark;
}