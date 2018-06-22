package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.UserVO;
import com.airline.service.UserService;


public class UserInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String id = request.getParameter("id");
		
		UserService service = UserService.getInstance();
		UserVO vo = service.getUser(id);
		
		request.setAttribute("vo",vo);
		HttpUtil.forward(request, response, "./userInfo.jsp");
	}

}
