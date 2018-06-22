package com.airline.vo;

public class ScheduleVO {
	private int scheduleid;
	private String planeid;
	private String departure;
	private String arrive;
	private String d_date;
	private String a_date;
	private String delay;
	private int bookedseat;
	
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
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public int getBookedseat() {
		return bookedseat;
	}
	public void setBookedseat(int bookedseat) {
		this.bookedseat = bookedseat;
	}

	

}
