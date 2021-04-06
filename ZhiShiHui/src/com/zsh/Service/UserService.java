package com.zsh.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zsh.Domian.User;

@Service
public interface UserService {
	//�û���¼
	boolean login(String user_phone,String user_pwd);

	//�û�ע��String user_name,String user_phone,String user_pwd
	Integer register(String user_name,String user_phone,String user_pwd);
	
	//ͨ���绰�����û�
	User selectByPhone(User user);
	
	//�޸��û���Ϣ
	Integer updateUser(User user);

	//ͨ��id�����û�
	User selectUserById(Integer user_id);
	
	List<User> selectAllUser();
	
	Integer selectByName(String user_name);
}
