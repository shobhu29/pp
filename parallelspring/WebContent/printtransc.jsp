<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>

<h3><u>Transactions</u> :</h3>
<h4>Hi <u>${name}</u>, Your transactions for <u>${mob}</u> are :</h4><br>
<table border="2">

<tr>
<!-- <th>S.No</th> -->
<th>Transactions</th>
<th>Date
</tr>

<a:forEach var="tras" items="${data}">

<tr>
<td>${tras.tr}</td>
<td>${tras.trDate}</td>

</a:forEach>
</table>
<br><br>
<a><b>Current balance:</b> ${bal}</a>
<br>
<br>
<a href="menu">
-Return to Menu</a> 




</body>
</html>