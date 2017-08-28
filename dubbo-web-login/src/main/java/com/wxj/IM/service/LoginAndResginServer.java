package com.wxj.IM.service;

import java.util.Map;

public interface LoginAndResginServer {
  public int login(Map map);
  
  public int add(Map map);
  
  public int checkAccount(String account);
  
}
