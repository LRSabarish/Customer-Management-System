<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center"> 
<h1>Registration Page</h1>
<form action="regcustomer" method="post">
<label for="tbname">Name :</label>
<input type="text" name="tbname" id="tbname"/>

<br><br>
<label for="tbnum">Mobile :</label>
<input type="number" name="tbnum" id="tbnum"/>

<br><br>
State :<select name="ddlstate"> 
<option>---select---</option>
<option value="TamilNadu">TN</option>
<option value="Kerala">KL</option>
<option value="Karnataka">KA</option>
</select>

<br><br>
<label for="tbemail">Email :</label>
<input type="email" name="tbemail"  id="tbemail"/>

<br><br>

<label for="tbpsw">Password :</label>
<input type="password" name="tbpsw"  id="tbpsw"/>

<br><br>

<input type="submit" value="Register"/>
</form>
</body>
</html>