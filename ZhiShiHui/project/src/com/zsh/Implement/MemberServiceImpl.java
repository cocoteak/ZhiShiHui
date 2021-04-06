package com.zsh.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Dao.MemberDao;
import com.zsh.Domian.SpaceMember;
import com.zsh.Service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	//动态向成员表中插入一条数据
	public Integer insertSpaceMember(SpaceMember spaceMember) {		
		return memberDao.insertSpaceMember(spaceMember);
	}

	//查询出此空间的所有成员
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId) {	
		return memberDao.selectMemberBySpaceId(spaceId);
	}

	//统计出此空间的所有成员
	public int selectStudyMemberCountBySpaceId(Integer spaceId) {		
		return memberDao.selectStudyMemberCountBySpaceId(spaceId);
	}

}