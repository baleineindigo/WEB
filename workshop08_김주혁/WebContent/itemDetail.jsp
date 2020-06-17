<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}
</style>
</head>
<body>
<h1 align="center">${item.name} ::: Fruit Detail List</h1>
<div class="card">
  <h2>Item Number : ${item.itemNumber}</h2>
  <img src="${item.url}" alt="${item.name}" style="width:100%">
  <h1>${item.name}</h1>
  <p class="price">${item.price}</p>
  <p>${item.description}</p>
  <p>${item.count}</p>
  <p><a href="itemList.do">View All Items</a></p>

</div>
</body>
</html>













