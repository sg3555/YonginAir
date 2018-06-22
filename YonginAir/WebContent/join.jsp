<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="LOGO.jsp" %>
	${temp}
	<form action="userjoin.do" method="post">
		ID<input type="text" name="id"><br>
		PW<input type="password" name="pw"><br>
		성함<input type="text" name="name"><br>
		이메일<input type="mail" name="mail"><br>
		국적<select name="nation">
			<option value="한국">한국
			<option value="중국">중국
			<option value="일본">일본
			<option value="미국">미국
			<option value="러시아">러시아
			<option value="영국">영국
		</select><br>
		<input type="hidden" name="role" value="user">
		<input type="submit" value="가입">
	</form>
</body>
</html>