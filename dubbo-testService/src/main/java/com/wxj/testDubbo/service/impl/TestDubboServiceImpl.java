package com.wxj.testDubbo.service.impl;


import net.sf.json.JSONObject;

import com.wxj.testDubbo.service.TestDubboService;

public class TestDubboServiceImpl implements TestDubboService {

	@Override
	public String sayHello(String userName) {
		// TODO Auto-generated method stub
		String message="";
		
		if("".equals(userName) || userName==null){
			 message="您未输入名字";
		}
		
		message="您当前输入的名字是"+userName;
       String str ="{\"message\": "+message+"}";
       
       JSONObject json = new JSONObject();
       JSONObject result = json.fromObject(str);
		return result.toString();
	}

	
}
