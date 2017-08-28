package com.wxj.IM.common.util.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {   


	static Jedis  jedis =new Jedis("192.168.75.128",6379);
	
	@Test
	public void TestRedisConnection(){
		 Jedis jedis=new Jedis("192.168.75.128",6379);

		 System.out.println("Server is running: "+jedis.ping()); 
		 String sname=jedis.get("name");
		 System.out.println(sname);
	}

	@Test
	public void   TestString(){
        	
        	 
			// jedis.set("name",wxj);
			 //根据key获取value
             String res=jedis.get("name");
             System.out.println(res);
             
             //拼接
            // jedis.append("name", " I love you");
             System.out.println(jedis.get("name"));
             
             //删除
             //jedis.del("name");
             System.out.println(jedis.get("name"));

         }
     @Test
	/*
      * jedis操作map使用hmset、和hmget
      */
     public void TestMap(){
    	 Map<String,String> map=new HashMap<String,String>();
    	 map.put("name", "张三");
    	 map.put("age", "10");
    	 map.put("tel", "123");
    	
    	 jedis.hmset("map",map);
    	 //List <String> rsmap=jedis.hmget("map","name","age","tel");
    	 //System.out.println(jedis.hmget("map","name","age"));//[张三, 10]
    	// System.out.println(rsmap);//[张三, 10, 123]
    	 
    	 
    	 //返回map的长度
    	 System.out.println(jedis.hlen("map"));//3
    	 
    	 //删除某一个key
    	 jedis.hdel("map", "tel");
    	 System.out.println(jedis.hmget("map","name","age","tel"));//[张三, 10, null]
    	 System.out.println(jedis.hlen("map"));//2
    	 
    	 //是否存在key
    	 System.out.println(jedis.exists("map"));//true
    	 //返回所有的map中的key
    	 System.out.println(jedis.hkeys("map"));//[name, age]
    	 //获取所有的map的值
    	 System.out.println(jedis.hvals("map"));//[张三, 10]
    	 
    	 Iterator<String> iter=jedis.hkeys("map").iterator(); 
    	 while (iter.hasNext()){  
    	            String key = iter.next();  
    	              System.out.println(key+":"+jedis.hmget("user",key));  
    	         }  
           }
     
     /*
      * 测试List
      */
     @Test
     public void TestList(){
    	 //先清空List的key的值，让后续操作更清晰
    	 jedis.del("Testlist");
    	 System.out.println(jedis.lrange("Testlist",0,-1));
    	 //给list添加内容
    	 //Redis Lpush 命令将一个或多个值插入到列表头部。 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误
    	 jedis.lpush("Testlist", "王");
    	 jedis.lpush("Testlist", "希");
    	 jedis.lpush("Testlist", "建");
    	 
    	 System.out.println(jedis.lrange("Testlist", 0, 2));//[建, 希, 王]
    	 System.out.println(jedis.lrange("Testlist", 0, -1));//[建, 希, 王]
    	 System.out.println(jedis.lrange("Testlist", 0, 1));//[建, 希]
        //Redis Rpush 命令用于将一个或多个值插入到列表的尾部(最右边)。 如果列表不存在，一个空列表会被创建并执行 RPUSH 操作。 当列表存在但不是列表类型时，返回一个错误
    	 jedis.del("Testlist");
        System.out.println(jedis.lrange("Testlist",0,-1));
         jedis.rpush("Testlist", "王");
   	     jedis.rpush("Testlist", "希");
   	     jedis.rpush("Testlist", "建");
   	    System.out.println(jedis.lrange("Testlist", 0, -1));//[王, 希, 建]
    
   	    jedis.del("Testlist");
   	    jedis.rpush("Testlist", "wang","xi","jian");
   	    System.out.println(jedis.lrange("Testlist", 0, -1));

     }
     @Test
      public void TestSet(){
    	  jedis.sadd("user", "zhangSan");
    	  jedis.sadd("user", "zhangSan1");
    	  jedis.sadd("user", "zhangSan2");
    	  jedis.sadd("user", "zhangSan3");
    	  jedis.sadd("user", "zhangSan4");
    	 //获取set中所有的value值
    	  System.out.println(jedis.smembers("user"));//[zhangSan3, zhangSan, zhangSan2, zhangSan1, zhangSan4]
    	//判断zhangSan 是否是user集合的元素
    	  System.out.println(jedis.sismember("user", "zhangSan"));//true
    	//  返回集合中一个或多个随机数 
    	  System.out.println(jedis.srandmember("user"));  
    	  //移除集合中的一个元素
    	  System.out.println(jedis.srem("user", "zhangSan4"));

     }
     
}
