<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	ClienteBean user = (ClienteBean) session.getAttribute("user");
	if(user == null){
		response.sendRedirect("Admin.html");
		return;
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN PAGE</title>
</head>
<body>
	
	<%
		if(user.getSesso() == 'M' || user.getSesso() == 'm'){
	%>
		BENVENUTO <%= user.getNome() %><br>
		Il tuo ID sessione: <%= session.getId() %>
	<% } else{ %>
		BENVENUTA <%= user.getNome() %>
	<% } %>
	
	<hr>
	<a href="Login.jsp">LOG-OUT</a>
</body>
</html>