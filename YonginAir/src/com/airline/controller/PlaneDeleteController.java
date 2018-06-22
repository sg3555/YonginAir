package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.service.PlaneService;

public class PlaneDeleteController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String planeid=request.getParameter("planeid");
		
		PlaneService ps = PlaneService.getInstance();
		
		ps.deletePlane(planeid);
		
		request.setAttribute("id", planeid);
		HttpUtil.forward(request, response, "./planeDeleteOutput.jsp");
	}

}
