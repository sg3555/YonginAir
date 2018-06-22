package com.airline.controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.*;
import com.airline.service.*;

public class SearchAirlineController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		String departure = request.getParameter("departure");
		String arrive = request.getParameter("arrive");
		String d_date = request.getParameter("d_date");
		String a_date = null;
		String value = request.getParameter("value");
		String path = null;
		if(value.equals("shuttle"))a_date = request.getParameter("a_date");
		
		if(value.equals("shuttle"))path="./searchShuttle1.jsp";
		if(value.equals("eachway"))path="./searchEachway.jsp";
		
		
		if(value.equals("shuttle")) {
			if(d_date.equals("")||a_date.equals("")) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다");
			HttpUtil.forward(request, response, "./index.jsp");
			return;
			}
		}
		if(value.equals("eachway")) {
			if(d_date.equals("")) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다");
			HttpUtil.forward(request, response, "./index.jsp");
			return;
			}
		}
		
		if(departure.equals(arrive)) {
			request.setAttribute("temp", "출발지와 목적지는 같을 수 없습니다");
			HttpUtil.forward(request, response, "./index.jsp");
			return;
		}
		
		ScheduleService sv = ScheduleService.getInstance();
		ScheduleVO vo = new ScheduleVO();
		vo.setDeparture(departure);
		vo.setArrive(arrive);
		vo.setD_date(d_date);
		ArrayList<ScheduleVO>list1 = sv.searchSchedule(vo);
		session.setAttribute("list1", list1);
		
		vo.setDeparture(arrive);
		vo.setArrive(departure);
		vo.setD_date(a_date);
		ArrayList<ScheduleVO>list2 = sv.searchSchedule(vo);
		session.setAttribute("list2", list2);
		
		HttpUtil.forward(request, response, path);
	}
}
