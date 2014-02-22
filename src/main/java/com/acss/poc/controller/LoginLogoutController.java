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
import org.springframework.web.servlet.ModelAndView;

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
	public String getLoginPage(ModelMap model) {
				
		// This will resolve to /WEB-INF/jsp/loginpage.jsp
		return getViewNameIfAuthenticated("loginpage");
	}

	private String getViewNameIfAuthenticated(String targetPage) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			//change view into common page.
		    targetPage = "commonpage";
		}
		logger.debug("Received request to show page: "+targetPage);
		return targetPage;
	}

	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a
	 * regular user tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
		return "deniedpage";
	}
	
	/**
	 * Handles redirection to login page after logout.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
 	public String logoutSuccess(ModelMap model) {
		String message = "Logout Success!";
		model.put("message", message);
				
		return getViewNameIfAuthenticated("loginpage");
	}
	
	/**
	 * Handles redirection to login page after failed login
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/failed", method = RequestMethod.GET)
 	public String loginFailed(ModelMap model) {
		String message = "You have entered an invalid username or password!";
		model.put("message", message);
		
		return getViewNameIfAuthenticated("loginpage");
	}
	
	/**
	 * Handles redirection to login page after failed login
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/session-failed", method = RequestMethod.GET)
 	public String sessionFailed(ModelMap model) {
		String message = "You're current session has been invalidated due to concurrent login.";
		model.put("message", message);
		
		return getViewNameIfAuthenticated("loginpage");
	}
	
	
}