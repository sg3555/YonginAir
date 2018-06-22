<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<%
	String temp = (String)request.getAttribute("temp");
%>
<script type="text/javascript">
function test(){
alert("<%=temp%>");
location.href = "index.jsp";
}
</script>
</head>
<body onload="test()">
</body>
</html>