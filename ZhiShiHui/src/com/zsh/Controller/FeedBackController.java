package com.zsh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedBackController {


	@RequestMapping(value ="/selectFeedback")
	public String login() {
		
		return "zhujsp/Feedback/content_feedback";
	}
	
}
