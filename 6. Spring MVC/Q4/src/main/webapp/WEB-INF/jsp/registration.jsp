<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/21/2021
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Register</title>
</head>
<body>

<form action="/Q4_war_exploded/registration" method="post">

	<p>
		User Name : <input type="text" name="userName" />
	</p>
	<p>
		Email : <input type="text" name="email" />
	</p>
	<p>
		Password : <input type="text" name="password"/>
	</p>

	<input type="submit" value="Register" />
</form>

</body>
</html>
