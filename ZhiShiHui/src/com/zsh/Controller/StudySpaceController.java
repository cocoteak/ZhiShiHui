package com.zsh.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsh.Domian.SpaceCollect;
import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;
import com.zsh.Service.MemberService;
import com.zsh.Service.StudySpaceService;

@Controller
public class StudySpaceController {
	
	@Autowired
	private StudySpaceService studySapceService;
	@Autowired
	private MemberService memberService;

	@RequestMapping(value ="/selectStudySpace")
	public String selectStudySpaceWeb(Model model,HttpSession session) {
		session.removeAttribute("studySpace");
		return "zhujsp/study_space/content_study_space";
	}
	
	@RequestMapping(value="/createStudySpace")
	public String createStudySpaceWeb() {		
		return "zhujsp/study_space/create_study_space";
	}	
	
	//添加学习空间
	@RequestMapping(value="/AddStudySpace")
	public String AddStudySpaceWeb(StudySpace studySpace,Model model) {
		//假设目前登录的user_id = 1
		int user_id=1;
		//创建时间和更新时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(new Date());
		Timestamp nowTime = Timestamp.valueOf(now);
		studySpace.setSpace_createtime(nowTime);
		studySpace.setSpace_updatetime(nowTime);
		studySpace.setUser_id(user_id);		
		
		int flag = studySapceService.insertStudySpace(studySpace);
		if(flag !=0) {
			model.addAttribute("studySpace", studySpace);
			//往成员表中添加此用户是创建者的信息,查询最后数据表中最后一条数据的space_id
			StudySpace studySpaceBean = studySapceService.selectLastSpaceIdBySpaceTable();
			SpaceMember spaceMember = new SpaceMember();
			spaceMember.setSpace_id(studySpaceBean.getSpace_id());
			spaceMember.setSpace_member_createtime(nowTime);
			spaceMember.setSpace_member_status(2);
			spaceMember.setUser_id(user_id);
			memberService.insertSpaceMember(spaceMember);			
			return "zhujsp/community/content_community";
		}else {
			model.addAttribute("error","添加空间失败");
			return "error";
		}	
	}
	
	//查询学习空间
	@RequestMapping(value="/dealWithStudySpace")
	public String dealWithStudySpaceWeb(HttpSession session) {	
		System.out.println("type:"+session.getAttribute("type"));
		System.out.println("choose:"+session.getAttribute("choose"));
		
		//假设目前登录的user_id = 1
		Integer userId=1;
		
		List studySpaceList = new ArrayList();
		if(session.getAttribute("type").equals("recommend")&& session.getAttribute("choose").equals("recent_update")) {
			//recommend+recent_update
			List recommendList = studySapceService.selectRecommendByRecentUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);				
				
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);			
				
				studySpaceList.add(studySpace);
			}
			System.out.println("recommend+recent_update");
		}else if(session.getAttribute("type").equals("recommend")&& session.getAttribute("choose").equals("recent_create")) {
			//recommend+recent_create
			List recommendList = studySapceService.selectRecommendByRecentCreate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
									recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);			
				studySpaceList.add(studySpace);
			}
			System.out.println("recommend+recent_create");			
		}else if(session.getAttribute("type").equals("recommend")&& session.getAttribute("choose").equals("most_collect")) {
			//recommend+earliest_collect
			List recommendList = studySapceService.selectRecommendByRecentUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶的存在studySpaceList中
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}	
			//除了置顶的空间，其余空间按收藏数排序
			for(int i=0;i<recommendList.size()-1;i++){						
				for(int j=i+1;j<recommendList.size();j++){					
						if(((StudySpace) recommendList.get(i)).getSpace_collectCount()<((StudySpace) recommendList.get(j)).getSpace_collectCount()){
							StudySpace studySpaceMiddle = (StudySpace) recommendList.get(i);
							recommendList.set(i,(StudySpace) recommendList.get(j));
							recommendList.set(j, studySpaceMiddle);
					}			
				}
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("recommend+most_collect");			
		}else if(session.getAttribute("type").equals("recommend")&& session.getAttribute("choose").equals("earliest_update")) {
			//recommend+earliest_update
			List recommendList = studySapceService.selectRecommendByEarliestUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("recommend+earliest_update");
			
		}else if(session.getAttribute("type").equals("recommend")&& session.getAttribute("choose").equals("earliest_create")) {
			//recommend+earliest_create
			List recommendList = studySapceService.selectRecommendByRecentCreate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("recommend+earliest_create");			
		}else if(session.getAttribute("type").equals("see")&& session.getAttribute("choose").equals("recent_update")) {
			//see+recent_update
			List recommendList = studySapceService.selectSeeByRecentUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("see+recent_update");
		}else if(session.getAttribute("type").equals("see")&& session.getAttribute("choose").equals("recent_create")) {
			//see+recent_create
			List recommendList = studySapceService.selectSeeByRecentCreate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("see+recent_create");			
		}else if(session.getAttribute("type").equals("see")&& session.getAttribute("choose").equals("most_collect")) {
			//see+most_collect
			List recommendList = studySapceService.selectSeeByRecentUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶的存在studySpaceList中
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}	
			//除了置顶的空间，其余空间按收藏数排序
			for(int i=0;i<recommendList.size()-1;i++){						
				for(int j=i+1;j<recommendList.size();j++){					
						if(((StudySpace) recommendList.get(i)).getSpace_collectCount()<((StudySpace) recommendList.get(j)).getSpace_collectCount()){
							StudySpace studySpaceMiddle = (StudySpace) recommendList.get(i);
							recommendList.set(i,(StudySpace) recommendList.get(j));
							recommendList.set(j, studySpaceMiddle);
					}			
				}
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("see+most_collect");			
		}else if(session.getAttribute("type").equals("see")&& session.getAttribute("choose").equals("earliest_update")) {
			//see+earliest_update
			List recommendList = studySapceService.selectSeeByEarliestUpdate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("see+earliest_update");
			
		}else if(session.getAttribute("type").equals("see")&& session.getAttribute("choose").equals("earliest_create")) {
			//see+earliest_create
			List recommendList = studySapceService.selectSeeByRecentCreate();
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("see+earliest_create");			
		}else if(session.getAttribute("type").equals("collect")&& session.getAttribute("choose").equals("recent_update")) {
			//collect+recent_update
			List collectList = studySapceService.selectCollectByRecentUpdate();
			List collectListMiddle = new ArrayList();
			for(int i=0;i<collectList.size();i++) {
				StudySpace studySpace = (StudySpace)collectList.get(i);
				List spaceCollectList = (List) studySpace.getSpaceCollectList();
				for(int j=0;j<spaceCollectList.size();j++) {
					SpaceCollect spaceCollectBean = (SpaceCollect)spaceCollectList.get(j);
					if(spaceCollectBean.getUser_id() == userId) {
						collectListMiddle.add(studySpace);
					}
				}				
			}			
			for(int i=0;i<collectListMiddle.size();i++) {
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					collectListMiddle.remove(i);					
				}				
			}
			for(int i=0;i<collectListMiddle.size();i++) {				
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("collect+recent_update");
		}else if(session.getAttribute("type").equals("collect")&& session.getAttribute("choose").equals("recent_create")) {
			//collect+recent_create
			List collectList = studySapceService.selectCollectByRecentCreate();
			List collectListMiddle = new ArrayList();
			for(int i=0;i<collectList.size();i++) {
				StudySpace studySpace = (StudySpace)collectList.get(i);
				List spaceCollectList = (List) studySpace.getSpaceCollectList();
				for(int j=0;j<spaceCollectList.size();j++) {
					SpaceCollect spaceCollectBean = (SpaceCollect)spaceCollectList.get(j);
					if(spaceCollectBean.getUser_id() == userId) {
						collectListMiddle.add(studySpace);
					}
				}				
			}	
			for(int i=0;i<collectListMiddle.size();i++) {
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					collectListMiddle.remove(i);					
				}				
			}	
			for(int i=0;i<collectListMiddle.size();i++) {				
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("collect+recent_create");			
		}else if(session.getAttribute("type").equals("collect")&& session.getAttribute("choose").equals("most_collect")) {
			//collect+most_collect
			List collectList = studySapceService.selectCollectByRecentUpdate();
			List collectListMiddle = new ArrayList();
			for(int i=0;i<collectList.size();i++) {
				StudySpace studySpace = (StudySpace)collectList.get(i);
				List spaceCollectList = (List) studySpace.getSpaceCollectList();
				for(int j=0;j<spaceCollectList.size();j++) {
					SpaceCollect spaceCollectBean = (SpaceCollect)spaceCollectList.get(j);
					if(spaceCollectBean.getUser_id() == userId) {
						collectListMiddle.add(studySpace);
					}
				}				
			}	
			for(int i=0;i<collectListMiddle.size();i++) {
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					collectListMiddle.remove(i);					
				}				
			}				
			//除了置顶的空间，其余空间按收藏数排序
			for(int i=0;i<collectListMiddle.size()-1;i++){						
				for(int j=i+1;j<collectListMiddle.size();j++){					
						if(((StudySpace) collectListMiddle.get(i)).getSpace_collectCount()<((StudySpace) collectListMiddle.get(j)).getSpace_collectCount()){
							StudySpace studySpaceMiddle = (StudySpace) collectListMiddle.get(i);
							collectListMiddle.set(i,(StudySpace) collectListMiddle.get(j));
							collectListMiddle.set(j, studySpaceMiddle);
					}			
				}
			}
			for(int i=0;i<collectListMiddle.size();i++) {				
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("collect+most_collect");			
		}else if(session.getAttribute("type").equals("collect")&& session.getAttribute("choose").equals("earliest_update")) {
			//collect+earliest_update
			List collectList = studySapceService.selectCollectByEarliestUpdate();
			List collectListMiddle = new ArrayList();
			for(int i=0;i<collectList.size();i++) {
				StudySpace studySpace = (StudySpace)collectList.get(i);
				List spaceCollectList = (List) studySpace.getSpaceCollectList();
				for(int j=0;j<spaceCollectList.size();j++) {
					SpaceCollect spaceCollectBean = (SpaceCollect)spaceCollectList.get(j);
					if(spaceCollectBean.getUser_id() == userId) {
						collectListMiddle.add(studySpace);
					}
				}				
			}		
			for(int i=0;i<collectListMiddle.size();i++) {
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					collectListMiddle.remove(i);					
				}				
			}
			for(int i=0;i<collectListMiddle.size();i++) {				
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				studySpaceList.add(studySpace);
			}	
			System.out.println("collect+earliest_update");
			
		}else if(session.getAttribute("type").equals("collect")&& session.getAttribute("choose").equals("earliest_create")) {
			//collect+earliest_create
			List collectList = studySapceService.selectCollectByEarliestCreate();
			List collectListMiddle = new ArrayList();
			for(int i=0;i<collectList.size();i++) {
				StudySpace studySpace = (StudySpace)collectList.get(i);
				List spaceCollectList = (List) studySpace.getSpaceCollectList();
				for(int j=0;j<spaceCollectList.size();j++) {
					SpaceCollect spaceCollectBean = (SpaceCollect)spaceCollectList.get(j);
					if(spaceCollectBean.getUser_id() == userId) {
						collectListMiddle.add(studySpace);
					}
				}				
			}		
			for(int i=0;i<collectListMiddle.size();i++) {
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					collectListMiddle.remove(i);					
				}				
			}
			for(int i=0;i<collectListMiddle.size();i++) {				
				StudySpace studySpace = (StudySpace)collectListMiddle.get(i);
				studySpaceList.add(studySpace);
			}	
			System.out.println("collect+earliest_create");			
		}else if(session.getAttribute("type").equals("my")&& session.getAttribute("choose").equals("recent_update")) {
			//my+recent_update
			List recommendList = studySapceService.selectMyByRecentUpdate(userId);
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("my+recent_update");
		}else if(session.getAttribute("type").equals("my")&& session.getAttribute("choose").equals("recent_create")) {
			//my+recent_create
			List recommendList = studySapceService.selectMyByRecentCreate(userId);
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("my+recent_create");			
		}else if(session.getAttribute("type").equals("my")&& session.getAttribute("choose").equals("most_collect")) {
			//my+most_collect
			List recommendList = studySapceService.selectMyByRecentUpdate(userId);
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶的存在studySpaceList中
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}	
			//除了置顶的空间，其余空间按收藏数排序
			for(int i=0;i<recommendList.size()-1;i++){						
				for(int j=i+1;j<recommendList.size();j++){					
						if(((StudySpace) recommendList.get(i)).getSpace_collectCount()<((StudySpace) recommendList.get(j)).getSpace_collectCount()){
							StudySpace studySpaceMiddle = (StudySpace) recommendList.get(i);
							recommendList.set(i,(StudySpace) recommendList.get(j));
							recommendList.set(j, studySpaceMiddle);
					}			
				}
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("my+most_collect");			
		}else if(session.getAttribute("type").equals("my")&& session.getAttribute("choose").equals("earliest_update")) {
			//my+earliest_update
			List recommendList = studySapceService.selectMyByEarliestUpdate(userId);
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("my+earliest_update");
			
		}else if(session.getAttribute("type").equals("my")&& session.getAttribute("choose").equals("earliest_create")) {
			//my+earliest_create
			List recommendList = studySapceService.selectMyByEarliestCreate(userId);
			for(int i=0;i<recommendList.size();i++) {
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				if(studySpace.getSpace_top()==1) {//需要置顶
					studySpaceList.add(studySpace);
					recommendList.remove(i);					
				}				
			}
			for(int i=0;i<recommendList.size();i++) {				
				StudySpace studySpace = (StudySpace)recommendList.get(i);
				studySpaceList.add(studySpace);
			}
			System.out.println("my+earliest_create");			
		}	
		String path=session.getServletContext().getRealPath("/upload_images/");
		path = path+"\\";		
		System.out.println("path:"+path);		
		session.setAttribute("studySpaceList", studySpaceList);
		
		return "zhujsp/study_space/select_study_space";
	}
	
	@RequestMapping(value="/byType")
	public String byTypeWeb(String type,HttpSession session) {	
		session.removeAttribute("studySpace");
		if(session.getAttribute("type") == null){
			session.setAttribute("type", "recommend");			
		}else{
			session.setAttribute("type", type);
		}	
		return "redirect:byChoose";
	}
	
	@RequestMapping(value="/byChoose")
	public String byChooseWeb(String choose,HttpSession session) {		
		if(session.getAttribute("choose") == null){
			session.setAttribute("choose", "recent_update");
		}else if(choose != null && !choose.equals("")){			
			session.setAttribute("choose", choose);
		}
		return "redirect:dealWithStudySpace";
	}	
	
}
