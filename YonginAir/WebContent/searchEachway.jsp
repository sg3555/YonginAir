<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="com.airline.service.*" %>
<%@page import="java.util.ArrayList" %>
<%
	ScheduleService ss = ScheduleService.getInstance();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<link rel="stylesheet" type="text/css" href="css/topbar.css">
<link rel="stylesheet" type="text/css" href="css/input.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>


<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<title>Yongin Air</title>
</head>
<body>
<%@include file="LOGO2.jsp" %>
            <div class="topspace2"></div>
               <div class="mainP">
                   <div class="mainP2">
                        <div class="container">
              <%
session = request.getSession();
ArrayList<ScheduleVO>list = (ArrayList<ScheduleVO>)session.getAttribute("list1");
PlaneService sv = PlaneService.getInstance();
if(!list.isEmpty()){
	for(int i=0;i<list.size();i++){
		ScheduleVO vo = list.get(i);
		ss.setBookedSeat(vo);
	}
%>
                            <div class="table">
                                    <div class="table-top">
                                        <h2>항공편 정보</h2>
                                    </div>
                                <table>
                                        <thead>
                                            <tr><th>항공기ID</th><th>잔여석</th><th>비행기선택</th></tr>
										</thead>
                                        <tbody>
                                        <%for(int i=0;i<list.size();i++){
		ScheduleVO vo = list.get(i);
		PlaneVO pvo = sv.getPlane(vo.getPlaneid());
		int totalseat = pvo.getTotalseat();
		int remainderseat = totalseat-vo.getBookedseat();
		%>
	<tr>
		<th><%=vo.getPlaneid() %></th>
		<th><%=remainderseat%></th>
		<th>
		<%if(remainderseat>=1&&vo.getDelay().equals("정상")){ %>
		<form action = "searchseat.do">
		<input type="hidden" name="scheduleid" value="<%=vo.getScheduleid() %>">
		<input type="hidden" name="type" value="eachway">
		<button type="submit" class="btn-green-biggest">비행기 선택</button>
		</form>
		<%}else{ %>
		본 비행기는 빈좌석이 없거나 지연&결항되었습니다.
		</th>
	</tr>
		<%}
	}%>
                                        </tbody>
                                      </table>
                                      <%}else{ %>
조건에 맞는 비행기가 없습니다.
<%} %>
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>