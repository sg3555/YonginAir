<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                        		<div class="form-title"><h2>관리자 추가</h2></div>
                                <form action="userjoin.do" method="post">
  										
  										<label>ID</label>
                                        <input type="id" name="id">
                                        
                                        <label>Password</label>
                                        <input type="password" name="pw">
                                        
                                        <label>성함</label>
                                        <input type="text" name="name">
                                        
                                        <label>메일</label>
                                        <input type="mail" name="mail">
                                        
                                        <label>국적</label>
  										<select name="nation">
   											<option value="한국">한국
											<option value="중국">중국
											<option value="일본">일본
											<option value="미국">미국
											<option value="러시아">러시아
											<option value="영국">영국
  										</select><br>
  										<input type="hidden" name="role" value="admin">

                                      <button type="submit" class="btn-green">추가</button>
                                      
                                      </form>
</div>
</div>
</div>

</body>
</html>