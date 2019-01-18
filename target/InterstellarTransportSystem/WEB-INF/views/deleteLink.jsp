<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Link From Network</title>
</head>
<h2>Delete Link From Network</h2>
<body>
	
	<form class="form-signin"
		action="/InterstellarTransportSystem/interstellar/delete/link" method="get" modelAttribute="linkInfo">
		<input type="text" name="linkName"> <br>
		<input class="btn btn-md btn-success btn-block" type="submit" value="submit">
	</form>

</body>
</html>