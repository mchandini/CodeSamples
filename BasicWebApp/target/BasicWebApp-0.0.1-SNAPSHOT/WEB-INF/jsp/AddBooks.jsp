<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="formLib" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Book</h2>
<!-- object properties gets mapped with the names of the form elements
	 commandName is used to pre-populate the form with its value(book) object
	 Model should have the attrubute of commandName value -->
<formLib:form method="post" action="${pageContext.request.contextPath}/doAdd" commandName="book">
	<p>Book Number: <formLib:input name="id" path="id" type="number" placeholder="Book Number"/></p>
	<p>Book Name: <formLib:input name="name" path="name" type="text" placeholder="Book Name"/><br/>
	<formLib:errors path="name" cssClass="error" style="color:red"></formLib:errors></p>
	<p>Author: <formLib:input name="author" path="author" type="text" placeholder="Author Name"/></p>

	<input type="submit" value="Add"/>
</formLib:form>
</body>
</html>