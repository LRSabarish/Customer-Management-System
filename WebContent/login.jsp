<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
 <h1>Login Page</h1>
 <form action="logcus" method="post">
 
<label for="tbemail">Email :</label>
<input type="email" name="tbemail"  id="tbemail" value="<%=request.getParameter("tbemail")%>"/>

<br><br>

<label for="tbpsw">Password :</label>
<input type="password" name="tbpsw"  id="tbpsw"  value="<%=request.getParameter("tbpsw")%>"/>

<br><br>

<input type="submit" value="Login"/>
</form>
</body>
</html>