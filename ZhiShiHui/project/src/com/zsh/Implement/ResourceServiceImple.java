package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsh.Dao.ResourceDao;
import com.zsh.Domian.Resources;
import com.zsh.Service.ResourceService;

@Service
public class ResourceServiceImple implements ResourceService{
	@Resource(name="resourceDao")
	ResourceDao resourceDao;
	
	
	public int deleteResource(Integer resource_id) {
		return resourceDao.deleteResourceById(resource_id);
	}

	public int insertResource(Resources resource) {
		return resourceDao.insertResource(resource);
	}

	public Integer selectResourceAccount(Map map) {
		return resourceDao.selectResourceAccount(map);
	}

	public List<Integer> selectResourceAllId() {
		return resourceDao.selectResourceAllId();
	}

	public Resources selectResourceById(Integer resourceId) {
		return resourceDao.selectResourceById(resourceId);
	}

	public List<Resources> selectResourceWithParamPage(Map map) {
		return resourceDao.selectResourceWithParamPage(map);
	}

	public int updateResource(Resources resource) {
		return resourceDao.updateResource(resource);
	}

	public List<Resources> selectAllResource() {
		return resourceDao.selectAllResource();
	}
	
}
