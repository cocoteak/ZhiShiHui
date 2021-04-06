package com.zsh.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;
import com.zsh.Service.MemberService;

@Controller
public class MemberController{
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value ="/selectAllMember")
	public String selectAllMemberWeb(HttpSession session) {
		//��ѯ����ǰ�ռ��space_id
		StudySpace studySpace = (StudySpace)session.getAttribute("studySpace");	
		int spaceMemberCount=memberService.selectStudyMemberCountBySpaceId(studySpace.getSpace_id());
		List memberMiddle = memberService.selectMemberBySpaceId(studySpace.getSpace_id());
		List memberList = new ArrayList();
		for(int i=0;i<memberMiddle.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberMiddle.get(i);
			if(spaceMember.getSpace_member_status()==2) {//ȡ�������ߵ���Ϣ
				memberList.add(spaceMember);
				memberMiddle.remove(i);
			}			
		}
		for(int i=0;i<memberMiddle.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberMiddle.get(i);	
			memberList.add(spaceMember);
		}
		session.setAttribute("spaceMemberCount", spaceMemberCount);
		session.setAttribute("memberList", memberList);
		return "zhujsp/study_space/select_member";
	}
	
	@RequestMapping(value ="/selectMember")
	public String selectMemberWeb(HttpSession session,String memberName,Model model) {
		//�洢memberName��Ϣ
		model.addAttribute("memberName", memberName);
		System.out.println("member:"+memberName);
		//��ѯ����ǰ�ռ��space_id
		StudySpace studySpace = (StudySpace)session.getAttribute("studySpace");	
		//ͳ�ƴ˿ռ�ĳ�Ա
		int spaceMemberCount=memberService.selectStudyMemberCountBySpaceId(studySpace.getSpace_id());
		//��ѯ�˿ռ����г�Ա����Ϣ
		List memberMiddle = memberService.selectMemberBySpaceId(studySpace.getSpace_id());
		List memberList = new ArrayList();
		List memberBean = new ArrayList();
		for(int i=0;i<memberMiddle.size();i++) {//��ѯ��userName����memberName�����м�¼
			SpaceMember spaceMember = (SpaceMember)memberMiddle.get(i);
			String userName = spaceMember.getUser().getUser_name();
			if((userName.contains(memberName))) {//����memberName����ture�����򷵻�false
				memberBean.add(spaceMember);
			}
		}
		for(int i=0;i<memberBean.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberBean.get(i);
			if(spaceMember.getSpace_member_status()==2) {//ȡ�������ߵ���Ϣ
				memberList.add(spaceMember);
				memberBean.remove(i);
			}			
		}
		for(int i=0;i<memberBean.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberBean.get(i);	
			memberList.add(spaceMember);
		}
		session.setAttribute("spaceMemberCount", spaceMemberCount);
		session.setAttribute("memberList", memberList);
		return "zhujsp/study_space/select_member";
	}
}