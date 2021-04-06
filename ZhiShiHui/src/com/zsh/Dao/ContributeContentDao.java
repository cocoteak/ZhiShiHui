package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.ContributeContent;
import com.zsh.Provider.ContributeContentProvider;



@Repository
public interface ContributeContentDao {
	//动态添加
	//动态回复
	@InsertProvider(type=ContributeContentProvider.class,method="addReplay")	
	@Options(useGeneratedKeys=true,keyProperty="content_id")
	public Integer addReplay(ContributeContent content);
	
	
	//分页查询
	@SelectProvider(type=ContributeContentProvider.class,method="selectContributeContentWithPage")
	@Results({
		@Result(column="devotion_id",property="devotion",one=@One(select="zhao.contribute.Dao.ContributeDao.selectContributeById",fetchType=FetchType.LAZY)),
		@Result(column="devotion_id",property="devotion_id")
	})
	List<ContributeContent> selectContributeContentWithPage(Map map);
	
	//按楼层分组查询回复帖子(先确定在哪一个讨论帖，再根据楼层分组)
	@SelectProvider(type=ContributeContentProvider.class,method="selectAllRecordNum")
	List<ContributeContent> selectAllRecordNum(Map map);
	
	
	//查询回复总数
	@SelectProvider(type=ContributeContentProvider.class,method="selectContributeContentAcount")
	List<ContributeContent> selectContributeContentAcount(Map map);
	
	
	//查询最新一条回复的时间
	@Select("SELECT * from (SELECT * FROM devotion_content_inf ORDER BY devotion_createdate DESC) devotion_content_inf GROUP BY devotion_id DESC")
	List<ContributeContent> selectLeastcontribute();
	
	//查询指定帖子中的所有回复
	@Select("SELECT * from devotion_content_inf where devotion_id=#{devotion_id}")
	List<ContributeContent> selectAllContent(Integer devotion_id);
	
	//查询帖子最新一条回复楼层
	@Select("select devotion_recordnum from devotion_content_inf where devotion_recordnum = (select max(devotion_recordnum) from devotion_content_inf order by devotion_id) and devotion_id=#{devotion_id}")
	Integer selectLeastContentNum(Integer devotion_id);
	
	
	
}
