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
<style type="text/css">
* {
	box-sizing: border-box;
}

.productbody {
	background-color: black;
	color: white;
}

.productcart {
	float: right;
	width: 100px;
	height: 30px;
}
/* Create three equal columns that floats next to each other */
.productcolumn {
	float: left;
	width: 33.33%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}
/* Clear floats after the columns */
.productrow:after {
	content: "";
	display: table;
	clear: both;
}

.producta {
	float: right;
}

.productbutton {
	background-color: orange;
	float: right;
	color: black;
	width: 100px;
	height: 40px;
}

div.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: blue;
}
</style>
</head>
<body class="productbody">
	<div class="topnav">
		<a href="welcome.html">Home</a> <a href="logIn.jsp">SignOut</a> <a
			href="javascript:history.back()">Movies List</a>
	</div>
	<div align="right">
		<h1>
			Hello <span>${user}</span>
		</h1>
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
					<td><hr>Movie Name:</td>
					<td><hr> <span class="price">${movieList.movieName}</span></td>
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
			<img alt="" src="Images/shopping-cart.png"> <a id="cartItems"></a>

		</div>
		<div class="productcolumn">
			<h1 align="center" style="color: Brown;">Ready To Sell This Beer</h1>
			<hr>
			<div>
				<h2>
					Movie Selected:<a class="producta" href="#">${movieList.movieName}</a>
				</h2>
			</div>
			<div>
				<h2>
					Movie Cost:<a class="producta" name="movieCost" href="#" id="demo">${movieList.movieCost}</a>
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
	<h4>Languages:</h4>
	<table>
		<c:forEach items="${languageList}" var="languageList">
			<tr>
				<td><c:out value="${languageList.language_id}" /></td>
				<td><c:out value="${languageList.language}" /></td>
				<td><c:out value="${languageList.movie_id}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h4>Actors:</h4>
	<table>
		<c:forEach items="${actorsList}" var="actorsList">
			<tr>
				<td><c:out value="${actorsList.actor_id}" /></td>
				<td><c:out value="${actorsList.fullName}" /></td>
				<td><c:out value="${actorsList.role}" /></td>
				<td><c:out value="${actorsList.movie_id}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h4>Cast Team:</h4>
	<table>
		<c:forEach items="${castTeamList}" var="castTeamList">
			<tr>
				<td><c:out value="${castTeamList.castTeam_id}" /></td>
				<td><c:out value="${castTeamList.fullName}" /></td>
				<td><c:out value="${castTeamList.experience}" /></td>
				<td><c:out value="${castTeamList.movie_id}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>