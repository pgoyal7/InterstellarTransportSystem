<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Network Information</title>
</head>
<center><h1>Network Information</h1></center>
<body>
<table align="center" border="2" cellspacing="5" cellpadding="5">
<tr>
    <th>LinkName</th>
    <th>Planet1</th>
    <th>Planet2</th>
    <th>Distance</th>
  </tr>
<c:forEach items="${networkInfo}" var="element"> 
  <tr>
    <td>${element.linkName}</td>
    <td>${element.sourcePlanet}</td>
    <td>${element.targetPlanet}</td>
    <td>${element.distance}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>