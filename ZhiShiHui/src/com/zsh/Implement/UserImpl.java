package com.zsh.Implement;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Domian.User;
import com.zsh.Dao.UserDao;
import com.zsh.Service.UserService;


@Service("userService")
public class UserImpl implements UserService{
	@Resource(name="userdao") 
	UserDao userdao;

	@Autowired
	HttpSession session;
	
	public boolean login(String user_phone, String user_pwd) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl login -->>");
		User user =  userdao.selectByPhonePwd(user_phone, user_pwd);
		if (user == null){
			return false;
		}
		session.setAttribute("user", user);
		return true;
	}


	public Integer register(String user_name, String user_phone, String user_pwd) {
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_phone(user_phone);
		user.setUser_pwd(user_pwd);
		return userdao.insertUser(user);
	}


	public User selectByPhone(User user) {
		// TODO Auto-generated method stub
		return userdao.selectByPhone(user);
	}


	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}


	public User selectUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return userdao.selectUserById(user_id);
	}


	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userdao.selectAllUser();
	}


	public Integer selectByName(String user_name) {
		// TODO Auto-generated method stub
		return userdao.selectByName(user_name);
	}





	
}
