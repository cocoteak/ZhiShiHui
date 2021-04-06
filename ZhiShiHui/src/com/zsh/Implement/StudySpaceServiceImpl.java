package com.zsh.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Dao.StudySpaceDao;
import com.zsh.Domian.StudySpace;
import com.zsh.Service.StudySpaceService;

@Service("studySpace")
public class StudySpaceServiceImpl implements StudySpaceService{
	
	@Autowired
	private StudySpaceDao studySpaceDao;
	
	//查询空间表中最后一天数据的space＿id
	public StudySpace selectLastSpaceIdBySpaceTable() {	
		return studySpaceDao.selectLastSpaceIdBySpaceTable();
	}
	
	//添加学习空间	
	public int insertStudySpace(StudySpace studySpace) {		
		return studySpaceDao.insertStudySpace(studySpace);
	}

	//recommend+recent_update
	public List<StudySpace> selectRecommendByRecentUpdate() {	
		return studySpaceDao.selectRecommendByRecentUpdate();
	}

	//recommend+recent_create
	public List<StudySpace> selectRecommendByRecentCreate() {	
		return studySpaceDao.selectRecommendByRecentCreate();
	}

	//recommend+earliest_update
	public List<StudySpace> selectRecommendByEarliestUpdate() {	
		return studySpaceDao.selectRecommendByEarliestUpdate();
	}

	//recommend+earliest_create
	public List<StudySpace> selectRecommendByEarliestCreate() {	
		return studySpaceDao.selectRecommendByEarliestCreate();
	}

	//see+recent_update
	public List<StudySpace> selectSeeByRecentUpdate() {	
		return studySpaceDao.selectRecommendByRecentUpdate();
	}

	//see+recent_create
	public List<StudySpace> selectSeeByRecentCreate() {		
		return studySpaceDao.selectRecommendByRecentCreate();
	}

	//see+earliest_update
	public List<StudySpace> selectSeeByEarliestUpdate() {		
		return studySpaceDao.selectSeeByEarliestUpdate();
	}

	//see+earliest_create
	public List<StudySpace> selectSeeByEarliestCreate() {	
		return studySpaceDao.selectSeeByEarliestCreate();
	}
	
	//collect+recent_update
	public List<StudySpace> selectCollectByRecentUpdate() {	
		return studySpaceDao.selectCollectByRecentUpdate();
	}
	
	//collect+recent_create
	public List<StudySpace> selectCollectByRecentCreate() {	
		return studySpaceDao.selectCollectByRecentCreate();
	}
	
	//collect+earliest_update
	public List<StudySpace> selectCollectByEarliestUpdate() {		
		return studySpaceDao.selectCollectByEarliestUpdate();
	}

	//collect+earliest_create
	public List<StudySpace> selectCollectByEarliestCreate() {		
		return studySpaceDao.selectCollectByEarliestCreate();
	}

	//my+recent_update
	public List<StudySpace> selectMyByRecentUpdate(Integer userId) {	
		return studySpaceDao.selectMyByRecentUpdate(userId);
	}

	//my+recent_create
	public List<StudySpace> selectMyByRecentCreate(Integer userId) {		
		return studySpaceDao.selectMyByRecentCreate(userId);
	}

	//my+earliest_update
	public List<StudySpace> selectMyByEarliestUpdate(Integer userId) {		
		return studySpaceDao.selectMyByEarliestUpdate(userId);
	}

	//my+earliest_create
	public List<StudySpace> selectMyByEarliestCreate(Integer userId) {		
		return studySpaceDao.selectMyByEarliestCreate(userId);
	}

	public StudySpace selectBySpaceId(Integer space_id) {
		// TODO Auto-generated method stub
		return studySpaceDao.selectBySpaceId(space_id);
	}

}
