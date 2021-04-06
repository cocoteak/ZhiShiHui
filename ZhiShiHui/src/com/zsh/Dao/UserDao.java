package com.zsh.Dao;


import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.zsh.Provider.UserProvider;
import com.zsh.Domian.User;

@Repository("userdao")
public interface UserDao {
	//通过user_phone和user_pwd查找用户
	@Select("select * from user_inf where user_phone=#{user_phone} and user_pwd=#{user_pwd}")
	User selectByPhonePwd(@Param("user_phone")String user_phone,@Param("user_pwd")String user_pwd);
    
	//通过user_id查找用户
	@Select("select * from user_inf where user_id=#{user_id}")
	User selectUserById(Integer user_id);
	
	//查找用户所有
	@Select("select * from user_inf")
	List<User> selectAllUser();

	//通过user_name查询用户
	@Select("select user_id from user_inf where user_name = #{user_name}")
	Integer selectByName(String user_name);
	
	//查询用户
	@Select("select * from user_inf where user_phone=#{user.user_phone}")
	User selectByPhone(@Param("user")User user);
	
	
	//@Insert("insert into user_inf values(#{user})")
	//User insertUser(User user);
	@InsertProvider(type=UserProvider.class ,method="insertUser")
	int insertUser(User user);
	
	//修改用户，动态
	@UpdateProvider(type=UserProvider.class,method="updateUser")
	public int updateUser(User user);





	
	
}
