package com.zsh.Provider;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.zsh.Domian.ResourceContent;

public class ResourceContentProvider {

    //动态新建评论
    public String insertContent(final ResourceContent resourceContent) {
        return new SQL() {
            {
                INSERT_INTO("resource_content_inf");
                if (resourceContent.getResource_recordnum() != null && !resourceContent.getResource_recordnum().equals("")) {
                    VALUES("resource_recordnum", "#{resource_recordnum}");
                }
                if (resourceContent.getResource_reply() != null && !resourceContent.getResource_reply().equals("")) {
                    VALUES("resource_reply", "#{resource_reply}");
                }
                if (resourceContent.getReply_user_id() != null) {
                    VALUES("reply_user_id", "#{reply_user_id}");
                }
                if (resourceContent.getResource_id() != null) {
                    VALUES("resource_id", "#{resource_id}");
                }
                
               
            }
        }.toString();
    }

	/**
	 * 分页查询
	 */
    public String selectResourceContentWithPage(final Map<String, Object> map) {
        String str = new SQL() {{
            SELECT("*");
            FROM("resource_content_inf");
            Integer resourceId = (Integer) map.get("resourceId");
            if (null != resourceId) {
                WHERE("resource_id=#{resourceId}");
            }
        }}.toString();
        return str;
    }

    //分页查询
    public String selectAllRecordNum(final Map map) {
        String str = new SQL() {{
            SELECT("*");
            FROM("post_content_inf");
            ResourceContent resourceContent = (ResourceContent) map.get("resourceContent");
            if (resourceContent != null) {
                if (resourceContent.getResource_recordnum() != null && !resourceContent.getResource_recordnum().equals("")) {
                    WHERE("resource_recordnum=#{resourceContent.resourcecontent_recordnum}");
                }
                if (resourceContent.getResource_reply() != null && !resourceContent.getResource_reply().equals("")) {
                    WHERE("resource_reply like concat('%',#{resourceContent.resource_reply},'%')");
                }
                if (resourceContent.getResource_likenum() != null && !resourceContent.getResource_likenum().equals("")) {
                    WHERE("recontent_likenum like concat('%',#{resourceContent.recontent_likenum},'%')");
                }
                if (resourceContent.getResource_dislikenum() != null && !resourceContent.getResource_dislikenum().equals("")) {
                    WHERE("post_dislikenum like concat('%',#{postContent.post_dislikenum},'%')");
                }
                if (resourceContent.getResource_updatedate() != null && !resourceContent.getResource_updatedate().equals("")) {
                    WHERE("content_updatetime=#{postContent.content_updatetime}");
                }
                if (resourceContent.getReply_user_id() != null) {
                    WHERE("reply_user_id=#{postContent.reply_user_id}");
                }
                if (resourceContent.getResource_id() != null) {
                    WHERE("resource_id=#{resourceContent.resource_id}");
                }
            }
        }}.toString();
        str = str + "group by resource_recordnum";
        return str;
    }


    //查询总数
    public String selectResourceContentAcount(final Map map) {
        return new SQL() {{
            SELECT("*");
            FROM("resource_content_inf");
            ResourceContent resourceContent = (ResourceContent) map.get("resourceContent");
            if (resourceContent != null) {
                if (resourceContent.getResource_recordnum() != null && !resourceContent.getResource_recordnum().equals("")) {
                    WHERE("resourcet_recordnum=#{resourceContent.resource_recordnum}");
                }
                if (resourceContent.getResource_reply() != null && !resourceContent.getResource_reply().equals("")) {
                    WHERE("resource_reply like concat('%',#{resourceContent.resource_reply},'%')");
                }
                if (resourceContent.getReply_user_id() != null) {
                    WHERE("reply_user_id=#{resourceContent.reply_user_id}");
                }
                if (resourceContent.getResource_id() != null) {
                    WHERE("resource_id=#{postContent.resource_id}");
                }
            }
        }}.toString();
    }

    //具体查询某一条回复
    public String selectContent(final ResourceContent resourceContent) {
        String str = new SQL() {{
            SELECT("*");
            FROM("resource_content_inf");
            if (resourceContent.getResource_content_id() != null) {
                WHERE("resource_content_id=#{resource_content_id}");
            }
            if (resourceContent.getResource_likenum() != null) {
                WHERE("find_in_set(#{recontent_likenum},recontent_likenum)");
            }
            if (resourceContent.getResource_dislikenum() != null) {
                WHERE("find_in_set(#{recontent_dislikenum},recontent_dislikenum)");
            }
            if (resourceContent.getResource_id() != null) {
                WHERE("resource_id=#{resource_id}");
            }
        }}.toString();
        return str;
    }

    //动态更新
    public String updateContent(final ResourceContent resourceContent) {
        return new SQL() {
            {
                UPDATE("resource_content_inf");
                if (resourceContent.getResource_likenum() != null) {
                    SET("recontent_likenum=#{recontent_likenum}");
                }
                if (resourceContent.getResource_dislikenum() != null) {
                    SET("recontent_dislikenum=#{recontent_dislikenum}");
                }
                WHERE("resource_content_id=#{resource_content_id}");
            }
        }.toString();
    }
    
//    //动态添加回复
//    public String addReply(final ResourceContent resourceContent){
//    	return new SQL(){
//    		{
//    		if(resourceContent.getResource_reply()!=null){
//    			WHERE("resource_reply=#{resource_reply}");
//    			}
//    		if(resourceContent.getReply_resource_id()!=null){
//    			WHERE("replyContents=#{replyContents}");
//    			}
//    		if(resourceContent.getReplyContents()!=null){
//    			WHERE("replyContents=#{replyContents}");
//    			}
//    		}
//    	}.toString();
//    }
}
