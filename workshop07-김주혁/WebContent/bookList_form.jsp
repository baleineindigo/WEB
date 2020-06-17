<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: auto;
	}
	#register_box{
		width: 600px;
		border: 1px solid black;
		margin-top : 250px;
		align-content: center;
	}
	#loginsessionbox{
		top: 100px;
	}
	.form-control{
		
	}
</style>
<script>
	
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<div id="loginsessionbox" class="card" style="width: 18rem;">
			  <img src="img/strawberry.jpg" class="card-img-top" alt="loginstatus">
			  <div class="card-body">
			    <h5 class="card-title">로그인 정보</h5>
			    <p class="card-text">세션이 유지되고 있습니다.</p>
			    <p>${sessionScope.user.userId}(${sessionScope.user.name})님 안녕하세요.</p>
			    					
					<!-- front.do Servlet으로 이동  command : mypage-->
					
			    <a href="front.do?command=mypage" class="btn btn-info">내 정보 확인</a>
			  </div>
			</div>
		</div>
		<div class="col-lg-9">
			<div id = "register_box" align="center">
				<h4 align="center">도서 목록 화면</h4>
				
				<!-- 검색기능  form으로 받아서 servlet으로 보낸 후 각 category마다 비즈니스로직 처리 후 되돌아와서 표시??????????-->  
				<!--front.do servlet으로 이동  command : searchBook-->
				
				<form action = "front.do" method="post">
				<input type="hidden" name="command" value="searchBook">
					<div class="form-group row">
						<div class="col-auto">
							<select class="custom-select my-1 mr-sm-2" id="search_category" name="category">
								<option value="전체" selected>전체</option>
								<option value="도서명">도서명</option>
								<option value="출판사">출판사</option>
								<option value="가격">가격</option>
							</select>
						</div>
						<div class="col-auto">
							<div class="input-group-append">
						    	<input type="text" class="form-control" placeholder="Insert please..." name="categoryContents" value="">
						    	<div class="input-group-append">
						      		<button class="btn btn-secondary" type="submit">
						        		<i class="fa fa-search"> 
							        		<svg class="bi bi-search" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><!-- icon -->
											  <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
											  <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
											</svg>
										</i>
						      		</button>
						    	</div>
						  	</div>
					  	</div>
					</div>
				</form> 
				
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">ISBN</th>
				      <th scope="col">제목</th>
				      <th scope="col">분야</th>
				      <th scope="col">출판사</th>
				      <th scope="col">저자</th>
				      <th scope="col">가격</th>
				      <th scope="col">단위</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:choose>
				  		<c:when test="${books eq null}">
				  			<tr>
					  			<td>1</td>
					  			<td>-</td>
					  			<td>-</td>
					  			<td>-</td>
					  			<td>-</td>
					  			<td>-</td>
					  			<td>0</td>
					  			<td>-</td>
				  			</tr>
				  		</c:when>
				  		<c:otherwise>
				  			<c:forEach items="${books}" var="book">
						  		<tr>
						  			<td>1</td>
						  			<td>${book.isbn}</td>
						  			<td>${book.title}</td>
						  			<td>${book.catalogue}</td>
						  			<td>${book.publisher}</td>
						  			<td>${book.author}</td>
						  			<td>${book.price}</td>
						  			<td>${book.currency}</td>
						  		</tr>
						  	</c:forEach>
				  		</c:otherwise>
				  	</c:choose>
				  </tbody>
				</table>
				<br>
				<br>
				<ul class="nav justify-content-center">
				  	<li class="nav-item">
				    	<a class="nav-link active" href="book_form.jsp">도서 등록</a>
				  	</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script></script>
</body>
</html>