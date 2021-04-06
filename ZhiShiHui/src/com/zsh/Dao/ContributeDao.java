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
	
	//根据id查找资源表的内容，查找的最新的
	@Select("select * from devotion_inf where resource_id=#{resource_id} ORDER BY devotion_createdate DESC limit 1")
    public ContributeDomain selectByNewContributeId(int id);
	
	//根据id查找资源表的内容，查找的最老的
	@Select("select * from devotion_inf  WHERE resource_id=#{resource_id} ORDER BY devotion_createdate asc limit 1")
	public ContributeDomain selectByBeforeContributeId(int id);
	
	//通过id查询贡献
	@Select("SELECT * FROM devotion_inf WHERE devotion_id=#{devotion_id}")
    public ContributeDomain selectContributeById(Integer devotion_id);
	
	//查找user表的内容
	@Select("select * from user_inf ")
	public List<User> selectAllUser();
	
	//查找devotion表的内容
	@Select("select * from devotion_inf ")
	public List<ContributeDomain> selectAllContribute();
	
	//动态查找
	@SelectProvider(type=ContributeProvider.class,method="selectContributeWithParam1")
	@Results({
		@Result(column="user_id",property="user_id"),
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
//		@Result(column="resource_id",property="resource_id"),
//		@Result(column="resource_id",property="resource",one=@One(select="zhao.contribute.Dao.ResourceDao.selectByResourceId",fetchType=FetchType.LAZY)),
	})//property表示java实体属性，column表示数据库字段
	public List<ContributeDomain> selectContributeWithParam1(Map map1);
	
	
	//在资源区发表资源时同时插入到devotion_inf表中
	@InsertProvider(type=ContributeProvider.class,method="InsertDevotion")
	@Options(useGeneratedKeys=true,keyProperty="devotion_id")
	public Integer InsertDevotion(ContributeDomain devotion);
	
	
	//对于修改过的资源的查找
	@SelectProvider(type=ContributeProvider.class,method="selectUpdateResourceWithParam1")
	@Results({
		@Result(column="user_id",property="user_id"),
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectByUserId",fetchType=FetchType.LAZY)),
		@Result(column="resource_id",property="resource_id"),
		@Result(column="resource_id",property="resource",one=@One(select="com.zsh.Dao.ResourceDao.selectByResourceId",fetchType=FetchType.LAZY)),
	})//property表示java实体属性，column表示数据库字段
	public List<ContributeDomain> selectUpdateResourceWithParam1(Map map1);

}
