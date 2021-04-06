package com.zsh.Controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsh.Domian.ContributeDomain;
import com.zsh.Domian.User;
import com.zsh.Service.ContributeContentService;
import com.zsh.Service.ContributeService;
import com.zsh.Service.UserService;
import com.zsh.util.PageShow;









@Controller
public class ContributeController {
	@Resource(name="contributeService")
    ContributeService  contributeService;
	
	@Resource(name="userService")
	 UserService userService;
		
//	@Resource(name="resourceService")
//	 ResourceService resourceService;
	
	@Resource(name="contentService")
	ContributeContentService contentService;
	
	int pageSize=2;//页面一页显示10条
	@RequestMapping("/no")
	public String no(){
		return "no";
		
	}
	@RequestMapping("/notyet")
	public String notyet(){
		return "notyet";
		
	}
	@RequestMapping("/whole")
	public String log(){
		
			return "whole";
		
	}

	//********************************************************************************************
	//@RequestParamRequestParam来映射请求参数
	 //required表示是否必须,默认为true
	// defaultValue请求参数的默认值
	//已接受
	@RequestMapping("/selectContributeWithParam1")
	public String selectContributeWithParam1(ContributeDomain contribute,Model model,
			@RequestParam(value="pageNow",defaultValue="1") int pageNow){
		Map map=new HashMap();//map就是一个容器，主要调用put（）、get（）方法；
		map.put("contribute", contribute);
		map.put("pageNow", pageNow);
		map.put("pageSize", pageSize);
		
		List<ContributeDomain> list1=contributeService.selectContributeWithParam1(map);
		model.addAttribute("contributeList",list1);
		model.addAttribute("contribute",contribute);
		
		int totalSize=contributeService.selectContributeWithParamCount(contribute);//总的条数
		PageShow pm=new PageShow(pageNow,pageSize,totalSize);
		model.addAttribute("pm",pm);
		System.out.println("当前页面:"+pageNow);
		System.out.println("当前页面条数:"+pageSize);
		System.out.println("总条数:"+totalSize);
		
		return "contribute/accept";//已接受
		
	}

	//根据id查询
	@RequestMapping("/lookDevotionView")
	public String lookDevotionView(Integer id,Model model,HttpServletRequest request){
		//将devotion——inf的表通过id查询然后通过model返回到页面通过requestScope.contribute调用得到页面显示的值
		//报错
		ContributeDomain contribute0=contributeService.selectByBeforeContributeId(id);
		
		ContributeDomain contribute1=contributeService.selectByNewContributeId(id);
		//System.out.println("contribute.getResource_id;"+contribute.get(0).getResource_id());
		model.addAttribute("contribute0",contribute0);
		
		model.addAttribute("contribute1",contribute1);

	    List<User> list2=userService.selectAllUser();
		model.addAttribute("userList", list2);
	
		
		return "contribute/Content";
	}
	
	 @RequestMapping("/download")
	    public ResponseEntity<byte[]> download(HttpSession request,String resource_filePath){
	    	
	    	String path=request.getServletContext().getRealPath("/upload");
	    	
	    	try {
	    		File file=new File(path+File.separator+resource_filePath);
				String downloadFile=new String(resource_filePath.getBytes("utf-8"),"iso-8859-1");
				HttpHeaders headers=new HttpHeaders();
				headers.setContentDispositionFormData("attachment", downloadFile);//通知浏览器以attachment的方式下载
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    	
	    }

	  @RequestMapping(value="addContribute")
	  public String addContribute(Model model,ContributeDomain contribute){
		  int i=contributeService.InsertDevotion(contribute);
		  if(i>0){
	    		return "redirect:selectContributeWithParam1";
	    	}else{
	    		return "error";
	    	}
		  
	  }
//    @RequestMapping(value="/addRemark1",method=RequestMethod.POST)
//    public String addRemark(
//    		ContributeContent content,HttpSession session,
//    		HttpServletRequest request){
//    	String devotion_id=request.getParameter("devotion_id");
//    	String user_id=request.getParameter("user_id");
//    	String devotion_content = request.getParameter("devotion_content"); 
//    	
//    	 System.out.println("user_id:"+user_id);
//    	 System.out.println("devotion_id:"+devotion_id);
//    	 System.out.println("devotion_content:"+devotion_content);
//    	 System.out.println("devotion_content:"+content.getDevotion_content());
//    	 
//    	
//     	Date date=new Date();
//     	content.setDevotion_createdate(date);
//    	 
//    	 int i=contentService.addReplay(content);
//     	if(i==1){
//     		return "redirect:selectContributeContent";
//     	}else{
//     		return "error";
//     	}
//    
//    }
//    @RequestMapping("/selectContributeContent")
//	public String selectContributeContent(ContributeContent content,Model model){
//		Map map=new HashMap();//map就是一个容器，主要调用put（）、get（）方法；
//		map.put("content", content);
//		
//		List<ContributeContent> list1=contentService.selectContentWithParam1(map);
//		model.addAttribute("contentList",list1);
//		model.addAttribute("content",content);
//		
//		
//		return "redirect:lookDevotionView";//已接受
//		
//	}
   
	public void setContributeService(ContributeService contributeService) {
		this.contributeService = contributeService;
	}

	
}
