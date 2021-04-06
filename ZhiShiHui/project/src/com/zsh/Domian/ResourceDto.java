package com.zsh.Domian;

import java.util.Date;

public class ResourceDto {
	
	private Integer resource_id;	    //资源id
	private String resource_title;	    //资源标题
	private String resource_content;	//资源内容
	private String resource_describe;  //资源描述
	private String[] resource_label;	    //资源标签
	private Integer resourceType;
	public Integer getResource_id() {
		return resource_id;
	}
	public void setResource_id(Integer resourceId) {
		resource_id = resourceId;
	}
	public String getResource_title() {
		return resource_title;
	}
	public void setResource_title(String resourceTitle) {
		resource_title = resourceTitle;
	}
	public String getResource_content() {
		return resource_content;
	}
	public void setResource_content(String resourceContent) {
		resource_content = resourceContent;
	}
	public String getResource_describe() {
		return resource_describe;
	}
	public void setResource_describe(String resourceDescribe) {
		resource_describe = resourceDescribe;
	}
	public String[] getResource_label() {
		return resource_label;
	}
	public void setResource_label(String[] resourceLabel) {
		resource_label = resourceLabel;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	} 

	
}
