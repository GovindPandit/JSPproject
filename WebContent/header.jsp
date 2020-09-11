<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js" integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J" crossorigin="anonymous"></script>
</head>
<body>
 <div class="container">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <!--Expression Language (EL) -->
      <c:if test="${u.username==null}">
      	<li class="nav-item">
        	<a class="nav-link" href="login.jsp">Login</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="register.jsp">Register</a>
      	</li>
      </c:if>
      
      <li class="nav-item">
        <a class="nav-link" href="books.jsp">Books</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="aboutus.jsp">About Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contactus.jsp">Contact Us</a>
      </li>
       
      <c:if test="${u.username!=null}">
        <c:if test="${u.role=='admin'}">
      		<li class="nav-item">
        		<a class="nav-link" href="addbook.jsp">Add Book</a>
      		</li>
      	</c:if>
      		<li class="nav-item">
        		<a class="nav-link" href="cart.jsp">Cart</a>
      		</li>
      	<li class="nav-item">
	        <a class="nav-link" href="login.jsp">Logout</a>
    	  </li>
      </c:if>
    </ul>
    
    <a href="books.jsp?sort=hightolow" class="btn btn-primary">High To Low</a>
    <a href="books.jsp?sort=lowtohigh" class="btn btn-danger">Low to High</a>
    <form class="form-inline my-2 my-lg-0" action="books.jsp">
      <input class="form-control mr-sm-2" type="search" name="bookname" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</div>
</body>
</html>