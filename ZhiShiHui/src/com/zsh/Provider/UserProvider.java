package com.zsh.Provider;


import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.User;


public class UserProvider {
	public String selectUser(final User user){//User user
		return new SQL(){{
			SELECT("*");
			FROM("user_inf");
			if(user.getUser_phone()!=null){
				WHERE("user_phone like concat('%',#{user_phone},'%')");//404客户端发送的信息在语法上是错误的，不能被数据库接收
			}
			if(user.getUser_pwd()!=null){
				WHERE("user_pwd = #{user_pwd}");
			}}
		}.toString();
	}//通过username、id查询用户
	
	
	public String selectByPhone(final User user){
		return new SQL(){{
			SELECT("*");
			FROM("user_inf");
			if(user.getUser_phone()!=null){
				WHERE("user_phone =#{user_phone}");//404客户端发送的信息在语法上是错误的，不能被数据库接收
			}
		}}.toString();
	}
	
	
	
	
	public String insertUser(final User user){
		return new SQL(){{
			INSERT_INTO("user_inf");
			if(user.getUser_name()!=null&& !user.getUser_name().equals("")){
				VALUES("user_name","#{user_name}");
			}
			if(user.getUser_phone()!=null&& !user.getUser_phone().equals("")){
				VALUES("user_phone","#{user_phone}");
			}
			if(user.getUser_pwd()!=null&& !user.getUser_pwd().equals("")){
				VALUES("user_pwd","#{user_pwd}");
		}
			}}.toString();

	}
	
	
	
	public String updateUser(final User user){
		return new SQL(){{
			UPDATE("user_inf");
			if(user.getUser_name()!=null && !user.getUser_name().equals("")){
				SET("user_name=#{user_name}");
			}
			if(user.getUser_pwd()!=null && !user.getUser_pwd().equals("")){
				SET("user_pwd=#{user_pwd}");
			}
			if(user.getUser_picture()!=null && !user.getUser_picture().equals("")){
				SET("user_picture=#{user_picture}");
			}
			if(user.getUser_email()!=null && !user.getUser_email().equals("")){
				SET("user_email=#{user_email}");
			}
			if(user.getUser_homepage()!=null && !user.getUser_homepage().equals("")){
				SET("user_homepage=#{user_homepage}");
			}
			WHERE("user_phone=#{user_phone}");
		}}.toString();
	}
}
