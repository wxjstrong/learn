package com.wxj.testDubbo;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RunDubboProvider {

	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});
		
		context.start();
		System.out.println("服务者已经开始提供服务");
		
		 try {  
             System.in.read();//让此程序一直跑，表示一直提供服务  
         } catch (IOException e) {         
             e.printStackTrace();  
         }  
	}

}
