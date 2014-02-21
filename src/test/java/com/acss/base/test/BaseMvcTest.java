package com.acss.base.test;

import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class BaseMvcTest {
	
	MockHttpSession session;
	/**
	 * Sets the Security Context in session
	 * @param securityContext
	 * @return MockHttpSession
	 */
	private MockHttpSession setSecurityContextInSession(
			SecurityContext securityContext) {
		session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                securityContext);
		return session;
	}
}
