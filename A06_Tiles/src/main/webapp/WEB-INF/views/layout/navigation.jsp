<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	navigation.jsp
	<hr>
	
	<c:if test="${page != 'home' }"><a href="${pageContext.request.contextPath }">home</a><br></c:if>
	<c:if test="${page != 'welcome' }"><a href="welcome">welcome</a><br></c:if>
	<c:if test="${page != 'login' }"><a href="login">login</a><br></c:if>
	
	
	
</body>
</html>