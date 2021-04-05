<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<title>Title</title>
</head>
<body>
<spring:url value="/add" var="addURL" />
<a href="${addURL }">Add User</a>

<h1>Users List</h1>
<table width="100%" border="1">
	<tr>
		<th>ID</th>
		<th>Employee Name</th>
		<th>Employee Department</th>
		<th>Employee Designation</th>
		<th>Employee Salary</th>
		<th colspan="2">Action</th>
	</tr>
	<c:forEach items="${listEmployees }" var="employees">
		<tr>
			<td>${employees.employeeId }</td>
			<td>${employees.employeeName }</td>
			<td>${employees.employeeDepartment }</td>
			<td>${employees.employeeDesignation }</td>
			<td>${employees.employeeSalary}</td>
			<td><spring:url
					value="/update/${employees.employeeName }" var="updateURL" />
				<a href="${updateURL }">Update</a></td>
			<td><spring:url
					value="/delete/${employees.employeeName }" var="deleteURL" />
				<a href="${deleteURL }">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
