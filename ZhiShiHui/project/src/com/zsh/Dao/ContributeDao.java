package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.ContributeDomain;
import com.zsh.Domian.User;
import com.zsh.Provider.ContributeProvider;







@Repository
public interface ContributeDao {
	@SelectProvider(type=ContributeProvider.class,method="selectContributeWithParamCount")
	public int selectContributeWithParamCount(ContributeDomain contribute);
	
	//����id������Դ������ݣ����ҵ����µ�
	@Select("select * from devotion_inf where resource_id=#{resource_id} ORDER BY devotion_createdate DESC limit 1")
    public ContributeDomain selectByNewContributeId(int id);
	
	//����id������Դ������ݣ����ҵ����ϵ�
	@Select("select * from devotion_inf  WHERE resource_id=#{resource_id} ORDER BY devotion_createdate asc limit 1")
	public ContributeDomain selectByBeforeContributeId(int id);
	
	//ͨ��id��ѯ����
	@Select("SELECT * FROM devotion_inf WHERE devotion_id=#{devotion_id}")
    public ContributeDomain selectContributeById(Integer devotion_id);
	
	//����user�������
	@Select("select * from user_inf ")
	public List<User> selectAllUser();
	
	//����devotion�������
	@Select("select * from devotion_inf ")
	public List<ContributeDomain> selectAllContribute();
	
	//��̬����
	@SelectProvider(type=ContributeProvider.class,method="selectContributeWithParam1")
	@Results({
		@Result(column="user_id",property="user_id"),
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
//		@Result(column="resource_id",property="resource_id"),
//		@Result(column="resource_id",property="resource",one=@One(select="zhao.contribute.Dao.ResourceDao.selectByResourceId",fetchType=FetchType.LAZY)),
	})//property��ʾjavaʵ�����ԣ�column��ʾ���ݿ��ֶ�
	public List<ContributeDomain> selectContributeWithParam1(Map map1);
	
	
	//����Դ��������Դʱͬʱ���뵽devotion_inf����
	@InsertProvider(type=ContributeProvider.class,method="InsertDevotion")
	@Options(useGeneratedKeys=true,keyProperty="devotion_id")
	public Integer InsertDevotion(ContributeDomain devotion);
	
	
	//�����޸Ĺ�����Դ�Ĳ���
	@SelectProvider(type=ContributeProvider.class,method="selectUpdateResourceWithParam1")
	@Results({
		@Result(column="user_id",property="user_id"),
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectByUserId",fetchType=FetchType.LAZY)),
		@Result(column="resource_id",property="resource_id"),
		@Result(column="resource_id",property="resource",one=@One(select="com.zsh.Dao.ResourceDao.selectByResourceId",fetchType=FetchType.LAZY)),
	})//property��ʾjavaʵ�����ԣ�column��ʾ���ݿ��ֶ�
	public List<ContributeDomain> selectUpdateResourceWithParam1(Map map1);

}
