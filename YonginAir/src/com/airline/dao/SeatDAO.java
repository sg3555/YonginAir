package com.airline.dao;

import java.sql.*;
import java.util.ArrayList;

import com.airline.vo.SeatVO;

public class SeatDAO {
	private static SeatDAO seatdao = new SeatDAO();
	private SeatDAO() {}
	public static SeatDAO getInstance() {
		return seatdao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setSeat(SeatVO vo) {
		String sql = "insert into seat(scheduleid, planeid, m, n, price) value(?,?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			for(int i=1;i<=vo.getM();i++) {
				for(int j=1;j<=vo.getN();j++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, vo.getScheduleid());
					pstmt.setString(2, vo.getPlaneid());
					pstmt.setInt(3, i);
					pstmt.setInt(4, j);
					pstmt.setInt(5, vo.getPrice());
					pstmt.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public ArrayList<SeatVO> getSeat(String id) {
		String sql = "select*from seat where bookingid=?";
		ArrayList<SeatVO>list = new ArrayList<SeatVO>();
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SeatVO seat = new SeatVO();
				seat.setSeatid(rs.getInt(1));
				seat.setScheduleid(rs.getInt(2));
				seat.setPlaneid(rs.getString(3));
				seat.setM(rs.getInt(4));
				seat.setN(rs.getInt(5));
				seat.setSeatclass(rs.getString(6));
				seat.setPrice(rs.getInt(7));
				seat.setBookingid(rs.getString(8));
				list.add(seat);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public void updateSeatClass(int seatid, String seatclass) {
		String sql = "update seat set seatclass=? where seatid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, seatclass);
			pstmt.setInt(2, seatid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-3-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateSeatPrice(int seatid, int price) {
		String sql = "update seat set price=? where seatid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, seatid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-3-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	public void updateSeatBookingid(int seatid, String bookingid) {
		String sql = "update seat set bookingid=? where seatid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, bookingid);
			pstmt.setInt(2, seatid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-3-3번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public ArrayList<SeatVO> getSeatList(int scheduleid){
		String sql = "select*from seat where scheduleid=?";
		ArrayList<SeatVO>list = new ArrayList<SeatVO>();
		SeatVO seat = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				seat = new SeatVO();
				seat.setSeatid(rs.getInt(1));
				seat.setScheduleid(rs.getInt(2));
				seat.setPlaneid(rs.getString(3));
				seat.setM(rs.getInt(4));
				seat.setN(rs.getInt(5));
				seat.setSeatclass(rs.getString(6));
				seat.setPrice(rs.getInt(7));
				seat.setBookingid(rs.getString(8));
				list.add(seat);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-4번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public SeatVO getSeatInfo(int seatid) {
		String sql = "select*from seat where seatid=?";
		SeatVO vo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seatid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new SeatVO();
				vo.setSeatid(rs.getInt(1));
				vo.setScheduleid(rs.getInt(2));
				vo.setPlaneid(rs.getString(3));
				vo.setM(rs.getInt(4));
				vo.setN(rs.getInt(5));
				vo.setSeatclass(rs.getString(6));
				vo.setPrice(rs.getInt(7));
				vo.setBookingid(rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-5번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int getSeatId(int scheduleid, int m, int n) {
		String sql = "select*from seat where scheduleid=? and m=? and n=?";
		int seatid = 0;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleid);
			pstmt.setInt(2, m);
			pstmt.setInt(3, n);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seatid = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4-6번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return seatid;
	}
	
	public void setBookedSeat(SeatVO vo) {
		String sql = "select*from seat where scheduleid=? and bookingid='0'";
		ArrayList<SeatVO>list = new ArrayList<SeatVO>();
		SeatVO sv = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getScheduleid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				sv = new SeatVO();
				sv.setScheduleid(rs.getInt(1));
				list.add(sv);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-8-1번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		sql = "select*from plane where planeid=?";
		int totalseat = 0;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPlaneid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalseat = rs.getInt(4);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-8-2번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		if(totalseat!=0) {
			int bookedseat = totalseat-list.size();
			sql = "update schedule set bookedseat=? where scheduleid=?";
			try {
				conn = JdbcUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookedseat);
				pstmt.setInt(2, vo.getScheduleid());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("5-8-3번 오류 : "+e);
			}finally {
				JdbcUtil.close(conn, pstmt);
			}
		}
		
	}
	
	public void setBookedSeatByUser(String userid) {
		String sql = "updaet seat set bookingid='0' where bookingid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-9번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
}
