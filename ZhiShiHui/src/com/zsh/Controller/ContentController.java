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

import com.zsh.util.ContentMap;
import com.zsh.util.PageShow;
import com.zsh.util.PostUtil;
import com.zsh.Domian.Post;
import com.zsh.Domian.PostContent;
import com.zsh.Domian.User;
import com.zsh.Implement.PostContentServiceImple;
import com.zsh.Implement.PostServiceImple;
import com.zsh.Service.UserService;

@Controller
public class ContentController {
	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "postContentServiceImple")
	PostContentServiceImple postContentServiceImple;

	@Resource(name = "postServiceImple")
	PostServiceImple postServiceImple;

	int pageSize = 8;

	@RequestMapping(value = "/selectContent")
	public String login(Integer post_id,Integer post_ifrefined,@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,PostContent paramContent,@ModelAttribute("inContent") PostContent inContent,boolean changeCollection, boolean changeLikeNum,boolean changeDislikeNum,Integer content_id, boolean changeContentLikenum,boolean changeContentDisikenum,boolean changeIfrefined,Model model,HttpSession session) {
		System.out.println("post_id:"+post_id);
		System.out.println("pageNow:"+pageNow);
		System.out.println("post_ifrefined:"+post_ifrefined);
		System.out.println("changeIfrefined:"+changeIfrefined);
		
		User user=(User)session.getAttribute("user");
		Integer user_id=user.getUser_id();
		String post_changUserId=user_id.toString();
		
//		model.addAttribute("users_id", user_id);
		
/*************************************************************************************************/			
/*************************************************************************************************/

		Post postChange=postServiceImple.selectPostById(post_id);

		Post post;

		Post paramChange = new Post();
		

		boolean collectionFlag;
		String str=postChange.getPost_collection();
		
		if((null != str && !str.isEmpty())){
			if(str.trim().length()==0||"".equals(str.trim())){}
			if(str.trim().indexOf(",")!=0){}
		}else  str="";
		
		if(changeCollection == false){}
		else{
			PostUtil postUtil = new PostUtil(str, post_changUserId);	
			
			postChange = new Post();
			postChange.setPost_id(post_id);
			postChange.setPost_collection(postUtil.change());
			postServiceImple.updatePost(postChange);
		}
			
			paramChange.setPost_collection(post_changUserId);
			paramChange.setPost_id(post_id);
			post = postServiceImple.selectPostChange(paramChange);

			if (post != null)
				collectionFlag = true;
			else
				collectionFlag = false;
		
		model.addAttribute("collectionFlag", collectionFlag);


		int like=0;
		boolean likeFlag=false;
		String likenum=postChange.getPost_likenum();
			
		if((null != likenum && !likenum.isEmpty())){
			if(likenum.trim().length()==0||"".equals(likenum.trim())){}
			if(likenum.trim().indexOf(",")!=0){}
		}else  likenum="";
		
		if (changeLikeNum == false) {}
		else {
					PostUtil postUtil = new PostUtil(likenum, post_changUserId);
					postChange = new Post();
					postChange.setPost_id(post_id);
					postChange.setPost_likenum(postUtil.change());
					postServiceImple.updatePost(postChange);
				}

				post = postServiceImple.selectPostById(post_id);
				String s=post.getPost_likenum();
				if((null != s && !s.isEmpty())){
				}else  s="";
				
				if ("".equals(s.trim())|| s.trim().length()==0)
					like = 0;
				else
					like = post.getPost_likenum().split(",").length;

		
				paramChange=new Post();
				paramChange.setPost_likenum(post_changUserId);
				paramChange.setPost_id(post_id);
				post = postServiceImple.selectPostChange(paramChange);
				
				if (post != null)
					likeFlag = true;
				else
					likeFlag = false;
		
		model.addAttribute("likeFlag",likeFlag);
		model.addAttribute("like", like);
		

		int dislike=0;
		boolean dislikeFlag=false;
		String dislikenum=postChange.getPost_dislikenum();
		
		if((null != dislikenum && !dislikenum.isEmpty())){
			if(dislikenum.trim().length()==0||"".equals(dislikenum.trim())){}
			if(dislikenum.trim().indexOf(",")!=0){}
		}else  dislikenum="";
		
		if (changeDislikeNum == false) {}
		else {
					PostUtil postUtil = new PostUtil(dislikenum,post_changUserId);
					
					postChange = new Post();
					postChange.setPost_id(post_id);
					postChange.setPost_dislikenum(postUtil.change());
					postServiceImple.updatePost(postChange);
				}
		
				post = postServiceImple.selectPostById(post_id);
				String s1 = post.getPost_dislikenum();
				if((null != s1 && !s1.isEmpty())){
					if(s1.trim().length()==0||"".equals(s1.trim())){}
					if(s1.trim().indexOf(",")!=0){}
				}else  s1="";
				
				if ("".equals(s1) || s1.length() == 0)
					dislike = 0;
				else
					dislike = post.getPost_dislikenum().split(",").length;
				
				paramChange=new Post();
				paramChange.setPost_dislikenum(post_changUserId);
				paramChange.setPost_id(post_id);
				post = postServiceImple.selectPostChange(paramChange);

				if (post != null)
					dislikeFlag = true;
				else
					dislikeFlag = false;
		
		model.addAttribute("dislikeFlag",dislikeFlag);
		model.addAttribute("dislike", dislike);		
		
///*************************************************************************************************/	
///*************************************************************************************************/
		Post postFirst = postServiceImple.selectPostById(post_id);
		
		
		if(changeIfrefined){
			Integer changeFined=null;
			if(post_ifrefined==1)
				changeFined=2;
			else changeFined=1;
			
			Post posts=new Post();
			posts.setPost_ifrefined(changeFined);
			posts.setPost_id(post_id);
			postServiceImple.updatePost(posts);
			
			postFirst.setPost_ifrefined(changeFined);
		}
		
		System.out.println("post_ifrefined:"+post_ifrefined);
		model.addAttribute("postFirst", postFirst);		
		
		int tableSize=postContentServiceImple.SelectTable();
		if(tableSize>0){
		
		paramContent.setPost_id(post_id);
		
		Map map = new HashMap();
		map.put("postContent", paramContent);
		map.put("pageNow", pageNow);
		map.put("pageSize", pageSize);

	
		List<PostContent> listContent = postContentServiceImple.selectPostContentWithPage(map);
		// List<User> userList= userServiceImple.selectAllUser();

		
		List<PostContent> listRecordContent = postContentServiceImple.selectAllRecordNum(map);
		int totalSize = listRecordContent.size();
		System.out.println("totalSize:" + totalSize);
		
		
		List<PostContent> allContentList = postContentServiceImple.selectAllContent(post_id);
		
		
		List<User> reply_user = userService.selectAllUser();
		model.addAttribute("reply_user", reply_user);

///*************************************************************************************************/			
///*************************************************************************************************/	
		Map likeMap = new HashMap();
		Map dislikeMap = new HashMap();
		
		for(int i=0;i<allContentList.size();i++){
			
			PostContent postContent = new PostContent();
			
			PostContent paramContentChange = new PostContent();
			paramContentChange.setContent_id(allContentList.get(i).getContent_id());
			
			PostContent contentChange = postContentServiceImple.selectContent(paramContentChange);
 
//////---------------------------------------------------------------------------------------/
//////---------------------------------------------------------------------------------------/
//////---------------------------------------------------------------------------------------/
			String contentLikenum=contentChange.getContent_likenum();
			int likeContent=0;
			boolean contentlikeFlag=false;
		
			
			if((null != contentLikenum&& !contentLikenum.isEmpty())){
				if(contentLikenum.trim().length()==0||"".equals(contentLikenum.trim())){}
				if(contentLikenum.trim().indexOf(",")!=0){}
			}else  contentLikenum="";
			
			if (changeContentLikenum == false) {}
			else {
				if (content_id != null&& content_id == allContentList.get(i).getContent_id()) {
						PostUtil postUtil = new PostUtil(contentLikenum,post_changUserId);
						
						postContent = new PostContent();
						postContent.setContent_id(allContentList.get(i).getContent_id());
						postContent.setContent_id(content_id);
						postContent.setContent_likenum(postUtil.change());

						postContentServiceImple.updateContent(postContent);
				}
			}
					
					postContent = postContentServiceImple.selectContent(paramContentChange);
					String s2 = postContent.getContent_likenum();
					if((null != s2 && !s2 .isEmpty())){}
					else  s2 ="";
					if ("".equals(s2) || s2.length() == 0)
						likeContent = 0;
					else
						likeContent = postContent.getContent_likenum().split(",").length;
					
					paramContentChange=new PostContent();
					paramContentChange.setContent_likenum(post_changUserId);
					postContent = postContentServiceImple.selectContent(paramContentChange);

					if (postContent != null)
						contentlikeFlag = true;
					else
						contentlikeFlag = false;
			
			ContentMap contentMap=new ContentMap(likeContent,contentlikeFlag);
			likeMap.put(allContentList.get(i).getContent_id(), contentMap);
		
//////----------------------------------------------------------------------------------------/
//////----------------------------------------------------------------------------------------/
//////---------------------------------------------------------------------------------------/	
			int dislikeContent=0;
			boolean contentdislikeFlag=false;
			String contentDislikenum=contentChange.getContent_dislikenum();
			
		
			if((null != contentDislikenum&& !contentDislikenum.isEmpty())){
				if(contentDislikenum.trim().length()==0||"".equals(contentDislikenum.trim())){}
				if(contentDislikenum.trim().indexOf(",")!=0){}
			}else  contentDislikenum="";
			
			if (changeContentDisikenum == false) {}
			else {
					if (content_id != null&& content_id == allContentList.get(i).getContent_id()) {
						PostUtil postUtil = new PostUtil(contentDislikenum,post_changUserId);

						postContent = new PostContent();
						postContent.setContent_id(allContentList.get(i).getContent_id());
						postContent.setContent_dislikenum(postUtil.change());

						postContentServiceImple.updateContent(postContent);
					}
				}
					
					paramContentChange = new PostContent();
					paramContentChange.setContent_id(allContentList.get(i).getContent_id());
					postContent = postContentServiceImple.selectContent(paramContentChange);

					String s3 = postContent.getContent_dislikenum();
					if((null != s3 && !s3 .isEmpty())){
					}else  s3 ="";
					
					if ("".equals(s3) || s3.length() == 0)
						dislikeContent = 0;
					else
						dislikeContent = postContent.getContent_dislikenum().split(",").length;

					paramContentChange.setContent_dislikenum(post_changUserId);
					postContent = postContentServiceImple.selectContent(paramContentChange);

					if (postContent != null)
						contentdislikeFlag = true;
					else
						contentdislikeFlag = false;
					
			contentMap = new ContentMap(dislikeContent, contentdislikeFlag);
			dislikeMap.put(allContentList.get(i).getContent_id(),contentMap);
			
		}
		model.addAttribute("likeMap",likeMap);
		model.addAttribute("dislikeMap",dislikeMap);
		model.addAttribute("allContentList", allContentList);
		
/*************************************************************************************************/	
/*************************************************************************************************/	
		PageShow ps = new PageShow(pageNow, pageSize, totalSize);
		
		model.addAttribute("listContent", listContent);
		// model.addAttribute("userList",userList);

		
		int totalPage = ps.getTotalPage();
		model.addAttribute("totalPage", totalPage);

		boolean isHasFirst = ps.isHasFirst();
		model.addAttribute("isHasFirst", isHasFirst);
		boolean isHasPre = ps.isHasPre();
		model.addAttribute("isHasPre", isHasPre);
		boolean isHasNext = ps.isHasNext();
		model.addAttribute("isHasNext", isHasNext);
		boolean isHasLast = ps.isHasLast();
		model.addAttribute("isHasLast", isHasLast);

		model.addAttribute("inContent", inContent);
		}
		
		model.addAttribute("pageNow", pageNow);
		
		return "discuss/selectContent";

	}

	@RequestMapping(value = "/insertContent")
	public String insert(Model model,int pageNow,PostContent inContent,HttpSession session,String content_replys) {
		PostContent inContents = inContent;
		
		User user=(User)session.getAttribute("user");
		Integer user_id=user.getUser_id();
		inContent.setUser_id(user_id);
		
		System.out.println("inContents:"+inContents);
		System.out.println("content_replys:"+content_replys);
		
		//现帖最大楼数
		Integer old_recordnum = postContentServiceImple.selectLeastContentNum(inContents.getPost_id());
		//回复插入的楼数
		Integer new_content_recordnums;
		
		//楼中楼回复
		if (inContents.getReply_user_id()!=null) {
			if(null != content_replys && !content_replys.isEmpty()){
				inContent.setContent_reply(content_replys);
				postContentServiceImple.insertContent(inContents);
			}
		}else if(inContents.getReply_user_id()==null){
			//新楼回复
			if(old_recordnum==null){
				System.out.println("old_recordnum:"+old_recordnum);
				new_content_recordnums = 2;
			}else{
				System.out.println("old_recordnum:"+old_recordnum);
			    new_content_recordnums = old_recordnum + 1;
			}
			inContents.setContent_recordnum(new_content_recordnums);
			System.out.println(inContents);
			postContentServiceImple.insertContent(inContents);
		}
		return "redirect:selectContent?post_id="+inContents.getPost_id()+"&pageNow="+pageNow;
	}

}
