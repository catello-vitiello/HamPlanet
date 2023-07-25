<%@page import="model_bigBean.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	Collection<?> OrdiniView = (Collection<?>) request.getAttribute("OrdiniView");
    	if(OrdiniView == null){
    		response.sendRedirect("ShowOrderByEmail");
    		return;
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VISTA ORDINI CLIENTE</title>
<link href="VisualizzazioneView.css" rel="stylesheet" type="text/css">
</head>
<body>

	<table>
		<tr>
			<td>NOME PRODOTTO</td>
			<td>QUANTIT&Aacute;</td>
			<td>PREZZO</td>
			<td>ID ORDINE</td>
			<td>TOT</td>
		</tr>
		
		<%
			double tot = 0;
			if(OrdiniView != null && OrdiniView.size()>0){
				Iterator<?> iterator = OrdiniView.iterator();
				while(iterator.hasNext()){
					BigBean bean = (BigBean) iterator.next();
					tot+=bean.getPrice();
		%>
			<tr>
				<td><%= bean.getNomeProdotto() %></td>
				<td><%= bean.getQuantity() %></td>
				<td><%= bean.getPrice() %></td>
				<td><%= bean.getId() %></td>
				<td>-</td>
			</tr>
		<%
			}}
		%>
		<tr>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td><%= tot %></td>
			</tr>
	</table>

	<hr>
	<p align="center">
	<form action="GetEmailCliente" method="post">
		<input type="text" name="valore" value="admin" hidden>
		<input type="submit" value="BACK">
	</form>
</body>
</html>