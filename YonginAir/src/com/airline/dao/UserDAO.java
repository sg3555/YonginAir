package com.airline.dao;

import java.sql.*;
import java.util.ArrayList;

import com.airline.vo.UserVO;
import com.airline.service.SeatService;


public class UserDAO {
	private static UserDAO userdao = new UserDAO();
	private UserDAO() {}
	public static UserDAO getInstance() {
		return userdao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setUser(UserVO vo) {
		String sql = "insert into user(id,pw,name,mail,nation,role) value(?,?,?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getMail());
			pstmt.setString(5, vo.getNation());
			pstmt.setString(6, vo.getRole());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public UserVO getUser(String id) {
		String sql = "select*from user where id=?";
		UserVO user = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(1));
				user.setPw(rs.getString(2));
				user.setName(rs.getString(3));
				user.setMail(rs.getString(4));
				user.setNation(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setMoney(rs.getInt(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return user;
	}
	
	public void updateUserPw(String id, String pw) {
		String sql = "update user set pw=? where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-3-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateUserName(String id, String name) {
		String sql = "update user set name=? where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-3-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateUserMail(String id, String mail) {
		String sql = "update user set mail=? where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, mail);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-3-3번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateUserNation(String id, String nation) {
		String sql = "update user set nation=? where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, nation);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-3-4번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateUserMoney(String id, int money) {
		String sql = "update user set money=? where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-3-5번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}

	}
	
	public void deleteUser(String id) {
		String sql = "delete from user where id=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-4-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		sql = "update seat set bookingid='0' where bookingid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-4-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		
	}
	
	public ArrayList<UserVO> getUserList(){
		String sql = "select*from user";
		ArrayList<UserVO>list = new ArrayList<UserVO>();
		UserVO user = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(1));
				user.setPw(rs.getString(2));
				user.setName(rs.getString(3));
				user.setMail(rs.getString(4));
				user.setNation(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setMoney(rs.getInt(7));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("2-5번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
}
