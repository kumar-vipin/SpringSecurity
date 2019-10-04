package com.vipin.user.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private AuthSessionManager authSessionManager;

	@Value("/home.htm")
	private String defaultRedirectURL;

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		super.handle(request, response, authentication);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		try {
			if (response.isCommitted()) {
				logger.debug("Response has already been committed. Unable to redirect to " + defaultRedirectURL);
				return;
			}
			authSessionManager.setSession(request, response, authentication);
			getRedirectStrategy().sendRedirect(request, response, defaultRedirectURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
