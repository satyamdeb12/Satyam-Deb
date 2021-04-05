<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2/26/2021
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form:errors path="customer.*"/>

<form:form action="/Q7_war_exploded/submit" method="post">

	<p>
		Name : <input type="text" name="username" />
	</p>
	<p>
		Password : <input type="text" name="password" />
	</p>
	<p>
		Email : <input type="text" name="email"/>
	</p>
	<p>
		contact : <input type="text" name="contact"/>
	</p>
	<p>
		city : <select name="city">
		<option value="Ghaziabad" label="Ghaziabad">Ghaziabad</option>
		<option value="Modinagar" label="Modinagar">Modinagar</option>
		<option value="Meerut" label="Meerut">Meerut</option>
		<option value="Amristar" label="Amristar">Amristar</option>
	</select>
	</p>

	<p>
		zip code : <input type="text" name="zipcode"/>
	</p>


	<input type="submit" value="Register" />
</form:form>
</body>
</html>
