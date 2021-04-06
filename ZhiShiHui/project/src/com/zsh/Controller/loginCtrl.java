package com.zsh.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsh.Domian.User;
import com.zsh.Service.UserService;

@Controller
public class loginCtrl {
	@Resource(name = "userService")
	UserService userService;

	@Autowired
	HttpSession session;
	
	User user;

	/*@RequestMapping(value = "/{formName}")
	public String formName(@PathVariable String formName) {
		return "formName";
	}*/

	@RequestMapping(value = "login")
	public String login(Model logg) {
		user = new User();
		logg.addAttribute("logg", user);
		
		System.out.println(logg);
		return "login";
	}// �õ�ҳ���ϵ�

	@RequestMapping(value = "loginon")
	public String loginon(
			@RequestParam(value = "user_phone") String user_phone, @RequestParam("checkcode")String checkcode,
			@RequestParam(value = "user_pwd") String user_pwd,
			Model model) {
		
		System.out.println("user_phone��"+user_phone+","+user_pwd+"-----"+user_pwd+"------"+checkcode+"----");
		/**
		 * ���ҳ���¼ʧ����ʾ
		 */
		session.setAttribute("message", "shibai");
		/**
		 * 1.��session��ȡ���������֤��
		 * 2.���û�������֤��Ƚϣ�ͨ���������¼��֤������ת����index.jsp���µ�¼
		 */
		String code=(String)session.getAttribute("checkCode");
		System.out.println("��ȷ��֤��:"+code+code.equalsIgnoreCase(checkcode));
		if(code!=null) {
			if(!code.equalsIgnoreCase(checkcode)) {//���Դ�Сдֱ�ӱȽ�
				model.addAttribute("msg", "��֤�����!");//session.setAttribute
				return "login";//����index.jsp  redirect:../login.do
			}
		}else {
			System.out.println("session��û�б�����֤��!");
		}
		
		boolean login = userService.login(user_phone, user_pwd);

		if (login) {
			/*User u1=(User) session.getAttribute("user");
			User u2=(User) session.getAttribute("logg");
			User u3=(User) session.getAttribute("command");
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(u3);*/
			return "index";
		} else {
			model.addAttribute("msg","��¼�����������");
			System.out.println("�û������������");
			return "login";
		}
	}
	
	
	//ע�������Ϻ�������ʹ��**������ڿ����ʹ��
	@RequestMapping(value="rlogin")
	public String rlogin(HttpSession session){
		session.setAttribute("user", user);
		session.removeAttribute("command");
		return "login";
	}
	

}
