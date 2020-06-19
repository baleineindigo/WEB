<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <!-- bs 라이브러리가 가장 나중에 와야한다. -->
  <script>
  $(function() {
    $( "#accordion" ).accordion();
    
    //h3를 클릭하면
    $('#accordion h3').click(function() {
		var text=$(this).text(); //html()
		//alert(text);
		
		//1. 비동기 통신 시작...
		if(text=="IT Education Subject"){
			$.ajax({
				type:'post',
				url:'front.do',
				data:'command=subject',
				
				success:function(data){
					$('#subject').html(data);
				}//callback
			});//ajax
		}else if(text=="Association Global IT Company"){
			$.ajax({
				type:'post',
				url:'front.do',
				data:'command=company',
				
				success:function(data){
					
				}//callback
			});//ajax
		}//else if
	}); //click
  });//ready
  </script>
</head>
<body>
 
<div id="accordion">
  <h3>Encore Academy Introduction</h3>
  <div>   
  		플레이 데이타의 새로운 교육 프로그램을 소개합니다.<br/>
  		아래 섹션에서 이수할 교육과목을 확인하시기 바랍니다.
  </div>
  
  <h3>IT Education Subject</h3>
  <div id="subject">  
    
  </div>
  
  <h3>Association Global IT Company</h3>
  <div id="itcom">      
  </div>
  
</div> 
</body>
</html>










