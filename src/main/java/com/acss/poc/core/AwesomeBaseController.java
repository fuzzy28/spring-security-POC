package com.acss.poc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AwesomeBaseController {
	
	protected Message message;
	protected static Logger logger = LoggerFactory.getLogger("controller");
	
	public AwesomeBaseController() {
		message = new Message();
	}
	
	protected void addErrorMessage(ModelMap model,String msg){
		message.setIsError(Message.TRUE);
		message.setInfo(msg);
		model.addAttribute(Message.MESSAGE_KEY, message);
	}
	protected void addInfoMessage(ModelMap model,String msg) {
		message.setIsError(Message.FALSE);
		message.setInfo(msg);
		model.addAttribute(Message.MESSAGE_KEY, message);
	}
	/**
	 * Used to persist attributes (flashAttributes) inter-controller 
	 * if using redirection.
	 * 
	 * @param redirectAttributes
	 * @param msg
	 */
	protected void addFlashInfoMessage(RedirectAttributes redirectAttributes,String msg) {
		message.setInfo(msg);
		message.setIsError(Message.FALSE);
		redirectAttributes.addFlashAttribute(Message.MESSAGE_KEY,message);
	}
	
}
