package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
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

import com.zsh.Domian.PostContent;
import com.zsh.Provider.PostContentProvider;

@Repository("postContentDao")
public interface PostContentDao {
	//ÅÐ¶Ï±íÊÇ·ñÎª¿Õ
	@Select("select count(*) from post_content_inf")
	int SelectTable();
	
	@InsertProvider(type=PostContentProvider.class,method="insertContent")
	@Options(useGeneratedKeys=true,keyProperty="content_id")
	int insertContent(PostContent postConent);
	
	@SelectProvider(type=PostContentProvider.class,method="selectPostContentWithPage")
	@Results({
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="user_id",property="user_id")
	})
	List<PostContent> selectPostContentWithPage(Map map);
	
	@SelectProvider(type=PostContentProvider.class,method="selectAllRecordNum")
	List<PostContent> selectAllRecordNum(Map map);
	
	@SelectProvider(type=PostContentProvider.class,method="selectPostContentAcount")
	List<PostContent> selectPostContentAcount(Map map);
	
	
	@Select("SELECT * FROM post_content_inf GROUP BY post_id ORDER BY content_updatetime DESC")
	@Results({
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="user_id",property="user_id")
	})
	List<PostContent> selectLeastPost();

	@Select("SELECT * from post_content_inf where post_id=#{post_id}")
	@Results({
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="user_id",property="user_id")
	})
	List<PostContent> selectAllContent(Integer post_id);
	
	@Select("select MAX(content_recordnum) from post_content_inf where post_id=#{post_id}")
	Integer selectLeastContentNum(Integer post_id);
	
	@SelectProvider(type=PostContentProvider.class,method="selectContent")
	public PostContent selectContent(PostContent postContent);
	
	@UpdateProvider(type=PostContentProvider.class,method="updateContent")
	public int updateContent(PostContent PostContent);
	
	@Delete("delete from post_content_inf WHERE  post_id=#{ post_id}")
    public int deleteContent(Integer post_id);
}
