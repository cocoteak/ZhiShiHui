package com.zsh.Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsh.Domian.ResourceContent;
import com.zsh.Domian.Resources;
import com.zsh.Domian.StudySpace;
import com.zsh.Domian.User;
import com.zsh.Service.ResourceContentService;
import com.zsh.Service.ResourceService;
import com.zsh.util.PageShow;


@Controller
public class ResourceContentController {

	@Resource
	ResourceContentService resourceContentService;

	@Resource
	ResourceService resourceService;


	/**
	 * Ĭ��չʾ3���ظ�
	 */
	private final static int DEFAULT_CONTENT_PAGE_SIZE = 3;
	/**
	 * ��Դ�ظ��б�
	 * @param resourceId
	 * @param pageNow
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/resourceContentList")
	public String resourceContentList(Integer resourceId,@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,HttpSession session, Model model) {
		User user=(User)session.getAttribute("user");
		StudySpace spaceStudy=(StudySpace)session.getAttribute("spaceStudy");
		//��ǰ�û������ж�
		Integer userId= user.getUser_id() ;
		// ��¼��id��String��ʽ
		String UserIdStr =user.getUser_name() ;

        //��ǰ��Դ
		Resources currentResource= resourceService.selectResourceById(resourceId);
		model.addAttribute("resource", currentResource);

		// ��ѯ��Դ�Ļظ�
		Map<String, Object> map = new HashMap();
		map.put("resourceId", resourceId);
		// ��ѯ��Դ������
		// 1. ��Դ��������
		Integer totalSize = resourceContentService.selectResourceContentCount(resourceId, 0);
		// 2. ��Դ��������
		PageShow ps = new PageShow(pageNow, DEFAULT_CONTENT_PAGE_SIZE, totalSize);
		List<ResourceContent> listContent = resourceContentService.selectResourceContent(resourceId);
		
		model.addAttribute("listContent", listContent);
		model.addAttribute("pageShow", ps);
		return "reContent/reContent";
	}

	@RequestMapping(value = "/addReply")
	public String insert(HttpSession session,Model model,ResourceContent inContent) {
		//�õ��½��ظ��Ķ���
		User user = (User)session.getAttribute("user");
		Integer user_id = user.getUser_id();
		inContent.setUser_id(user_id);
		inContent.setResource_updatedate(new Date());
		resourceContentService.insertContent(inContent);
		model.addAttribute("resourceId", inContent.getResource_id());
		return "redirect:resourceContentList";
	}
}

// �ղ��߼�
// �ղ��˵�id  ���ŷָ�--->  1,2,3,4
//String resourceCollectionIdStr = currentResource.getResource_collection_ids();
//if (null == resourceCollectionIdStr || "".equals(resourceCollectionIdStr)) {
//	model.addAttribute("collectionFlag", false);
//} else {
//	// ת����һ��list -->  {1,2,3,4}
//	List<String> collectionUserIds = Arrays.asList(resourceCollectionIdStr.split(","));
//	// ���list���������ǰ�û���id  ��ʾ�Ѿ��ղ��� ���true   ������false
//	model.addAttribute("collectionFlag", collectionUserIds.contains(UserIdStr));
//}


//// �����߼�   ͬ�ղ�
//String resourceLikeIdStr = currentResource.getResource_like_ids();
//if(null == resourceLikeIdStr ||"".equals(resourceLikeIdStr)) {
//	model.addAttribute("likeFlag", false);
//} else {
//	List<String> likeUserIds = Arrays.asList(resourceLikeIdStr.split(","));
//	model.addAttribute("likeFlag", likeUserIds.contains(UserIdStr));
//}
//
//// ���߼�  ͬ�ղ�
//String resourceDisLikeIdStr = currentResource.getResource_like_ids();
//if(null == resourceDisLikeIdStr ||"".equals(resourceDisLikeIdStr)){
//	model.addAttribute("disLikeFlag", false);
//} else {
//	List<String> disLikeUserIds = Arrays.asList(resourceDisLikeIdStr.split(","));
//	model.addAttribute("disLikeFlag", disLikeUserIds.contains(UserIdStr));
//}
