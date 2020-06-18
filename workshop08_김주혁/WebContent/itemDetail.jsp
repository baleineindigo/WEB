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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $(function() {
    $('#addtocart').click(function() {
      // alert(localStorage.length);
		  var itemNumber =  $('#itemNumber').val();
      var itemName = $('#itemName').val();
      var itemUrl = $('#itemUrl').val();
      var itemPrice = $('#itemPrice').val();
      console.log(itemNumber);
      console.log(itemName);
      console.log(itemUrl);
      console.log(itemPrice);

      var addedItem = localStorage.getItem(itemNumber);
      if (addedItem==null) {
        var cartitem = {
        cartitemNumber:itemNumber,
        cartitemUrl:itemUrl,
        cartitemName:itemName,
        cartitemPrice : itemPrice,
        cartitemCount : 1
        };
        localStorage.setItem(itemNumber,cartitem);
      } else {
        addedItem.cartitemCount += addedItem.cartitemCount+1;
        localStorage.setItem(itemNumber, addedItem);
      }
    });
  });
</script>
</head>
<body>
<h1 align="center">${item.name} ::: Fruit Detail List</h1>
<div class="card">
  <h2>Item Number : ${item.itemNumber}</h2>
  <input type="hidden" id="itemNumber" value="${item.itemNumber}">
  <img src="${item.url}" id="itemUrl" alt="${item.name}" style="width:100%" value="${item.url}">
  <h1 id="itemname">${item.name}</h1>
  <p class="price" id="itemPrice">${item.price}</p>
  <p id="itemdescription">${item.description}</p>
  <p>${item.count}</p>
  <p><a href="itemList.do?redirect=true">View All Items</a></p>
  <p><button id="addtocart">+ Add to Cart</button></p>
  <p><a href="cart.jsp"><button id="gotocart">  Go  to Cart</button></a></p>
</div>
</body>
</html>