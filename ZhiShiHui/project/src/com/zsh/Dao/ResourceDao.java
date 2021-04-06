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
	//查询所有资源
	@Select("select * from resource_inf")
	public List<Resources> selectAllResource();
	
	//动态新建资源
	@InsertProvider(type=ResourceProvider.class,method="insertResource")
	@Options(useGeneratedKeys=true,keyProperty="resource_id")
	int insertResource(Resources resource);
	
	//分页查询
	@SelectProvider(type=ResourceProvider.class,method="selectResourceWithPage")
	List<Resources> selectResourceWithParamPage(Map map);
	
	//查询资源总数
	@SelectProvider(type=ResourceProvider.class,method="selectPostAcount")
	Integer selectResourceAccount(Map map );
	
     
	//查询资源id
	@Select("SELECT resource_id FROM resource_inf")
    public List<Integer> selectResourceAllId();
	
	//通过id查询资源
	@Select("SELECT * FROM resource_inf WHERE resource_id=#{resourceId}")
    public Resources selectResourceById(@Param("resourceId") Integer resourceId);
	
   
	//更新资源信息
    @Update({ "update resource_inf set resource_title = #{resource_title}, resource_content= #{resource_content},resource_describe = #{resource_describe},resource_label = #{resource_label}" + 
    			"resource_filePath = #{resource_filePath},space_id = #{space_id, jdbcType=TIMESTAMP},space_id = #{space_id}," +
    			"space_id = #{space_id},user_id = #{user_id}" })
	int updateResource(Resources resource);
	
	//查询资源总数
	//@SelectProvider(type=ResourceProvider.class,method="selectResourceChange")
	//public Resources selectResourceChange(final Resources resource);

	//删除资源
	@Delete("delete from resource_inf where resource_id=#{resource_id}")
	public int deleteResourceById(Integer resource_id);
}
