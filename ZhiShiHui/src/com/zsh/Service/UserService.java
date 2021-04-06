package com.zsh.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zsh.Domian.User;

@Service
public interface UserService {
	//用户登录
	boolean login(String user_phone,String user_pwd);

	//用户注册String user_name,String user_phone,String user_pwd
	Integer register(String user_name,String user_phone,String user_pwd);
	
	//通过电话查找用户
	User selectByPhone(User user);
	
	//修改用户信息
	Integer updateUser(User user);

	//通过id查找用户
	User selectUserById(Integer user_id);
	
	List<User> selectAllUser();
	
	Integer selectByName(String user_name);
}
