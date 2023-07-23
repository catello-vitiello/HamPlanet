<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodottiByCategory");
	if(prodotti == null){
		response.sendRedirect("/Store.jsp");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
    <head>
        <title>Lista prodotti</title>
        <link rel="stylesheet" href="./FileCSS/Store.css">
        <link rel="Website Icon" type="png" href="./Icon/OnlyLogo_RED.svg"> 

    </head>

    <body>
    
        <!-- HEADER -->
    	<jsp:include page="./Header.jsp"></jsp:include>



            <div class="content">
            
                <!-- TITOLO DEL CARRELLO -->
                <div class="titleStore">
                    <p class="storeTitle">Store</p>
                    <hr>
                </div>
            
            
                
                <div class="prodotti">
            
            	<%
					if(prodotti != null && prodotti.size()>0){
					Iterator<?> iterator = prodotti.iterator();
					while(iterator.hasNext()){
						ProdottoBean bean = (ProdottoBean)iterator.next();
				%>
            
            
                    <!-- ITEM -->
                    <div class="formedItem">
            
                        <form class="formItem" action="SingleProductServlet" method="post">
                            
                            <img src="./ImageProductServlet?id=<%= bean.getIAN() %>" onerror="this.src='img/p.png'" width="40" height="40">
            
                            <input type="text" name="ianProdotto" value="<%= bean.getIAN() %>" hidden>
                            
                            <div class="rowItem">
                                <p class="nomeItem"><%= bean.getNomeProdotto() %></p>
                                <p class="priceItem"><%= bean.getPrezzo() %>&euro;</p>
                            </div>
            
                            <input type="submit" value="">
                            
                        </form>
                        
                    </div> 
            		<%}} %>
            
                </div>
            
                
                


                <hr>
                
                <!-- FOOTER -->
    			<jsp:include page="./Footer.jsp"></jsp:include>
                
            </div>
    </body>
</html>