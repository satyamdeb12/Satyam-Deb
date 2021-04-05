<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/22/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="/Q5_war_exploded/add" method="post">

	<p>
		Employee Name : <input type="text" name="employeeName" />
	</p>
	<p>
		Employee Department : <input type="text" name="employeeDepartment" />
	</p>
	<p>
		Employee Designation : <input type="text" name="employeeDesignation"/>
	</p>
	<p>
		Employee Salary : <input type="text" name="employeeSalary"/>
	</p>

	<input type="submit" value="Add" />
</form>
</body>
</html>
