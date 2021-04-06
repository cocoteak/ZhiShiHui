package com.zsh.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.Post;


public class PostProvider {
	public String insertPost(final Post post){
		return new SQL(){{
			INSERT_INTO("post_inf");
			if(post.getPost_title()!=null&&!post.getPost_title().equals("")){
				VALUES("post_title","#{post_title}");
			}
			if(post.getPost_content()!=null&&!post.getPost_content().equals("")){
				VALUES("post_content","#{post_content}");
			}
			if(post.getPost_reminder()!=null&&!post.getPost_reminder().equals("")){
				VALUES("post_reminder","#{post_reminder}");
			}
			if(post.getPost_label()!=null&&!post.getPost_label().equals("")){
				VALUES("post_label","#{post_label}");
			}
			if(post.getPost_collection()!=null&&!post.getPost_collection().equals("")){
				VALUES("post_collection","#{post_collection}");
			}
			if(post.getUser_id()!=null){
			    VALUES("user_id","#{user_id}");
			}
			if(post.getSpace_id()!=null){
			    VALUES("space_id","#{space_id}");
			}
	      }
	    }.toString();
  }
	
		public String selectPostWithPage(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_inf");
				Post post=(Post)map.get("post");
				if(post!=null){
				if(post.getPost_title()!=null&&!post.getPost_title().equals("")){
					WHERE("post_title like concat('%',#{post.post_title},'%')");
				}
				if(post.getPost_label()!=null&&!post.getPost_label().equals("")){
					WHERE("post_label like concat('%',#{post.post_label},'%')");
				}
				if(post.getPost_likenum()!=null&&!post.getPost_likenum().equals("")){
					WHERE("post_likenum like concat('%',#{post.post_likenum},'%')");
				}
				if(post.getPost_dislikenum ()!=null&&!post.getPost_dislikenum().equals("")){
					WHERE("post_dislikenum like concat('%',#{post.post_dislikenum},'%')");
				}
				if(post.getPost_collection()!=null&&!post.getPost_collection().equals("")){
					WHERE("find_in_set(#{post.post_collection}, post_collection)");
				}
				if(post.getPost_ifrefined()!=null){
					WHERE("post_ifrefined=#{post.post_ifrefined}");
				}
				if(post.getPost_id()!=null){
					WHERE("post_id=#{post.post_id}");
				}
			    if(post.getUser_id()!=null){
			    	WHERE("user_id=#{post.user_id}");
				}
			    if(post.getSpace_id()!=null){
			    	WHERE("space_id=#{post.space_id}");
				}
		      }
		    }}.toString();
		    int pageNow=(Integer)map.get("pageNow");
		    int pageSize=(Integer)map.get("pageSize");
		    str=str+" order by post_createtime desc limit "+(pageNow-1)*pageSize+","+pageSize;
		    return str;	      
	  }
		
		public String selectPostAcount(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_inf");
				Post post=(Post)map.get("post");
				if(post!=null){
				if(post.getPost_title()!=null&&!post.getPost_title().equals("")){
					WHERE("post_title like concat('%',#{post.post_title},'%')");
				}
				if(post.getPost_label()!=null&&!post.getPost_label().equals("")){
					WHERE("post_label like concat('%',#{post.post_label},'%')");
				}
				if(post.getPost_likenum()!=null&&!post.getPost_likenum().equals("")){
					WHERE("post_likenum like concat('%',#{post.post_likenum},'%')");
				}
				if(post.getPost_dislikenum ()!=null&&!post.getPost_dislikenum().equals("")){
					WHERE("post_dislikenum like concat('%',#{post.post_dislikenum},'%')");
				}
				if(post.getPost_collection()!=null&&!post.getPost_collection().equals("")){
					WHERE("find_in_set(#{post.post_collection}, post_collection)");
				}
				if(post.getPost_createtime()!=null){
					WHERE("post_createtime=#{post.createtime}");
				}
				if(post.getPost_ifrefined()!=null){
					WHERE("post_ifrefined=#{post.post_ifrefined}");
				}
				if(post.getPost_id()!=null){
					WHERE("post_id=#{post.post_id}");
				}
				if(post.getUser_id()!=null){
					WHERE("user_id=#{post.user_id}");
				}
				if(post.getSpace_id()!=null){
				    WHERE("space_id=#{post.space_id}");
				}
		      }
		    }}.toString();
		    str=str+" order by post_createtime desc ";
		    return str;	
	}

		public String selectPostChange(final Post post){
			String str=new SQL(){{
				SELECT("*");
				FROM("post_inf");
				if(post.getPost_likenum()!=null&&!post.getPost_likenum().equals("")){
					WHERE("find_in_set(#{post_likenum},post_likenum)");
				}
				if(post.getPost_dislikenum ()!=null&&!post.getPost_dislikenum().equals("")){
					WHERE("find_in_set(#{post_dislikenum},post_dislikenum)");
				}
				if(post.getPost_collection()!=null&&!post.getPost_collection().equals("")){
					WHERE("find_in_set(#{post_collection}, post_collection)");
				}
				    WHERE("post_id=#{post_id}");
		      }
		    }.toString();
		    return str;	
	  }	
		
		public String updatePost(final Post post){
			return new SQL(){{
				UPDATE("post_inf");
				if(post.getPost_title()!=null&&!post.getPost_title().equals("")){
					SET("post_title=#{post_title}");
				}
				if(post.getPost_label()!=null&&!post.getPost_label().equals("")){
					SET("post_label=#{post_label}");
				}
				if(post.getPost_content()!=null&&!post.getPost_content().equals("")){
					SET("post_content=#{post_content}");
				}
				if(post.getPost_likenum()!=null){
					SET("post_likenum=#{post_likenum}");
				}
				if(post.getPost_dislikenum ()!=null){
					SET("post_dislikenum=#{post_dislikenum}");
				}
				if(post.getPost_collection()!=null){
					SET("post_collection=#{post_collection}");
				}
				if(post.getPost_ifrefined()!=null){
					SET("post_ifrefined=#{post_ifrefined}");
				}
				    WHERE("post_id=#{post_id}");
		      }
		    }.toString();
	  }
	}
