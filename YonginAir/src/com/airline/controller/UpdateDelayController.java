package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.vo.ScheduleVO;
import com.airline.service.ScheduleService;

public class UpdateDelayController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
		String delay = request.getParameter("delay");
		
		ScheduleVO vo = new ScheduleVO();
		vo.setScheduleid(scheduleid);
		vo.setDelay(delay);
		ScheduleService s = ScheduleService.getInstance();
		s.updateDelay(vo);
		
		HttpUtil.forward(request, response, "updateDelayOutput.jsp");
		
	}
}
