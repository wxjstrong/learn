package com.wxj.testDubbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxj.testDubbo.service.TestDubboService;
@Controller
@RequestMapping("/testDubbo")
public class TestDubboController {
     
	@Autowired TestDubboService service;
	
	
	@RequestMapping("/sayHello.do")
	@ResponseBody

	public String TestDubboController(String userName) {
		
		 String res = service.sayHello(userName);	
		 return res;
	}

}
