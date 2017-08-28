package com.wxj.IM.common.util.httputils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.wxj.IM.common.util.EncryptUtil.SHAEncrypt;
import com.wxj.IM.entity.AppEntity;

@SuppressWarnings("unused")
public abstract class AppManageUtil {
    /*
     * 设置基础属性
     * url
     *passId是请求链接中的参数,并不是应用id的passId
     * 腾讯给的appSecret
     */
	
		private static final String baseServerUrl ="http://172.17.20.213:8074"; 
		private static final String paasId ="admin";
		private static final String appSecret ="Nu4WmXGBauU99NsNuwXjbV7hO2xwEbc91Rp9rKX6WatcmiwWqXyk";
	
	
	/*
	 * 设置请求头
	 */
	public static String sendPostRtxApi(String url,String param,Map<String,String> map) throws  IOException{
		
		String result="";
		//使用接口1.2处理token并把请求头放入map中包括timestamp、x_rio_seq、signature、Content_Type、	Host、Connection	
		if(map==null){
			map = new HashMap<String, String>();
		}
		//System.currentTimeMillis()的单位是毫秒
		Long timestamp=System.currentTimeMillis()/1000;
		String x_rio_seq=timestamp.toString();
	
		//token 也是 signature
		String token=SHAEncrypt.getSha256String(timestamp.toString()+appSecret+x_rio_seq+timestamp.toString());
		
		map.put("timestamp", timestamp.toString());
		map.put("x-rio-seq", x_rio_seq);
		map.put("signature", token.toUpperCase());
		map.put("Content-Type", "application/json;charset=utf-8");
		map.put("Host", "paasapi.oa.com");
		map.put("Connection", "keep-alive");
		//此处抛出异常
		result=HttpRequestUtil.sendPost(url, param, map);
		return result;
	}
	
	
	/*
	 * 获取所有应用信息
	 */
	
	public static String getAllAppInfo() throws  IOException{
		String result="";
		String url=baseServerUrl+"/api/app/list?paasId="+paasId;
		String param="{}";
		
		result=sendPostRtxApi(url, param, null);
		System.out.println(result);
		return result;
	}
	
	
	
	/*
	 * 根据paasId获取应用信息
	 */
	public static String getAppInfo(String _paasId) throws  IOException{
		String result="";
		String url=baseServerUrl+"/api/app/get?paasId="+paasId;
		String param="{\"paasId\":\""+_paasId+"\"}";
		
		result=sendPostRtxApi(url, param, null);
		System.out.println(result);
		return result;
	}
	
	
	/*
	 * 新建应用
	 */
	public static String createApp(AppEntity appEntity) throws Exception{
		String result="";
		//将对象转换成Json对象
		JSONObject jsonObject=JSONObject.fromObject(appEntity);
		//处理参数
		String url=baseServerUrl+"/api/app/create?paasId="+paasId;
		String param=jsonObject.toString();
		
		result=sendPostRtxApi(url,param,null);
		return result;
	}
	

	/*
	 * 根据paasId获取应用可见性
	 */
	public static String getSubscriber(String _paasId) throws IOException{
		
		String result="";
		String url=baseServerUrl+"/api/app/getsubscriber?paasId="+paasId;
		String param="{\"paasId\":\""+_paasId+"\"}";
		
		result=sendPostRtxApi(url, param,null);
		return result;
	}
	/*
	 * 设置应用可见性
	 */
	public static String setSubscriber(String _paasId,String openToAll,String staffIds,String unitIds) throws IOException{
		String result="";
		String url=baseServerUrl+"/api/app/subscribe?paasId="+paasId;
		String param="{\"paasId\":\"" + _paasId + "\",\"openToAll\": "
				+ openToAll + ",\"staffIds\": " + staffIds + ",\"unitIds\": "
				+ unitIds + "}";
		result=sendPostRtxApi(url, param, null);
		return result;
	}

	/*
	 *修改应用 
	 */
	public static String updateApp(AppEntity appEntity) throws IOException{
		String result="";
		JSONObject jsonObject=JSONObject.fromObject(appEntity);
		String url=baseServerUrl+"/api/app/update?paasId="+paasId;
		String param=jsonObject.toString();
		result=sendPostRtxApi(url, param, null);
		
		return result;
	}
	
	/*
	 * 删除应用
	 */
	public static String deleteApp(String _paasId) throws IOException{
		String result="";
		String url=baseServerUrl+"/api/app/remove?paasId="+paasId;
		String param="{\"paasId\":\""+_paasId+"\"}";
		result=sendPostRtxApi(url, param, null);
		return result;
	}
	
}
