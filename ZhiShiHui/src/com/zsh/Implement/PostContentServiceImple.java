package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsh.Dao.PostContentDao;
import com.zsh.Domian.Post;
import com.zsh.Domian.PostContent;
import com.zsh.Service.PostContentService;


@Service("postContentServiceImple")
public class PostContentServiceImple implements PostContentService {
	@Resource(name="postContentDao")
	PostContentDao postContentDao;

	public List<PostContent> selectPostContentAcount(Map map) {
		return postContentDao.selectPostContentAcount(map);
	}

	public List<PostContent> selectPostContentWithPage(Map map) {
		return postContentDao.selectPostContentWithPage(map);
	}

	public int insertContent(PostContent postContent) {
		return postContentDao.insertContent(postContent);
	}

	public List<PostContent>  selectLeastPost() {
		// TODO Auto-generated method stub
		return postContentDao.selectLeastPost();
	}

	public List<PostContent> selectAllContent(Integer post_id) {
		// TODO Auto-generated method stub
		return postContentDao.selectAllContent(post_id);
	}

	public Integer selectLeastContentNum(Integer post_id) {
		// TODO Auto-generated method stub
		return postContentDao.selectLeastContentNum(post_id);
	}

	public List<PostContent> selectAllRecordNum(Map map) {
		return postContentDao.selectAllRecordNum(map);
	}

	public int updateContent(PostContent PostContent) {
		return postContentDao.updateContent(PostContent);
	}

	public PostContent selectContent(PostContent postContent) {
		// TODO Auto-generated method stub
		return postContentDao.selectContent(postContent);
	}

	public int deleteContent(Integer post_id) {
		// TODO Auto-generated method stub
		return postContentDao.deleteContent(post_id);
	}

	public int SelectTable() {
		// TODO Auto-generated method stub
		return postContentDao.SelectTable();
	}
	
}
