package com.zsh.Service;

import java.util.List;

import com.zsh.Domian.SpaceMember;

public interface MemberService {
	
	//��̬���Ա���в���һ������
	public Integer insertSpaceMember(SpaceMember spaceMember);
	
	//��ѯ���˿ռ�����г�Ա
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId);
	
	//ͳ�Ƴ��˿ռ�����г�Ա
	public int selectStudyMemberCountBySpaceId(Integer spaceId);
}
