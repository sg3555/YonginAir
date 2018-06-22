<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/sidebar.css?ver=1">
<link rel="stylesheet" type="text/css" href="../css/topbar.css">
<link rel="stylesheet" type="text/css" href="../css/input.css">
<link rel="stylesheet" type="text/css" href="../css/table.css?ver=1">
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
ScheduleService ss = ScheduleService.getInstance();
String planeid = (String)request.getAttribute("planeid");
ArrayList<ScheduleVO>list=(ArrayList<ScheduleVO>)request.getAttribute("list");
AirportService sc = AirportService.getInstance();
if(!list.isEmpty()){
	for(int i=0;i<list.size();i++){
		ScheduleVO s = list.get(i);
		ss.setBookedSeat(s);
	}
%>
                            <div class="table">
                                    <div class="table-top">
                                        <h2>항공편 정보</h2>
                                    </div>
                                <table class="listtable">
                                        <thead>
                                            <tr><th>일정ID</th><th>출발지</th><th>도착지</th><th>출발일</th><th>도착일</th>
                                            <th>지연여부</th><th>예약된 좌석수</th><th>좌석상세보기</th><th>해당스케줄삭제</th></tr>
	
										</thead>
                                        <tbody>
                                        <%
	for(int i=0;i<list.size();i++){
		ScheduleVO s = list.get(i);
	%>
	<tr><td><%=s.getScheduleid() %>
		<td><%=sc.getAirportNation(s.getDeparture())%>/<%=sc.getAirportName(s.getDeparture())%></td>
		<td><%=sc.getAirportNation(s.getArrive())%>/<%=sc.getAirportName(s.getArrive())%></td>
		<td><%=s.getD_date()%></td>
		<td><%=s.getA_date()%></td>
		<td>
		<%=s.getDelay()%>
		<form action="updatedelay.do" method="post">
		<input type="hidden" name="scheduleid" value="<%=s.getScheduleid()%>">
		<select name="delay">
		<option value="정상">정상
		<option value="지연">지연
		<option value="결항">결항
		</select>
		<button type="submit" class="btn-green-big">정보 수정</button>
		</form>
		</td>
		<td><%=s.getBookedseat() %></td>
		<td><form action="seatinfo.do" method="post">
		<input type="hidden" name="scheduleid" value="<%=s.getScheduleid()%>">
		<input type="hidden" name="type" value="admin">
		<button type="submit" class="btn-green-big">상세 보기</button>
		</form></td>
		<td><form action="scheduledelete.do" method="post">
		<input type="hidden" name="scheduleid" value="<%=s.getScheduleid()%>">
		
		<button type="submit" class="btn-red">삭제</button>
		</form></td>
	<tr>

<%}%>
                                        </tbody>
                                      </table>
                                      <%}else{ %>
항공편 스케줄이 없습니다.
<%} %>
<form action="./schedulePlane.jsp" method="post">
<input type="hidden" name="planeid" value=<%=planeid %>><br>
<button type="submit" class="btn-green-biggest">신규 스케줄 등록</button>
</form><br>
<form action="planedelete.do" method="post">
<input type="hidden" name="planeid" value="<%=planeid%>">
<button type="submit" class="btn-red-bigger">항공기 삭제</button><br>
</form><br><br>
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>