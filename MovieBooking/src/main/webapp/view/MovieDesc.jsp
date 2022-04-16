<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Cart</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<link href="./css/movieDesc.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<style>

.row {
  margin-left:-5px;
  margin-right:-5px;
}
  
.column {
  float: left;
  width: 30%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 10px;
}
</style>
</head>
<body class="productbody">
	<div id="header">
		<div>
			<a href="view/welcome.html" id="logo"><img src="images/logo.png" alt=""></a>
			<ul>
				<li>
					<a href="view/welcome.html">Home</a>
				</li>
				<li>
					<a href="view/logIn.jsp">Movies</a>
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
					<a href="view/ticket-info.html">Ticket Info</a>
				</li>
				<li class="selected">
					<a href="view/rentals.html">Rentals</a>
				</li>
				<li>
						<a href="view/about.html">About</a>
					</li>
					<li>
						<a href="view/blog.html">Blog</a>
						</li>
						<li>
						<a href="view/logIn.jsp">Sign Out</a>
					</li>
			</ul>
		</div>
	</div>
	<div class="productrow">
		<div class="productcolumn">
			<img src="${imageLocation}" width="400px" height="300px" />
		</div>
		<div class="productcolumn">
			<h1 style="color: red;">
				<b>Movie Details</b>
			</h1>
			<table>
				<tr>
					<td><hr>MovieName:</td>
					<td><hr><span class="price">${movieList.movieName}</span></td>
				</tr>
				<tr>
					<td>Cost:</td>
					<td><span class="price">${movieList.movieCost}</span></td>
				</tr>
				<tr>
					<td>Duration:</td>
					<td><span class="price">${movieList.movieLength}</span></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><span class="price">${movieList.movieDesc}</span></td>
				</tr>
				<tr>
					<td>Release:</td>
					<td><span class="price">${movieList.movieDate}</span></td>
				</tr>
			</table>
		</div>
		<div class="productcart">
			<img alt="" src="img/shopping-cart.png"> <a id="cartItems"></a>
		</div>
		<div class="productcolumn">
			<h1 align="center" style="color: Red;">Buy Tickets for Movie Selected:</h1>
			<hr>
			<div>
				<h2>
					Movie Selected:<a style="color:#a5a5a5!important;
	font-family:Arial, Helvetica, sans-serif;
	font-size:20px;
	line-height:28px;
	text-transform: uppercase;" class="producta" href="#">${movieList.movieName}</a>
				</h2>
			</div>
			<div>
				<h2>
					Movie Cost:<a style="color:#a5a5a5!important;
	font-family:Arial, Helvetica, sans-serif;
	font-size:20px;
	line-height:28px;
	text-transform: uppercase;" class="producta" name="movieCost" href="#" id="demo">${movieList.movieCost}</a>
				</h2>
			</div>
			<hr>
			<div>
				<form action="authorize_payment" method="post">
					No of People:<select id="quantity" name="quantity"
						onchange="myFunction()">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
					</select> <input type="hidden" name="user" value="${user}" /> <input
						type="hidden" name="movieName" value="${movieList.movieName}" />
					<button class="productbutton" value="Buy Now">Buy Now</button>
				</form>
				<br>
				<button onclick="cartFunction()" id="button" value="Buy Now">Add
					to Cart</button>

			</div>
		</div>
		<script>
		function myFunction() {
			var x = document.getElementById("quantity").value;
			document.getElementById("demo").innerHTML =	${movieList.movieCost}*x;
		}
		function cartFunction(){
			var y=document.getElementById("quantity").value;
			document.getElementById("cartItems").innerHTML = y;
			 $.post('cartitem', {
                 userName : '${user}',
			 	 productid : '${movieList.movieId}',
			 	 price:'${movieList.movieCost}',
			 	quantity: y
         }, function(responseText) {
                 $('#cartItems').text(responseText);
         });               
		}		
	</script>
	</div>
	<br>
<div class="row">
<h3>Movie Information:</h3>
  <div class="column">
        <b>Language:&ensp;&ensp;</b>
        <i>
        	<c:forEach items="${languageList}" var="languageList">
				<c:out value="${languageList.language}" />
		</c:forEach>
        </i>
      
		<br><br>
        <b>Actor:&ensp;&ensp;</b>
        <i>
         <c:forEach items="${actorsList}" var="actorsList">
				<c:out value="${actorsList.fullName}" />,
		</c:forEach>
        </i>
     
		<br><br>
		 <b>Role:&ensp;&ensp;</b>
		 <i>
        <c:forEach items="${actorsList}" var="actorsList">
				<c:out value="${actorsList.role}" />,
		</c:forEach>
        </i>
      
		<br><br>
		<b>Name:&ensp;&ensp;</b>
		<i>
        <c:forEach items="${castTeamList}" var="castTeamList">
			<c:out value="${castTeamList.fullName}" />,
		</c:forEach>
        </i>
		
		<br><br>
		<b>Experience:&ensp;&ensp;</b>
		<i>
        <c:forEach items="${castTeamList}" var="castTeamList">
			<c:out value="${castTeamList.experience}" />,
		</c:forEach>
        </i>
		
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
						<a href="view/ticket-info.html">Ticket Info</a>
					</li>
					<li>
						<a href="#">Location</a>
					</li>
					<li>
						<a href="view/logIn.jsp">Now Showing</a>
					</li>
					<li>
						<a href="view/rentals.html">Rentals</a>
					</li>
					<li>
						<a href="view/about.html">Contact</a>
					</li>
					<li>
						<a href="view/logIn.jsp">Coming Soon</a>
					</li>
					<li>
						<a href="view/about.html">The Company</a>
					</li>
					<li>
						<a href="view/blog.html">Blog</a>
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