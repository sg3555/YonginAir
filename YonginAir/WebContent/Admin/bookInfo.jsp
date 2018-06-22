<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="com.airline.service.*" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
<link rel="stylesheet" type="text/css" href="../css/topbar.css">
<link rel="stylesheet" type="text/css" href="../css/input.css">
<link rel="stylesheet" type="text/css" href="../css/table.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>


<link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
<title>Yongin Air</title>
</head>
<body>

            <%@include file="LOGO.jsp" %>
            

            <div class="topspace2"></div>
               <div class="mainP">
                   <div class="mainP2">
                        <div class="container">
                        <%
ArrayList<SeatVO>list = (ArrayList<SeatVO>)request.getAttribute("list");
ScheduleService ss = ScheduleService.getInstance();
AirportService s = AirportService.getInstance();
String id = (String)request.getAttribute("id");
if(!list.isEmpty()){
%>
                            <div class="table">
                                    <div class="table-top">
                                        <h2><%=id %>님의 예약 내역</h2>
                                    </div>
                                <table class="listtable">
                                        <thead>
                                            <tr><th>항공편ID</th><th>출발</th><th>도착</th><th>출발일</th><th>도착예정일</th>
                                            <th>좌석번호</th><th>좌석등급</th><th>가격</th><th>환불</th></tr>
	
										</thead>
                                        <tbody>
                                        <%
	for(int i=0;i<list.size();i++){
		SeatVO se = list.get(i);
		ScheduleVO sv = ss.getSchedule2(se.getScheduleid());
	%>
	<tr><td><%=se.getPlaneid()%></td>
		<td><%=s.getAirportName(sv.getDeparture())%>/<%=s.getAirportNation(sv.getDeparture())%></td>
		<td><%=s.getAirportName(sv.getArrive())%>/<%=s.getAirportNation(sv.getArrive())%></td>
		<td><%=sv.getD_date() %></td>
		<td><%=sv.getA_date() %></td>
		<td><%=se.getN()%>-<%=se.getM()%></td>
		<td><%=se.getSeatclass()%></td>
		<td><%=se.getPrice()%></td>
		<td>
		<form action="deletebooking.do" method="post">
		<input type="hidden" name="seatid" value="<%=se.getSeatid()%>">
		<input type="hidden" name="type" value="admin">
		<input type="submit" value="환불">
		</form>
		</td>
	<tr>
<%}%>
                                        </tbody>
                                      </table>
                                      <%}else{ %>
정보가 없습니다
<%} %>
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>