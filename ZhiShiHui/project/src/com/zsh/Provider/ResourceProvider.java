package com.zsh.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.Resources;

public class ResourceProvider {
	
	//动态新建帖子
	public String insertResource(final Resources resource){
		return new SQL(){{
			INSERT_INTO("resource_inf");
			if(resource.getResource_title()!=null&&!resource.getResource_title().equals("")){
				VALUES("resource_title","#{resource_title}");
			}
			if(resource.getResource_content()!=null&&!resource.getResource_content().equals("")){
				VALUES("resource_content","#{resource_content}");
			}
			if(resource.getResource_describe()!=null&&!resource.getResource_describe().equals("")){
				VALUES("resource_describe","#{resource_describe}");
			}
			if(resource.getResource_label()!=null&&!resource.getResource_label().equals("")){
				VALUES("resource_label","#{resource_label}");
			}
			if(resource.getResource_collection_ids()!=null&&!resource.getResource_collection_ids().equals("")){
				VALUES("resource_collection","#{resource_collection}");
			}
			if(resource.getResource_if_main()!=null&&!resource.getResource_if_main().equals("")){
				VALUES("resource_if_main","#{resource_if_main}");
			}
			if(resource.getResource_if_refined()!=null&&!resource.getResource_if_refined().equals("")){
				VALUES("resource_if_refined","#{resource_if_refined}");
			}
			if(resource.getUser_id()!=null&&!resource.getUser_id().equals("")){
				VALUES("user_id","#{user_id}");
			}
			if(resource.getSpace_id()!=null&&!resource.getSpace_id().equals("")){
				VALUES("space_id","#{space_id}");
			}
			if(resource.getResource_create_date()!=null&&!resource.getSpace_id().equals("")){
				VALUES("resource_create_date","#{resource_create_date}");
			}
	      }
	    }.toString();
  }
	
		//分页查询
		public String selectResourceWithPage(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("resource_inf");
				Resources resource=(Resources)map.get("resource");
				if(resource!=null){
				if(resource.getResource_title()!=null&&!resource.getResource_title().equals("")){
					WHERE("resource_title like concat('%',#{resource.resource_title},'%')");
				}
				if(resource.getResource_label()!=null&&!resource.getResource_label().equals("")){
					WHERE("resource_label like concat('%',#{resource.resource_label},'%')");
				}
				if(resource.getResource_like_num()!=null&&!resource.getResource_like_num().equals("")){
					WHERE("resource_likenum like concat('%',#{resource.resource_likenum},'%')");
				}
				if(resource.getResource_dislike_num()!=null&&!resource.getResource_dislike_num().equals("")){
					WHERE("resource_dislikenum like concat('%',#{resource.resource_dislikenum},'%')");
				}
				if(resource.getResource_collection_ids()!=null&&!resource.getResource_collection_ids().equals("")){
					WHERE("find_in_set(#{resource.resource_collection}, resource_collection)");
				}
				if(resource.getResource_create_date()!=null&&!resource.getResource_create_date().equals("")){
					WHERE("resource_create_date=#{resource.resource_create_date}");
				}if(resource.getResource_describe()!=null&&resource.getResource_describe().equals("")){
					WHERE("resource_discribe=#{resource.resource_discribe}");
				}
				if(resource.getResource_if_refined()!=null){
					WHERE("resource_if_refined=#{resource.resource_if_refined}");
				}if(resource.getResource_if_main()!=null){
					WHERE("resource_if_main=#{resource.resource_if_main}");
				}
				if(resource.getResource_id()!=null){
					WHERE("resource_id=#{resource.resource_id}");
				}
		      }
		    }}.toString();
		    int pageNow=(Integer)map.get("pageNow");
		    int pageSize=(Integer)map.get("pageSize");
		    str=str+" order by resource_id desc limit "+(pageNow-1)*pageSize+","+pageSize;
		    return str;	      
	  }
		
		//查询总数
		public String selectPostAcount(final Map map){
			String str=new SQL(){{
				SELECT("count(1)");
				FROM("resource_inf");
				Resources resource=(Resources)map.get("resource");
				if(resource!=null){
				if(resource.getResource_title()!=null&&!resource.getResource_title().equals("")){
					WHERE("resource_title like concat('%',#{resource.resource_title},'%')");
				}
				if(resource.getResource_label()!=null&&!resource.getResource_label().equals("")){
					WHERE("resource_label like concat('%',#{resource.resource_label},'%')");
				}
				if(resource.getResource_like_num()!=null&&!resource.getResource_like_num().equals("")){
					WHERE("resource_likenum like concat('%',#{resource.resource_likenum},'%')");
				}
				if(resource.getResource_dislike_num()!=null&&!resource.getResource_dislike_num().equals("")){
					WHERE("resource_dislikenum like concat('%',#{resource.resource_dislikenum},'%')");
				}
				if(resource.getResource_describe()!=null&&!resource.getResource_describe().equals("")){
					WHERE("find_in_set(#{resource.resource_describe}, resource_describe)");
				}
				if(resource.getResource_create_date()!=null&&!resource.getResource_create_date().equals("")){
					WHERE("resource.resource_create_date=#{resource.resource_create_date}");
				}
				if(resource.getResource_if_refined()!=null){
					WHERE("resource_if_refined=#{resource.resource_if_refined}");
				}if(resource.getResource_if_main()!=null){
					WHERE("resource_if_main=#{resource.resource_if_main}");
				}
				if(resource.getResource_id()!=null){
					WHERE("resource_id=#{resource.resource_id}");
				}if(resource.getResource_collection_ids()!=null&&!resource.getResource_collection_ids().equals("")){
					WHERE("resource_collection=#{resource.resource_collection}");
				}
		      }
		    }}.toString();
		    str=str+" order by resource_create_date desc ";
		    return str;	
	}

		
		//动态更新
		public String updatePost(final Resources resource){
			return new SQL(){{
				UPDATE("resource_inf");
				if(resource.getResource_title()!=null&&!resource.getResource_title().equals("")){
					SET("resource_title=#{resource_title}");
				}
				if(resource.getResource_label()!=null&&!resource.getResource_label().equals("")){
					SET("resource_label=#{resource_label}");
				}
				if(resource.getResource_like_num()!=null){
					SET("resource_likenum=#{resource_likenum}");
				}
				if(resource.getResource_dislike_num()!=null){
					SET("resource_dislikenum=#{resource_dislikenum}");
				}
				if(resource.getResource_collection_ids()!=null){
					SET("resource_collection=#{resource_collection}");
				}
				if(resource.getResource_if_main()!=null){
					SET("resource_ifmain=#{resource_ifmain}");
				}
				    WHERE("resource_id=#{resource_id}");
		      }
		    }.toString();
	  }
}
//
////动态更新
//public String selectPostChange(final Resources resource){
//	String str=new SQL(){{
//		SELECT("*");
//		FROM("resource_inf");
//		if(resource.getResource_like_num()!=null&&!resource.getResource_like_num().equals("")){
//			WHERE("find_in_set(#{resource_likenum},resource_likenum)");
//		}if(resource.getResource_describe()!=null&&!resource.getResource_describe().equals("")){
//			WHERE("find_in_set(#{resource_describe},resource_describe)");
//		}
//		if(resource.getResource_dislike_num()!=null&&!resource.getResource_dislike_num().equals("")){
//			WHERE("find_in_set(#{resource_dislikenum},resource_dislikenum)");
//		}
//		if(resource.getResource_collection_ids()!=null&&!resource.getResource_collection_ids().equals("")){
//			WHERE("find_in_set(#{resource_collection}, resource_collection)");
//		}
//		    WHERE("resource_id=#{resource_id}");
//      }
//    }.toString();
//    return str;	
//}	
