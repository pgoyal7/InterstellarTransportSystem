<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shortest Path Between Earth and other Planet</title>
</head>
<h2>Shortest Path Between Earth and other Planet</h2>
<body>

	<form class="form-signin"
		action="/InterstellarTransportSystem/interstellar/shortest/path" method="get" modelAttribute="shortestPathData">
		Source Planet : <input type="text" name="sourcePlanet"> <br><br>
		Destination Planet: <input type="text" name="destinationPlanet"> <br><br>
		<input class="btn btn-md btn-success btn-block" type="submit" value="submit">
	</form>
	 
</body>
</html>