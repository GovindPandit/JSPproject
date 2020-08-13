<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://localhost:3306/demo"
					   user="root"
					   password="root"
					   var="con"/>
					   
	<sql:query var="rs" dataSource="${con}">
		select * from books
	</sql:query>
			
	<div class="container">		 
	<table class="table">
	 	<tr>
	 		<th>Book Id</th>
	 		<th>Book Name</th>
	 		<th>Book Author</th>
	 		<th>Book Price</th>
	 		<th>Book Link</th>
	 	</tr>
	<c:forEach items="${rs.rows}" var="row">
		<tr>
			<td>${row.bookid}</td>
			<td>${row.bookname}</td>
			<td>${row.author}</td>
			<td>${row.price}</td>
			<td>${row.link}</td>
		</tr>
	</c:forEach>
	</table>
	</div>	    
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>