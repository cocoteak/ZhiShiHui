package com.zsh.Dao;

import static com.zsh.util.ZhuZSHConstants.SPACECOLLENTTABLE;
import static com.zsh.util.ZhuZSHConstants.SPACELAUDTABLE;
import static com.zsh.util.ZhuZSHConstants.SPACETABLE;
import static com.zsh.util.ZhuZSHConstants.USERTABLE;

import java.util.List;

import static com.zsh.util.ZhuZSHConstants.SPACEMEMBERATABLE;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zsh.Domian.SpaceMember;
import com.zsh.Domian.StudySpace;
import com.zsh.Domian.User;


public interface HomepageDao {

	//查询此空间的相关信息
	@Select (value="select * from "+SPACETABLE+" where space_id = #{Integer spaceId}")
	@Results({
		@Result(column="space_id",property="space_id"),			
		@Result(column="user_id",property="user_id"),	
		//根据user_id来得到user的值
		@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
		//利用space_id来得到space_collectCount的值		
		@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
		//利用space_id来得到space_laudCount的值		
		@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
	})
	public StudySpace selectStudySapceBySpaceId(Integer spaceId);	
	
	//查询用户管理团队
	@Select(value="select * from "+SPACEMEMBERATABLE+" where space_id = #{spaceId} and space_member_status >0 ")
	@Results({
		@Result(column="space_id",property="space_id"),			
		@Result(column="user_id",property="user_id"),	
		//根据user_id来得到user的值
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.HomepageDao.selectUserNameByUserId")),		
	})	
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer  spaceId);	
	
	//根据space_id查询对应的收藏数
	@Select(value="select count(*) from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
	public Integer selectCollectCountBySpaceId(Integer userId);
	
	//根据user_id得到user
	@Select(value="select * from "+USERTABLE+" where user_id = #{userId}")
	public User selectUserNameByUserId(Integer  userId);		
	
	//根据space_id得到spaceLaudCount
	@Select(value="select count(*) from "+SPACELAUDTABLE+" where space_id = #{spaceId}")
	public Integer selectLaudCountBySpaceId(Integer userId);
	

		
	
}
