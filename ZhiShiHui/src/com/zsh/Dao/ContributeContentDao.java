package com.zsh.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.zsh.Domian.ContributeContent;
import com.zsh.Provider.ContributeContentProvider;



@Repository
public interface ContributeContentDao {
	//��̬���
	//��̬�ظ�
	@InsertProvider(type=ContributeContentProvider.class,method="addReplay")	
	@Options(useGeneratedKeys=true,keyProperty="content_id")
	public Integer addReplay(ContributeContent content);
	
	
	//��ҳ��ѯ
	@SelectProvider(type=ContributeContentProvider.class,method="selectContributeContentWithPage")
	@Results({
		@Result(column="devotion_id",property="devotion",one=@One(select="zhao.contribute.Dao.ContributeDao.selectContributeById",fetchType=FetchType.LAZY)),
		@Result(column="devotion_id",property="devotion_id")
	})
	List<ContributeContent> selectContributeContentWithPage(Map map);
	
	//��¥������ѯ�ظ�����(��ȷ������һ�����������ٸ���¥�����)
	@SelectProvider(type=ContributeContentProvider.class,method="selectAllRecordNum")
	List<ContributeContent> selectAllRecordNum(Map map);
	
	
	//��ѯ�ظ�����
	@SelectProvider(type=ContributeContentProvider.class,method="selectContributeContentAcount")
	List<ContributeContent> selectContributeContentAcount(Map map);
	
	
	//��ѯ����һ���ظ���ʱ��
	@Select("SELECT * from (SELECT * FROM devotion_content_inf ORDER BY devotion_createdate DESC) devotion_content_inf GROUP BY devotion_id DESC")
	List<ContributeContent> selectLeastcontribute();
	
	//��ѯָ�������е����лظ�
	@Select("SELECT * from devotion_content_inf where devotion_id=#{devotion_id}")
	List<ContributeContent> selectAllContent(Integer devotion_id);
	
	//��ѯ��������һ���ظ�¥��
	@Select("select devotion_recordnum from devotion_content_inf where devotion_recordnum = (select max(devotion_recordnum) from devotion_content_inf order by devotion_id) and devotion_id=#{devotion_id}")
	Integer selectLeastContentNum(Integer devotion_id);
	
	
	
}
