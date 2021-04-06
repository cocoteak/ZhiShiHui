package com.zsh.Service;

import java.util.List;
import java.util.Map;
import com.zsh.Domian.Post;

public interface PostService {
	public List<Post> selectPostAccount(Map map);

	public List<Post> selectPostWithParamPage(Map map) ;

	public int insertPost(Post post);

	public int updatePost(Post post);

	public Post selectPostById(Integer post_id);
	
	public List<Integer> selectPosAllId();
	
	public Post selectPostChange(Post post);
	
	public int deletePost(Integer post_id);
	
	int SelectTable(Integer space_id);

}
