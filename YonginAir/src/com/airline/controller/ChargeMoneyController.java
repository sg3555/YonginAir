package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.airline.service.UserService;
import com.airline.vo.UserVO;

public class ChargeMoneyController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		int money = 0;
		try {
			money=Integer.parseInt(request.getParameter("money"));
		}catch(Exception e) {
			request.setAttribute("temp", "충전할 금액을 입력해 주시기 바랍니다.");
			HttpUtil.forward(request, response, "/myInformationUpdate.jsp");
		}
		request.setAttribute("money", money);
		UserService service = UserService.getInstance();
		UserVO vo = service.getUser(id);
		money += vo.getMoney();
		service.updateUserMoney(id, money);
		
		
		HttpUtil.forward(request, response, "/chargeOutput.jsp");
	}
}
