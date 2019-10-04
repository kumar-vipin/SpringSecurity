package com.vipin.user.auth;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.vipin.common.utils.ICollectionUtils;
import com.vipin.model.RoleType;
import com.vipin.model.User;

@Component("authSessionManager")
public class AuthSessionManager {

	private static final String ROLE = "role";

	public void setSession(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		HttpSession session = request.getSession();
		User userDetails = (User) authentication.getPrincipal();
		boolean isAdmin = false;
		boolean isUser = false;
		if (userDetails != null) {

			Set<String> hasAuths = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

			if (ICollectionUtils.isNotEmpty(hasAuths)) {
				isAdmin = hasAuths.contains(RoleType.ROLE_ADMIN.toString());
				isUser = hasAuths.contains(RoleType.ROLE_USER.toString());
			}

			String name = null;
			Set<String> assignedRoles = new HashSet<>();

			if (isAdmin) {
				name = userDetails.getUsername();
				assignedRoles.add(RoleType.ROLE_ADMIN.toString());
			}
			if (isUser) {
				name = userDetails.getUsername();
				assignedRoles.add(RoleType.ROLE_USER.toString());
			}

			String roles = String.join(", ", assignedRoles);
			session.setAttribute(ROLE, roles);
			session.setAttribute("name", name);
		}
	}

	public static HttpSession getSession() {
		try {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			return attr.getRequest().getSession(); // true == allow create
		} catch (Exception e) {
			return null;
		}
	}
}