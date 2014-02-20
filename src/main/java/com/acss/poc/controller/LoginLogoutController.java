package com.acss.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {

	protected static Logger logger = Logger.getLogger("controller");

	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "message", required = false) String message,
			ModelMap model) {
		logger.debug("Received request to show login page");
		
		/*
		 * See below: <form-login login-page="/auth/login"
		 * authentication-failure-url="/auth/login?error=true"
		 * default-target-url="/main/common"/>
		 */
		if (error == true) {
			// Assign an error message
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		
		//for message notification
		if(message != null){
			model.put("message", message);
		}else {
			model.put("message", "");
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			//just stay on commonpage if user is logged in.
		    return "commonpage";
		}
		
		// This will resolve to /WEB-INF/jsp/loginpage.jsp
		return "loginpage";
	}

	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a
	 * regular user tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		logger.debug("Received request to show denied page");

		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
		return "deniedpage";
	}
	
	/*
	 * Ignore this, this is incase we need to define a custom logout. currenlt using logout by spring-security.
	@RequestMapping(value = "/logout/success", method = RequestMethod.GET)
 	public String logoutSuccess() {
		logger.debug("Logging out. . .");
		String message = "Logout Success!";
		System.out.println(message);
		
		return "redirect:/auth/login?message="+message;
	}*/
	
	
}