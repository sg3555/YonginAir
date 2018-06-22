package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import com.airline.service.SeatService;
import com.airline.vo.*;

public class SearchSeatController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
		String type = request.getParameter("type");
		String path = null;
		if(type.equals("admin"))path="./searchSeat.jsp";
		if(type.equals("eachway"))path="./searchEachwaySeat.jsp";
		if(type.equals("shuttle1"))path="./searchShuttleSeat1.jsp";
		if(type.equals("shuttle2"))path="./searchShuttleSeat2.jsp";
		
		SeatService service = SeatService.getInstance();
		ArrayList<SeatVO>list = service.getSeatList(scheduleid);
		
		request.setAttribute("list",list);
		HttpUtil.forward(request, response, path);
	}

}
