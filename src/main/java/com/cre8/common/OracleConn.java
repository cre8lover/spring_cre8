package com.cre8.common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConn {
	
	private static OracleConn my = new OracleConn();
	private Connection conn;
	
	private OracleConn() {
		oracleConn();
	}
	
	public static OracleConn getInstance() {
		return my;
	}
	
	public void oracleConn() {
		final String url="jdbc:oracle:thin:@192.168.10.135:1521:cre8";
//		final String url="jdbc:oracle:thin:@192.168.219.109:1521:xe";
//		final String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,"jmh","jmh");
//			conn = DriverManager.getConnection(url,"joy","8088");
//			System.out.println("?ò§?ùº?Å¥ ?ó∞Í≤∞ÏôÑÎ£?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	

	}
	
	public Connection getConn(){
		return conn;
	}
	
	
}
