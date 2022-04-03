<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genres</title>
<link href="./css/stylesheet.css" rel="stylesheet" />
</head>
<body class="genre">
	<div align="right">
		<h3 class="formh1">
		<span>${register.firstName}</span>
		</h3>
	</div>
	<h1 class="formh1" align="center">Genre Selection Page</h1>
	<form action="genreSelect" method="post">
		<h2 class="formh2" align="center">
			<input type="hidden" name="register" value='${register.firstName}'><br>
			Select beer Characteristics Color:<br> <select
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
		</h2>
	</form>
</body>
</html>