<!-- All jsp files should be in web-inf/jsp -->
<!-- java code can be written in <% %>
	 below page directive allows this -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>@@@</title>
</head>
<body>
Welcome to dynamic web with spring features

<%-- <div>Session : <%= session.getAttribute("key") %></div>

<div>Model : <%= request.getAttribute("model-key") %></div>

<div>ModelOnly : <%= request.getAttribute("onlyModelKey") %></div> --%>

<%-- <div>Using EL : ${onlyModelKey}</div> --%>

<!-- using jstl -->
<%-- <c:out value="${onlyModelKey}"></c:out> --%>

<!-- displaying data from mysql db without DAO pattern -->
<%--  <sql:query var="rs" dataSource="jdbc/mydbres">
	select id, name, author from Books
</sql:query>
<h1>table data from db</h1>
<c:forEach var="row" items="${rs.rows}">
    <b>Id:</b> ${row.id}<br/>
    <b>Name:</b> ${row.Name}<br/>
</c:forEach> --%>

<br/>
<!-- ${pageContext.request.contextPath} is the root of page url -->
<div>
	<a href=${pageContext.request.contextPath}/Books>Show Available Books</a>
</div>
<div>
	<a href=${pageContext.request.contextPath}/AddBooks>Add Books</a>
</div>


</body>
</html>