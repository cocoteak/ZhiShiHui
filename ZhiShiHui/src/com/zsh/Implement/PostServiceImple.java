package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsh.Dao.PostDao;
import com.zsh.Domian.Post;
import com.zsh.Service.PostService;

@Service("postServiceImple")
public class PostServiceImple implements PostService {
	@Resource(name="postDao")
	PostDao postDao;

	public List<Post> selectPostAccount(Map map) {
		return postDao.selectPostAccount(map);
	}

	public List<Post> selectPostWithParamPage(Map map) {
		return postDao.selectPostWithParamPage(map);
	}

	public int insertPost(Post post) {
		return  postDao.insertPost(post);
	}

	public int updatePost(Post post) {
		return postDao.updatePost(post);
	}

	public Post selectPostById(Integer post_id) {
		return postDao.selectPostById(post_id);
	}

	public List<Integer> selectPosAllId() {
		// TODO Auto-generated method stub
		return postDao.selectPosAllId();
	}

	public Post selectPostChange(Post post) {
		// TODO Auto-generated method stub
		return postDao.selectPostChange(post);
	}

	public int deletePost(Integer post_id) {
		// TODO Auto-generated method stub
		return postDao.deletePost(post_id);
	}

	public int SelectTable(Integer space_id) {
		// TODO Auto-generated method stub
		return postDao.SelectTable(space_id);
	}

	

	

}
