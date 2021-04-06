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
	
	//���Ա���в���һ������
	@InsertProvider(type=MemberDaoProvider.class,method="insertSpaceMember")
	public Integer insertSpaceMember(SpaceMember spaceMember);
	
	//��ѯ���˿ռ�����г�Ա
	@Select (value="select * from "+SPACEMEMBERATABLE+" where space_id = #{spaceId}")
	@Results({
		@Result(column="space_id",property="space_id"),	
		//����user_id���õ�user��ֵ
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.HomepageDao.selectUserNameByUserId")),			
	})
	public List<SpaceMember> selectMemberBySpaceId(Integer spaceId);
	
	//ͳ�Ƴ��˿ռ�����г�Ա������
	@Select (value="select count(*) from "+SPACEMEMBERATABLE+" where space_id = #{spaceId}")
	public int selectStudyMemberCountBySpaceId(Integer spaceId);	
	
}
