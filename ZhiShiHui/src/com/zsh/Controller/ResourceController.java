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
		//��ҳ
		Map map=new HashMap();
		map.put("resource",paramResource);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		//��ҳ���Ʋ�ѯ
		List<Resources> listResource= resourceService.selectResourceWithParamPage(map);
		
		//��ҳ���Ʋ�ѯ����
		Integer totalSize=resourceService.selectResourceAccount(map);
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		Integer resourceType = 0;   //��Դ����  0:ȫ��  1:���� 2����Ʒ
		Integer isMain = paramResource.getResource_if_main();
		if(isMain != null && isMain ==1) {
			resourceType =1;
		}
		
		Integer isRefined = paramResource.getResource_if_refined();
		if(isRefined != null && isRefined ==1) {
			resourceType =2;
		}
		
		model.addAttribute("resourceType", resourceType);
		
		//��ֵ
		model.addAttribute("listResource",listResource);             //��ҳ���Ʋ�ѯ
		//model.addAttribute("userList",userList);           //�����û�

		
		model.addAttribute("paramResource",paramResource);           //��ѯ����
		model.addAttribute("pageNow",pageNow);               //��ǰҳ��
		int totalPage=ps.getTotalPage();					 
		model.addAttribute("ps",ps);           //��ҳ���Ʋ�ѯ����
	
		return "resource/main";
		
	}
	
	/**
	 * ��ѯ������Դ
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
	 * ��ѯ������Դ
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
	
	//�½���Դ
	@RequestMapping("/insertResource")
	public String insert(Model model) {
		Resources iresource=new Resources();
		model.addAttribute("iresource",iresource);
		return "resource/resource_add";
	}

	//��ѯ��Դ
	@RequestMapping(value = "/selectResource")
	public String selectWithEmployee(@RequestParam(value="pageNow",defaultValue="1")int pageNow,HttpSession session,Resources paramResource,Model model) {
		
		//�鿴��Դ�Ƿ�Ϊ������Դ
		System.out.println("Resource_ifremain:"+paramResource.getResource_if_main());
		
		//�鿴��Դ�Ƿ�Ϊ��Ʒ��Դ
		System.out.println("Resource_ifrefined:"+paramResource.getResource_if_refined());
		
		//������Դ��������������ѯ
		System.out.println("Resource_title:"+paramResource.getResource_title());
		
		//������Դ����������ѯ
		System.out.println("Resource_id:"+paramResource.getResource_id());
		
		//������Դ��ǩ��������ѯ
		System.out.println("Resource_label:"+paramResource.getResource_label());
		
		
		//��ҳ
		Map map=new HashMap();
		map.put("resource",paramResource);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);
		
		//��ҳ���Ʋ�ѯ
		List<Resources> listResource= resourceService.selectResourceWithParamPage(map);
		
		//��ҳ���Ʋ�ѯ����
		Integer totalSize=resourceService.selectResourceAccount(map);
		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		//������������id
		List<Integer> idList= new ArrayList<Integer>();
		for(Resources resource : listResource) {
			idList.add(resource.getResource_id());
		}
		//���������������»ظ�ʱ��
		List<ResourceContent> updateList=resourceContentService.selectLeastResource();
		
		
		//�������������ڲ��ظ�����
		Map updateCount=new HashMap();
		for(int i=0;i<idList.size();i++){
		     Integer contentnum=resourceContentService.selectAllContent(idList.get(i)).size();
		     updateCount.put(idList.get(i),contentnum);
		}

		//��ֵ
		model.addAttribute("listResource",listResource);             //��ҳ���Ʋ�ѯ
		model.addAttribute("updateList",updateList);         //�����������»ظ�ʱ��
		model.addAttribute("updateCount",updateCount);       //�������������ڲ��ظ�����
		//model.addAttribute("userList",userList);           
		User user = (User)session.getAttribute("user");		//�����û�id
		Integer user_id = user.getUser_id();

		
		model.addAttribute("paramResource",paramResource);           //��ѯ����
		model.addAttribute("pageNow",pageNow);               //��ǰҳ��
		int totalPage=ps.getTotalPage();					 
		model.addAttribute("ps",ps);           //��ҳ���Ʋ�ѯ����
		
		return "resource/resource_select";
	}
	
	//ɾ����Դ
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
