<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null){
		response.sendRedirect("ProdottoControl");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti View</title>
<link href="VisualizzazioneView.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<h1>LISTA PRODOTTI</h1>
	<table>
		<tr>
			<td>IAN</td>
			<td>PREZZO</td>
			<td>PESO</td>
			<td>DESCRIZIONE</td>
			<td>IMMAGINE</td>
			<td>NOME PRODOTTO</td>
		</tr>
		
		<%
		
			String vuoto = null;
			if(prodotti != null && prodotti.size()>0){
				Iterator<?> iterator = prodotti.iterator();
				while(iterator.hasNext()){
					ProdottoBean bean = (ProdottoBean)iterator.next();
		%>
		
			<tr>
				<td><%= bean.getIAN() %></td>
				<td><%= bean.getPrezzo() %></td>
				<td><%= bean.getPeso() %></td>
				<td><%= bean.getDescrizione() %></td>
				<td><img src="" onerror="this.src='img/p.png'" width="40" height="40"></td>
				<td><%= bean.getNomeProdotto().toString() %></td>
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