<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rest Service Consumer Home</title>
</head>
<body>
	<br />
	<table style="border: 1px solid black">
		<tr style="border: 1px solid black">
			<th style="border: 1px solid black">Product Id</th>
			<th style="border: 1px solid black">Product Name</th>
		</tr>
		<jstl:forEach var="product" items="${responseList}">
			<tr style="border: 1px solid black">
				<td style="border: 1px solid black">${product.id}</td>
				<td style="border: 1px solid black">${product.name}</td>
			</tr>
		</jstl:forEach>
	</table>
</body>
</html>