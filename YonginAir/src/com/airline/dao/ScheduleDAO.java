package com.airline.dao;

import java.sql.*;
import java.util.ArrayList;

import com.airline.vo.ScheduleVO;
import com.airline.vo.SeatVO;


public class ScheduleDAO {
	private static ScheduleDAO scheduledao = new ScheduleDAO();
	private ScheduleDAO() {}
	public static ScheduleDAO getInstance() {
		return scheduledao;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void setSchedule(ScheduleVO vo) {
		String sql = "insert into schedule(planeid,departure,arrive,d_date,a_date,delay,bookedseat) value(?,?,?,?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPlaneid());
			pstmt.setString(2, vo.getDeparture());
			pstmt.setString(3, vo.getArrive());
			pstmt.setString(4, vo.getD_date());
			pstmt.setString(5, vo.getA_date());
			pstmt.setString(6, vo.getDelay());
			pstmt.setInt(7, vo.getBookedseat());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn,pstmt);
		}
	}
	
	public ScheduleVO getSchedule(ScheduleVO vo) {
		String sql = "select*from schedule where planeid=? and departure=? and arrive=? and d_date=? and a_date=?";
		ScheduleVO nvo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPlaneid());
			pstmt.setString(2, vo.getDeparture());
			pstmt.setString(3, vo.getArrive());
			pstmt.setString(4, vo.getD_date());
			pstmt.setString(5, vo.getA_date());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nvo = new ScheduleVO();
				nvo.setScheduleid(rs.getInt(1));
				nvo.setPlaneid(rs.getString(2));
				nvo.setDeparture(rs.getString(3));
				nvo.setArrive(rs.getString(4));
				nvo.setD_date(rs.getString(5));
				nvo.setA_date(rs.getString(6));
				nvo.setDelay(rs.getString(7));
				nvo.setBookedseat(rs.getInt(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-2-1번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return nvo;
	}
	
	public ScheduleVO getSchedule2(int scheduleid) {
		String sql = "select*from schedule where scheduleid=?";
		ScheduleVO nvo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nvo = new ScheduleVO();
				nvo.setScheduleid(rs.getInt(1));
				nvo.setPlaneid(rs.getString(2));
				nvo.setDeparture(rs.getString(3));
				nvo.setArrive(rs.getString(4));
				nvo.setD_date(rs.getString(5));
				nvo.setA_date(rs.getString(6));
				nvo.setDelay(rs.getString(7));
				nvo.setBookedseat(rs.getInt(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-2-2번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return nvo;
	}
	
	public ArrayList<ScheduleVO> getScheduleList(String planeid){
		String sql = "select*from schedule where planeid=? order by d_date";
		ArrayList<ScheduleVO>list = new ArrayList<ScheduleVO>();
		ScheduleVO schedule = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planeid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				schedule = new ScheduleVO();
				schedule.setScheduleid(rs.getInt(1));
				schedule.setPlaneid(rs.getString(2));
				schedule.setDeparture(rs.getString(3));
				schedule.setArrive(rs.getString(4));
				schedule.setD_date(rs.getString(5));
				schedule.setA_date(rs.getString(6));
				schedule.setDelay(rs.getString(7));
				schedule.setBookedseat(rs.getInt(8));
				list.add(schedule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-3번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void deleteSchedule(int scheduleid) {
		String sql = "delete from schedule where scheduleid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-5-1번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		sql = "delete from seat where scheduleid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scheduleid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-5-2번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public ArrayList<String> searchPlaneid(String departure, String d_date) {
		String sql = "select from schedule where departure=? and d_date=?";
		ArrayList<String>planeid = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departure);
			pstmt.setString(2, d_date);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				planeid.add(rs.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-6번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return planeid;
	}
	
	public ArrayList<ScheduleVO> searchSchedule(ScheduleVO vo){
		String sql = "select*from schedule where departure=? and arrive=? and d_date=?";
		ArrayList<ScheduleVO>list = new ArrayList<ScheduleVO>();
		ScheduleVO scvo = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDeparture());
			pstmt.setString(2, vo.getArrive());
			pstmt.setString(3, vo.getD_date());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				scvo = new ScheduleVO();
				scvo.setScheduleid(rs.getInt(1));
				scvo.setPlaneid(rs.getString(2));
				scvo.setDeparture(rs.getString(3));
				scvo.setArrive(rs.getString(4));
				scvo.setD_date(rs.getString(5));
				scvo.setA_date(rs.getString(6));
				scvo.setDelay(rs.getString(7));
				scvo.setBookedseat(rs.getInt(8));
				list.add(scvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-7번 오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void setBookedSeat(ScheduleVO vo) {
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
	
	public ArrayList<ScheduleVO> getScheduleList3(String d_date){
		String sql = "select*from schedule where d_date=?";
		ArrayList<ScheduleVO>list = new ArrayList<ScheduleVO>();
		ScheduleVO schedule = null;
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d_date);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				schedule = new ScheduleVO();
				schedule.setScheduleid(rs.getInt(1));
				schedule.setPlaneid(rs.getString(2));
				schedule.setDeparture(rs.getString(3));
				schedule.setArrive(rs.getString(4));
				schedule.setD_date(rs.getString(5));
				schedule.setA_date(rs.getString(6));
				schedule.setDelay(rs.getString(7));
				schedule.setBookedseat(rs.getInt(8));
				list.add(schedule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-9번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void updateDelay(ScheduleVO vo) {
		String sql = "update schedule set delay=? where scheduleid=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDelay());
			pstmt.setInt(2, vo.getScheduleid());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("5-10번오류 : "+e);
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
}