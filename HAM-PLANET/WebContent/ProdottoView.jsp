<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	Collection<?> prodotti_no = (Collection<?>) request.getAttribute("prodotti_no");
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
			<td>TIPOLOGIA PRODOTTO</td>
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
				<td><img src="./ImageProductServlet?id=<%= bean.getIAN() %>" onerror="this.src='img/p.png'" width="40" height="40"></td>
				<td><%= bean.getNomeProdotto().toString() %></td>
				<td><%= bean.getTipo().toString() %></td>
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
	
	<!-- VISUALIZZA PRODOTTI NON IN VENDITA -->
	<hr>
	
		<h1>LISTA PRODOTTI NON DISPONIBILI</h1>
	<table>
		<tr>
			<td>IAN</td>
			<td>PREZZO</td>
			<td>PESO</td>
			<td>DESCRIZIONE</td>
			<td>IMMAGINE</td>
			<td>NOME PRODOTTO</td>
			<td>TIPOLOGIA PRODOTTO</td>
		</tr>
		
		<%
		
			if(prodotti_no != null && prodotti_no.size()>0){
				Iterator<?> iterator = prodotti_no.iterator();
				while(iterator.hasNext()){
					ProdottoBean bean = (ProdottoBean)iterator.next();
		%>
		
			<tr>
				<td><%= bean.getIAN() %></td>
				<td><%= bean.getPrezzo() %></td>
				<td><%= bean.getPeso() %></td>
				<td><%= bean.getDescrizione() %></td>
				<td><img src="./ImageProductServlet?id=<%= bean.getIAN() %>" onerror="this.src='img/p.png'" width="40" height="40"></td>
				<td><%= bean.getNomeProdotto().toString() %></td>
				<td><%= bean.getTipo().toString() %></td>
			</tr>
		
		<%
				}
			} else {
		%>
		
			<tr>
				<td colspan="3">NON CI SONO PRODOTTI NON IN VENDITA</td>
			</tr>
		
		<%
			}
		%>
	</table>
	
	<hr>
	<p align="center">
	<form action="GetEmailCliente" method="post">
		<input type="text" name="valore" value="admin" hidden>
		<input type="submit" value="BACK">
	</form>
	
</body>
</html>