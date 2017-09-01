package com.wxj.testDubbo.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxj.testDubbo.service.TestDubboService;



@Controller
@RequestMapping("/testDubbo")
public class TestDubbo {

	@RequestMapping("/sayHello.do")
	@ResponseBody
    public String sayHello(@RequestParam("userName")String userName){
		
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
		
		context.start();
		System.out.println("服务者已经开始运行");
		
		TestDubboService service = (TestDubboService) context.getBean("testDubboService");
	    String res = service.sayHello(userName);
	    
	    
	    return res;
		
	}
}
