package com.zsh.Provider;

import static com.zsh.util.ZhuZSHConstants.SPACETABLE;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.SpaceMember;

import static com.zsh.util.ZhuZSHConstants.SPACEMEMBERATABLE;

public class MemberDaoProvider {
	
	//动态插入插入成员信息
	public String insertSpaceMember(final SpaceMember spaceMember){
		return new SQL(){{
			
			INSERT_INTO(SPACEMEMBERATABLE);					
			if(spaceMember.getSpace_id()!=null){
				VALUES("space_id","#{space_id}");
			}				
			if(spaceMember.getUser_id()!=null){
				VALUES("user_id","#{user_id}");
			}			
			if(spaceMember.getSpace_member_status()!=null){
				VALUES("space_member_status","#{space_member_status}");
			}
			if(spaceMember.getSpace_member_createtime()!=null && !spaceMember.getSpace_member_createtime().equals("")){
				VALUES("space_member_createtime","#{space_member_createtime}");
			}			
		}}.toString();	
	}
}
