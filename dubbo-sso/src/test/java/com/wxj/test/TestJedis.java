package com.wxj.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestJedis {
   @Test
	public  void TestJedisPing(){
		Jedis jedis = new Jedis("192.168.75.128",6379);
		//ping测试
		System.out.println(jedis.ping());//测试结果为pong
		
		System.out.println(jedis.get("wangxijian"));
		System.out.println(jedis.get("wxj"));
		
	}

}
