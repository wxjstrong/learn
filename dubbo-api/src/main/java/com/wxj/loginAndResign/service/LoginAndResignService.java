package com.wxj.loginAndResign.service;

import com.wxj.loginAndResign.entity.User;

public interface LoginAndResignService {

	
	//注册接口
	public String resign(User user);
	
	//查询用户名是否已经被占用
	public String checkExist(String userName);
	
	//登录接口
	public String login(String loginName,String password);
	
	
	
}
