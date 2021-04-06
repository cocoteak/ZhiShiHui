package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsh.Dao.ResourceContentDao;
import com.zsh.Domian.ResourceContent;
import com.zsh.Service.ResourceContentService;
@Service
public class ResourceContentServiceImple implements ResourceContentService{
	@Resource
	ResourceContentDao resourceContentDao;
	
	public Integer deleteResource(Integer resource_id) {
		return resourceContentDao.deleteResourceById(resource_id);
	}

	public int insertContent(ResourceContent resourceContent) {
		return resourceContentDao.insertResourceContent(resourceContent);
	}

	public List<ResourceContent> selectAllContent(Integer resource_id) {
		return resourceContentDao.selectAllContent(resource_id);
	}

	public List<ResourceContent> selectAllRecordNum(Map map) {
		return resourceContentDao.selectAllRecordNum(map);
	}

	public Integer selectLeastContentNum(Integer resource_id) {
		return resourceContentDao.selectLeastContentNum(resource_id);
	}

	public List<ResourceContent> selectLeastResource() {
		return resourceContentDao.selectLeastResource();
	}

	public Integer selectResourceContentCount(Integer resourceId, Integer replyResourceId) {
		return resourceContentDao.selectResourceContentCount(resourceId, replyResourceId);
	}

	public List<ResourceContent> selectResourceContent(Integer resourceId) {
		return resourceContentDao.selectResourceContentWithPage(resourceId);
	}

	public ResourceContent selectContent(ResourceContent resourceContent) {
		return resourceContentDao.selectContent(resourceContent);
	}

	public int updateContent(ResourceContent ResourceContent) {
		return resourceContentDao.updateContent(ResourceContent);
	}

}
