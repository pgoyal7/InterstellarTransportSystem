<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Link In Network</title>
</head>
<h2>Update Link In Network</h2>
<body>

	<form class="form-signin"
		action="/InterstellarTransportSystem/interstellar/update/link" method="get" modelAttribute="updateDistanceInfo">
		LinkName : <input type="text" name="linkName"> <br><br>
		Distance to Update: <input type="text" name="distance"> <br><br>
		<input class="btn btn-md btn-success btn-block" type="submit" value="submit">
	</form>
	 
</body>
</html>