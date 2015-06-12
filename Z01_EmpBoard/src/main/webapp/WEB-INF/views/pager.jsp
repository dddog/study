<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jacademy.empboard.util.Pager" %>

<c:if test="${pager.totalCount==0 }">
	<!-- 페이징 정보가 없습니다. -->
</c:if>

<c:if test="${pager.totalCount>0 }">
	<c:if test="${pager.firstPage > pager.pagePerBlock }">
		<a href="emp_list?currentPage=1">Home</a>
		&nbsp;
		<a href='<c:url value="emp_list?currentPage=${pager.firstPage-1 }"/>'>
			Prev
		</a>
		&nbsp;
	</c:if>
	<c:forEach var="pno" begin="${pager.firstPage }" end="${pager.lastPage }">
		<c:if test="${pno==pager.currentPage }"><font color="red">[</c:if>
		<c:if test="${pno!=pager.currentPage }"><a href='<c:url value="emp_list?currentPage=${pno }"/>'></c:if>
			${pno }
		<c:if test="${pno!=pager.currentPage }"></a></c:if>
		<c:if test="${pno==pager.currentPage }">]</font></c:if>
		&nbsp;
	</c:forEach>
	<c:if test="${pager.lastPage < pager.totalPage }">
		<a href='<c:url value="emp_list?currentPage=${pager.lastPage+1 }"/>'>
			Next
		</a>
		&nbsp;
	</c:if>
</c:if>

<%
/*
	Pager p = (Pager) request.getAttribute("pager");
	out.print("<br/>getCurrentPage:"+p.getCurrentPage());
	out.print("<br/>getRowPerPage:"+p.getRowPerPage());
	out.print("<br/>getPagePerBlock:"+p.getPagePerBlock());
	out.print("<br/>getStart:"+p.getStart());
	out.print("<br/>getEnd:"+p.getEnd());
	out.print("<br/>getFirstPage:"+p.getFirstPage());
	out.print("<br/>getLastPage:"+p.getLastPage());
	out.print("<br/>getTotalCount:"+p.getTotalCount());
	out.print("<br/>getTotalPage:"+p.getTotalPage());
*/
%>