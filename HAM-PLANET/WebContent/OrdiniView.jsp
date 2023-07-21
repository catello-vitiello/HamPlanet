<%@page import="model_ordine.OrdineBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");
	if(ordini == null){
		response.sendRedirect("OrdineControl");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View degli ordini</title>
<link href="VisualizzazioneView.css" rel="stylesheet" type="text/css">
</head>
<body>

	<h1>ORDINI EFFETTUATI</h1>
	<table>
		<tr>
			<td>ID</td>
			<td>DATA ACQUISTO</td>
			<td>STATO</td>
			<td>EMAIL</td>
		</tr>
		
		<%
			if(ordini != null && ordini.size()>0){
				Iterator<?> iterator = ordini.iterator();
				while(iterator.hasNext()){
					OrdineBean bean = (OrdineBean) iterator.next();
		%>
			
			<tr>
				<td><%= bean.getId() %></td>
				<td><%= bean.getData_acquisto() %></td>
				<td><%= bean.getStato() %></td>
				<td><%= bean.getEmail() %></td>
			</tr>
			
		<%
				}
			} else {
		%>
			
			<tr>
				<td colspan="3">NON CI SONO ORDINI</td>
			</tr>
			
		<%
			}
		%>
	</table>

	<hr>
	<p align="center">
	<a href="Admin.html">BACK</a>

</body>
</html>