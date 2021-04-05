<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/22/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<p>
	Employee Id : <input type="text" name="employeeId" value="${employee.employeeId}" disabled />
</p>
<form action="/Q5_war_exploded/update" method="post">

	<p>
		Employee Name : <input type="text" name="employeeName" value="${employee.employeeName}"/>
	</p>
	<p>
		Employee Department : <input type="text" name="employeeDepartment" value="${employee.employeeDepartment}" />
	</p>
	<p>
		Employee Designation : <input type="text" name="employeeDesignation" value="${employee.employeeDesignation}"/>
	</p>
	<p>
		Employee Salary : <input type="text" name="employeeSalary" value="${employee.employeeSalary}"/>
	</p>

	<input type="submit" value="Update" />
</form>
</body>
</html>
