<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $(function() {
       var storagelength = localStorage.length;
       alert(storagelength);
       for (let index = 0; index < localStorage.length; index++) {
           var itemNumber = localStorage.key(index);
           var item = localStorage.getItem(itemNumber);
           console.log(item.);
       };
    });
</script>
</head>
<body>
    <table id="carttable">
        <thead>
            <td>번호</td>
            <td>상품이미지</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>수량</td>
            <td>삭제</td>
        </thead>
    </table>
    <span id="subject"></span>
</body>
</html>