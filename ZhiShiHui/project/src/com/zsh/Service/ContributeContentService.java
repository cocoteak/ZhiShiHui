package com.zsh.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.zsh.Domian.ContributeContent;
import com.zsh.Provider.ContributeContentProvider;


public interface ContributeContentService {
	

	public Integer addReplay(ContributeContent content);
	
	
	//分页查询
	List<ContributeContent> selectContributeContentWithPage(Map map);
	
	//按楼层分组查询回复帖子(先确定在哪一个讨论帖，再根据楼层分组)
	List<ContributeContent> selectAllRecordNum(Map map);
	
	
	//查询回复总数
	List<ContributeContent> selectContributeContentAcount(Map map);
	
	
	//查询最新一条回复的时间
	List<ContributeContent> selectLeastcontribute();
	
	//查询指定帖子中的所有回复
	List<ContributeContent> selectAllContent(Integer devotion_id);
	
	//查询帖子最新一条回复楼层
	Integer selectLeastContentNum(Integer devotion_id);
	
	

}
