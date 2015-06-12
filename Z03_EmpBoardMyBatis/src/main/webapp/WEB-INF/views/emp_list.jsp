<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jacademy.empboard.util.Pager" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pager</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/table_simple.css">
</head>
<body>
	
	<table width="400">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>sal</th>
		</tr>
		<c:forEach items="${results }" var="e">
			<tr>
				<td><c:out value="${e.empno }" /></td>
				<td><c:out value="${e.ename }" /></td>
				<td><c:out value="${e.job }" /></td>
				<td><c:out value="${e.sal }" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<!-- 페이징 처리 -->
				<c:import url="pager.jsp"></c:import>
			</td>
		</tr>
	</table>

</body>
</html>