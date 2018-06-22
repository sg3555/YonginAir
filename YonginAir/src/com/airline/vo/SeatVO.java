package com.airline.vo;

public class SeatVO {
	private int seatid;
	private int scheduleid;
	private String planeid;
	private int m;
	private int n;
	private String seatclass;
	private int price;
	private String bookingid;
	
	public int getSeatid() {
		return seatid;
	}
	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}
	public int getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getPlaneid() {
		return planeid;
	}
	public void setPlaneid(String planeid) {
		this.planeid = planeid;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getSeatclass() {
		return seatclass;
	}
	public void setSeatclass(String seatclass) {
		this.seatclass = seatclass;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

}
