<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="ca" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
Deposit Money :</h3>
<table border="1">
<ca:form action="depositsuccess" method="post" modelAttribute="my" >

<tr>
<td>Enter Your Mobile Number to deposit money : </td>
<td> <ca:input path="mobileNo" /></td>
<td><ca:errors path="mobileNo"></ca:errors></td>
</tr>



<tr>
<td>Enter Amount you want to deposit : </td>
<td> <ca:input path="balance"/></td>
<td><ca:errors path="balance"></ca:errors></td>
</tr>



<tr>
<td></td><td><input type="submit" value="Deposit Money" /></td></tr>


</ca:form>
</table>

<a>*Note : Amount must be greater than zero</a>
</body>
</html>