package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.*;

public class UserDeleteController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		String id=null;
		String role=(String)session.getAttribute("role");
		if(role.equals("admin"))
			id = request.getParameter("id");
		else if(role.equals("user"))
			id = (String)session.getAttribute("id");
		
		UserService us = UserService.getInstance();
		SeatService ss = SeatService.getInstance();
		us.deleteUser(id);
		
		ss.setBookedSeatByUser(id);
		
		if(role.equals("admin")) {
			request.setAttribute("id", id);
			HttpUtil.forward(request, response, "./userDeleteOutput.jsp");
		}
		else if(role.equals("user")) {
			session.invalidate();
			HttpUtil.forward(request, response, "./index.jsp");
		}
		
	}

}
