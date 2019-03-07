<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="ca" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Balance</title>
</head>
<body>
<h2> Check Balance :</h2>
<table border="1">
<ca:form action="showbalancesuccess"  modelAttribute="my" >

<tr>
<td>Enter Your Mobile Number : </td>
<td> <ca:input path="mobileNo" /></td>
<td><ca:errors path="mobileNo"></ca:errors></td>
</tr>






<tr>
<td></td><td><input type="submit" value="Show Balance" /></td></tr>


</ca:form>
</table>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





</body>
</html>