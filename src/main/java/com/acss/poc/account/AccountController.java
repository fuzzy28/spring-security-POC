package com.acss.poc.account;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acss.poc.main.exception.MenuServiceException;

@Controller
@Secured("ROLE_USER")
@RequestMapping("account")
class AccountController {
	
    private IAccountService accountService;
	
	public AccountController(){}
	
    @Autowired
	public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    
    /**
     * Gets account information of the currently logged in user.
     * @param principal
     * @return
     */
    @RequestMapping(value = "current", method = RequestMethod.GET)
    public String accounts(Principal principal,ModelMap model) {
        Assert.notNull(principal);
        model.addAttribute("account",accountService.findByUsername(principal.getName()));
        return "accountpage";
    }
    
    @RequestMapping(value = "exception", method = RequestMethod.GET)
    public String exceptionDemo() throws MenuServiceException{
    	throw new MenuServiceException("Demo for Exception Logs and Exception Handing. . .");
    }
    
    
}
