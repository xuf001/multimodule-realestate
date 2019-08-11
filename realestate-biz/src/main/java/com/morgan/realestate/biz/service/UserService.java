package com.morgan.realestate.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morgan.realestate.biz.mapper.UserMapper;
import com.morgan.realestate.common.model.User;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUsers(){
		return userMapper.getUsers();
	}
}
