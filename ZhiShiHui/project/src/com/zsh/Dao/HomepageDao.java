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

	//��ѯ�˿ռ�������Ϣ
	@Select (value="select * from "+SPACETABLE+" where space_id = #{Integer spaceId}")
	@Results({
		@Result(column="space_id",property="space_id"),			
		@Result(column="user_id",property="user_id"),	
		//����user_id���õ�user��ֵ
		@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
		//����space_id���õ�space_collectCount��ֵ		
		@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
		//����space_id���õ�space_laudCount��ֵ		
		@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
	})
	public StudySpace selectStudySapceBySpaceId(Integer spaceId);	
	
	//��ѯ�û������Ŷ�
	@Select(value="select * from "+SPACEMEMBERATABLE+" where space_id = #{spaceId} and space_member_status >0 ")
	@Results({
		@Result(column="space_id",property="space_id"),			
		@Result(column="user_id",property="user_id"),	
		//����user_id���õ�user��ֵ
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.HomepageDao.selectUserNameByUserId")),		
	})	
	public List<SpaceMember> selectSpaceMemberTeamByspaceId(Integer  spaceId);	
	
	//����space_id��ѯ��Ӧ���ղ���
	@Select(value="select count(*) from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
	public Integer selectCollectCountBySpaceId(Integer userId);
	
	//����user_id�õ�user
	@Select(value="select * from "+USERTABLE+" where user_id = #{userId}")
	public User selectUserNameByUserId(Integer  userId);		
	
	//����space_id�õ�spaceLaudCount
	@Select(value="select count(*) from "+SPACELAUDTABLE+" where space_id = #{spaceId}")
	public Integer selectLaudCountBySpaceId(Integer userId);
	

		
	
}
