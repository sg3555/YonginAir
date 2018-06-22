<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.airline.service.*" %>
<%@page import="com.airline.vo.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.airline.service.AirportService" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
Calendar c1 = Calendar.getInstance();
String today = day.format(c1.getTime());

ScheduleService ss = ScheduleService.getInstance();
ArrayList<ScheduleVO>list2 = ss.getScheduleList3(today);
ProfitService fs = ProfitService.getInstance();


session = request.getSession(false);
String userinfo = (String)session.getAttribute("id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<link rel="stylesheet" type="text/css" href="css/topbar.css">
<link rel="stylesheet" type="text/css" href="css/bootmetro-tiles.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/table.css?ver=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">

<title>Yongin Air</title>

</head>
<body>
<%
AirportService s = AirportService.getInstance();
ArrayList<AirportVO>list=s.getAirportList();



%>
<%
if(session.isNew()||session.getAttribute("id")==null){
%>

            <div class="topspace">
			<a href="./index.jsp"><img src="image/Logo.png"></a></div>
            <div class="triangle"><a href="./index.jsp"><span class="text">HOME</span></a></div>
            <div class="topspace1"></div>
               <div class="mainP3">
                        <div class="container">
                                   <div class="mainUI">
                                      <div class="mainUI-sections">
                             
                                        <div  class="mainUI-section plane">
                                        <h2 class="title-text4">flight search</h2>
                                            <div class="search">
                                        <div align="center">
                                            <div id="container">
                                                <input id="tab-1" type="radio" name="tab-group" checked="checked" />
                                                <label for="tab-1" class="tablabel1"> 왕복 </label>
                                                <input id="tab-2" type="radio" name="tab-group" />
                                                <label for="tab-2" class="tablabel2"> 편도 </label>
                                                
                                                <div id="content">
                                                    <div id="content-1">
                                                <form action="searchairline.do" method="post">
                                                      <div class="title1">
                                                    <h2 class="title-text3">왕복</h2>
                                                </div>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                            출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select>
                                                        </div><div class="input_blank"></div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br><div class="input_blank"></div>
                                                    복귀일 : <input type="date" name="a_date"><br>
                                                    <input type="hidden" name="value" value="shuttle">
                                                     <div class="search_blank"></div><div class="input_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                </form></div>

                                                <div id="content-2">
                                                <form action="searchairline.do" method="post">
                                                        <div class="title1">
                                                                <h2 class="title-text3">편도</h2>
                                                            </div>
                                                    <label class="dropdown">
                                                    <div class="input-wrapper">
                                                    출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><div class="input_blank"></div>
                                                        </div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br>
                                                    <input type="hidden" name="value" value="eachway">
                                                    <div class="search_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                    
                                                </form>
                                            </div>
                                            </div>
</div></div></div></div>
                             

                                         
                                         <div id="section2" class="mainUI-section menu">
                             
                                            <h2 class="title-text1"><a href="#open">로그인/회원가입</a></h2>
                             
                                            <a class="single red" href="#open">
                                                    <div class="icon-wrapper1">
                                                     <i class="fa fa-address-card fa-5x"></i>
                                                    </div>
                                                    <span class="app-label">내 정보</span>
                                                 </a>

                                             <a class="single purple" href="#open">
                                                <div class="icon-wrapper2">
                                                        
                                                        <i class="fa fa-plane fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">예약 정보</span>
                                             </a>

                                             <a class="single yellow" href="#open">
                                                    <div class="icon-wrapper3">
                                                            
                                                            <i class="fa fa-credit-card fa-5x"></i>
                                                            
                                                    </div>
                                                    <span class="app-label">금액 충전</span>
                                                 </a>
                             
                                             <a class="single darken" href="#open">
                                                <div class="icon-wrapper4">
                                                        
                                                        <i class="fa fa-sign-out fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">회원 탈퇴</span>
                                             </a>
                                             
                                             <div class="board">
                                             <h2 class="title-text1">Today's flight list</h2>
                                             <%
	if(!list2.isEmpty()){
	%>
		<table class="maintable">
			<tr><th>항공기ID</th><th>출발지</th><th>도착지</th><th>예상도착일</th><th>지연여부</th></tr>
			<%for(int i=0;i<list2.size();i++){
				ScheduleVO vo = list2.get(i);%>
			<tr><td><%=vo.getPlaneid() %></td>
				<td><%=s.getAirportNation(vo.getDeparture())%>/<%=s.getAirportName(vo.getDeparture()) %></td>
				<td><%=s.getAirportNation(vo.getArrive())%>/<%=s.getAirportName(vo.getArrive()) %></td>
				<td><%=vo.getA_date() %></td>
				<td><%=vo.getDelay() %></td>
			<tr>
			<%} %>
		</table>
	<%}else{ %>
		금일 이륙하는 비행기가 없습니다
	<%} %>
                                             
                                             </div>
                                      </div>
                                   </div>
                                </div>
                            </div>
                        <div class="login-popup" id="open">
        
     
  
    <div class="container1">
      <div class="frame1" style="overflow-x:hidden;  overflow-y:hidden;">
        <div class="nav1">
          <ul class="links">
            <li class="signin-active"><a class="btn">login</a></li>
            <li class="signup-inactive"><a class="btn">join</a></li>
          </ul>
        </div>
        <div ng-app ng-init="checked = false">
              <form class="form-signin" action="login.do" method="post" name="form">
              <label for="username">Username</label>
              <input class="form-styling" type="text" name="id" placeholder=""/>
              <label for="password">Password</label>
              <input class="form-styling" type="password" name="pw" placeholder=""/>
              
                <button type="submit" class="btn-signin">login</button>
                <a style="position:relative; float: right; color:white;"href="#close" >close</a>
             
              </form>
            
              <form class="form-signup" action="userjoin.do" method="post" name="form">
              <label for="fullname">ID</label>
              <input class="form-styling" type="text" name="id" placeholder=""/>
              <label for="password">Password</label>
              <input class="form-styling" type="password" name="pw" placeholder=""/>
              <label for="name">name</label>
              <input class="form-styling" type="text" name="name" placeholder=""/>
              <label for="mail">mail</label>
              <input class="form-styling" type="text" name="mail" placeholder=""/>
              
              
               <label for="nation">nation&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
               &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<select name="nation">
			<option value="한국">한국
			<option value="중국">중국
			<option value="일본">일본
			<option value="미국">미국
			<option value="러시아">러시아
			<option value="영국">영국
		</select>
		</label>
              <input type="hidden" name="role" value="user">
              <button type="submit" class="btn-signup">join</button>
              <a style="position:relative; float: right; color:white;"href="#close" >close</a>
              </form>
              </div>
         </div></div>
	</div></div>
         
<%
}else{
	if(session.getAttribute("role").equals("admin")){
%>
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
                        <a href="Admin/joinPlane.jsp">
                            <i class="fa fa-plane fa-2x"></i>
                            <span class="nav-text">
                                비행기 등록
                            </span>
                        </a>
                          
                      </li>
                     
                      
                      <li class="has-subnav">
                        <a href="Admin/planelist.do">
                            <i class="fa fa-list fa-2x"></i>
                            <span class="nav-text">
                                비행기 목록
                            </span>
                        </a>
                         
                      </li>
                      
                      <li>
                        <a href="Admin/userlist.do">
                            <i class="fa fa-address-book fa-2x"></i>
                            <span class="nav-text">
                                유저 목록
                            </span>
                        </a>
                      </li>
                      <li>
                        <a href="Admin/addAdmin.jsp">
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
            
               <div class="mainP">
                        <div class="container">
                                   <div class="mainUI">
                                      <div class="mainUI-sections">
                             
                                         <div  class="mainUI-section plane">
                                        <h2 class="title-text4">flight search</h2>
                                            <div class="search">
                                        <div align="center">
                                            <div id="container">
                                                <input id="tab-1" type="radio" name="tab-group" checked="checked" />
                                                <label for="tab-1" class="tablabel1"> 왕복 </label>
                                                <input id="tab-2" type="radio" name="tab-group" />
                                                <label for="tab-2" class="tablabel2"> 편도 </label>
                                                
                                                <div id="content">
                                                    <div id="content-1">
                                                <form action="searchairline.do" method="post">
                                                      <div class="title1">
                                                    <h2 class="title-text3">왕복</h2>
                                                </div>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                            출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select>
                                                        </div><div class="input_blank"></div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br><div class="input_blank"></div>
                                                    복귀일 : <input type="date" name="a_date"><br>
                                                    <input type="hidden" name="value" value="shuttle">
                                                     <div class="search_blank"></div><div class="input_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                </form></div>

                                                <div id="content-2">
                                                <form action="searchairline.do" method="post">
                                                        <div class="title1">
                                                                <h2 class="title-text3">편도</h2>
                                                            </div>
                                                    <label class="dropdown">
                                                    <div class="input-wrapper">
                                                    출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><div class="input_blank"></div>
                                                        </div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br>
                                                    <input type="hidden" name="value" value="eachway">
                                                    <div class="search_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                    
                                                </form>
                                            </div>
                                            </div>
</div></div></div></div>
                             

                                         
                                         <div id="section2" class="mainUI-section menu">
                             
                                            <h2 class="title-text1">menu</h2>
                             
                                            <a class="single red" href="Admin/joinPlane.jsp">
                                                    <div class="icon-wrapper2">
                                                     <i class="fa fa-plane fa-5x"></i>
                                                    </div>
                                                    <span class="app-label">비행기 등록</span>
                                                 </a>

                                             <a class="single yellow" href="Admin/planelist.do">
                                                    <div class="icon-wrapper6">
                                                            
                                                            <i class="fa fa-list fa-5x"></i>
                                                            
                                                    </div>
                                                    <span class="app-label">비행기 목록</span>
                                                 </a>
                             
                                             <a class="single darken" href="Admin/userlist.do">
                                                <div class="icon-wrapper7">
                                                        
                                                        <i class="fa fa-address-book fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">유저 목록</span>
                                             </a>
                                             
                                             <a class="single purple" href="Admin/addAdmin.jsp">
                                                <div class="icon-wrapper7">
                                                        
                                                        <i class="fa fa-cog fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">관리자 계정 추가</span>
                                             </a>
                                             
                                             <div class="board">
                                             <h2 class="title-text1">Today's flight list</h2>
                                             <%
	if(!list2.isEmpty()){
	%>
		<table class="maintable">
			<tr><th>항공기ID</th><th>출발지</th><th>도착지</th><th>예상도착일</th><th>지연여부</th></tr>
			<%for(int i=0;i<list2.size();i++){
				ScheduleVO vo = list2.get(i);%>
			<tr><td><%=vo.getPlaneid() %></td>
				<td><%=s.getAirportNation(vo.getDeparture())%>/<%=s.getAirportName(vo.getDeparture()) %></td>
				<td><%=s.getAirportNation(vo.getArrive())%>/<%=s.getAirportName(vo.getArrive()) %></td>
				<td><%=vo.getA_date() %></td>
				<td><%=vo.getDelay() %></td>
			<tr>
			<%} %>
		</table>
	<%}else{ %>
		금일 이륙하는 비행기가 없습니다
	<%} %>
                                             
                                             </div>
                                      </div>
                                   </div>
                                </div>
                            </div>
<%
	}else if(session.getAttribute("role").equals("user")){
%>
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
           
               <div class="mainP">
                        <div class="container">
                                   <div class="mainUI">
                                      <div class="mainUI-sections">
                             
                                        <div  class="mainUI-section plane">
                                        <h2 class="title-text4">flight search</h2>
                                            <div class="search">
                                        <div align="center">
                                            <div id="container">
                                                <input id="tab-1" type="radio" name="tab-group" checked="checked" />
                                                <label for="tab-1" class="tablabel1"> 왕복 </label>
                                                <input id="tab-2" type="radio" name="tab-group" />
                                                <label for="tab-2" class="tablabel2"> 편도 </label>
                                                
                                                <div id="content">
                                                    <div id="content-1">
                                                <form action="searchairline.do" method="post">
                                                      <div class="title1">
                                                    <h2 class="title-text3">왕복</h2>
                                                </div>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                            출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select>
                                                        </div><div class="input_blank"></div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br><div class="input_blank"></div>
                                                    복귀일 : <input type="date" name="a_date"><br>
                                                    <input type="hidden" name="value" value="shuttle">
                                                     <div class="search_blank"></div><div class="input_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                </form></div>

                                                <div id="content-2">
                                                <form action="searchairline.do" method="post">
                                                        <div class="title1">
                                                                <h2 class="title-text3">편도</h2>
                                                            </div>
                                                    <label class="dropdown">
                                                    <div class="input-wrapper">
                                                    출발지 : <select name="departure">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><div class="input_blank"></div>
                                                        </div>
                                                      </label>
                                                    <label class="dropdown">
                                                        <div class="input-wrapper">
                                                          도착지 : <select name="arrive">
					<%
					for(int i=0;i<list.size();i++){
						AirportVO vo = list.get(i);
					%>
					<option value="<%=vo.getAirportid()%>"><%=vo.getNation()%>/<%=vo.getAirportname()%>
					<%
					}
					%>
			</select><br><br>
                                                        </div>
                                                      </label><br>
                                                    출발일 : <input type="date" name="d_date"><br>
                                                    <input type="hidden" name="value" value="eachway">
                                                    <div class="search_blank"></div>
                                                    <input type="submit" value="검색" class="button">
                                                    
                                                </form>
                                            </div>
                                            </div>
</div></div></div></div>

                             

                                         
                                         <div id="section2" class="mainUI-section menu">
                             
                                            <h2 class="title-text1">menu</h2>
                             
                                            <a class="single red" href="mypage.do">
                                                    <div class="icon-wrapper1">
                                                     <i class="fa fa-address-card fa-5x"></i>
                                                    </div>
                                                    <span class="app-label">내 정보</span>
                                                 </a>

                                             <a class="single purple" href="bookinfo.do">
                                                <div class="icon-wrapper2">
                                                        
                                                        <i class="fa fa-plane fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">예약 정보</span>
                                             </a>

                                             <a class="single yellow" href="chargeMoney.jsp">
                                                    <div class="icon-wrapper3">
                                                            
                                                            <i class="fa fa-credit-card fa-5x"></i>
                                                            
                                                    </div>
                                                    <span class="app-label">금액 충전</span>
                                                 </a>
                             
                                             <a class="single darken" href="deleteUser.jsp">
                                                <div class="icon-wrapper4">
                                                        
                                                        <i class="fa fa-sign-out fa-5x"></i>
                                                        
                                                </div>
                                                <span class="app-label">회원 탈퇴</span>
                                             </a>
                                             
                                             <div class="board">
                                             <h2 class="title-text1">Today's flight list</h2>
                                             <%
	if(!list2.isEmpty()){
	%>
		<table class="maintable">
			<tr><th>항공기ID</th><th>출발지</th><th>도착지</th><th>예상도착일</th><th>지연여부</th></tr>
			<%for(int i=0;i<list2.size();i++){
				ScheduleVO vo = list2.get(i);%>
			<tr><td><%=vo.getPlaneid() %></td>
				<td><%=s.getAirportNation(vo.getDeparture())%>/<%=s.getAirportName(vo.getDeparture()) %></td>
				<td><%=s.getAirportNation(vo.getArrive())%>/<%=s.getAirportName(vo.getArrive()) %></td>
				<td><%=vo.getA_date() %></td>
				<td><%=vo.getDelay() %></td>
			<tr>
			<%} %>
		</table>
	<%}else{ %>
		금일 이륙하는 비행기가 없습니다
	<%} %>
                                             
                                             </div>
                                      </div>
                                   </div>
                                </div>
                            </div>
<%
	}
}
%>
	<script src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
   
$(function() {
	$(".btn").click(function() {
		$(".form-signin").toggleClass("form-signin-left");
    $(".form-signup").toggleClass("form-signup-left");
    $(".frame1").toggleClass("frame1-long");
    $(".signup-inactive").toggleClass("signup-active");
    $(".signin-active").toggleClass("signin-inactive");
	});
});

</script>
</body>
</html>