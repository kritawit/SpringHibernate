package com.headerdev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.headerdev.model.User;
import com.headerdev.model.UserProfile;
import com.headerdev.service.UserProfileService;
import com.headerdev.service.UserService;

@Controller
@SessionAttributes("roles")
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserProfileService userProfileService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<User> usersList = userService.findAllUsers();
		model.addAttribute("userList", usersList);
		return "home";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String pagehome() {
		return "homepage";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String adduser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "register";
		}

		List<User> userList = userService.findAllUsers();

		for (int i = 0; i < userList.size(); i++) {
			if (user.getUsername().toLowerCase().equals(userList.get(i).getUsername().toLowerCase())) {
				result.rejectValue("username", "error.user", "Username already exists for this Username.");
				return "register";
			}

		}

		userService.save(user);

		return "redirect:/";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password.");
		}

		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully.");
		}

		return "login";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";// You can redirect wherever you want,
										// but generally it's a good practice to
										// show login screen again.
	}

	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
}
