<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script type="text/javascript">
function test(){
alert("${planeid}에 일정 등록 완료!");
location.href = "./planelist.do";
}
</script>
</head>
<body onload="test()">
</body>
</html>