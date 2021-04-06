package com.zsh.Provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.Post;
import com.zsh.Domian.PostContent;


public class PostContentProvider {
	//动态新建帖子
	public String insertContent(final PostContent postContent){
		return new SQL(){{
			INSERT_INTO("post_content_inf");
			if(postContent.getContent_recordnum()!=null&&!postContent.getContent_recordnum().equals("")){
				VALUES("content_recordnum","#{content_recordnum}");
			}
			if(postContent.getContent_reply()!=null&&!postContent.getContent_reply().equals("")){
				VALUES("content_reply","#{content_reply}");
			}
			if(postContent.getReply_user_id()!=null){
				VALUES("reply_user_id","#{reply_user_id}");
			}
			if(postContent.getPost_id()!=null){
				VALUES("post_id","#{post_id}");
			}
			if(postContent.getUser_id()!=null){
				VALUES("user_id","#{user_id}");
			}
	      }
	    }.toString();
  }
	
		//分页查询
		public String selectPostContentWithPage(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_content_inf");
				PostContent postContent=(PostContent)map.get("postContent");
				if(postContent!=null){
				if(postContent.getContent_recordnum()!=null&&!postContent.getContent_recordnum().equals("")){
					WHERE("content_recordnum=#{postContent.content_recordnum}");
				}
				if(postContent.getContent_reply()!=null&&!postContent.getContent_reply().equals("")){
					WHERE("content_reply like concat('%',#{postContent.content_reply},'%')");
				}
				if(postContent.getContent_likenum()!=null&&!postContent.getContent_likenum().equals("")){
					WHERE("post_likenum like concat('%',#{postContent.post_likenum},'%')");
				}
				if(postContent.getContent_dislikenum ()!=null&&!postContent.getContent_dislikenum().equals("")){
					WHERE("post_dislikenum like concat('%',#{postContent.post_dislikenum},'%')");
				}
				if(postContent.getContent_updatetime()!=null&&!postContent.getContent_updatetime().equals("")){
					WHERE("content_updatetime=#{postContent.content_updatetime}");
				}
				if(postContent.getReply_user_id()!=null){
					WHERE("reply_user_id=#{postContent.reply_user_id}");
				}
				if(postContent.getPost_id()!=null){
					WHERE("post_id=#{postContent.post_id}");
				}
				if(postContent.getUser_id()!=null){
					WHERE("user_id=#{postContent.user_id}");
				}
		
		      }
		    }}.toString();
		    int pageNow=(Integer)map.get("pageNow");
		    int pageSize=(Integer)map.get("pageSize");
		    str=str+"group by  content_recordnum limit "+(pageNow-1)*pageSize+","+pageSize;
		    return str;	      
	  }		
		
		//分页查询
		public String selectAllRecordNum(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_content_inf");
				PostContent postContent=(PostContent)map.get("postContent");
				if(postContent!=null){
				if(postContent.getContent_recordnum()!=null&&!postContent.getContent_recordnum().equals("")){
					WHERE("content_recordnum=#{postContent.content_recordnum}");
				}
				if(postContent.getContent_reply()!=null&&!postContent.getContent_reply().equals("")){
					WHERE("content_reply like concat('%',#{postContent.content_reply},'%')");
				}
				if(postContent.getContent_likenum()!=null&&!postContent.getContent_likenum().equals("")){
					WHERE("post_likenum like concat('%',#{postContent.post_likenum},'%')");
				}
				if(postContent.getContent_dislikenum ()!=null&&!postContent.getContent_dislikenum().equals("")){
					WHERE("post_dislikenum like concat('%',#{postContent.post_dislikenum},'%')");
				}
				if(postContent.getContent_updatetime()!=null&&!postContent.getContent_updatetime().equals("")){
					WHERE("content_updatetime=#{postContent.content_updatetime}");
				}
				if(postContent.getReply_user_id()!=null){
					WHERE("reply_user_id=#{postContent.reply_user_id}");
				}
				if(postContent.getPost_id()!=null){
					WHERE("post_id=#{postContent.post_id}");
				}
				if(postContent.getUser_id()!=null){
					WHERE("user_id=#{postContent.user_id}");
				}
		      }
		    }}.toString();
		    str=str+"group by content_recordnum";
		    return str;	      
	  }		
		
		
		//查询总数
		public String selectPostContentAcount(final Map map){
			return new SQL(){{
				SELECT("*");
				FROM("post_content_inf");
				PostContent postContent=(PostContent)map.get("postContent");
				if(postContent!=null){
				if(postContent.getContent_recordnum()!=null&&!postContent.getContent_recordnum().equals("")){
					WHERE("content_recordnum=#{postContent.content_recordnum}");
				}
				if(postContent.getContent_reply()!=null&&!postContent.getContent_reply().equals("")){
					WHERE("content_reply like concat('%',#{postContent.content_reply},'%')");
				}
				if(postContent.getReply_user_id()!=null){
					WHERE("reply_user_id=#{postContent.reply_user_id}");
				}
				if(postContent.getPost_id()!=null){
					WHERE("post_id=#{postContent.post_id}");
				}
				if(postContent.getUser_id()!=null){
					WHERE("user_id=#{postContent.user_id}");
				}
		      }
		    }}.toString();
	}
		
		//具体查询某一条回复
		public String selectContent(final PostContent postContent){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_content_inf");
				if(postContent.getContent_id()!=null){
					WHERE("content_id=#{content_id}");
				}
				if(postContent.getContent_likenum()!=null){
					WHERE("find_in_set(#{content_likenum},content_likenum)");
				}
				if(postContent.getContent_dislikenum ()!=null){
					WHERE("find_in_set(#{content_dislikenum},content_dislikenum)");
				}
				if(postContent.getPost_id()!=null){
					WHERE("post_id=#{post_id}");
		      }
		    }}.toString();
		    return str;	      
	  }		
		
		//动态更新
		public String updateContent(final PostContent PostContent){
			return new SQL(){{
				UPDATE("post_content_inf");
				if(PostContent.getContent_likenum()!=null){
					SET("content_likenum=#{content_likenum}");
				}
				if(PostContent.getContent_dislikenum()!=null){
					SET("content_dislikenum=#{content_dislikenum}");
				}
				    WHERE("content_id=#{content_id}");
		      }
		    }.toString();
	  }
	}
