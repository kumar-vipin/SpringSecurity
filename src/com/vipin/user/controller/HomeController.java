package com.vipin.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vipin.common.utils.ICollectionUtils;
import com.vipin.model.Role;
import com.vipin.model.RoleType;
import com.vipin.user.auth.UserDetailComponent;

@Controller
@RequestMapping("/home.htm")
public class HomeController {
	@Autowired
	private UserDetailComponent userDetailComponent;

	@RequestMapping(method = RequestMethod.GET)
	public String setViewAfterLogin(HttpServletRequest req, HttpServletResponse res) {
		List<Role> roles = userDetailComponent.getLoggedInUserRole();
		if (ICollectionUtils.isEmpty(roles)) {
			return "403";
		}
		String viewName = getDashboardViewName(roles);
		return "redirect:/" + viewName;
	}

	private String getDashboardViewName(List<Role> roles) {
		String viewName = null;
		if (roles.contains(new Role(RoleType.ROLE_ADMIN))) {
			viewName = "admin/home.htm";
		} else if (roles.contains(new Role(RoleType.ROLE_USER))) {
			viewName = "user/home.htm";
		}
		return viewName;
	}
}