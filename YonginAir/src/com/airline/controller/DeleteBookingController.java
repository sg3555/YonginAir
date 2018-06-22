package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.*;
import com.airline.vo.*;

public class DeleteBookingController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{

	int seatid = Integer.parseInt(request.getParameter("seatid"));
	SeatService seats = SeatService.getInstance();
	UserService users = UserService.getInstance();
	ProfitService profits = ProfitService.getInstance();
	
	SeatVO seatvo = seats.getSeatInfo(seatid);
	String userid = seatvo.getBookingid();
	UserVO uservo = users.getUser(userid);
	int profitmoney = profits.getMoney();
	int price = seatvo.getPrice();
	int usermoney=0;
	try {
		
		usermoney = uservo.getMoney();
		usermoney += price;
		profitmoney -= price;
		
		profits.setMoeny(profitmoney);
		users.updateUserMoney(userid, usermoney);
	}catch(Exception e) {
		System.out.println("회원이 존재하지 않음");
	}
	seats.setBookedSeat(seatvo);
	seats.updateSeatBookingid(seatid, "0");
	seats.setBookedSeat(seatvo);
	HttpUtil.forward(request, response, "bookDeleteOutput.jsp");
	
	}
}
