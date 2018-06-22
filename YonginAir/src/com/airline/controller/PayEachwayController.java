package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.*;
import com.airline.service.*;

public class PayEachwayController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		String userid = (String)session.getAttribute("id");
		if(session ==null||session.getAttribute("id")==null){
			request.setAttribute("temp", "로그인 후에 이용하실 수 있습니다.");
			HttpUtil.forward(request, response, "./denyOutput.jsp");
			return;
		}
		
		String role = (String)session.getAttribute("role");
		if(role.equals("admin")) {
			request.setAttribute("temp", "관리자는 비행기표를 예약할 수 없습니다.");
			HttpUtil.forward(request, response, "./denyOutput.jsp");
			return;
		}
		
		int seatid = Integer.parseInt(request.getParameter("seatid"));
		
		UserVO uv = new UserVO();
		SeatVO sv = new SeatVO();
		UserService us = UserService.getInstance();
		SeatService ss = SeatService.getInstance();
		ProfitService ps = ProfitService.getInstance();
		
		uv = us.getUser(userid);
		sv = ss.getSeatInfo(seatid);
		
		int usermoney = uv.getMoney();
		int seatprice = sv.getPrice();
		int profit = ps.getMoney();
		
		if(usermoney<seatprice) {
			request.setAttribute("temp", "잔액이 부족합니다.");
			HttpUtil.forward(request, response, "./result.jsp");
			return;
		}
		
		usermoney -= seatprice;
		profit += seatprice;
		
		ss.updateSeatBookingid(seatid, userid);
		ss.setBookedSeat(sv);
		ps.setMoeny(profit);
		us.updateUserMoney(userid, usermoney);
		
		HttpUtil.forward(request, response, "./payEachwayOutput.jsp");
	}

}
