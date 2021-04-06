package com.zsh.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsh.Domian.ResourceContent;
import com.zsh.Domian.ResourceDto;
import com.zsh.Domian.Resources;
import com.zsh.Domian.StudySpace;
import com.zsh.Domian.User;
import com.zsh.Service.ResourceContentService;
import com.zsh.Service.ResourceService;
import com.zsh.Service.UserService;
import com.zsh.util.PageShow;

@Controller
public class ResourceController {
	@Resource
    ResourceService resourceService;
	@Resource
	ResourceContentService resourceContentService;
	@Resource 
	UserService userservice;
	int pageSize=5;

	
	@RequestMapping("/main")
	public String main(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Resources paramResource,Model model){
		//分页
		Map map=new HashMap();
		map.put("resource",paramResource);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		//分页限制查询
		List<Resources> listResource= resourceService.selectResourceWithParamPage(map);
		
		//分页限制查询总数
		Integer totalSize=resourceService.selectResourceAccount(map);
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		Integer resourceType = 0;   //资源类型  0:全部  1:核心 2：精品
		Integer isMain = paramResource.getResource_if_main();
		if(isMain != null && isMain ==1) {
			resourceType =1;
		}
		
		Integer isRefined = paramResource.getResource_if_refined();
		if(isRefined != null && isRefined ==1) {
			resourceType =2;
		}
		
		model.addAttribute("resourceType", resourceType);
		
		//传值
		model.addAttribute("listResource",listResource);             //分页限制查询
		//model.addAttribute("userList",userList);           //所有用户

		
		model.addAttribute("paramResource",paramResource);           //查询条件
		model.addAttribute("pageNow",pageNow);               //当前页数
		int totalPage=ps.getTotalPage();					 
		model.addAttribute("ps",ps);           //分页限制查询总数
	
		return "resource/main";
		
	}
	
	/**
	 * 查询所有资源
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectAllResource")
	public String selectResource(Model model){
		List<Resources> list1=resourceService.selectAllResource();
		model.addAttribute("resourceList",list1);
		return "resource/resource_select";
	}
	
	/**
	 * 查询所有资源
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert")
	public String selectResource(HttpSession session,Model model, ResourceDto resource){
		Resources rs = new Resources();
		User user=(User)session.getAttribute("user");
		StudySpace spaceStudy=(StudySpace)session.getAttribute("spaceStdudy");
		rs.setResource_create_date(new Date());
		rs.setResource_content(resource.getResource_content());
		rs.setResource_describe(resource.getResource_content());
		rs.setResource_title(resource.getResource_title());
		Integer space_id=spaceStudy.getSpace_id();
		rs.setSpace_id(space_id);
		Integer user_id=user.getUser_id();
		rs.setUser_id(user_id);
		Integer type = resource.getResourceType();
		if(type == 1) {
			rs.setResource_if_main(1);
		} 
		if(type ==2) {
			rs.setResource_if_refined(1);
		}
		String[] labels = resource.getResource_label();
		String label = "";
		for(int i = 0; i < labels.length; i ++) {
			if(i == 0) {
				label += labels[i];
			} else {
				label = label + "," + labels[i];
			}
		}
		rs.setResource_label(label);
		resourceService.insertResource(rs);
		return "redirect:resource/main";
	}
	
	//新建资源
	@RequestMapping("/insertResource")
	public String insert(Model model) {
		Resources iresource=new Resources();
		model.addAttribute("iresource",iresource);
		return "resource/resource_add";
	}

	//查询资源
	@RequestMapping(value = "/selectResource")
	public String selectWithEmployee(@RequestParam(value="pageNow",defaultValue="1")int pageNow,HttpSession session,Resources paramResource,Model model) {
		
		//查看资源是否为核心资源
		System.out.println("Resource_ifremain:"+paramResource.getResource_if_main());
		
		//查看资源是否为精品资源
		System.out.println("Resource_ifrefined:"+paramResource.getResource_if_refined());
		
		//进行资源标题名的条件查询
		System.out.println("Resource_title:"+paramResource.getResource_title());
		
		//进行资源名的条件查询
		System.out.println("Resource_id:"+paramResource.getResource_id());
		
		//进行资源标签的条件查询
		System.out.println("Resource_label:"+paramResource.getResource_label());
		
		
		//分页
		Map map=new HashMap();
		map.put("resource",paramResource);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		//分页限制查询
		List<Resources> listResource= resourceService.selectResourceWithParamPage(map);
		
		//分页限制查询总数
		Integer totalSize=resourceService.selectResourceAccount(map);
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//查找所有帖子id
		List<Integer> idList= new ArrayList<Integer>();
		for(Resources resource : listResource) {
			idList.add(resource.getResource_id());
		}
		//查找所有帖子最新回复时间
		List<ResourceContent> updateList=resourceContentService.selectLeastResource();
		
		
		//查找所有帖子内部回复总数
		Map updateCount=new HashMap();
		for(int i=0;i<idList.size();i++){
		     Integer contentnum=resourceContentService.selectAllContent(idList.get(i)).size();
		     updateCount.put(idList.get(i),contentnum);
		}

		//传值
		model.addAttribute("listResource",listResource);             //分页限制查询
		model.addAttribute("updateList",updateList);         //所有帖子最新回复时间
		model.addAttribute("updateCount",updateCount);       //查找所有帖子内部回复总数
		//model.addAttribute("userList",userList);           
		User user = (User)session.getAttribute("user");		//所有用户id
		Integer user_id = user.getUser_id();

		
		model.addAttribute("paramResource",paramResource);           //查询条件
		model.addAttribute("pageNow",pageNow);               //当前页数
		int totalPage=ps.getTotalPage();					 
		model.addAttribute("ps",ps);           //分页限制查询总数
		
		return "resource/resource_select";
	}
	
	//删除资源
	@RequestMapping("/deleteResourceById")
	public String deleteResourceById(int resource_id){
		int i=resourceService.deleteResource(resource_id);
		if(i>0){
			return "redirect:resource/main";
		}else{
			return "error";
		}
	}

    
    public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
}
