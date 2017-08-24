package com.wxj.sso.service.impl;

import java.util.UUID;

import com.wxj.sso.service.SsoService;

public class SsoServiceImpl implements SsoService {
   

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		
		
		System.out.println("开始处理单点登录");
		//生成一个随机数token
	   String token=UUID.randomUUID().toString();
	   System.out.println("生成的token是-->"+token);
	   return token;
	}
}
