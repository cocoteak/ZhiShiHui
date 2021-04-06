package com.zsh.Controller;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.zsh.Domian.User;
import com.zsh.Service.UserService;

@Controller
public class RegisterController {

	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping(value="register")
	public String register(@RequestParam("register_user_name")String registerUserName,@RequestParam(value="register_user_phone", defaultValue="")String registerUserPhone,
			@RequestParam("register_user_pwd")String registerUserPwd,Model model){
		//判断从前端传输的用户名、用户电话、用户密码是否为空
		
		
		if(StringUtils.isEmpty(registerUserName) || StringUtils.isEmpty(registerUserPhone) || StringUtils.isEmpty(registerUserPwd)){
			System.out.println("信息不完整无法注册！");
			model.addAttribute("msg","信息不完整无法注册！");
			return "register";
		}
		//注册
		Integer register = userService.register(registerUserName, registerUserPhone, registerUserPwd);
		if (register == null || register <= 0){
			System.out.println("注册失败");
			model.addAttribute("msg","注册失败！");
			return "register";
		}
		/*
		List<User> users= userService.selectAllUser();
		for(int i=0;i<users.size();i++){
			String userphone=users.get(i).getUser_phone();
			if(registerUserPhone.equals(userphone)){
				System.out.println("手机号已注册！");
				model.addAttribute("msg","该手机号已被注册！");
				return "register";
			}
		}*/
		
		
		//注册成功返回的页面
		model.addAttribute("msg","成功，请登录！");
		return "login";
	}
}
