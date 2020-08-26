<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		
		<form action='ChangePasswordServlet'method='post' class="col-lg-6 col-md-9 col-sm-12 col-xs-12 myclass">
			<div class="form-group">
				<label>Enter Password</label>
				<input type="text" name="password" placeholder="Enter Password" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter ConfirmPassword</label>
				<input type="text" name="confirmpassword" placeholder="Enter ConfirmPassword" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="submit" value="ChangePassword" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>