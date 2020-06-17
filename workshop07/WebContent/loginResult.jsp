<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#login_success_box{
		width: 600px;
		height: 200px;
		border: 1px solid black;
		margin-top : 250px;
		align-content: center;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<div id="loginsessionbox" class="card" style="width: 18rem;">
			  <img src="img/strawberry.jpg" class="card-img-top" alt="loginstatus">
			  <div class="card-body">
			    <h5 class="card-title">로그인 정보</h5>
			    <c:if test="${sessionScope.user ne null}">
			    	<p class="card-text">세션시작</p>
					<p>${sessionScope.user.userId}(${sessionScope.user.name})님 안녕하세요.</p>
					
					<!-- front.do Servlet으로 이동  command : mypage-->
					
					<a href="front.do?command=mypage" class="btn btn-info">내 정보 확인</a>
			    </c:if>
			    <c:if test="${sessionScope.user eq null}">
			    	<p>세션다운</p>
			    </c:if>
			  </div>
			</div>
		</div>
		
		<div class="col-lg-9">
			<div id = "login_success_box" align="center">
				<br><br>
				<c:if test="${sessionScope.user eq null}">
					<h2 align="center">로그인 실패</h2>
					<p class="text-center">해당 회원의 정보가 없습니다. 아이디와 비밀번호를 다시 확인하세요.<p>
					
					<!-- login_form.jsp로 이동 -->
					
					<a href="login_form.jsp"><button type="button" class="btn btn-primary">로그인</button></a>
				</c:if>
				<c:if test="${sessionScope.user ne null}">
			    	<div class="mx-auto" style="width: 300px;">
					<h2 align="center">로그인 성공</h2>
					${sessionScope.user.userId}(${sessionScope.user.name})님 안녕하세요.
					</div>
					
					<!-- book_form.jsp로 이동 -->
					
					<a href="book_form.jsp"><button type="button" class="btn btn-primary" id="registerBook">도서등록</button></a>
					
					
					<!-- front.do Servlet으로 이동 command : logout-->
					
					
					<a href="front.do?command=logout"><button type="button" class="btn btn-primary" id="logout">로그아웃</button></a>
			    </c:if>
			</div>
		</div>
		
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
$("#logout").on('click', logoutAlert);
function logoutAlert(){
	alert("로그아웃 되셨습니다.");
}
</script>
</body>
</html>