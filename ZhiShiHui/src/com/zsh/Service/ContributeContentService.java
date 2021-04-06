package com.zsh.Service;

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

import com.zsh.Domian.ContributeContent;
import com.zsh.Provider.ContributeContentProvider;


public interface ContributeContentService {
	

	public Integer addReplay(ContributeContent content);
	
	
	//��ҳ��ѯ
	List<ContributeContent> selectContributeContentWithPage(Map map);
	
	//��¥������ѯ�ظ�����(��ȷ������һ�����������ٸ���¥�����)
	List<ContributeContent> selectAllRecordNum(Map map);
	
	
	//��ѯ�ظ�����
	List<ContributeContent> selectContributeContentAcount(Map map);
	
	
	//��ѯ����һ���ظ���ʱ��
	List<ContributeContent> selectLeastcontribute();
	
	//��ѯָ�������е����лظ�
	List<ContributeContent> selectAllContent(Integer devotion_id);
	
	//��ѯ��������һ���ظ�¥��
	Integer selectLeastContentNum(Integer devotion_id);
	
	

}
