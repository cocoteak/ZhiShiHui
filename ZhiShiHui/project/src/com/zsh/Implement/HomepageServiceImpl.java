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
	
	
	//��ѯ�˿ռ�������Ϣ
	public StudySpace selectStudySapceBySpaceId(Integer spaceId) {		
		return homePageDao.selectStudySapceBySpaceId(spaceId);
	}

	//��ѯ�û������Ŷ�
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer spaceId) {		
		return homePageDao.selectSpaceMemberTeamByspaceId(spaceId);
	}

}
