package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		if(session !=null&&session.getAttribute("id")!=null){
			session.invalidate();
			System.out.println("로그아웃 완료");
			HttpUtil.forward(request, response, "/index.jsp");
		}else{
			System.out.println("로그인 정보가 없습니다.");
			HttpUtil.forward(request, response, "/index.jsp");
		}
	}
}