package com.airline.dao;

import java.sql.*;
import java.util.ArrayList;

import com.airline.vo.PlaneVO;
public class PlaneDAO {
	private static PlaneDAO planedao = new PlaneDAO();
	private PlaneDAO() {}
	public static PlaneDAO getInstance() {
		return planedao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setPlane(PlaneVO vo) {
		String sql = "insert into plane value(?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPlaneid());
			pstmt.setInt(2, vo.getM());
			pstmt.setInt(3, vo.getN());
			pstmt.setInt(4, vo.getTotalseat());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public PlaneVO getPlane(String planeid) {
		String sql = "select*from plane where planeid=?";
		PlaneVO vo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planeid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new PlaneVO();
				vo.setPlaneid(rs.getString(1));
				vo.setM(rs.getInt(2));
				vo.setN(rs.getInt(3));
				vo.setTotalseat(rs.getInt(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public void deletePlane(String planeid) {
		String sql1 = "delete from plane where planeid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, planeid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-3-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		String sql2 = "delete from seat where planeid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, planeid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-3-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		String sql3 = "delete from schedule where planeid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, planeid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-3-3번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public ArrayList<PlaneVO> getPlaneList(){
		String sql = "select*from plane";
		ArrayList<PlaneVO>list = new ArrayList<PlaneVO>();
		PlaneVO plane = null;
		try {
		
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				plane = new PlaneVO();
				plane.setPlaneid(rs.getString(1));
				plane.setTotalseat(rs.getInt(4));
				list.add(plane);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("3-4번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
}
