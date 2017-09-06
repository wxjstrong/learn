package com.wxj.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TestMySqlConnect {
	private static Connection conn = null ;
	private PreparedStatement ps   = null ;
	private ResultSet rs = null;
	
	public static Connection testConnection() throws ClassNotFoundException, SQLException{
	String url = "jdbc:mysql://localhost:3306/userinfo";	
	Class.forName("com.mysql.jdbc.Driver");
	conn = (Connection)DriverManager.getConnection(url, "root","");
	System.out.println(conn);	
	return conn	;
	}
   
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		testConnection();
	}
	
	
	
}
