<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="com.airline.service.AirportService" %>
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
SeatVO book1 = (SeatVO)session.getAttribute("book1");
ScheduleVO info1 = (ScheduleVO)session.getAttribute("info1");
SeatVO book2 = (SeatVO)session.getAttribute("book2");
ScheduleVO info2 = (ScheduleVO)session.getAttribute("info2");
AirportService s = AirportService.getInstance();
%>
                            <div class="table">
                                    <div class="table-top">
                                        <h2>티켓 정보</h2>
                                    </div>
                                <table>
                                        <tr><th>출발</th><th>도착</th><th>좌석번호</th><th>좌석등급</th><th>가격</th></tr>
<tr><td><%=s.getAirportName(info1.getDeparture())%>/<%=s.getAirportNation(info1.getDeparture())%></td>
	<td><%=s.getAirportName(info1.getArrive())%>/<%=s.getAirportNation(info1.getArrive())%></td>
	<td><%=book1.getN()%>-<%=book1.getM()%></td>
	<td><%=book1.getSeatclass()%></td>
	<td><%=book1.getPrice()%></td>
</tr>
<%if(book2!=null){%>
<tr><td><%=s.getAirportName(info2.getDeparture())%>/<%=s.getAirportNation(info2.getDeparture())%></td>
	<td><%=s.getAirportName(info2.getArrive())%>/<%=s.getAirportNation(info2.getArrive())%></td>
	<td><%=book2.getN()%>-<%=book2.getM()%></td>
	<td><%=book2.getSeatclass()%></td>
	<td><%=book2.getPrice()%></td>
</tr>
<%} %>
                                      </table>
                                      결제하시겠습니까?
<%if(book2==null){%>
<form action="payeachway.do" method="post">
<input type="hidden" name="seatid" value="<%=book1.getSeatid()%>">
<button type="submit" class="btn-green">구매</button>
</form>
<%}else{ %>
<form action="payshuttle.do" method="post">
<input type="hidden" name="seatid1" value="<%=book1.getSeatid()%>">
<input type="hidden" name="seatid2" value="<%=book2.getSeatid()%>">
<button type="submit" class="btn-green">구매</button>
</form>
<%} %>
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>