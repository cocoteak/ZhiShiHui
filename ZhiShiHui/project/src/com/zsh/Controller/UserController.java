package com.zsh.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsh.Domian.User;
import com.zsh.Service.UserService;

@Controller
public class UserController {
	@Resource(name="userService")
	UserService userService;
	
	User user;
	
	@RequestMapping(value="MyJsp")
	public String MyJsp(){
		return "MyJsp";
	}
	
	
	@RequestMapping(value="UserMsg")
	public String UserMsg(User user,HttpSession session,Model model){
		User u=(User) session.getAttribute("user");
		
		System.out.println(u);
		
		User list=userService.selectByPhone(u);
		session.setAttribute("list", list);
		model.addAttribute("user",list);
		return "UserMsg";
	}

	
	@RequestMapping(value="UserUpdate")
	public String UserUpdate(User user,HttpSession session){
		User u=(User) session.getAttribute("user");
		System.out.println(u);
		
		User list =userService.selectByPhone(u);
		session.setAttribute("list", list);
		return "UserUpMsg";
	}
	@RequestMapping(value="updateUser")
	public String updateUser(HttpSession session,User user){
	    User userSession=(User)session.getAttribute("user");
	    String user_phone=userSession.getUser_phone();
	    user.setUser_phone(user_phone);
		userService.updateUser(user);
		return "redirect:UserMsg";
	}//跳转到更新页面,更新操作
	
	
}
