package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.UserVO;
import com.airline.service.UserService;

public class UserJoinController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("pw");
		String mail=request.getParameter("mail");
		String nation=request.getParameter("nation");
		String role=request.getParameter("role");
		String path = null;
		
		if(role.equals("user"))path="/join.jsp";
		if(role.equals("admin"))path="./addAdmin.jsp";
		
		if(id.isEmpty()||pw.isEmpty()||name.isEmpty()||mail.isEmpty()) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다");
			HttpUtil.forward(request, response, path);
		}
		
		UserService service = UserService.getInstance();
		UserVO check = service.getUser(id);
		
		if(check!=null) {
			request.setAttribute("temp", "이미 존재하는 아이디입니다.");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setMail(mail);
		vo.setNation(nation);
		vo.setRole(role);
		
		service.setUser(vo);
		if(role.equals("user")) {
			path="/index.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("role", "user");
		}
		if(role.equals("admin")) {
			request.setAttribute("id", id);
			path="./adminJoinOutput.jsp";
		}
		
		request.setAttribute("userinfo", id);
		HttpUtil.forward(request, response, path);
		
		
	}

}
