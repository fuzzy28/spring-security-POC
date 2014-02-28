package com.acss.poc.core.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Component;

import com.acss.poc.core.Message;
import com.acss.poc.main.exception.MenuServiceException;

/**
 * This Handlder is so awesome that 
 * it centralized the logging mechanism all accross the code.
 * 
 * so we are focused on code and not being distracted with logger object all over
 * the place in our code.
 * 
 * @author gvargas.local
 *
 */
@Component
@Aspect
public class KickAssCentralExceptionHandler {

	private static Logger errorLogger = LoggerFactory.getLogger("errors");
	
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && target(controller)")
    public String handleException(ProceedingJoinPoint jp, Object controller) throws Throwable {
        String view = null;
        Message msg = new Message();
        
        try {
            view = (String) jp.proceed();
        } catch (DataAccessException e) {
            errorLogger.error("error in {}", controller.getClass().getSimpleName(), e);
            msg.setInfo(e.getMessage());
            msg.setIsError(Message.TRUE);
            return "commonpage";
        }catch (MenuServiceException e) {
            errorLogger.error("error in {}", controller.getClass().getSimpleName(), e);
            msg.setInfo(e.getMessage());
            msg.setIsError(Message.TRUE);
            return "commonpage";
		}
        
        return view;
    }

}
