<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:url var="loginUrl" value="/login" />
	<form action="${loginUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<p>Invalid username and password.</p>
			</div>
		</c:if>
		<c:if test="${param.msg != null}">
			<div class="alert alert-success">
				<p>You have been logged out successfully.</p>
			</div>
		</c:if>
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" id="username" name="username"
					placeholder="Enter Username" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password"
					placeholder="Enter Password" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Log in"></td>
			</tr>
		</table>
	</form>

</body>
</html>