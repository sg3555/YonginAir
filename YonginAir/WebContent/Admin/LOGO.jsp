<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.airline.service.*" %>
<%
	session = request.getSession();
	String userinfo = (String)session.getAttribute("id");
%>
<%
ProfitService fs = ProfitService.getInstance();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="rap">
    <nav class="sidemenu">
                  <ul>
                      <li>
                          <a href="../index.jsp">
                              <i class="fa fa-home fa-2x"></i>
                              <span class="nav-text">
                                  HOME
                              </span>
                          </a>
                        
                      </li>
                      <li class="has-subnav">
                        <a href="joinPlane.jsp">
                            <i class="fa fa-plane fa-2x"></i>
                            <span class="nav-text">
                                비행기 등록
                            </span>
                        </a>
                          
                      </li>
                      
                      
                      <li class="has-subnav">
                        <a href="planelist.do">
                            <i class="fa fa-list fa-2x"></i>
                            <span class="nav-text">
                                비행기 목록
                            </span>
                        </a>
                         
                      </li>
                      
                      <li>
                        <a href="userlist.do">
                            <i class="fa fa-address-book fa-2x"></i>
                            <span class="nav-text">
                                유저 목록
                            </span>
                        </a>
                      </li>
                      <li>
                        <a href="addAdmin.jsp">
                            <i class="fa fa-user-plus fa-2x"></i>
                            <span class="nav-text">
                                관리자 계정 추가
                            </span>
                        </a>
                      </li>
                      <li>
                        <a>
                            <i class="fa fa-money fa-2x"></i>
                            <span class="nav-text">
                                항공사 총수익 : <%=fs.getMoney() %>
                            </span>
                        </a>
                      </li>
                  </ul>
      
                  <ul class="logout">
                      <li>
                         <a href=".././logout.do">
                               <i class="fa fa-power-off fa-2x"></i>
                              <span class="nav-text">
                                  Logout
                              </span>
                          </a>
                      </li>  
                  </ul>
              </nav>
            </div>
<div class="topspace"><a href="../index.jsp"><img src="../image/Logo.png"></a></div>
<div class="hello">안녕하세요. <%=userinfo %>님.  <a href=".././logout.do">로그아웃</a></div>
<div class="triangle"><a href="../index.jsp"><span class="text">HOME</span></a></div>
<div class="topspace1"></div>
</body>
</html>