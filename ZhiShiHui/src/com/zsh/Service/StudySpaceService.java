package com.zsh.Service;

import java.util.List;

import com.zsh.Domian.StudySpace;

public interface StudySpaceService {
	
	//��ѯ�ռ�������һ�����ݵ�space��id SELECT * FROM ��bai��du ORDER BY ��_ID DESC LIMIT 1
	public StudySpace selectLastSpaceIdBySpaceTable();
	
	//���ѧϰ�ռ�	
	public int insertStudySpace(StudySpace studySpace);

	//recommend+recent_update
	public List<StudySpace> selectRecommendByRecentUpdate();
	
	//recommend+recent_create
	public List<StudySpace> selectRecommendByRecentCreate();
	
	//recommend+earliest_update
	public List<StudySpace> selectRecommendByEarliestUpdate();	
	
	//recommend+earliest_create
	public List<StudySpace> selectRecommendByEarliestCreate();	
	
	//see+recent_update
	public List<StudySpace> selectSeeByRecentUpdate();
	
	//see+recent_create
	public List<StudySpace> selectSeeByRecentCreate();	
	
	//see+earliest_update	
	public List<StudySpace> selectSeeByEarliestUpdate();	
	
	//see+earliest_create
	public List<StudySpace> selectSeeByEarliestCreate();
	
	//collect+recent_update
	public List<StudySpace> selectCollectByRecentUpdate();	
	
	//collect+recent_create
	public List<StudySpace> selectCollectByRecentCreate();	
	
	//collect+earliest_update
	public List<StudySpace> selectCollectByEarliestUpdate();
	
	//collect+earliest_create
	public List<StudySpace> selectCollectByEarliestCreate();	
	
	//my+recent_update
	public List<StudySpace> selectMyByRecentUpdate(Integer userId);	
	
	//my+recent_create
	public List<StudySpace> selectMyByRecentCreate(Integer userId);	
	
	//my+earliest_update
	public List<StudySpace> selectMyByEarliestUpdate(Integer userId);
	
	//my+earliest_create
	public List<StudySpace> selectMyByEarliestCreate(Integer userId);	
	
	//ͨ��
	public StudySpace selectBySpaceId(Integer space_id);
		
}
