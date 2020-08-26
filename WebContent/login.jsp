<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
		<!-- Scriplet Tag -->
		<!-- Scriplet is used to write java code in jsp -->
		<!-- Earlier we used to write all scriplets tag for java code -->
		<!-- But combining pure java and html is difficult -->
		<!-- But JSTL Tags combines with html very easily -->
	    <%
	    	session.removeAttribute("un");
	    	session.invalidate();
	    %>
	    
		<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		
		<form action='LoginServlet'method='post' class="col-lg-6 col-md-9 col-sm-12 col-xs-12 myclass">
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control"/>
			</div>
			<div class="form-group">
				<a href="collectemail.jsp">Forgot Password?</a>
			</div>
			<div class="form-group">
				<input type="submit" value="Login" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>