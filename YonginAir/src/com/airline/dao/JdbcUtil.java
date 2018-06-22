package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/yonginair?useSSL=false&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "cs1234";
			return DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("1-1번오류 : "+e);
		}return null;
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				if(!rs.isClosed())rs.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("1-2번오류 : "+e);
			}
		}
		close(conn,ps);
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if(ps!=null) {
			try {
				if(!ps.isClosed())ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("1-3번오류 : "+e);
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())conn.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("1-4번오류 : "+e);
			}
		}
	}

}
