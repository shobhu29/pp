<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Balance Enquiry :</h3>
<table border="1">
<tr>
<th> Mobile Number </th>
<th>Name </th>
<th>Balance </th>
</tr>
<tr>
<td>${data.mobileNo }</td>
<td>${data.name }</td>
<td>${data.balance }</td>
</tr>
</table>

<a href="menu">
-Return to Menu</a> 
</body>
</body>
</html>