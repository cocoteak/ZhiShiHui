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
		//查询出当前空间的space_id
		StudySpace studySpace = (StudySpace)session.getAttribute("studySpace");	
		int spaceMemberCount=memberService.selectStudyMemberCountBySpaceId(studySpace.getSpace_id());
		List memberMiddle = memberService.selectMemberBySpaceId(studySpace.getSpace_id());
		List memberList = new ArrayList();
		for(int i=0;i<memberMiddle.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberMiddle.get(i);
			if(spaceMember.getSpace_member_status()==2) {//取出创建者的信息
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
		//存储memberName信息
		model.addAttribute("memberName", memberName);
		System.out.println("member:"+memberName);
		//查询出当前空间的space_id
		StudySpace studySpace = (StudySpace)session.getAttribute("studySpace");	
		//统计此空间的成员
		int spaceMemberCount=memberService.selectStudyMemberCountBySpaceId(studySpace.getSpace_id());
		//查询此空间所有成员的信息
		List memberMiddle = memberService.selectMemberBySpaceId(studySpace.getSpace_id());
		List memberList = new ArrayList();
		List memberBean = new ArrayList();
		for(int i=0;i<memberMiddle.size();i++) {//查询出userName包括memberName的所有记录
			SpaceMember spaceMember = (SpaceMember)memberMiddle.get(i);
			String userName = spaceMember.getUser().getUser_name();
			if((userName.contains(memberName))) {//包括memberName返回ture，否则返回false
				memberBean.add(spaceMember);
			}
		}
		for(int i=0;i<memberBean.size();i++) {
			SpaceMember spaceMember = (SpaceMember)memberBean.get(i);
			if(spaceMember.getSpace_member_status()==2) {//取出创建者的信息
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