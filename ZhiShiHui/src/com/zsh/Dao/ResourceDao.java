package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.Resources;
import com.zsh.Provider.PostProvider;
import com.zsh.Provider.ResourceProvider;



@Repository("resourceDao")
public interface ResourceDao {
	//��ѯ������Դ
	@Select("select * from resource_inf")
	public List<Resources> selectAllResource();
	
	//��̬�½���Դ
	@InsertProvider(type=ResourceProvider.class,method="insertResource")
	@Options(useGeneratedKeys=true,keyProperty="resource_id")
	int insertResource(Resources resource);
	
	//��ҳ��ѯ
	@SelectProvider(type=ResourceProvider.class,method="selectResourceWithPage")
	List<Resources> selectResourceWithParamPage(Map map);
	
	//��ѯ��Դ����
	@SelectProvider(type=ResourceProvider.class,method="selectPostAcount")
	Integer selectResourceAccount(Map map );
	
     
	//��ѯ��Դid
	@Select("SELECT resource_id FROM resource_inf")
    public List<Integer> selectResourceAllId();
	
	//ͨ��id��ѯ��Դ
	@Select("SELECT * FROM resource_inf WHERE resource_id=#{resourceId}")
    public Resources selectResourceById(@Param("resourceId") Integer resourceId);
	
   
	//������Դ��Ϣ
    @Update({ "update resource_inf set resource_title = #{resource_title}, resource_content= #{resource_content},resource_describe = #{resource_describe},resource_label = #{resource_label}" + 
    			"resource_filePath = #{resource_filePath},space_id = #{space_id, jdbcType=TIMESTAMP},space_id = #{space_id}," +
    			"space_id = #{space_id},user_id = #{user_id}" })
	int updateResource(Resources resource);
	
	//��ѯ��Դ����
	//@SelectProvider(type=ResourceProvider.class,method="selectResourceChange")
	//public Resources selectResourceChange(final Resources resource);

	//ɾ����Դ
	@Delete("delete from resource_inf where resource_id=#{resource_id}")
	public int deleteResourceById(Integer resource_id);
}
