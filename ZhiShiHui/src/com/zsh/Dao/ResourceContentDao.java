package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.ResourceContent;
import com.zsh.Provider.ResourceContentProvider;
import com.zsh.Provider.ResourceProvider;



@Repository
public interface ResourceContentDao {
    //动态新建回复
    @InsertProvider(type = ResourceContentProvider.class, method = "insertContent")
    @Options(useGeneratedKeys = true, keyProperty = "resource_content_id")
    int insertResourceContent(ResourceContent resourceContent);

//    
//   @InsertProvider(type = ResourceContentProvider.class, method = "insertContentReply")
//    @Options(useGeneratedKeys = true, keyProperty = "resource_recordnum")
//    int insertContentReply(ResourceContent resourceRecordnum);
// 
    
    /**
     * 分页查询回复
     */
    @SelectProvider(type = ResourceContentProvider.class, method = "selectResourceContentWithPage")
   
	@ResultType(ResourceContent.class)
    List<ResourceContent> selectResourceContentWithPage(@Param("resourceId") Integer resourceId);

    //按楼层分组查询回复资源
    @SelectProvider(type = ResourceContentProvider.class, method = "selectAllRecordNum")
    List<ResourceContent> selectAllRecordNum(Map map);


    /**
     * 查询回复总数
     */
    @Select("select count(1) from resource_content_inf where resource_id=#{resourceId} and reply_content_id = #{replyResourceId}")
    Integer selectResourceContentCount(@Param("resourceId") Integer resourceId, @Param("replyResourceId") Integer replyResourceId);


    //查询最新一条回复的时间
    @Select("SELECT * from (SELECT * FROM resource_content_inf ORDER BY  resource_updatedate DESC) resource_content_inf GROUP BY resource_id DESC")
    List<ResourceContent> selectLeastResource();

    //查询指定资源中的所有回复
    @Select("SELECT * from resource_content_inf where resource_id=#{resource_id}")
    List<ResourceContent> selectAllContent(Integer resource_id);

    //查询资源最新一条回复楼层
    @Select("select resource_recordnum from resource_content_inf where resource_recordnum = (select max(resource_recordnum) from resource_content_inf order by resource_id) and resource_id=#{resource_id}")
    Integer selectLeastContentNum(Integer resource_id);

    //查询具体某一条回复
    @SelectProvider(type = ResourceContentProvider.class, method = "selectContent")
    public ResourceContent selectContent(ResourceContent resourceContent);

    //更新回复信息
    @UpdateProvider(type = ResourceContentProvider.class, method = "updateContent")
    public int updateContent(ResourceContent ResourceContent);

    
    //根据资源id删除资源内容
    @Delete("delete from resource_content_inf where resource_content_id=#{resource_content_id}")
    public int deleteResourceById(Integer resource_id);
}
