<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	
	<a href="check">check</a> :	service: ${service }
	<hr>
	
	<a href="getEmp?deptno=90">getEmp</a> :	list: <br>
	<c:if test="${not empty list }">
		<c:forEach var="emp" items="${list }">
			<c:out value="${emp.empno }" />,<c:out value="${emp.ename }" />,<c:out value="${emp.deptno }" /><br>
		</c:forEach>
	</c:if>
	<hr>
	
	<a href="insertEmp">insertEmp</a> :	result: ${result }
	
</body>
</html>
