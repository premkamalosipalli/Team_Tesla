<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body class="resultbody">
	<div id="header">
		<div>
			<a href=".html" id="logo"><img src="images/logo.png" alt=""></a>
			<ul>
				<li>
					<a href="view/welcome.html">Home</a>
				</li>
				<li class="selected">
					<a href="../view/geners.jsp">Genres</a>
					<ul>
						<li class="selected">
							<a href="#">Now Showing</a>
						</li>
						<li>
							<a href="#">Coming Soon</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#">Ticket Info</a>
				</li>
				<li>
					<a href="#">Rentals</a>
				</li>
				<li>
					<a href="logIn.jsp">Log In</a>
				</li>
				<li>
					<a href="#">Sign Up</a>
				</li>
			</ul>
		</div>
	</div>
	<div>
		<h2 style="text-align: center; color: white">List Of Movies Based On The Genre:</h2>
	
		
		<div class="container"> 
		<div class="row">
			<c:forEach items="${styles}" var="movieObj">
  			
   				 <div class="col-sm mb-5">
      					<c:set var="movieName" value="${movieObj.movieName}" scope="session" />
				<c:url var="productUrl"
					value="MovieDesc?movieName=${movieObj.movieName}"></c:url>
					<div class="row">
					<a id="cart" href="${productUrl}"
												target="_blank"><img style="    width: 200px;
    height: 300px;"
									src="<c:out value ="${movieObj.imageLocation}"/>" /></a>
					</div>
					<div class="row" style="justify-content: center;">
					<a style="color:#a5a5a5!important;
	font-family:Arial, Helvetica, sans-serif;
	font-size:20px;
	line-height:28px;
	text-transform: uppercase;" id="cart" href="${productUrl}"
												target="_blank"><c:out value="${movieObj.movieName}" /></a>
					</div>
											
						
    			</div>
    		
    		</c:forEach>
		</div>
		
    	</div>
				
		
	</div>
	<div id="footer">
		<div>
			<div>
				<span>Quick Links</span>
				<ul>
					<li>
						<a href="view/welcome.html">Home</a>
					</li>
					<li>
						<a href="V">Ticket Info</a>
					</li>
					<li>
						<a href="#">Location</a>
					</li>
					<li>
						<a href="V">Now Showing</a>
					</li>
					<li>
						<a href="V">Rentals</a>
					</li>
					<li>
						<a href="V">Contact</a>
					</li>
					<li>
						<a href="V">Coming Soon</a>
					</li>
					<li>
						<a href="about.html">The Company</a>
					</li>
					<li>
						<a href="blog.html">Blog</a>
					</li>
				</ul>
			</div>
			<div class="section">
				<span>Recent Tweets</span>
				<ul>
					<li>
						<p>
							No one is born hating another person because of the color of his skin or his background or his religion.
						</p>
						<span><a href="#">- 1 day ago</a></span>
					</li>
					<li>
						<p>
							Kobe was a legend on the court and just getting started in what would have been just as meaningful a second act. To lose Gianna is even more heartbreaking to us as parents. 
						</p>
						<span><a href="#">- 2 day ago</a></span>
					</li>
				</ul>
			</div>
			<div>
				<span>Sign Up For Our Mailing List</span>
				<p>
					Enter your emailId to for any queries....
				</p>
				<form action="welcome.html">
					<input type="text" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Enter Email Address Here':this.value;" value="Enter Email Address Here">
					<input type="button" value="">
				</form>
			</div>
			<p>
				&#169; 2023 Movie Booking
			</p>
			<div class="connect">
				<span>Stay Connected:</span> <a href="https://www.facebook.com/Kamal.Osipalli" id="facebook">FaceBook</a>
			<a href="https://www.instagram.com/premkamal.osipalli/" id="twitter">Twitter</a>
			<a href="https://www.linkedin.com/in/prem-kamal-osipalli-73ba65114/" id="googleplus">LinkedIn</a>
		</div>
		</div>
	</div>
</body>
</html>