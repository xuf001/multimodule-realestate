package com.morgan.realestate.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.morgan.realestate.common.model.User;


@Mapper
public interface UserMapper {

	public List<User> getUsers();
}
