<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#loginbox{
		width: 600px;
		height: 200px;
		border: 1px solid black;
		margin-top : 250px;
		align-content: center;
	}
	#bookimg{
		width: 300px;
		height: 200px;
		float: left;
	}
	td{
		text-align: right;
	}
</style>
</head>
<body>
<div class="container">
	<div id = "loginbox" align="center">
		<div id="bookimg">
			<img src="img/book.jpg" height="90%">
		</div>
		<div>
		
			<!-- front.do Servlet으로 이동  command : login-->
		
			<form action="front.do" method="post">
			<input type="hidden" name="command" value="login">
				<div id = "log_status_box">
					<h3>LOGIN</h3>				
					<table>
						<tr>
							<td>ID</td>
							<td><input id="idText" type="text" name = "userId"></td>
						</tr>
						<tr>
							<td>PW</td>
							<td><input id="pwText" type="password" name="password"></td>
						</tr>
						<tr>
							<td></td>
							<td>.....................................................</td>
						</tr>
					</table>
					<button id="loginbutton" type="submit" class="btn btn-success" value="login">login</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
$(function(){
	$("#loginbutton").click(function(event){
		var id = $('#idText').val();
		var pw = $('#pwText').val();
		if(id==""){
			alert("아이디를 입력하세요.");
			event.preventDefault();
			return;
		}
		if(pw==""){
			alert("패스워드를 입력하세요.");
			event.preventDefault();
		}
	});
});
</script>
</body>
</html>