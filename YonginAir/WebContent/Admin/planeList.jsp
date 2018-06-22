<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.vo.PlaneVO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.ProfitService" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
<link rel="stylesheet" type="text/css" href="../css/topbar.css">
<link rel="stylesheet" type="text/css" href="../css/input.css">
<link rel="stylesheet" type="text/css" href="../css/table.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>


<link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">


<title>Yongin Air</title>
</head>
<body>
            <%@include file="LOGO.jsp" %>
            
<%
ArrayList<PlaneVO>list=(ArrayList<PlaneVO>)request.getAttribute("list");
if(!list.isEmpty()){
%>
            <div class="topspace2"></div>
               <div class="mainP">
                   <div class="mainP2">
                        <div class="container">
                            <div class="table">
                                    <div class="table-top">
                                        <h2>항공기 목록</h2>
                                    </div>
                                <table>
                                        <thead>
                                            <tr><th>항공편ID</th><th>총좌석수</th><th>세부정보</th></tr>
                                        </thead>
                                        <tbody>
                                        <%
										for(int i=0;i<list.size();i++){
										PlaneVO user = list.get(i);
										%>
                                          <tr class="able" onclick="">
                                            <tr><td><%=user.getPlaneid()%></td>
                                            <td><%=user.getTotalseat() %>
											<td><form action="planeinfo.do" method="post">
											<input type="hidden" name="planeid" value=<%=user.getPlaneid() %>>
											<button type="submit" class="btn-green-big">세부 정보</button>
											</form></td>
											</tr>
											<%
												}
												%>
                                        </tbody>
                                      </table>
                                      <%
							}else{
							%>
						검색된 항공기 정보가 없습니다
						<%
						}
						%>
                                    </div>
                                </div>
                                </div>
                            </div>
</body>
</html>