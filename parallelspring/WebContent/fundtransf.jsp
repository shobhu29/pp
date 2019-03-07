<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="ca" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
<h3>
Fund Transfer :</h3>
<table border="1">
<ca:form action="fundtransf2" method="post" modelAttribute="my" >

<tr>
<td>Enter Your Mobile Number to Withdraw money : </td>
<td> <ca:input path="mobileNo" /></td>
<td><ca:errors path="mobileNo"></ca:errors></td>
</tr>

<tr>
<td></td><td><input type="submit" value="Search MobileNo" /></td></tr>


</ca:form>
</table>
</body>
</html>