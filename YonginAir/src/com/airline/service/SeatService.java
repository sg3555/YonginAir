package com.airline.service;

import com.airline.vo.SeatVO;
import com.airline.dao.SeatDAO;

import java.util.ArrayList;

public class SeatService {
	private static SeatService seatservice = new SeatService();
	public SeatDAO seatdao = SeatDAO.getInstance();
	
	private SeatService() {}
	public static SeatService getInstance() {
		return seatservice;
	}
	
	public void setSeat(SeatVO vo) {
		seatdao.setSeat(vo);
	}
	
	public ArrayList<SeatVO> getSeat(String bookingid) {
		return seatdao.getSeat(bookingid);
	}
	
	public void updateSeatClass(int seatid, String seatclass) {
		seatdao.updateSeatClass(seatid,seatclass);
	}
	public void updateSeatPrice(int seatid, int price) {
		seatdao.updateSeatPrice(seatid,price);
	}
	public void updateSeatBookingid(int seatid, String bookingid) {
		seatdao.updateSeatBookingid(seatid,bookingid);
	}
	
	public ArrayList<SeatVO> getSeatList(int scheduleid){
		ArrayList<SeatVO>list=seatdao.getSeatList(scheduleid);
		return list;
	}
	
	public SeatVO getSeatInfo(int seatid) {
		return seatdao.getSeatInfo(seatid);
	}
	public int getSeatId(int scheduleid, int m, int n) {
		return seatdao.getSeatId(scheduleid, m, n);
	}
	
	public void setBookedSeat(SeatVO vo) {
		seatdao.setBookedSeat(vo);
	}
	
	public void setBookedSeatByUser(String userid) {
		seatdao.setBookedSeatByUser(userid);
	}

}
