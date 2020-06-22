<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">MUSINSA PRODUCT img</h1>
<table align="center">
	<tr>
		<c:forEach items="${list}"   var="img">
			<td>
				${img}
			</td>
		</c:forEach>
	</tr>
</table>
</body>
</html>













