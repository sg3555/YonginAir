<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.service.ProfitService" %>

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
                        		<div class="form-title"><h2>항공기 등록</h2></div>
                                <form action="joinplane.do" method="post">
  
                                        <label>항공기 ID</label>
                                        <input type="text" name="planeid" required>
                                        
                                        <label>좌석 수(가로 열)</label>
                                        <input type="number" name="m" required>
                                        
                                        <label>좌석 수(세로 열)</label>
                                        <input type="number" name="n" required>
                                        <br>
  										
                                      <button type="submit" class="btn-green">등록</button>
                                      
                                      </form>
                                      </div>
                                      </div>
                                      </div>
                                      

</body>
</html>