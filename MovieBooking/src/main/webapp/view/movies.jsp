<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
<link href="./css/stylesheet.css" rel="stylesheet" />
</head>
<body class="resultbody">
	<div class="topnav">
		<a href="view/welcome.html">Home</a> <a href="view/logIn.jsp">SignIn</a> <a
			href="javascript:history.back()">Movie Selection</a>
		<div align="right">
			<h1>
				<span>${user}</span>
			</h1>
		</div>
	</div>

	<h2 align="center">

		List Of Movies Based On The Genre:<br>
	</h2>
	<div align="center">
		<table>
			<c:forEach items="${styles}" var="movieObj">

				<c:set var="movieName" value="${movieObj.movieName}" scope="session" />
				<c:url var="productUrl"
					value="MovieDesc?movieName=${movieObj.movieName}"></c:url>
				<tr>
					<td><a href="${productUrl}" target="_blank"><img
							src="<c:out value ="${movieObj.imageLocation}"/>" width="160px"
							height="160px" /> </a></td>
					<td>
						<table>
							<tr>
								<td><b><a id="cart" href="${productUrl}"
										target="_blank"><c:out value="${movieObj.movieName}" /></a></b></td>
							</tr>
						</table>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>