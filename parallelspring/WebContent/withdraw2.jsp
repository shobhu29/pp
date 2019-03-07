<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="ca" uri="http://www.springframework.org/tags/form" %>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
Withdraw Money :</h3>
<a>Hi ${data.name }, your account details are</a>

<br>

 <table border="1">

<tr>
<th> Mobile Number </th>
<th>Name </th>
<th>Balance </th>
</tr>
<tr>
<td >${data.mobileNo }</td>
<td > ${data.name }</td>
<td>${data.balance }</td>
</tr>
</table>
<br>
<br>
<table border="1">
<ca:form action="withdrawsuccess?mNo=${data.mobileNo }" method="post" modelAttribute="my" >

<tr>
<td>Enter Money you want to withdraw : </td>
<td> <ca:input path="balance" /></td>
<td><ca:errors path="balance"></ca:errors></td>
</tr>

<tr>
<td></td><td><input type="submit" value="Withdraw" /></td></tr>


</ca:form>
</table>
<br><br><br>
<a>*Note : Withdraw Amount must be lesser than or equal to existing balance</a>
</body>
</html>