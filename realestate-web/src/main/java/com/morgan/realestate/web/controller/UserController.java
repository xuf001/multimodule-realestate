package com.morgan.realestate.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morgan.realestate.biz.service.UserService;
import com.morgan.realestate.common.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("user")
	public List<User> getUsers(){
		return userService.getUsers();
	}

}
