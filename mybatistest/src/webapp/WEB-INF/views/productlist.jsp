<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl 사용 선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${productlist }" var="productVO">
${productvo.prdNo} : ${productvo.prdName} : ${productvo.prdPrice}<br>
</c:forEach>
</body>
</html>