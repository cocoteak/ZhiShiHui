package com.zsh.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.zsh.Domian.Post;
import com.zsh.Domian.PostContent;
import com.zsh.Provider.PostContentProvider;
import com.zsh.Provider.PostProvider;

public interface PostContentService {
	public int insertContent(PostContent postContent);
	
	public List<PostContent> selectPostContentWithPage(Map map);
	
	public List<PostContent> selectPostContentAcount(Map map);
	
	public List<PostContent> selectAllContent(Integer post_id);
	
	public List<PostContent>  selectLeastPost();
	
	public Integer selectLeastContentNum(Integer post_id);
	
	public List<PostContent> selectAllRecordNum(Map map);
	
	public int updateContent(PostContent PostContent);
	
	public PostContent selectContent(PostContent postContent);
    
	public int deleteContent(Integer content_id);
	
	int SelectTable();
}
