<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">=============== All Fruits List.1  ===============</h2><br>
<table align="center">
		<tr>
			<c:forEach items="${list}" var="item">
				<td>
					<figure>
						<img src="${item.url}" width="150" height="150">
						<figcaption>
							상품명 : ${item.name} <br>
							가 격 : ${item.price}원
						</figcaption>
					</figure>
				</td>
			</c:forEach>
			
		</tr>
</table>
</body>
</html>