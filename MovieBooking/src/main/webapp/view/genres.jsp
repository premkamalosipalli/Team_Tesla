<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genres</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header">
		<div>
			<a href=".html" id="logo"><img src="images/logo.png" alt=""></a>
			<ul>
				<li>
					<a href="#">Home</a>
				</li>
				<li class="selected">
					<a href="#">Movies</a>
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
	<div id="container">
	<form action="genreSelect" method="post">
		<h1 class="formh2" align="center">
			<input type="hidden" name="register" value='${register.firstName}'><br>
			Select Genre for Movies:<br><select
				class="formselect" name="genre" size="1">
				<option value="default">Select Genre</option>
				<option value="Adventure" selected="selected">Adventure</option>
				<option value="action">Action</option>
				<option value="drama">Drama</option>
				<option value="comedy">Comedy</option>
				<option value="thriller">Thriller/Suspense</option>
				<option value="horror">Horror</option>
				<option value="romantic">Romantic</option>
				<option value="education">Education</option>
			</select><br> <input class="forminput" type="submit" value="submit">
			<br><br>
		</h1>
	</form>
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