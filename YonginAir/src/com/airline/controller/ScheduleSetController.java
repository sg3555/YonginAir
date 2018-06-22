package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.*;
import com.airline.vo.*;

public class ScheduleSetController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String planeid = request.getParameter("planeid");
		String departure = request.getParameter("departure");
		String arrive = request.getParameter("arrive");
		String d_date = request.getParameter("d_date");
		String a_date = request.getParameter("a_date");
		String delay = request.getParameter("delay");
		int price = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		}catch(Exception e) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다.");
			HttpUtil.forward(request, response, "./schedulePlane.jsp");
			return;
		}
		
		if(departure.equals(arrive)) {
			request.setAttribute("temp", "출발지와 목적지는 같을 수 없습니다");
			HttpUtil.forward(request, response, "./schedulePlane.jsp");
			return;
		}
		if(d_date.equals("")||a_date.equals("")) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다");
			HttpUtil.forward(request, response, "./schedulePlane.jsp");
			return;
		}
		
		PlaneService psc = PlaneService.getInstance();
		ScheduleService ssc = ScheduleService.getInstance();
		SeatService sec = SeatService.getInstance();
		
		ScheduleVO svo = new ScheduleVO();
		svo.setPlaneid(planeid);
		svo.setDeparture(departure);
		svo.setArrive(arrive);
		svo.setD_date(d_date);
		svo.setA_date(a_date);
		svo.setDelay(delay);
		svo.setBookedseat(0);
		
		ssc.setSchedule(svo);
		
		PlaneVO pvo = psc.getPlane(planeid);
		ScheduleVO vo = ssc.getSchedule(svo);
		SeatVO evo = new SeatVO();
		evo.setScheduleid(vo.getScheduleid());
		evo.setPlaneid(pvo.getPlaneid());
		evo.setM(pvo.getM());
		evo.setN(pvo.getN());
		evo.setPrice(price);
		
		sec.setSeat(evo);
		
		request.setAttribute("planeid", planeid);
		HttpUtil.forward(request, response, "./scheduleSetOutput.jsp");
	}
}
