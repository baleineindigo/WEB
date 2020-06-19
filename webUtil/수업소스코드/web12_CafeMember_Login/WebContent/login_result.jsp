<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");	
	if(vo==null){
%>
	<h3>로그인부터 시작하세요...</h3>
	<a href="login.html">Login.html</a>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information....</h2>
Login  ID : <B><%= vo.getId() %></B><br/>
Login  NAME : <B><%= vo.getName() %></B><br/>
Login  ADDRESS : <B><%= vo.getAddress() %></B><br/>
JSESSION  ID VALUE :: <B><%= session.getId() %></B><br/>
<hr>
<a href="logout.jsp">LOG OUT</a>&nbsp;&nbsp;&nbsp;<a href="index.html">INDEX</a>
</body>
</html>










