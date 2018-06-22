package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import com.airline.service.UserService;
import com.airline.vo.UserVO;

public class UserListController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		UserService userservice = UserService.getInstance();
		ArrayList<UserVO>list = userservice.getUserList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "./userList.jsp");
	}

}
