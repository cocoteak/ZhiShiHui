package com.zsh.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.ContributeContent;





public class ContributeContentProvider {
	//动态新建帖子
	public String addReplay(final ContributeContent contributeContent){
		return new SQL(){{
			INSERT_INTO("devotion_content_inf");
			if(contributeContent.getDevotion_recordnum()!=null&&!contributeContent.getDevotion_recordnum().equals("")){
				VALUES("devotion_recordnum","#{devotion_recordnum}");
			}
			if(contributeContent.getDevotion_content()!=null&&!contributeContent.getDevotion_content().equals("")){
				VALUES("devotion_content","#{devotion_content}");
			}
			if(contributeContent.getUser_id()!=null){
				VALUES("user_id","#{user_id}");
			}
			if(contributeContent.getDevotion_id()!=null){
				VALUES("devotion_id","#{devotion_id}");
			}
	      }
	    }.toString();
  }
	
		//分页查询
		public String selectContributeContentWithPage(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("devotion_content_inf");
				ContributeContent contributeContent=(ContributeContent)map.get("contributeContent");
				if(contributeContent!=null){
				if(contributeContent.getDevotion_recordnum()!=null&&!contributeContent.getDevotion_recordnum().equals("")){
					WHERE("devotion_recordnum=#{contributeContent.devotion_recordnum}");
				}
				if(contributeContent.getDevotion_content()!=null&&!contributeContent.getDevotion_content().equals("")){
					WHERE("devotion_content like concat('%',#{contributeContent.devotion_content},'%')");
				}
				if(contributeContent.getDevotion_likenum()!=null&&!contributeContent.getDevotion_likenum().equals("")){
					WHERE("devotion_likenum like concat('%',#{contributeContent.devotion_likenum},'%')");
				}
				if(contributeContent.getDevotion_dislikenum ()!=null&&!contributeContent.getDevotion_dislikenum().equals("")){
					WHERE("devotion_dislikenum like concat('%',#{contributeContent.devotion_dislikenum},'%')");
				}
				if(contributeContent.getDevotion_createdate()!=null&&!contributeContent.getDevotion_createdate().equals("")){
					WHERE("devotion_createdate=#{contributeContent.devotion_createdate}");
				}
				if(contributeContent.getUser_id()!=null){
					WHERE("user_id=#{contributeContent.user_id}");
				}
				if(contributeContent.getDevotion_id()!=null){
					WHERE("devotion_id()=#{contributeContent.devotion_id()}");
				}
		
		      }
		    }}.toString();
		    int pageNow=(Integer)map.get("pageNow");
		    int pageSize=(Integer)map.get("pageSize");
		    str=str+"group by devotion_recordnum limit "+(pageNow-1)*pageSize+","+pageSize;
		    return str;	      
	  }		
		
		//分页查询
		public String selectAllRecordNum(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("devotion_content_inf");
				ContributeContent contributeContent=(ContributeContent)map.get("contributeContent");
				if(contributeContent!=null){
				if(contributeContent.getDevotion_recordnum()!=null&&!contributeContent.getDevotion_recordnum().equals("")){
					WHERE("devotion_recordnum=#{contributeContent.devotion_recordnum}");
				}
				if(contributeContent.getDevotion_content()!=null&&!contributeContent.getDevotion_content().equals("")){
					WHERE("devotion_content like concat('%',#{contributeContent.devotion_content},'%')");
				}
				if(contributeContent.getDevotion_likenum()!=null&&!contributeContent.getDevotion_likenum().equals("")){
					WHERE("devotion_likenum like concat('%',#{contributeContent.devotion_likenum},'%')");
				}
				if(contributeContent.getDevotion_dislikenum ()!=null&&!contributeContent.getDevotion_dislikenum().equals("")){
					WHERE("devotion_dislikenum like concat('%',#{contributeContent.devotion_dislikenum},'%')");
				}
				if(contributeContent.getDevotion_createdate()!=null&&!contributeContent.getDevotion_createdate().equals("")){
					WHERE("devotion_createdate=#{contributeContent.devotion_createdate}");
				}
				if(contributeContent.getUser_id()!=null){
					WHERE("user_id=#{contributeContent.user_id}");
				}
				if(contributeContent.getDevotion_id()!=null){
					WHERE("devotion_id()=#{contributeContent.devotion_id()}");
				}
		
		      }
		    }}.toString();
		    str=str+"group by devotion_recordnum";
		    return str;	      
	  }		
		
		
		//查询总数
		public String selectContributeContentAcount(final Map map){
			String str=new SQL(){{
				SELECT("*");
				FROM("devotion_content_inf");
				ContributeContent contributeContent=(ContributeContent)map.get("contributeContent");
				if(contributeContent!=null){
				if(contributeContent.getDevotion_recordnum()!=null&&!contributeContent.getDevotion_recordnum().equals("")){
					WHERE("devotion_recordnum=#{contributeContent.devotion_recordnum}");
				}
				if(contributeContent.getDevotion_content()!=null&&!contributeContent.getDevotion_content().equals("")){
					WHERE("devotion_content like concat('%',#{contributeContent.devotion_content},'%')");
				}
				if(contributeContent.getDevotion_likenum()!=null&&!contributeContent.getDevotion_likenum().equals("")){
					WHERE("devotion_likenum like concat('%',#{contributeContent.devotion_likenum},'%')");
				}
				if(contributeContent.getDevotion_dislikenum ()!=null&&!contributeContent.getDevotion_dislikenum().equals("")){
					WHERE("devotion_dislikenum like concat('%',#{contributeContent.devotion_dislikenum},'%')");
				}
				if(contributeContent.getDevotion_createdate()!=null&&!contributeContent.getDevotion_createdate().equals("")){
					WHERE("devotion_createdate=#{contributeContent.devotion_createdate}");
				}
				if(contributeContent.getUser_id()!=null){
					WHERE("user_id=#{contributeContent.user_id}");
				}
				if(contributeContent.getDevotion_id()!=null){
					WHERE("devotion_id()=#{contributeContent.devotion_id()}");
				}
		
		      }
		    }}.toString();
			return str;
	}
	}
