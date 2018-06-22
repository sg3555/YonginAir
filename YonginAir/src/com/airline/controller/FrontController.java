package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller>list=null;
	
	@Override
	public void init(ServletConfig sc)throws ServletException{
		charset=sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/searchairline.do", new SearchAirlineController());
		list.put("/searchseat.do", new SearchSeatController());
		list.put("/bookseat.do", new BookSeatController());
		list.put("/payeachway.do", new PayEachwayController());
		list.put("/payshuttle.do", new PayShuttleController());
		list.put("/userjoin.do", new UserJoinController());
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/mypage.do", new MypageController());
		list.put("/userupdate.do", new UserUpdateController());
		list.put("/chargemoney.do", new ChargeMoneyController());
		list.put("/deleteuser.do", new UserDeleteController());
		list.put("/bookinfo.do", new BookInfoController());
		list.put("/deletebooking.do", new DeleteBookingController());
		
		list.put("/Admin/joinplane.do", new JoinPlaneController());
		list.put("/Admin/searchplane.do", new SearchPlaneController());
		list.put("/Admin/userlist.do", new UserListController());
		list.put("/Admin/userinfo.do", new UserInfoController());
		list.put("/Admin/deleteuser.do", new UserDeleteController());
		list.put("/Admin/setschedule.do", new ScheduleSetController());
		list.put("/Admin/planelist.do", new PlaneListController());
		list.put("/Admin/planeinfo.do", new PlaneInfoController());
		list.put("/Admin/seatinfo.do", new SeatInfoController());
		list.put("/Admin/deletebooking.do", new DeleteBookingController());
		list.put("/Admin/updateseat.do", new UpdateSeatController());
		list.put("/Admin/scheduledelete.do", new ScheduleDeleteController());
		list.put("/Admin/planedelete.do", new PlaneDeleteController());
		list.put("/Admin/userjoin.do", new UserJoinController());
		list.put("/Admin/bookinfo.do", new BookInfoController());
		list.put("/Admin/updatedelay.do", new UpdateDelayController());
		list.put("/Admin/deletebooking.do", new DeleteBookingController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		//System.out.println(path);
		Controller subController = list.get(path);
		subController.execute(request,response);
	}

}
