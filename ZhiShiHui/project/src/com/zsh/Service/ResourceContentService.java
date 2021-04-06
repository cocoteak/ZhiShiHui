package com.zsh.Service;

import java.util.List;
import java.util.Map;

import com.zsh.Domian.ResourceContent;


public interface ResourceContentService {
	int insertContent(ResourceContent resourceContent);
	
	List<ResourceContent> selectResourceContent(Integer resourceId);
	
	Integer selectResourceContentCount(Integer resourceId, Integer replyResourceId);
	
	List<ResourceContent> selectAllContent(Integer resource_id);
	
	List<ResourceContent>  selectLeastResource();
	
	Integer selectLeastContentNum(Integer resource_id);
	
	List<ResourceContent> selectAllRecordNum(Map map);
	
	Integer deleteResource(Integer resource_id);
	
//	int insertContentReply(ResourceContent resource_recordnum);
	
	int updateContent(ResourceContent ResourceContent);
	
	ResourceContent selectContent(ResourceContent resourceContent);
}
