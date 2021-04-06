package com.zsh.Service;

import java.util.List;

import com.zsh.Domian.SpaceMember;

public interface MemberService {
	
	//动态向成员表中插入一条数据
	public Integer insertSpaceMember(SpaceMember spaceMember);
	
	//查询出此空间的所有成员
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId);
	
	//统计出此空间的所有成员
	public int selectStudyMemberCountBySpaceId(Integer spaceId);
}
