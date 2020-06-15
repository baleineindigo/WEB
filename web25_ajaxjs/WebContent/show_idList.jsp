<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var xhr;
	function startRequest(){
		var id = document.getElementById("idList").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get","find.do?id="+id);
		xhr.send(null);
	}
	
	function callback(){
		if(xhr.readystate==4){
			if(xhr.status==200){
				document.getElementById("memberIdView").innerHTML = 
				"<font color=blue size=4>"+xhr.responseText+"</font>";
				
			}
		}
	}
</script>
</head>
<body>
<h1>The option element</h1>

<label for="members">Id List Information</label>
<h2>리스트 폼에서 아이디를 선택하세요.</h2>
<select id="idList" onchange="startRequest()">
	<c:forEach items="${list}" var="member">
		<option value="${member.id}">${member.name}</option>
	</c:forEach>
</select>
<span id="memberIdView"></span>
</body>
</html>















