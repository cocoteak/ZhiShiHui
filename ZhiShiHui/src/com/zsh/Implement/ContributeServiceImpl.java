package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Dao.ContributeDao;
import com.zsh.Domian.ContributeContent;
import com.zsh.Domian.ContributeDomain;
import com.zsh.Domian.User;
import com.zsh.Service.ContributeService;




@Service("contributeService")
public class ContributeServiceImpl implements ContributeService {
	@Autowired
	ContributeDao contributedao;

	
	public List<User> selectAllUser(){
		// TODO Auto-generated method stub
		return contributedao.selectAllUser();
	}



	
	public List<ContributeDomain> selectContributeWithParam1(Map map1) {
		// TODO Auto-generated method stub
		return contributedao.selectContributeWithParam1(map1);
	}

	
	public int selectContributeWithParamCount(ContributeDomain contribute) {
		// TODO Auto-generated method stub
		return contributedao.selectContributeWithParamCount(contribute);
	}

	
	public List<ContributeDomain> selectAllContribute() {
		// TODO Auto-generated method stub
		return contributedao.selectAllContribute();
	}

	public Integer InsertDevotion(ContributeDomain devotion) {
		// TODO Auto-generated method stub
		return contributedao.InsertDevotion(devotion);
	}

	public List<ContributeDomain> selectUpdateResourceWithParam1(Map map1) {
		// TODO Auto-generated method stub
		return contributedao.selectUpdateResourceWithParam1(map1);
	}



	
	public ContributeDomain selectByBeforeContributeId(int id) {
		// TODO Auto-generated method stub
		return contributedao.selectByBeforeContributeId(id);
	}



	public ContributeDomain selectByNewContributeId(int id) {
		// TODO Auto-generated method stub
		return contributedao.selectByNewContributeId(id);
	}

	

	

}
