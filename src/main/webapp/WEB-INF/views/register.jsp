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
	<form:form accept-charset="utf-8"
		action="${pageContext.request.contextPath}/save" method="POST"
		commandName="user">
		<table>
			<tbody>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstname" id="firstname" /> <form:errors
							path="firstname" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastname" id="lastname" /> <form:errors
							path="lastname" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><form:input path="username" id="username" /><form:errors
							path="username" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" id="password" /> <form:errors
							path="password" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" id="email" /> <form:errors
							path="email" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Roles</td>
					<td><form:select path="userProfiles" items="${roles}"
							multiple="true" itemValue="id" itemLabel="type" /> <form:errors
							path="userProfiles" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" /><a
						href="<c:url value="/"/>">Back</a></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>