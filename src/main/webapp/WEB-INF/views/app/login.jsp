<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>
	<title>Basketball Statistics System</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />">
</head>
<body>
	<div class="container">
		<form action="<c:url value='/login' />" method="post" class="login-panel center col-md-4 col-lg-3">
			<img id="login-logo" src="<c:url value="/resources/images/basta-logo-black.jpg" />"/>
			<div class="form-group">
				<input id="username" type="text" class="form-control"
					name="userName" placeholder="Username">
			</div>
			<div class="form-group">
				<input id="password" type="password" class="form-control"
					name="password" placeholder="Password">
			</div>
			
			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<c:out value="Invalid username or password."/>
				</div>
			</c:if>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input name="submit" type="submit" value="Login" class="btn btn-primary login-button" />
		</form>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>