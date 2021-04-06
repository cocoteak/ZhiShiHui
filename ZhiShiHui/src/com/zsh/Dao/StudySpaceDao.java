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
	
		//��ѯ�ռ�������һ�����ݵ�space��id SELECT * FROM ��bai��du ORDER BY ��_ID DESC LIMIT 1
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_id DESC limit 1")
		public StudySpace selectLastSpaceIdBySpaceTable();
		
		//���ѧϰ�ռ�		
		@InsertProvider(type=StudySpaceDaoProvider.class,method="insertStudySpace")
		public int insertStudySpace(StudySpace studySpace);
	
		//recommend+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),			
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),			
		})
		public List<StudySpace> selectRecommendByRecentUpdate();	
		
		//recommend+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByRecentCreate();	
		
		//recommend+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByEarliestUpdate();	
		
		//recommend+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectRecommendByEarliestCreate();	
		
		//see+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByRecentUpdate();	
		
		//see+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByRecentCreate();	
		
		//see+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByEarliestUpdate();	
		
		//see+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zhuzsh.dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectSeeByEarliestCreate();
		
		//collect+recent_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����space_id���õ�spaceCollectList��ֵ		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByRecentUpdate();	
		
		//collect+recent_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����space_id���õ�spaceCollectList��ֵ		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByRecentCreate();	
		
		//collect+earliest_update
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����space_id���õ�spaceCollectList��ֵ		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByEarliestUpdate();	
		
		//collect+earliest_create
		@Select (value="select * from "+SPACETABLE+" ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����space_id���õ�spaceCollectList��ֵ		
			@Result(column="space_id",property="spaceCollectList",one=@One(select="com.zsh.Dao.StudySpaceDao.selectSpaceCollectBySpaceId")),
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectCollectByEarliestCreate();			
		
		//my+recent_update
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_updatetime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByRecentUpdate(Integer userId);	
		
		//my+recent_create
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_createtime DESC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zhuzsh.dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByRecentCreate(Integer userId);	
		
		//my+earliest_update
		@Select (value="select * from "+SPACETABLE+"  where user_id = #{userId} ORDER BY space_updatetime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),	
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByEarliestUpdate(Integer userId);	
		
		//my+earliest_create
		@Select (value="select * from "+SPACETABLE+" where user_id = #{userId} ORDER BY space_createtime ASC")
		@Results({
			@Result(column="space_id",property="space_id"),	
			//����user_id���õ�user��ֵ
			@Result(column="user_id",property="userName",one=@One(select="com.zsh.Dao.StudySpaceDao.selectUserNameByUserId")),	
			//����space_id���õ�space_collectCount��ֵ		
			@Result(column="space_id",property="space_collectCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectCollectCountBySpaceId")),
			//����space_id���õ�space_laudCount��ֵ		
			@Result(column="space_id",property="space_laudCount",one=@One(select="com.zsh.Dao.StudySpaceDao.selectLaudCountBySpaceId")),
		})
		public List<StudySpace> selectMyByEarliestCreate(Integer userId);	
		
		//����space_id��ѯ���˿ռ䱻��Щ���û��ղ�
		@Select(value="select user_id from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
		public List<SpaceCollect> selectSpaceCollectBySpaceId();		
		
		//����space_id��ѯ��Ӧ���ղ���
		@Select(value="select count(*) from "+SPACECOLLENTTABLE+" where space_id = #{spaceId}")
		public Integer selectCollectCountBySpaceId();
		
		//����user_id�õ�userName
		@Select(value="select user_name from "+USERTABLE+" where user_id = #{userId}")
		public String selectUserNameByUserId(Integer  userId);		
		
		//����space_id�õ�spaceLaudCount
		@Select(value="select count(*) from "+SPACELAUDTABLE+" where space_id = #{spaceId}")
		public Integer selectLaudCountBySpaceId(Integer userId);
		
		//����space_id�õ�spaceLaudCount
		@Select(value="select * from space_inf where space_id = #{space_id}")
		public StudySpace selectBySpaceId(Integer space_id);
		
}
