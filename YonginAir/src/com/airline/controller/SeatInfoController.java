package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import com.airline.service.SeatService;
import com.airline.vo.*;

public class SeatInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
		
		SeatService service = SeatService.getInstance();
		ArrayList<SeatVO>list = service.getSeatList(scheduleid);
		
		request.setAttribute("list",list);
		HttpUtil.forward(request, response, "./seatInfo.jsp");
	}

}
