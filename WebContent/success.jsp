<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.techpalle.util.SuccessPage" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">

<%
SuccessPage spjsp = (SuccessPage)request.getAttribute("successDetails");
%>
<header>
      <h1><%= spjsp.h1 %></h1>
</header>

       <p><%= spjsp.p %></p>
       
 <footer>
 
         <h3><%= spjsp.h3 %></h3>
 </footer>      
</body>
</html>