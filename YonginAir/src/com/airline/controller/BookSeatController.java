package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.*;
import com.airline.service.*;

public class BookSeatController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		int seatid =  Integer.parseInt(request.getParameter("seatid"));
		String type = request.getParameter("type");
		String path = null;
		if(type.equals("eachway")||type.equals("shuttle2"))path="/payTicket.jsp";
		if(type.equals("shuttle1"))path="/searchShuttle2.jsp";
		
		
		SeatVO book = new SeatVO();
		ScheduleVO info = new ScheduleVO();
		
		SeatService sc = SeatService.getInstance();
		ScheduleService ssc = ScheduleService.getInstance();
		
		if(type.equals("eachway")||type.equals("shuttle1")) {
			book = sc.getSeatInfo(seatid);
			info = ssc.getSchedule2(book.getScheduleid());
			session.setAttribute("book1",book);
			session.setAttribute("info1",info);
		}
		if(type.equals("shuttle1")) {
			book = sc.getSeatInfo(seatid);
			info = ssc.getSchedule2(book.getScheduleid());
			session.setAttribute("book1",book);
			session.setAttribute("info1",info);

		}
		if(type.equals("shuttle2")) {
			book = sc.getSeatInfo(seatid);
			info = ssc.getSchedule2(book.getScheduleid());
			session.setAttribute("book2",book);
			session.setAttribute("info2",info);
		}
		request.setAttribute("temp", "구매완료");
		HttpUtil.forward(request, response, path);
		
	}
}
