<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link rel="stylesheet" type="text/css" href="../css/sidebar.css">
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
int seatid = Integer.parseInt(request.getParameter("seatid"));
SeatService sc = SeatService.getInstance();
SeatVO vo = sc.getSeatInfo(seatid);
if(!vo.getBookingid().equals("0")){
%>
<form action="deletebooking.do" method="post">
<input type="hidden" name="seatid" value="<%=seatid%>">
<button type="submit" class="btn-green-bigger">예약취소/환불</button>
</form><br>
<%} %>
<div class="form-title"><h2>좌석 정보 수정</h2></div>

${temp}
<form action="updateseat.do" method="post">

클래스
<select name="seatclass">
<option value="economy">economy
<option value="business">business
<option value="first">first
</select><br>
가격<input type="number" name="price"><br>
<input type="hidden" name="seatid" value="<%=seatid%>">
<button type="submit" class="btn-green">수정</button>
</form>
</div>
</div>
</div>

</body>
</html>