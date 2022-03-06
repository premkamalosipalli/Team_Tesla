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
<script type="text/javascript" src="Validation.js"></script>
</head>
<body>
	<h1>Create New Account</h1>
  <form action="Registration" method="post" id="form" class="form">

    <label class="label" for="firstName">First Name</label>
    <input class="input" type="text" name="firstName" id="firstName" placeholder="Enter Your First Name" data-error="#firstName"/>
    <span id="firstName"></span>
	<br>
    <label class="label" for="lastName">Last Name</label>
    <input class="input" type="text" name="lastName" id="lastName" placeholder="Enter Your Last Name" data-error="#lastName"/>
    <span id="lastName"></span>
	<br>
	<label class="label" for="mobile">Mobile</label>
    <input class="input" type="text" name="mobile" id="mobile" placeholder="9999999999" data-error="#Mobile"/>
    <span id="Mobile"></span>
    <br>
    <label class="label" for="email">Email</label>
    <input class="input" type="email" name="email" id="email" placeholder="example@email.com" data-error="#Email"/>
    <span id="Email"></span>
    <br>
    <label class="label" for="zipCode">City</label>
    <input class="input" type="text" name="zipCode" id="city" placeholder="Enter Your City" data-error="#City"/>
    <span id="City"></span>
    <br>
    <label class="label" for="password">Password</label>
    <input class="input" type="password" name="password" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;" data-error="#Password"/>
    <span id="Password"></span>
    <br>
    <button class="button" type="submit">Register</button>
  </form>
</body>
</html>