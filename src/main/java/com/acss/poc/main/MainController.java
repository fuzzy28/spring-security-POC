package com.acss.poc.main;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves the common or admin page depending on the URI template.
 * A user must be log-in first he can access these pages. Only the admin can see
 * the adminpage, however.
 */
@Controller
@RequestMapping("/main")
public class MainController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	/**
	 * View Definitions
	 */
	private static String HOME_PAGE="commonpage";
	private static String USER_PAGE="userpage";
	private static String ADMIN_PAGE="adminpage";
	
	
	/**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage() {
		logger.debug("Received request to show common page");
		return HOME_PAGE;
	}

	/**
	 * Handles and retrieves the admin JSP page that only admins can see
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		logger.debug("Received request to show admin page");
		return ADMIN_PAGE;
	}
	
	/**
	 * Handles and retrieves the user JSP page that user can see
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String getUserPage(){
		return USER_PAGE;
	}
}
