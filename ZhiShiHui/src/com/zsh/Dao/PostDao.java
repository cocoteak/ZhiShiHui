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
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.Post;
import com.zsh.Provider.PostProvider;

@Repository("postDao")
public interface PostDao {
	//ÅÐ¶Ï±íÊÇ·ñÎª¿Õ
	@Select("select count(*) from post_inf where space_id=#{space_id}")
	int SelectTable(Integer space_id);
	
	@InsertProvider(type=PostProvider.class,method="insertPost")
	@Options(useGeneratedKeys=true,keyProperty="post_id")
	int insertPost(Post post);
	
	@SelectProvider(type=PostProvider.class,method="selectPostWithPage")
	@Results({
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="user_id",property="user_id"),
		@Result(column="space_id",property="space_id"),
		@Result(column="space_id",property="studySpace",one=@One(select="com.zsh.Dao.StudySpaceDao.selectBySpaceId",fetchType=FetchType.LAZY))
	})
	List<Post> selectPostWithParamPage(Map map);
	
	@SelectProvider(type=PostProvider.class,method="selectPostAcount")
	List<Post> selectPostAccount(Map map);

	@Select("SELECT post_id FROM post_inf")
    public List<Integer> selectPosAllId();
	
	@Select("SELECT * FROM post_inf WHERE post_id=#{post_id}")
	@Results({
		@Result(column="user_id",property="user",one=@One(select="com.zsh.Dao.UserDao.selectUserById",fetchType=FetchType.LAZY)),
		@Result(column="user_id",property="user_id")
	})
    public Post selectPostById(Integer post_id);
	
	@UpdateProvider(type=PostProvider.class,method="updatePost")
	int updatePost(Post post);
	
	@SelectProvider(type=PostProvider.class,method="selectPostChange")
	public Post selectPostChange(final Post post);

	@Delete("delete from post_inf WHERE post_id=#{post_id}")
    public int deletePost(Integer post_id);
	
}
