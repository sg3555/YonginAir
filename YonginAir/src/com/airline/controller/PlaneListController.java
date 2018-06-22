package com.airline.controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.vo.PlaneVO;
import com.airline.service.PlaneService;

public class PlaneListController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		PlaneService userservice = PlaneService.getInstance();
		ArrayList<PlaneVO>list = userservice.getPlaneList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "./planeList.jsp");
	}
}
