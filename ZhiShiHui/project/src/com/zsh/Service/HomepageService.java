package com.zsh.Service;

import java.util.List;

import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;

public interface HomepageService {

	//查询此空间的相关信息
	public StudySpace selectStudySapceBySpaceId(Integer spaceId);
	
	//查询用户管理团队
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer  spaceId);	
	
}
