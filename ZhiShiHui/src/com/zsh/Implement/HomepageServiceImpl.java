package com.zsh.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Dao.HomepageDao;
import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;
import com.zsh.Service.HomepageService;

@Service("homePage")
public class HomepageServiceImpl implements HomepageService{

	@Autowired
	private HomepageDao homePageDao;
	
	
	//查询此空间的相关信息
	public StudySpace selectStudySapceBySpaceId(Integer spaceId) {		
		return homePageDao.selectStudySapceBySpaceId(spaceId);
	}

	//查询用户管理团队
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer spaceId) {		
		return homePageDao.selectSpaceMemberTeamByspaceId(spaceId);
	}

}
