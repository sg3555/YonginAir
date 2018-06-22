package com.airline.dao;

import java.sql.*;
import java.util.ArrayList;

import com.airline.vo.AirportVO;

public class AirportDAO {
	private static AirportDAO airportdao = new AirportDAO();
	private AirportDAO() {}
	public static AirportDAO getInstance() {
		return airportdao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setAirport(AirportVO vo) {
		String sql = "insert into airport value(?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAirportid());
			pstmt.setString(2, vo.getAirportname());
			pstmt.setString(3, vo.getNation());
			pstmt.setString(4, vo.getWeather());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public void updateAirportWeather(String airportid,String weather) {
		String sql = "update schedule set weather=? where airportid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, weather);
			pstmt.setString(2, airportid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-2번오류: "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public void deleteAirport(String airportid) {
		String sql = "delete from airport where airportid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, airportid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-3번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public ArrayList<AirportVO> getAirportList(){
		String sql = "select*from airport";
		ArrayList<AirportVO>list = new ArrayList<AirportVO>();
		AirportVO vo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new AirportVO();
				vo.setAirportid(rs.getString(1));
				vo.setAirportname(rs.getString(2));
				vo.setNation(rs.getString(3));
				vo.setWeather(rs.getString(4));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-4번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public String getAirportName(String airportid) {
		String sql = "select*from airport where airportid=?";
		String name=null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, airportid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(2);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-5번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return name;
	}
	
	public String getAirportNation(String airportid) {
		String sql = "select*from airport where airportid=?";
		String name=null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, airportid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(3);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("6-6번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return name;
	}
	
}
