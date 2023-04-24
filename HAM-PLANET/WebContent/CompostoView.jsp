<%@page import="model_composto.CompostoBean"%>
<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> composti = (Collection<?>) request.getAttribute("composti");
	if(composti == null){
		response.sendRedirect("CompostoControl");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Composto ordine View</title>
<link href="VisualizzazioneView.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<h1>LISTA ORDINI DETTAGLIATI</h1>
	<table>
		<tr>
			<td>ID COMPOSTO</td>
			<td>ID ORDINE DI RIFERIMENTO</td>
			<td>IAN PRODOTTO</td>
			<td>TOTALE DA PAGARE</td>
			<td>QUANTITÀ PRODOTTO</td>
		</tr>
		
		<%
		
			if(composti != null && composti.size()>0){
				Iterator<?> iterator = composti.iterator();
				while(iterator.hasNext()){
					CompostoBean bean = (CompostoBean)iterator.next();
		%>
		
			<tr>
				<td><%= bean.getId_c() %></td>
				<td><%= bean.getId_ordine() %></td>
				<td><%= bean.getIan_prodotto() %></td>
				<td><%= bean.getPrezzo() %></td>
				<td><%= bean.getQuantity() %></td>
			</tr>
		
		<%
				}
			} else {
		%>
		
			<tr>
				<td colspan="3">NON CI SONO PRODOTTI</td>
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