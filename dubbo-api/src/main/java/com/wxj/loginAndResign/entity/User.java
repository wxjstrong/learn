package com.wxj.loginAndResign.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
      
	   String  id;
	  
	   String UserName;
       String password;
       String nickName;
       boolean gender;
	   String IDCard;
	   String phonenum;
	   String eMail;
	   String address;
       String borthday;
       //TODO
       //爱好 
       
       public String getId() {
		return id;
	   }
	   public void setId(String id) {
		this.id = id;
	   }
       
	  public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBorthday() {
		return borthday;
	}
	public void setBorthday(String borthday) {
		this.borthday = borthday;
	}
       
       
       
}
