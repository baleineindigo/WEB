<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Droppable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #draggable { width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0; }
  #droppable { width: 150px; height: 150px; padding: 0.5em; float: left; margin: 10px; }
  #cart {float:left}
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	  $('#catalog').accordion();
    $('#catalog li').draggable({
      helper:'clone',//복사본을만들어서 draggable

    });//draggable
    $( "#droppable" ).droppable({
        drop: function( event, ui ) {
          $(this).find('.placeholder').remove();
            var uidrag = ui.draggable.text();
          $(this).append("<li>"+uidrag+"</li>");
        }
      });
  }); //function
  </script>
</head>
<body>
<div id="clothing">
  <h2>카 탈 로 그</h2>
  <div id="catalog">
    <h2><a href="#">상의류</a></h2>
    <div>
      <ul>
        <li>블라우스</li>
        <li>티셔츠</li>
        <li>폴라티</li>
        <li>바바리</li>
        <li>가디건</li>
      </ul>
    </div>
    <h2><a href="#">하의류</a></h2>
  <div>
    <ul>
      <li>긴바지</li>
      <li>반바지</li>
      <li>치마</li>
      <li>바지</li>
      <li>짧은바지</li>
    </ul>
  </div>
  <h2><a href="#">액세서리</a></h2>
<div>
  <ul>
    <li>목걸이</li>
    <li>코걸이</li>
    <li>귀걸이</li>
    <li>버스손잡이</li>
    <li>뭐든</li>
  </ul>
</div>
</div>  
</div>
<div id="cart">
  <h2>Clothing Cart</h2>
  <div id="droppable" class="ui-widget-header"><ol>
    <li class="placeholder">Droppiing Here</li>
  </ol></div>
</div>
</body>
</html>