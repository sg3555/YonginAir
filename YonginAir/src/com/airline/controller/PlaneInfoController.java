package com.airline.controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.vo.*;
import com.airline.service.*;


public class PlaneInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String planeid = request.getParameter("planeid");
		
		ScheduleService scs = ScheduleService.getInstance();
		ArrayList<ScheduleVO>list = scs.getSchedule(planeid);
		
		request.setAttribute("planeid", planeid);
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "./planeInfo.jsp");
	}
}
