package com.zsh.Provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.ContributeContent;
import com.zsh.Domian.ContributeDomain;



public class ContributeProvider {
	//在插入资源的时候同时向贡献表中插入贡献，与资源表同步
	public String InsertDevotion(final ContributeDomain contribute){
		return new SQL(){{
			INSERT_INTO("devotion_inf");
			if(contribute.getResource_title()!=null&&!contribute.getResource_title().equals("")){
				VALUES("resource_title","#{resource_title}");
			}
			if(contribute.getResource_content()!=null&&!contribute.getResource_content().equals("")){
				VALUES("resource_content","#{resource_content}");
			}
			if(contribute.getResource_describe()!=null&&!contribute.getResource_describe().equals("")){
				VALUES("resource_describe","#{resource_describe}");
			}
			if(contribute.getResource_label()!=null&&!contribute.getResource_label().equals("")){
				VALUES("resource_label","#{resource_label}");
			}
			if(contribute.getResource_filePath()!=null&&!contribute.getResource_filePath().equals("")){
				VALUES("resource_filePath","#{resource_filePath}");
			}
			if(contribute.getDevotion_createdate()!=null&&!contribute.getDevotion_createdate().equals("")){
				VALUES("devotion_createdate","#{devotion_createdate}");
			}
			if(contribute.getResource_id()!=null){
				VALUES("Resource_id","#{Resource_id}");
			
			}
	      }
	    }.toString();
  }
	
	public String selectContributeWithParamCount(final ContributeDomain contribute){
		return new SQL(){{
			SELECT("count(*)");
			FROM("devotion_inf");
			if(contribute.getResource_content()!=null&&!contribute.getResource_content().equals("")){
				WHERE("resource_content like concat ('%',#{resource_content},'%')");
			}
			
		}}.toString();	
	}
	//分页查询
	public String selectContributeWithParam1(final Map map){
		String str=new SQL(){{
			SELECT("*");
			FROM("devotion_inf");
			ContributeDomain contribute=(ContributeDomain)map.get("post");
			if(contribute!=null){
			if(contribute.getResource_title()!=null&&!contribute.getResource_title().equals("")){
				WHERE("resource_title like concat('%',#{contribute.resource_title},'%')");
			}
			if(contribute.getResource_content()!=null&&!contribute.getResource_content().equals("")){
				WHERE("resource_content like concat('%',#{contribute.resource_content()},'%')");
			}
			
			if(contribute.getResource_describe()!=null&&!contribute.getResource_describe().equals("")){
				WHERE("resource_describe()=#{contribute.resource_describe()}");
			}
			if(contribute.getResource_filePath()!=null&&!contribute.getResource_filePath().equals("")){
				WHERE("resource_filePath=#{contribute.resource_filePath}");
			}
			if(contribute.getResource_label()!=null&&!contribute.getResource_label().equals("")){
				WHERE("resource_label like concat('%',#{contribute.resource_label},'%')");
			}
			if(contribute.getDevotion_createdate()!=null&&!contribute.getDevotion_createdate().equals("")){
				WHERE("devotion_createdate like concat('%',#{contribute.devotion_createdate},'%')");
			}
	//		if(contribute.getSpace_id()!=null){
//				VALUES("Space_id","#{Space_id}");
//			}
	//		if(post.getUSER_ID()!=null){
//				VALUES("USER_ID","#{USER_ID}");
//			}
	      }
	    }}.toString();
	    int pageNow=(Integer)map.get("pageNow");
	    int pageSize=(Integer)map.get("pageSize");
	    str=str+" order by devotion_createdate desc limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str;	      
  }
	public String selectUpdateResourceWithParam1(final Map map1){
		String str1=new SQL(){{
			SELECT("count(distinct resource_id)");			
			FROM("devotion_inf");
			ContributeDomain contribute=(ContributeDomain)map1.get("post");
			if(contribute!=null){
				if(contribute.getResource_title()!=null&&!contribute.getResource_title().equals("")){
					WHERE("resource_title like concat('%',#{contribute.resource_title},'%')");
				}
				if(contribute.getResource_content()!=null&&!contribute.getResource_content().equals("")){
					WHERE("resource_content like concat('%',#{contribute.resource_content()},'%')");
				}
				
				if(contribute.getResource_describe()!=null&&!contribute.getResource_describe().equals("")){
					WHERE("resource_describe()=#{contribute.resource_describe()}");
				}
				if(contribute.getResource_filePath()!=null&&!contribute.getResource_filePath().equals("")){
					WHERE("resource_filePath=#{contribute.resource_filePath}");
				}
				if(contribute.getResource_label()!=null&&!contribute.getResource_label().equals("")){
					WHERE("resource_label like concat('%',#{contribute.resource_label},'%')");
				}
				if(contribute.getDevotion_createdate()!=null&&!contribute.getDevotion_createdate().equals("")){
					WHERE("devotion_createdate like concat('%',#{contribute.devotion_createdate},'%')");
				}
			}
		}}.toString();
		int pageNow=(Integer)map1.get("pageNow");
	    int pageSize=(Integer)map1.get("pageSize");
	    str1=str1+"order by devotion_createdate desc limit "+(pageNow-1)*pageSize+","+pageSize;
	    return str1;
		
	}
}