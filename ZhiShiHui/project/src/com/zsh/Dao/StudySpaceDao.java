package com.zsh.Dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import static com.zsh.util.ZhuZSHConstants.SPACETABLE;
import static com.zsh.util.ZhuZSHConstants.USERTABLE;
import static com.zsh.util.ZhuZSHConstants.SPACECOLLENTTABLE;
import static com.zsh.util.ZhuZSHConstants.SPACELAUDTABLE;

import com.zsh.Provider.StudySpaceDaoProvider;
import com.zsh.Domian.SpaceCollect;
import com.zsh.Domian.StudySpace;

public interface StudySpaceDao {
	
		//查询空间表中最后一天数据的space＿id SELECT * FROM 表bai名du ORDER BY 表_ID DESC LIMIT 1
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_id DESC limit 1")
		public StudySpace selectLastSpaceIdBySpaceTable();
		
		//添加学习空间		
		@InsertProvider(type=StudySpaceDaoProvider.class,method="insertStudySpace")
		public int insertStudySpace(StudySpace studySpace);
	
		//recommend+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),			
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),			
		})
		public List<StudySpace> selectRecommendByRecentUpdate();	
		
		//recommend+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByRecentCreate();	
		
		//recommend+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByEarliestUpdate();	
		
		//recommend+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByEarliestCreate();	
		
		//see+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByRecentUpdate();	
		
		//see+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByRecentCreate();	
		
		//see+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByEarliestUpdate();	
		
		//see+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zhuzsh.dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByEarliestCreate();
		
		//collect+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//利用space_id来得到spaceCollectList的值		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByRecentUpdate();	
		
		//collect+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//利用space_id来得到spaceCollectList的值		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByRecentCreate();	
		
		//collect+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//利用space_id来得到spaceCollectList的值		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByEarliestUpdate();	
		
		//collect+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//利用space_id来得到spaceCollectList的值		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByEarliestCreate();			
		
		//my+recent_update
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByRecentUpdate(Integer userId);	
		
		//my+recent_create
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zhuzsh.dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByRecentCreate(Integer userId);	
		
		//my+earliest_update
		@Select (value="select * from "+SPACETABLE+"  where user_id = #{userId} ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByEarliestUpdate(Integer userId);	
		
		//my+earliest_create
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//根据user_id来得到user的值
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//利用space_id来得到space_collectCount的值		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//利用space_id来得到space_laudCount的值		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByEarliestCreate(Integer userId);	
		
		//根据space_id查询出此空间被那些有用户收藏
		@Select(value="select user_id from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
		public List<SpaceCollect> selectSpaceCollectBySpaceId();		
		
		//根据space_id查询对应的收藏数
		@Select(value="select count(*) from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
		public Integer selectCollectCountBySpaceId();
		
		//根据user_id得到userName
		@Select(value="select user_name from "+USERTABLE+" where user_id = #{userId}")
		public String selectUserNameByUserId(Integer  userId);		
		
		//根据space_id得到spaceLaudCount
		@Select(value="select count(*) from "+SPACELAUDTABLE+" where space_id = #{spaceId}")
		public Integer selectLaudCountBySpaceId(Integer userId);
		
		//根据space_id得到spaceLaudCount
		@Select(value="select * from space_inf where space_id = #{space_id}")
		public StudySpace selectBySpaceId(Integer space_id);
		
}
