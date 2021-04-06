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
	
	//��̬���Ա���в���һ������
	public Integer insertSpaceMember(SpaceMember spaceMember) {		
		return memberDao.insertSpaceMember(spaceMember);
	}

	//��ѯ���˿ռ�����г�Ա
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId) {	
		return memberDao.selectMemberBySpaceId(spaceId);
	}

	//ͳ�Ƴ��˿ռ�����г�Ա
	public int selectStudyMemberCountBySpaceId(Integer spaceId) {		
		return memberDao.selectStudyMemberCountBySpaceId(spaceId);
	}

}