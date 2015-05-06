<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<title>Home</title>
	<script type="text/javascript">
	jQuery(document).ready(function() {
		alert(jQuery('p').text());
	});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
