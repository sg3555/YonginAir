<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
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
                        		<div class="form-title"><h2>내 정보 확인</h2></div>
                                <form action="myInformationUpdate.jsp">
  
                                        <label>ID</label>
                                        <input type="text" value="${vo.id}" readonly>
                                        
                                        <label>성함</label>
                                        <input type="text" value="${vo.name}" readonly>
                                        
                                        <label>메일 주소</label>
                                        <input type="text" value="${vo.mail}" readonly>
                                        
                                        <label>국가</label>
                                        <input type="text" value="${vo.nation}" readonly>
                                        
                                        <label>충전된 금액</label>
                                        <input type="text" value="${vo.money}" readonly><br>
                                      
										<button type="submit" class="btn-green">변경</button>
                                      </form>
                                      </div>
                                      </div>
                                      </div>
                                      

</body>
</html>