package com.io.andromeda.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.io.andromeda.Dao.FeedbackDaoImpl;
import com.io.andromeda.Entity.FeedbackEntity;
import com.io.andromeda.domain.CurrentUser;
import com.io.andromeda.domain.UserCreateForm;
import com.io.andromeda.service.user.UserService;

@RestController
public class AndromedaRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AndromedaRestController.class);

	@Autowired
	UserService userService;

	@Autowired
	FeedbackDaoImpl feedbackDao;

	@PostMapping(value = "/bistro/sendfeedback")
	@ResponseBody
	public ResponseEntity<FeedbackEntity> feedback(@RequestBody FeedbackEntity feedBackEntity) {
		feedbackDao.insertWithQuery(feedBackEntity);
		return new ResponseEntity<FeedbackEntity>(feedBackEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		LOGGER.debug("Getting login page, error={}", error);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserCreateForm> register(@RequestBody UserCreateForm userCreateForm) {
		userService.create(userCreateForm);
		return new ResponseEntity<UserCreateForm>(userCreateForm, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getPrincipal().equals("anonymousUser")) {
		CurrentUser currentUser = (CurrentUser)auth.getPrincipal();
		System.out.println(currentUser.getUsername());
		System.out.println(currentUser.getUser());
		System.out.println(currentUser.isCredentialsNonExpired());
		System.out.println(auth.getDetails());
		System.out.println(auth.getAuthorities());
		}
		return "index";
	}
}
