package com.wxj.IM.common.util.httputils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.wxj.IM.common.util.EncryptUtil.SHAEncrypt;


public class HttpRequestUtil {
    /*
     * 使用get方式实现发送请求
     * requestProperties请求头的内容
     */
	public static String sendGet(String url,String param,Map<String,String>requestProperties) {
		String res="";
		//定义BufferReader来读取url的响应
	    BufferedReader br = null;
		//把url和参数拼接起来
		
		
		 
		try {
			String urlString=url;
			if(param !=null && "".equals(param)){
				urlString= urlString+"?"+param; 
			}
			URL realUrl = new URL(urlString);
		
		//打开和url之间的链接
	    URLConnection connection=realUrl.openConnection();
		
	    //设置通用的请求属性
		if(requestProperties!=null){
			//获取集合的迭代器保存在 iter中
			Iterator <Map.Entry<String, String>> iter=requestProperties.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry=iter.next();
				connection.setRequestProperty(entry.getKey(),entry.getValue());
			}
		}
	   //获取所有响应头并输出
		Map<String,List<String>> map = connection.getHeaderFields();
		 //keySet()获取所有的key
		for(String key:map.keySet()){
			System.out.println(key+"--->"+map.get(key));
		}
		
		//建立实际连接
	    connection.connect();
		//读取url响应
		br= new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String line;
		while((line=br.readLine())!=null){
			res +="/n"+line;
		}
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("get请求失败");
			e.printStackTrace();
		}
		finally{
			//关闭输入流
			try {
				if (br!=null){
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		return res;
	}
	
	
	public static String sendPostOld(String url, String param,
			Map<String, String> requestPropertys) throws Exception {
		BufferedWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			if(requestPropertys != null) { 
				Iterator<Map.Entry<String, String>> iter = requestPropertys.entrySet().iterator();
				while(iter.hasNext()) {
					Map.Entry<String, String> entry = iter.next();
					conn.setRequestProperty(entry.getKey(), entry.getValue());	
				}
			}
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 设置通用的请求属性
			if (param != null) {
				conn.setRequestProperty("Content-Length",String.valueOf(param.length()));
			}
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestMethod("POST");
			conn.connect();
			// 获取URLConnection对象对应的输出流
			out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
			out.write(param == null ? "" : param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result = result + line + "\n";
			}
		} catch (Exception e) {
			System.out.println("HttpRequestUtils sendPost() error:");
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				throw ex;
			}
		}
		return result;
	}
	
	/*
	 * 使用post方式发送请求
	 */
	
	public static String sendPost(String url,String param,Map<String,String> requestProperties) throws ClientProtocolException, IOException{
		HttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		if(requestProperties!=null){
			Iterator<Map.Entry<String, String>> iter = requestProperties.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry = iter.next();
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
		}
		Header[] allHeaders = httpPost.getAllHeaders();
	   for(int i=0;i<allHeaders.length-1;i++){
		  System.out.println(allHeaders[i]);
	   }
		//设置头信息
	   //设置超时时间
	    RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();
		httpPost.setConfig(requestConfig);
		httpPost.setEntity(new StringEntity(param,"UTF-8"));
	    HttpResponse response = httpClient.execute(httpPost);
	    BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
	    String line;
	    String res="";
	    while((line=in.readLine())!=null){
	    	res=res+line+"\n";
	    }
		return res;
	}
	public static void main(String[] args) throws Exception {
		Map<String,String>map=new HashMap<String,String>();
		Long timeS=System.currentTimeMillis()/1000;
		String x_rio_seq="ab570e0a:015a1d0fbef0:00cb3d";
		String appSecret ="Nu4WmXGBauU99NsNuwXjbV7hO2xwEbc91Rp9rKX6WatcmiwWqXyk";
		  String token=	SHAEncrypt.getSha256String(timeS.toString()+appSecret+x_rio_seq+timeS.toString());
		  System.out.println(token.toUpperCase());
		  System.out.println(timeS.toString());
		map.put("timestamp", timeS.toString());
		map.put("x-rio-seq", x_rio_seq);
		map.put("signature", token.toUpperCase());
		map.put("Content-Type","application/json;charset=utf-8");
		String result=sendPost("http://172.17.20.213:8074/api/staff/get?paasId=admin","{\"staffName\": \"test2\"}",map);
		System.out.println(result);
	}
	
}
