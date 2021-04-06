package com.zsh.Dao;

import static com.zsh.util.ZhuZSHConstants.SPACETABLE;

import java.util.List;

import static com.zsh.util.ZhuZSHConstants.SPACEMEMBERATABLE;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zsh.Provider.MemberDaoProvider;
import com.zsh.Domian.SpaceMember;

public interface MemberDao {
	
	//向成员表中插入一条数据
	@InsertProvider(type=MemberDaoProvider.class,method="insertSpaceMember")
	public Integer insertSpaceMember(SpaceMember spaceMember);
	
	//查询出此空间的所有成员
	@Select (value="select * from "+SPACEMEMBERATABLE+" where space_id = #{spaceId}")
	@Results({
		@Result(column="space_id",property="space_id"),	
		//根据user_id来得到user的值
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.HomepageDao.selectUserNameByUserId")),			
	})
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId);
	
	//统计出此空间的所有成员个个数
	@Select (value="select count(*) from "+SPACEMEMBERATABLE+" where space_id = #{spaceId}")
	public int selectStudyMemberCountBySpaceId(Integer spaceId);	
	
}
