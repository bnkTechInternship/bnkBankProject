<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!-- jstl:: 라이브러리 다운, tahlib선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    td, h2{
        text-align : center;
    }
</style>
</head>
<body>
<h2>+++++++++ 상품정보를 출력합니다 +++++++++</h2>
<table border="1">
    <thead>
    <tr>
    <th>아이디</th>
    <th>상품명</th>
    <th>제조사</th>
    <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vo" items="${list}">
    <tr>
        <td>${vo.id}</td>
        <td>${vo.name}</td>
        <td>${vo.maker}</td>
        <td>${vo.price}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<center><a href="product.jsp">상품가입하기 홈으로...</a></center>
</body>
</html>