package com.zsh.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zsh.Domian.Resources;

public interface ResourceService {
	//æ≤Ã¨≤È—Ø
	public List<Resources> selectAllResource();
	
	public Integer selectResourceAccount(Map map);

	public List<Resources> selectResourceWithParamPage(Map map) ;

	public int insertResource(Resources resource);

	public int updateResource(Resources resource);
	
	public Resources selectResourceById(Integer resource_id);
	
	public List<Integer> selectResourceAllId();
	
	public int deleteResource(Integer resource_id);
}
