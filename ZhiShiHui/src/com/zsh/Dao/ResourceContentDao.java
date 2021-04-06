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
    //��̬�½��ظ�
    @InsertProvider(type = ResourceContentProvider.class, method = "insertContent")
    @Options(useGeneratedKeys = true, keyProperty = "resource_content_id")
    int insertResourceContent(ResourceContent resourceContent);

//    
//   @InsertProvider(type = ResourceContentProvider.class, method = "insertContentReply")
//    @Options(useGeneratedKeys = true, keyProperty = "resource_recordnum")
//    int insertContentReply(ResourceContent resourceRecordnum);
// 
    
    /**
     * ��ҳ��ѯ�ظ�
     */
    @SelectProvider(type = ResourceContentProvider.class, method = "selectResourceContentWithPage")
   
	@ResultType(ResourceContent.class)
    List<ResourceContent> selectResourceContentWithPage(@Param("resourceId") Integer resourceId);

    //��¥������ѯ�ظ���Դ
    @SelectProvider(type = ResourceContentProvider.class, method = "selectAllRecordNum")
    List<ResourceContent> selectAllRecordNum(Map map);


    /**
     * ��ѯ�ظ�����
     */
    @Select("select count(1) from resource_content_inf where resource_id=#{resourceId} and reply_content_id = #{replyResourceId}")
    Integer selectResourceContentCount(@Param("resourceId") Integer resourceId, @Param("replyResourceId") Integer replyResourceId);


    //��ѯ����һ���ظ���ʱ��
    @Select("SELECT * from (SELECT * FROM resource_content_inf ORDER BY  resource_updatedate DESC) resource_content_inf GROUP BY resource_id DESC")
    List<ResourceContent> selectLeastResource();

    //��ѯָ����Դ�е����лظ�
    @Select("SELECT * from resource_content_inf where resource_id=#{resource_id}")
    List<ResourceContent> selectAllContent(Integer resource_id);

    //��ѯ��Դ����һ���ظ�¥��
    @Select("select resource_recordnum from resource_content_inf where resource_recordnum = (select max(resource_recordnum) from resource_content_inf order by resource_id) and resource_id=#{resource_id}")
    Integer selectLeastContentNum(Integer resource_id);

    //��ѯ����ĳһ���ظ�
    @SelectProvider(type = ResourceContentProvider.class, method = "selectContent")
    public ResourceContent selectContent(ResourceContent resourceContent);

    //���»ظ���Ϣ
    @UpdateProvider(type = ResourceContentProvider.class, method = "updateContent")
    public int updateContent(ResourceContent ResourceContent);

    
    //������Դidɾ����Դ����
    @Delete("delete from resource_content_inf where resource_content_id=#{resource_content_id}")
    public int deleteResourceById(Integer resource_id);
}
