<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
<link rel="stylesheet" type="text/css" href="../css/topbar.css">
<link rel="stylesheet" type="text/css" href="../css/input.css">
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
String planeid = request.getParameter("planeid");
AirportService s = AirportService.getInstance();
ArrayList<AirportVO>list=s.getAirportList();
if(planeid!=null){
%>
										<br><br>
										<div class="form-title"><h2>일정 추가</h2></div>
										
										<form action="setschedule.do" method="post">
<input type="hidden" name="planeid" readonly value="<%=planeid%>"><br>
출발지<select name="departure">
	<%
	for(int i=0;i<list.size();i++){
	AirportVO ap = list.get(i);
	%>
		<option value="<%=ap.getAirportid()%>"><%=ap.getNation()%>/<%=ap.getAirportname()%>
	<%}%>
	</select><br>
도착지<select name="arrive">
	<%
	for(int i=0;i<list.size();i++){
	AirportVO ap = list.get(i);
	%>
		<option value="<%=ap.getAirportid()%>"><%=ap.getNation()%>/<%=ap.getAirportname()%>
	<%}%>
	</select><br>
출발일<input type="date" name="d_date"><br>
도착일<input type="date" name="a_date"><br>
지연여부<select name="delay">
	<option value="정상">정상
	<option value="지연">지연
	<option value="결항">결항
</select><br>
좌석당 가격<input type="number" name="price"><br>
<button type="submit" class="btn-green-big">일정 생성</button>
<%}%>
</form>
</div>
</div>
</div>
							
											
                                       	
</body>
</html>