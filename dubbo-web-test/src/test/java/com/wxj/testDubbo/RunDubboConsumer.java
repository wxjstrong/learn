package com.wxj.testDubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wxj.testDubbo.service.TestDubboService;


public class RunDubboConsumer {

	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
		
		context.start();
		System.out.println("服务者已经开始运行");
		
		TestDubboService service = (TestDubboService) context.getBean("testDubboService");
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
