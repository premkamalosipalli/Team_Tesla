<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script type="text/javascript" src="Validate.js"></script>
</head>
<body>
	<h1>Login User</h1>
	<form action="login" method="post" id="form" class="form">

			<label class="label" for="email">Email</label> 
			<input class="input" type="email" name="email"
				id="email" placeholder="example@email.com" data-error="#Email" />
			<span id="Email"></span> 
			<br>
			<label class="label" for="password">Password</label>
		    <input class="input" type="password" name="password" id="password"
				placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;"
				data-error="#Password" />
		    <span id="Password"></span>
			<br>
			<button class="button" type="submit">Log in</button>
		</form>
</body>
</html>