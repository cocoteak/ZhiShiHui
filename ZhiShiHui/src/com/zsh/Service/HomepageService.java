package com.zsh.Service;

import java.util.List;

import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;

public interface HomepageService {

	//��ѯ�˿ռ�������Ϣ
	public StudySpace selectStudySapceBySpaceId(Integer spaceId);
	
	//��ѯ�û������Ŷ�
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer  spaceId);	
	
}
