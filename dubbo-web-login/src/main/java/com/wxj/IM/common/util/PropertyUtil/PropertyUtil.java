package com.wxj.IM.common.util.PropertyUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Test;

public class PropertyUtil {
	
	 Properties props = new Properties();
	
	
    public static void main(String [] args) throws IOException{
    	//getProperties("jdbc.properties");
    }
   
    @Test
    /*
     * 通过当前类加载器的getResourceAsStream方法获取
     */
    public void getResourceAsStream() throws IOException{
    	InputStream in =
    		    PropertyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
    	        props.load(in);
    	     //  System.out.println(props);
    	       Iterator<String> it=props.stringPropertyNames().iterator();
               while(it.hasNext()){
                  String key=it.next();
                  System.out.println(key+":"+props.getProperty(key));
                 }
          in.close();
    }
  
    
    /*
     * 通过文件路径获取
     */
    @Test
    public void getPropertiesByFilePath() throws IOException{
    	String filePath = "src/main/resources/jdbc.properties";
 
    	
    	InputStream in = new FileInputStream(new File(filePath));
    	
    	 props.load(in);
    	 Iterator<String> it=props.stringPropertyNames().iterator();
         while(it.hasNext()){
            String key=it.next();
            System.out.println(key+":"+props.getProperty(key));
           }
    	in.close();
    }
    
    /*
     * 通过文件路径获取
     */
      @Test
        public void  getPropertiesByFileStreamPath() throws IOException{
    	
    	InputStream in = new BufferedInputStream (new FileInputStream("src/main/resources/jdbc.properties"));
    	            props.load(in);     ///加载属性列表
    	            Iterator<String> it=props.stringPropertyNames().iterator();
    	            while(it.hasNext()){
    	                 String key=it.next();
    	                 System.out.println(key+":"+props.getProperty(key));
    	            }
                 in.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
