package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.PlaneVO;
import com.airline.service.PlaneService;


public class SearchPlaneController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String planeid=request.getParameter("planeid");
		PlaneService pservice = PlaneService.getInstance();
		
		PlaneVO check = pservice.getPlane(planeid);
		if(check==null) {
			request.setAttribute("temp", "없는 기체입니다.");
			HttpUtil.forward(request, response, "./schedulePlane.jsp");
			return;
		}
		
		request.setAttribute("planeid",planeid);
		HttpUtil.forward(request, response, "./schedulePlane.jsp");
	}
}
