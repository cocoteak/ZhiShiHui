package com.zsh.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zsh.Domian.ContributeContent;
import com.zsh.Domian.ContributeDomain;
import com.zsh.Domian.User;



public interface ContributeService {
	public int selectContributeWithParamCount(ContributeDomain contribute);
	
	 public ContributeDomain selectByNewContributeId(int id);
	 
	 public ContributeDomain selectByBeforeContributeId(int id);
	
	public List<User> selectAllUser();
	
	public List<ContributeDomain> selectContributeWithParam1(Map map1);
	
	public List<ContributeDomain> selectAllContribute();
	
	public Integer InsertDevotion(ContributeDomain devotion);
	
	//查找更新的资源
	public List<ContributeDomain> selectUpdateResourceWithParam1(Map map1);;
}
