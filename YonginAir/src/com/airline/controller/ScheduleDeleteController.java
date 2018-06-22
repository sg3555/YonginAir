package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.service.ScheduleService;

public class ScheduleDeleteController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
		
		ScheduleService sc = ScheduleService.getInstance();
		
		sc.deleteSchedule(scheduleid);
		
		HttpUtil.forward(request, response, "scheduleDeleteOutput.jsp");
	}
}
