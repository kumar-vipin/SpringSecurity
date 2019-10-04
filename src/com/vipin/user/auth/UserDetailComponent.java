package com.vipin.user.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vipin.model.Role;
import com.vipin.model.User;

@Component("userDetailComponent")
public class UserDetailComponent {

	public String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
			return null;
		if (authentication.getPrincipal() instanceof User) {
			User userDetails = (User) authentication.getPrincipal();
			return userDetails.getUsername();
		} else {
			return null;
		}
	}

	public static String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
			return null;
		if (authentication.getPrincipal() instanceof User) {
			User userDetails = (User) authentication.getPrincipal();
			return userDetails.getUsername();
		} else {
			return null;
		}
	}

	public List<Role> getLoggedInUserRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
			return Collections.emptyList();
		User userDetails = authentication.getPrincipal() instanceof User ? (User) authentication.getPrincipal() : null;
		if (userDetails != null)
			return new ArrayList<>(userDetails.getRoles());
		else
			return Collections.emptyList();
	}

	public UserDetails currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			return principal instanceof UserDetails ? (UserDetails) principal : null;
		}
		return null;
	}

	public User currentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			return (User) authentication.getPrincipal();
		}
		return null;
	}

}
