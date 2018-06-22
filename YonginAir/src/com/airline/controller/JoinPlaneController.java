package com.airline.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.airline.vo.PlaneVO;
import com.airline.service.PlaneService;


public class JoinPlaneController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String planeid=request.getParameter("planeid");
		int m=0;
		int n=0;
		try {
			m = Integer.parseInt(request.getParameter("m"));
			n = Integer.parseInt(request.getParameter("n"));
		}catch(Exception e) {
			request.setAttribute("temp", "모든 항목을 입력해 주시기 바랍니다.");
			HttpUtil.forward(request, response, "./joinPlane.jsp");
			return;
		}
		int totalseat = m*n;
		PlaneService pservice = PlaneService.getInstance();
		
		PlaneVO check = pservice.getPlane(planeid);
		if(check!=null) {
			request.setAttribute("temp", "이미 존재하는 기체명입니다");
			HttpUtil.forward(request, response, "./joinPlane.jsp");
			return;
		}
		
		PlaneVO vo = new PlaneVO();
		vo.setPlaneid(planeid);
		vo.setM(m);
		vo.setN(n);
		vo.setTotalseat(totalseat);
		
		pservice.setPlane(vo);
		
		request.setAttribute("planeid", planeid);
		HttpUtil.forward(request, response, "./joinPlaneOutput.jsp");
		
		
	}

}
