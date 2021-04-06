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
	}// 得到页面上的

	@RequestMapping(value = "loginon")
	public String loginon(
			@RequestParam(value = "user_phone") String user_phone, @RequestParam("checkcode")String checkcode,
			@RequestParam(value = "user_pwd") String user_pwd,
			Model model) {
		
		System.out.println("user_phone："+user_phone+","+user_pwd+"-----"+user_pwd+"------"+checkcode+"----");
		/**
		 * 清空页面登录失败提示
		 */
		session.setAttribute("message", "shibai");
		/**
		 * 1.从session中取出保存的验证码
		 * 2.与用户输入验证码比较，通过则继续登录验证，否则转发到index.jsp重新登录
		 */
		String code=(String)session.getAttribute("checkCode");
		System.out.println("正确验证码:"+code+code.equalsIgnoreCase(checkcode));
		if(code!=null) {
			if(!code.equalsIgnoreCase(checkcode)) {//忽略大小写直接比较
				model.addAttribute("msg", "验证码错误!");//session.setAttribute
				return "login";//返回index.jsp  redirect:../login.do
			}
		}else {
			System.out.println("session中没有保存验证码!");
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
			model.addAttribute("msg","登录名或密码错误！");
			System.out.println("用户名或密码错误！");
			return "login";
		}
	}
	
	
	//注销，请结合后续界面使用**最好是在框架中使用
	@RequestMapping(value="rlogin")
	public String rlogin(HttpSession session){
		session.setAttribute("user", user);
		session.removeAttribute("command");
		return "login";
	}
	

}
