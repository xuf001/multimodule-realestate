package com.morgan.realestate.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morgan.realestate.biz.service.UserService;
import com.morgan.realestate.common.model.User;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("hello")
	public String hello(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		User one = users.get(0);
		modelMap.put("user", one);
		return "hello";
	}
	
	@RequestMapping("index")
	public String index() {
		return "homepage/index";
	}
}
