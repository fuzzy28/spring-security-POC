package com.acss.poc.core;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;

public class AwesomeBaseController {
	
	protected Message message;
	protected static Logger logger = Logger.getLogger("controller");
	
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
	
}
