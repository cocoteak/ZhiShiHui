package com.zsh.Implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsh.Dao.ContributeContentDao;
import com.zsh.Dao.ContributeDao;
import com.zsh.Domian.ContributeContent;
import com.zsh.Service.ContributeContentService;

@Service("contentService")
public class ContributeContentServiceImpl implements ContributeContentService {
	@Autowired
	ContributeContentDao contentdao;

	public Integer addReplay(ContributeContent content) {
		// TODO Auto-generated method stub
		return contentdao.addReplay(content);
	}

	public List<ContributeContent> selectAllContent(Integer devotion_id) {
		// TODO Auto-generated method stub
		return contentdao.selectAllContent(devotion_id);
	}

	public List<ContributeContent> selectAllRecordNum(Map map) {
		// TODO Auto-generated method stub
		return contentdao.selectAllRecordNum(map);
	}

	public List<ContributeContent> selectContributeContentAcount(Map map) {
		// TODO Auto-generated method stub
		return contentdao.selectContributeContentAcount(map);
	}

	public List<ContributeContent> selectContributeContentWithPage(Map map) {
		// TODO Auto-generated method stub
		return contentdao.selectContributeContentWithPage(map);
	}

	public Integer selectLeastContentNum(Integer devotion_id) {
		// TODO Auto-generated method stub
		return contentdao.selectLeastContentNum(devotion_id);
	}

	public List<ContributeContent> selectLeastcontribute() {
		// TODO Auto-generated method stub
		return contentdao.selectLeastcontribute();
	}

}
