<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<hr>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	
	<pre>
현재의 접속 URL은 다음과 같다.
<b>http://localhost:8080/startproject/</b>

Eclipse 프로젝트 이름이 URL에 포함되지 않게 하려면 톰캣의 server.xml을 편집한다.
Server/Service/Engine/Host/Context 요소를 찾아서 확장한다.
그 중에서 path 항목의 값으로 설정된 정보 startproject를 지우고 슬래시 기호만 남겨 둔다.
편집한 내용을 저장하고 다시 톰캣을 재시동하고 다음과 같은 URL으로 접속해본다.
<b>http://localhost:8080/</b>

접속을 위한 URL에서 8080과 같은 접속 포트번호를 제외하는 방법을 알아보자.
Server/Service/Connector/port 요소를 찾는다.
8080을 80으로 바꾼다. 편집한 내용을 저장하고 다시 톰캣을 시동하고 다음과 같은 URL으로 접속해본다.
<b>http://localhost/</b>

가능하다면 도메인을 하나사서 고정아이피가 있는 컴퓨터에 톰캣을 설치하고
DNS서비스 연결을 통해 나만의 도메인네임으로 접속하는 것을 시도해 보자.
<b>http://www.yourdomain.com/</b>
	</pre>
	
</body>
</html>
