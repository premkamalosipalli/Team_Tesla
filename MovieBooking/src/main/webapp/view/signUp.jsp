<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script type="text/javascript" src="../js/Validation.js"></script>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<div id="header">
		<div>
			<a href="index.html" id="logo"><img src="../images/logo.png" alt=""></a>
			<ul>
				<li>
					<a href="welcome.html">Home</a>
				</li>
				<li>
					<a href="logIn.jsp">Movies</a>
					<ul>
						<li>
							<a href="#">Now Showing</a>
						</li>
						<li>
							<a href="#">Comming Soon</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="ticket-info.html">Ticket Info</a>
				</li>
				<li class="selected">
					<a href="rentals.html">Rentals</a>
				</li>
				<li>
					<a href="logIn.jsp">Log In</a>
				</li>
				<li>
					<a href="signUp.jsp">Sign Up</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="container">
		<h1 align="center">Create New Account</h1>
	<form action="../src/../Registration" method="post" id="form" class="form">
		<label class="label" for="firstName">First Name</label> <input
			class="input" type="text" name="firstName" id="firstName"
			placeholder="Enter Your First Name" data-error="#firstName" /> <span
			id="firstName"></span> <br> <label class="label" for="lastName">Last
			Name</label> <input class="input" type="text" name="lastName" id="lastName"
			placeholder="Enter Your Last Name" data-error="#lastName" /> <span
			id="lastName"></span> <br> <label class="label" for="mobile">Mobile</label>
		<input class="input" type="text" name="mobile" id="mobile"
			placeholder="9999999999" data-error="#Mobile" /> <span id="Mobile"></span>
		<br> <label class="label" for="email">Email</label> <input
			class="input" type="email" name="email" id="email"
			placeholder="example@email.com" data-error="#Email" /> <span
			id="Email"></span> <br> <label class="label" for="zipCode">City</label>
		<input class="input" type="text" name="zipCode" id="city"
			placeholder="Enter Your City" data-error="#City" /> <span id="City"></span>
		<br> <label class="label" for="password">Password</label> <input
			class="input" type="password" name="password" id="password"
			placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;"
			data-error="#Password" /> <span id="Password"></span> <br><br><br>
		<button class="button" type="submit">Register</button>
	</form>
	</div>
	<div id="footer">
		<div>
			<div>
				<span>Quick Links</span>
				<ul>
					<li>
						<a href="welcome.html">Home</a>
					</li>
					<li>
						<a href="ticket-info.html">Ticket Info</a>
					</li>
					<li>
						<a href="#">Location</a>
					</li>
					<li>
						<a href="logIn.jsp">Now Showing</a>
					</li>
					<li>
						<a href="rentals.html">Rentals</a>
					</li>
					<li>
						<a href="about.html">Contact</a>
					</li>
					<li>
						<a href="logIn.jsp">Coming Soon</a>
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