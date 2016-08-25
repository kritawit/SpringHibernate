<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th><sec:authorize access="hasRole('ADMIN')">
						<a href="<c:url value="/register" />">Add User</a>
					</sec:authorize></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.email}</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>