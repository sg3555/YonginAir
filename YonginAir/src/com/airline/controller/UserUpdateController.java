package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.UserService;

public class UserUpdateController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String nation=request.getParameter("nation");
		
		if(pw.isEmpty()&&name.isEmpty()&&mail.isEmpty()) {
			request.setAttribute("temp", "입력된 내용이 없습니다.");
			HttpUtil.forward(request, response, "/myInformationUpdate.jsp");
		}
		
		UserService service = UserService.getInstance();
		if(!pw.isEmpty())service.updateUserPw(id, pw);
		if(!name.isEmpty())service.updateUserName(id, name);
		if(!mail.isEmpty())service.updateUserMail(id, mail);
		if(!nation.isEmpty())service.updateUserNation(id, nation);
		
		HttpUtil.forward(request, response, "/userUpdateOutput.jsp");
	}
}
