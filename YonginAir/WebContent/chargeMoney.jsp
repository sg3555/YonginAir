<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link rel="stylesheet" type="text/css" href="css/sidebar.css">
<link rel="stylesheet" type="text/css" href="css/topbar.css">
<link rel="stylesheet" type="text/css" href="css/input.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">

<title>Yongin Air</title>
</head>
<body>
		<%@include file="LOGO.jsp" %>
            <div class="topspace2"></div>
               <div class="mainP">
                   <div class="mainP2">
                        <div class="container">
                        		<div class="form-title"><h2>금액 충전</h2></div>
                                <form action="chargemoney.do" method="post">
  
                                        <label>충전 할 금액을 입력해주세요.</label><br>
                                        <input type="number" name="money" required autocomplete="off"><br>
                                        
                                      	<button type="submit" class="btn-green">충전</button>
                                      
                                    </form>
                              </div>
                        </div>
                	</div>
                                      

</body>
</html>