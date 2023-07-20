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
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>NOME PRODOTTO</td>
			<td>QUANTITA'</td>
			<td>PREZZO</td>
		</tr>
		
		<%
			if(OrdiniView != null && OrdiniView.size()>0){
				Iterator<?> iterator = OrdiniView.iterator();
				while(iterator.hasNext()){
					BigBean bean = (BigBean) iterator.next();
		%>
			<tr>
				<td><%= bean.getNomeProdotto() %></td>
				<td><%= bean.getQuantity() %></td>
				<td><%= bean.getPrice() %></td>
			</tr>
		<%
			}}
		%>
	</table>

</body>
</html>