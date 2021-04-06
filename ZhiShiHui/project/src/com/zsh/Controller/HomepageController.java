package com.zsh.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.zsh.Domian.StudySpace;
import com.zsh.Service.HomepageService;

@Controller
public class HomepageController {

	@Autowired
	HomepageService homepageService;
	
	@RequestMapping(value="/studySpaceIndex")
	public String studySpaceIndexWeb(int space_id,HttpSession session) {	
		System.out.println("spaceId:"+space_id);
		StudySpace studySpace = (StudySpace) homepageService.selectStudySapceBySpaceId(space_id);		
		session.setAttribute("studySpace", studySpace);
		return "zhujsp/study_space/study_space_index";
	}	
	
	@RequestMapping(value="/welcomeToMyStudySpace")
	public String welcomeToMyStudySpaceWeb() {		
		return "zhujsp/study_space/welcomeToMy_study_space";
	}
	
	@RequestMapping(value="/selectHomepage")
	public String createStudySpaceWeb(HttpSession session) {	
		StudySpace studySpace = (StudySpace)session.getAttribute("studySpace");
		List spaceManaTeamList = (List)homepageService.selectSpaceMemberTeamByspaceId(studySpace.getSpace_id());
		session.setAttribute("spaceManaTeamList", spaceManaTeamList);
		return "zhujsp/study_space/homepage";
	}
	

}
