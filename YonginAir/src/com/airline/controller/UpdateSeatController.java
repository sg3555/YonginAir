package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.SeatService;

public class UpdateSeatController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String seatclass = request.getParameter("seatclass");
		int seatid = Integer.parseInt(request.getParameter("seatid"));
		int price;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		}catch(Exception e) {
			request.setAttribute("temp", "금액을 입력해 주시기 바랍니다.");
			HttpUtil.forward(request, response, "./result.jsp");
			return;
		}
		
		SeatService s = SeatService.getInstance();
		
		s.updateSeatClass(seatid, seatclass);
		s.updateSeatPrice(seatid, price);
		
		request.setAttribute("seatid", seatid);
		HttpUtil.forward(request, response, "./updateSeatOutput.jsp");
		
	}
}
