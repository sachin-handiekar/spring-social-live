<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Sign In</title>
	</head>
	<body>
		<form action="<c:url value="/signin/live" />" method="POST">
		    <button type="submit">Sign in with Live</button>
		    <input type="hidden" name="scope" value="wl.basic" />		    
		</form>
	</body>
</html>
