package com.wxj.IM.common.util.EncryptUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;

public class SHAEncrypt {
     /*
      * 将8位的byte转成16进制
      */
	public static String byteToHex(byte[] bytes){
		 StringBuffer stringBuffer = new StringBuffer();
		 String temp = null;
		 for(int i=0;i<bytes.length;i++){
			 temp = Integer.toHexString(bytes[i] & 0xFF);
			 if(temp.length()==1){
				 //1得到一位的进行补0操作
				 stringBuffer.append("0");
			 }
			    stringBuffer.append(temp);
		 }

		 return stringBuffer.toString();
	}

	//使用apache工具类实现加密
	public static String getSha256String(String str){
		MessageDigest messageDigest;
		String res="";
		try {
			messageDigest=MessageDigest.getInstance("SHA-256");
			byte[] hash=messageDigest.digest(str.getBytes("UTF-8"));
			res=Hex.encodeHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
				
	}
	
	
	//第二种，使用java自导的sha256加密方式
	public static String getSha256Stringjava(String str){
		MessageDigest messageDigest;
		String res="";
	
		try {
			messageDigest=MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			
			res =byteToHex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public static void main(String[] args){
	/*	Date timestamp=new Date();
		System.out.println(timestamp.toString());*/
        String timestamp="1493113594";
		String x_rio_seq="ab570e0a:015a1d0fbef0:00cb3d";
		String appSecret="f70d12a5a40046b981a1100c01a0ba77";
		String signature= getSha256String(timestamp+appSecret+x_rio_seq+timestamp);
		System.out.println(signature);
		
	}
	
}
