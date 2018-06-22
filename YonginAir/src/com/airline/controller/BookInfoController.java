package com.airline.controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.*;
import com.airline.service.*;

public class BookInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		String role= (String)session.getAttribute("role");
		String userid = null;
		if(role.equals("admin")) {
			userid = request.getParameter("userid");
		}else if(role.equals("user")) {
			userid = (String)session.getAttribute("id");
		}
		
		SeatService sc = SeatService.getInstance();
		ArrayList<SeatVO>list = sc.getSeat(userid);
		
		request.setAttribute("id", userid);
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "./bookInfo.jsp");
		
	}

}
