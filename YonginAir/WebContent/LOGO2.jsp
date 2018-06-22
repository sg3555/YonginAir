<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session = request.getSession(false);
	String userinfo = (String)session.getAttribute("id");
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
                          <a href="index.jsp">
                              <i class="fa fa-home fa-2x"></i>
                              <span class="nav-text">
                                  HOME
                              </span>
                          </a>
                        
                      </li>
                      <li class="has-subnav">
                        <a href="mypage.do">
                            <i class="fa fa-user-circle-o fa-2x"></i>
                            <span class="nav-text">
                                내 정보
                            </span>
                        </a>
                          
                      </li>
                      <li class="has-subnav">
                        <a href="bookinfo.do">
                            <i class="fa fa-plane fa-2x"></i>
                            <span class="nav-text">
                                예약 정보
                            </span>
                        </a>
                          
                      </li>
                      <li class="has-subnav">
                        <a href="chargeMoney.jsp">
                            <i class="fa fa-credit-card fa-2x"></i>
                            <span class="nav-text">
                                금액 충전
                            </span>
                        </a>
                         
                      </li>
                      
                      <li>
                        <a href="myInformationUpdate.jsp">
                            <i class="fa fa-address-card fa-2x"></i>
                            <span class="nav-text">
                                정보 수정
                            </span>
                        </a>
                      </li>

                      <li>
                            <a href="deleteUser.jsp">
                                <i class="fa fa-sign-out fa-2x"></i>
                                <span class="nav-text">
                                    회원 탈퇴
                                </span>
                            </a>
                          </li>
                  </ul>
      
                  <ul class="logout">
                      <li>
                         <a href="./logout.do">
                               <i class="fa fa-power-off fa-2x"></i>
                              <span class="nav-text">
                                  Logout
                              </span>
                          </a>
                      </li>  
                  </ul>
              </nav>
            </div>

<div class="topspace">
<a href="./index.jsp"><img src="image/Logo.png"></a></div>
            <div class="hello">안녕하세요. <%=userinfo %>님.  <a href="./logout.do">로그아웃</a></div>
            <div class="triangle"><a href="./index.jsp"><span class="text">HOME</span></a></div>
            <div class="topspace1"></div>
</body>
</html>