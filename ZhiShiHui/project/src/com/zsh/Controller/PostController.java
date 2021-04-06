package com.zsh.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsh.util.PageShow;

import com.zsh.Domian.Post;
import com.zsh.Domian.PostContent;
import com.zsh.Domian.StudySpace;
import com.zsh.Domian.User;
import com.zsh.Implement.PostContentServiceImple;
import com.zsh.Implement.PostServiceImple;
import com.zsh.Service.UserService;

@Controller
public class PostController {
	@Resource(name = "userService")
	UserService userService;
	
	@Resource(name="postServiceImple")
	PostServiceImple postServiceImple;
	
	@Resource(name="postContentServiceImple")
	PostContentServiceImple postContentServiceImple;
	
	int pageSize = 8;
	
	@RequestMapping(value = "/showPost")
	public String index(HttpSession session) {
		session.removeAttribute("allSelect");
		return "discuss/showPost";
	}
	
	@RequestMapping(value = "/selectPost")
	public String selectWithContent(@RequestParam(value="pageNow",defaultValue="1")int pageNow,Post paramPost,Model model,@RequestParam(value="allSelect",defaultValue="false")boolean allSelect,boolean selectCollection,HttpSession session,String user_name) {
		System.out.println();
		StudySpace studySpace=(StudySpace) session.getAttribute("studySpace");
		Integer space_id=studySpace.getSpace_id();
		
		int tableSize=postServiceImple.SelectTable(space_id);
		
		if(tableSize>0){
		//±Í«©≤È—Ø
		String post_label=paramPost.getPost_label();
		String selctLabel="none";
		
		if((null != post_label && !post_label.isEmpty())){
			if(post_label.trim().length()==0||"".equals(post_label.trim())){}
		    if(post_label.trim().indexOf(",")!=0){}
		    String s=paramPost.getPost_label().replaceAll("\\s*", "");
		    
		    post_label=new String();
		    String[] str=s.split(",");
		    selctLabel="block";
		    for(int i=0;i<str.length;i++)
		    	 post_label+=str[i]+",";
		    space_id=null;
		}else  post_label="";
		
		paramPost.setPost_label(post_label);
		
		Integer user_id;
		
		if(user_name!=null&&!user_name.equals("")) {
			user_id=userService.selectByName(user_name);
			System.out.println("user_id:"+user_id);
			if(user_id==null) user_id=0;
			paramPost.setUser_id(user_id);
			model.addAttribute("user_name", user_name);
			space_id=null;
		}
		
		if(selectCollection){
			User user=(User)session.getAttribute("user");
			user_id=user.getUser_id();
		    System.out.println("user_id:"+user_id);
			String collection=user_id.toString();
			paramPost.setPost_collection(collection);
		}
		
		paramPost.setSpace_id(space_id);
		
		Map map=new HashMap();
		map.put("post",paramPost);
		map.put("pageNow",pageNow);
		map.put("pageSize",pageSize);

		List<Post> listPost= postServiceImple.selectPostWithParamPage(map);
		System.out.println(listPost);
		
		Map likeMap=new HashMap();
		Map dislikeMap=new HashMap();
		
		for(int i=0;i< listPost.size();i++){
			String likenum=listPost.get(i).getPost_likenum();
			String dislikenum=listPost.get(i).getPost_dislikenum();
			
			if((null != likenum && !likenum.isEmpty())){
				if(likenum.trim().length()==0||"".equals(likenum.trim())){}
				if(likenum.trim().indexOf(",")!=0){}
			}else  likenum="";
			
			if((null != dislikenum && !dislikenum.isEmpty())){
				if(dislikenum.trim().length()==0||"".equals(dislikenum.trim())){}
				if(dislikenum.trim().indexOf(",")!=0){}
			}else  dislikenum="";
			
			
			Integer  post_likenum;
			Integer  post_dislikenum;
			if ("".equals(likenum) || likenum.length() == 0)
				post_likenum = 0;
			else
				post_likenum= listPost.get(i).getPost_likenum().split(",").length;
			
			if ("".equals(dislikenum) || dislikenum.length() == 0)
				post_dislikenum = 0;
			else
				post_dislikenum= listPost.get(i).getPost_dislikenum().split(",").length;
			
			likeMap.put(listPost.get(i).getPost_id(),post_likenum);
			dislikeMap.put(listPost.get(i).getPost_id(),post_dislikenum);
		}
		
		model.addAttribute("likeMap",likeMap);
		model.addAttribute("dislikeMap",dislikeMap);
		System.out.println("dislikeMap:"+dislikeMap);
		
		int totalSize=postServiceImple.selectPostAccount(map).size();

		PageShow ps=new PageShow(pageNow,pageSize,totalSize);
		
		List<Integer> idList=postServiceImple.selectPosAllId();
		
		List<PostContent> updateList=postContentServiceImple.selectLeastPost();
		
		Map updateCount=new HashMap();
		for(int i=0;i<idList.size();i++){
		     Integer contentnum=postContentServiceImple.selectAllContent(idList.get(i)).size();
		     updateCount.put(idList.get(i),contentnum);
		}
		
		model.addAttribute("listPost",listPost); 
		model.addAttribute("updateList",updateList);         
		model.addAttribute("updateCount",updateCount);
		int totalPage=ps.getTotalPage();					 
		model.addAttribute("totalPage",totalPage);           

		boolean isHasFirst=ps.isHasFirst();
		model.addAttribute("isHasFirst",isHasFirst);
		boolean isHasPre=ps.isHasPre();
		model.addAttribute("isHasPre",isHasPre);
		boolean isHasNext=ps.isHasNext();
		model.addAttribute("isHasNext",isHasNext);
		boolean isHasLast=ps.isHasLast();
		model.addAttribute("isHasLast",isHasLast); 
		      		
		model.addAttribute("paramPost",paramPost);           
		model.addAttribute("pageNow",pageNow);               
		System.out.println("allSelect:"+allSelect);
		
		if(allSelect==false){
			session.removeAttribute("allSelect");
			model.addAttribute("allSelect",allSelect);  
		}if(allSelect==true){
			session.setAttribute("allSelect", allSelect);
		}
		
		model.addAttribute("selctLabel", selctLabel);
		}
		
		return "discuss/selectPost";
}
	
	@RequestMapping(value = "/postInsert")                  
	public String insert(Model model) {
		Post inPost=new Post();
		model.addAttribute("inPost",inPost);
		return "discuss/createPost";
	}
	
	@RequestMapping(value = "/postInsert2")
	public String inserts(@ModelAttribute("inPost")Post inPost,Model model,HttpSession session,String posts_content) {
		User user=(User)session.getAttribute("user");
		System.out.println(user);
		Integer user_id=user.getUser_id();
		
		StudySpace studySpace=(StudySpace) session.getAttribute("studySpace");
		Integer space_id=studySpace.getSpace_id();
		
		System.out.println("user_id:"+user_id);
		System.out.println("space_id:"+space_id);
		
		inPost.setUser_id(user_id);
		inPost.setSpace_id(space_id);
		
		System.out.println("posts_content:"+posts_content);
		String post_label=inPost.getPost_label().replaceAll("\\s*", "");
		
		inPost.setPost_label(post_label);
		System.out.println("inPost:"+inPost);
		
		postServiceImple.insertPost(inPost);
		return "redirect:selectPost";
		
	}
	
	@RequestMapping(value= "/updateHandlePost")
	public String updateInfo(Integer post_id,Model model){
		Post upPost = postServiceImple.selectPostById(post_id);
		model.addAttribute("upPost",upPost);
       
		String post_label=upPost.getPost_label();
		String selctLabel="none";
		
		if((null != post_label && !post_label.isEmpty())){
			if(post_label.trim().length()==0||"".equals(post_label.trim())){}
		    if(post_label.trim().indexOf(",")!=0){}
		    String s=upPost.getPost_label().replaceAll("\\s*", "");
		    
		    post_label=new String();
		    String[] str=s.split(",");
		    selctLabel="block";
		    for(int i=0;i<str.length;i++)
		    	 post_label+=str[i]+",";
		    
		}else  post_label="";
		upPost.setPost_label(post_label);
		model.addAttribute("selctLabel", selctLabel);
		
		return "discuss/updatePost";
	}
	
	@RequestMapping(value = "/updatePost")
	public String updateHandles(Post upPost,Model model, HttpSession session) {
		postServiceImple.updatePost(upPost);
		return "redirect:selectContent?post_id="+upPost.getPost_id();
	}
	
	@RequestMapping(value = "/deletePost")
	public String deleteMore(Integer post_id) {
		List<PostContent> content=postContentServiceImple.selectAllContent(post_id);
		for(int i=0;i<content.size();i++){
			postContentServiceImple.deleteContent(content.get(i).getPost_id());
		}
			postServiceImple.deletePost(post_id);
			return "redirect:selectPost";
		}
	

}