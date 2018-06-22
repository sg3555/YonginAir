package com.airline.dao;

import java.sql.*;

public class ProfitDAO {
	private static ProfitDAO profitdao = new ProfitDAO();
	private ProfitDAO() {}
	public static ProfitDAO getInstance() {
		return profitdao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setMoney(int money) {
		String sql = "update profit set money=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public int getMoney() {
		String sql = "select*from profit";
		int money=0;
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				money = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return money;
	}

	
}
