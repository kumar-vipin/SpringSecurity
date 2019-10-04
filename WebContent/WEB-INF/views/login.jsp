<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Custom Login Page</title>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
}
</style>
</head>
<body onload='document.login.username.focus();'>
	<h3>Custom Login Page</h3>

	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
		}
	%>

	<form action="j_security_check" name="login" method="post">
		<div class="username-wrapper">
			<div class="element-container">
				<div class="user-icon">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
				<div class="user-input">
					<input type="text" id="userName" name="username"
						class="user-name" placeholder="Enter Username" />
				</div>
			</div>
		</div>
		<div class="password-wrapper">
			<div class="element-container">
				<div class="password-icon">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="password-input">
					<input type="password" id="password" name="password"
						class="user-password" placeholder="Enter Password" />
				</div>
			</div>
		</div>
		<div class="signin-control">
			<div class="loginControl">
				<input type="submit" value="Log In" />
			</div>
		</div>
	</form>
</body>
</html>