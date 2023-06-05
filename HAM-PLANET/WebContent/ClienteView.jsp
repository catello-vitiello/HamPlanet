<%@page import="model_cliente.ClienteBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> clienti = (Collection<?>) request.getAttribute("clienti");
	if(clienti == null){
		response.sendRedirect("ClienteControl");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clienti View</title>
<link href="VisualizzazioneView.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<h1>LISTA CLIENTI REGISTRATI</h1>
	<table>
		<tr>
			<td>EMAIL</td>
			<td>PASSWORD</td>
			<td>NOME</td>
			<td>COGNOME</td>
			<td>SESSO</td>
			<td>INDIRIZZO</td>
			<td>CELLULARE</td>7
			<td>DATA DI NASCITA</td>
		</tr>
		
		<%
		
			if(clienti != null && clienti.size()>0){
				Iterator<?> iterator = clienti.iterator();
				while(iterator.hasNext()){
					ClienteBean bean = (ClienteBean)iterator.next();
		%>
		
			<tr>
				<td><%= bean.getEmail().toString() %></td>
				<td><%= bean.getPass().toString() %></td>
				<td><%= bean.getNome().toString() %></td>
				<td><%= bean.getCognome().toString() %></td>
				<td><%= bean.getSesso() %></td>
				<td><%= bean.getIndirizzo().toString() %></td>
				<td><%= bean.getCellulare().toString() %></td>
				<td><%= bean.getData_nascita().toString() %></td>
			</tr>
		
		<%
				}
			} else {
		%>
		
			<tr>
				<td colspan="3">NON CI SONO UTENTI REGISTRATI</td>
			</tr>
		
		<%
			}
		%>
	</table>
	
	<hr>
	<p align="center">
	<a href="Admin.html" >BACK</a> <!-- Per tornare alla pagina amministrtore -->
	
</body>
</html>