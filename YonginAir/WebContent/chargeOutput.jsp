<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script type="text/javascript">
function test(){
alert("${money}원 충전이 완료되었습니다!");
location.href = "mypage.do";
}
</script>
</head>
<body onload="test()">
</body>
</html>