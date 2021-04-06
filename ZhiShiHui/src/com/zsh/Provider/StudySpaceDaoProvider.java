package com.zsh.Provider;

import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.StudySpace;

import static com.zsh.util.ZhuZSHConstants.SPACETABLE;

public class StudySpaceDaoProvider {
	
	//动态插入学习空间信息
		public String insertStudySpace(final StudySpace studySpace){
			return new SQL(){{
				
				INSERT_INTO(SPACETABLE);					
				if(studySpace.getSpace_name()!=null && !studySpace.getSpace_name().equals("")){
					VALUES("space_name","#{space_name}");
				}				
				if(studySpace.getSpace_describe()!=null && !studySpace.getSpace_describe().equals("")){
					VALUES("space_describe","#{space_describe}");
				}
				if(studySpace.getUser_id()!=null){
					VALUES("user_id","#{user_id}");
				}
				if(studySpace.getSpace_createtime()!=null && !studySpace.getSpace_createtime().equals("")){
					VALUES("space_createtime","#{space_createtime}");
				}
				if(studySpace.getSpace_updatetime()!=null && !studySpace.getSpace_updatetime().equals("")){
					VALUES("space_updatetime","#{space_updatetime}");
				}
				if(studySpace.getSpace_picture()!=null && !studySpace.getSpace_picture().equals("")){
					VALUES("space_picture","#{space_picture}");
				}
			}}.toString();	
		}
}
