package com.zsh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {
	
	@RequestMapping(value ="/selectCommunity")
	public String selectCommunityWeb() {
		
		return "zhujsp/community/content_community";
	}
	
}
