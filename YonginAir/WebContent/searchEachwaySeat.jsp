<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.SeatVO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.SeatService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<link rel="stylesheet" type="text/css" href="css/topbar.css">
<link rel="stylesheet" type="text/css" href="css/input.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>


<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<title>Yongin Air</title>
</head>
<body>
	<%@include file="LOGO2.jsp" %>
            <div class="topspace2"></div>
               <div class="mainP">
                   <div class="mainP2">
                        <div class="container">
              <%
session = request.getSession();
ArrayList<SeatVO>list = (ArrayList<SeatVO>)request.getAttribute("list");
SeatService sv = SeatService.getInstance();
if(!list.isEmpty()){
	SeatVO sc = new SeatVO();
	sc = list.get(list.size()-1);
	int width = sc.getM();
	int height = sc.getN();
	String planeid = sc.getPlaneid();
	int scheduleid = sc.getScheduleid();
%>
                            <div class="table">
                                    <div class="table-top">
                                        <h2>항공편 정보</h2>
                                    </div>
                                <table>
                                        <tr><th><%=planeid%></th><%for(int i=1;i<=width;i++){ %><th><%=i%></th><%}%></tr>
	<%for(int i=1;i<=height;i++){ %>
	<tr><td><%=i%></td>
	<%for(int j=1;j<=width;j++){
		int seatid = sv.getSeatId(scheduleid,j,i);
		sc = sv.getSeatInfo(seatid);
	%>
		<td><%if(sc.getBookingid().equals("0")){ %>
			예약자ID : <%=sc.getBookingid()%><br>
			클래스 : <%=sc.getSeatclass()%><br>
			가격 : <%=sc.getPrice() %>
			<form action="bookseat.do" method="post">
			<input type="hidden" name="seatid" value="<%=sc.getSeatid()%>">
			<input type="hidden" name="type" value="eachway">
			<button type="submit" class="btn-green-bigger">좌석 예약</button>
			</form>
			<%}else{ %>
			예약된 좌석
			<%}%>
		</td>
	<%
	}
	}
}else{
%>
좌석정보가 존재하지 않습니다.
<%
}
%>
                                      </table>
                                      
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>