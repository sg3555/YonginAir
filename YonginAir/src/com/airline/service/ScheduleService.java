package com.airline.service;

import com.airline.vo.ScheduleVO;
import com.airline.dao.ScheduleDAO;

import java.util.ArrayList;

public class ScheduleService {
	private static ScheduleService scheduleservice = new ScheduleService();
	public ScheduleDAO scheduledao = ScheduleDAO.getInstance();
	
	private ScheduleService() {}
	public static ScheduleService getInstance() {
		return scheduleservice;
	}
	
	public void setSchedule(ScheduleVO vo) {
		scheduledao.setSchedule(vo);
	}
	public ScheduleVO getSchedule(ScheduleVO vo) {
		return scheduledao.getSchedule(vo);
	}
	public ScheduleVO getSchedule2(int scheduleid) {
		return scheduledao.getSchedule2(scheduleid);
	}
	public ArrayList<ScheduleVO> getSchedule(String planeid) {
		return scheduledao.getScheduleList(planeid);
	}
	
	public void deleteSchedule(int scheduleid) {
		scheduledao.deleteSchedule(scheduleid);
	}
	
	public ArrayList<ScheduleVO> searchSchedule(ScheduleVO vo){
		return scheduledao.searchSchedule(vo);
	}
	
	public void setBookedSeat(ScheduleVO vo) {
		scheduledao.setBookedSeat(vo);
	}
	
	public ArrayList<ScheduleVO> getScheduleList3(String d_date) {
		return scheduledao.getScheduleList3(d_date);
	}
	public void updateDelay(ScheduleVO vo) {
		scheduledao.updateDelay(vo);
	}
}
