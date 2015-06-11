<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	
	<spring:message code="hello"></spring:message><br>
	<spring:message code="hi"></spring:message>
	<hr>
	
	<pre>
	javax.servlet.ServletException: javax.servlet.jsp.JspTagException: 
	No message found under code 'hello' for locale 'en_US'.
	>> 예외 발생 시 org.springframework.context.support.ReloadableResourceBundleMessageSource 등록
	</pre>
	
	<a href="changeLocale.do?locale=ko">한국어</a> | <a href="changeLocale.do?locale=en">ENGLISH</a>
	<hr>
	
	redirectAttr: ${redirectAttr }<br>
	redirectFlashAttr: ${redirectFlashAttr }
</body>
</html>
