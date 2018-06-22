package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.UserVO;
import com.airline.service.UserService;

public class LoginController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		if(id.isEmpty()||pw.isEmpty()) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다");
			HttpUtil.forward(request, response, "/index.jsp");
		}
		
		UserService service = UserService.getInstance();
		UserVO check = service.getUser(id);
		
		if(check==null) {
			request.setAttribute("temp", "존재하지 않는 회원입니다.");
			HttpUtil.forward(request, response, "/index.jsp");
			return;
		}
		
		if(!pw.equals(check.getPw())) {
			request.setAttribute("temp", "비밀번호가 일치하지 않습니다.");
			HttpUtil.forward(request, response, "/index.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		if(check.getRole().equals("user")) {
			session.setAttribute("role", "user");
			HttpUtil.forward(request, response, "/index.jsp");
		}else if(check.getRole().equals("admin")) {
			session.setAttribute("role", "admin");
			HttpUtil.forward(request, response, "/index.jsp");
		}else {
			request.setAttribute("temp", "role역할군 배정 실패.");
			HttpUtil.forward(request, response, "/index.jsp");
		}
		
		
		
	}

}
