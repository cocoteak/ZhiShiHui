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
		//�жϴ�ǰ�˴�����û������û��绰���û������Ƿ�Ϊ��
		
		
		if(StringUtils.isEmpty(registerUserName) || StringUtils.isEmpty(registerUserPhone) || StringUtils.isEmpty(registerUserPwd)){
			System.out.println("��Ϣ�������޷�ע�ᣡ");
			model.addAttribute("msg","��Ϣ�������޷�ע�ᣡ");
			return "register";
		}
		//ע��
		Integer register = userService.register(registerUserName, registerUserPhone, registerUserPwd);
		if (register == null || register <= 0){
			System.out.println("ע��ʧ��");
			model.addAttribute("msg","ע��ʧ�ܣ�");
			return "register";
		}
		/*
		List<User> users= userService.selectAllUser();
		for(int i=0;i<users.size();i++){
			String userphone=users.get(i).getUser_phone();
			if(registerUserPhone.equals(userphone)){
				System.out.println("�ֻ�����ע�ᣡ");
				model.addAttribute("msg","���ֻ����ѱ�ע�ᣡ");
				return "register";
			}
		}*/
		
		
		//ע��ɹ����ص�ҳ��
		model.addAttribute("msg","�ɹ������¼��");
		return "login";
	}
}
