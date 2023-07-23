<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	ProdottoBean bean = (ProdottoBean) request.getAttribute("ProdottoBean");
	if(bean == null){
		response.sendRedirect("/HomePage.jsp");
		return;
	}
%>
    
<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
        <link rel="stylesheet" href="./FileCSS/ViewProduct.css">
    </head>

    <body>

        <!-- HEADER -->
    	<jsp:include page="./Header.jsp"></jsp:include>
    	       
		<div class="content">
            <div class="prodotto">
               
                <!-- IMMAGINE DEL PRODOTTO-->
                <div class="imageProduct">
                    <img src="./ImageProductServlet?id=<%= bean.getIAN() %>" onerror="this.src='img/p.png'" width="40" height="40">				<!-- INSERIRE IMMAGINE DEL PRODOTTO CHE VIENE CLICCATO -->
                </div>

                <!-- CAMPI DEL PRODOTTO -->
                <div class="descriptionProduct">

                    <form class="formProduct" action="">
                        
                        <div class="gradientBorder">

                            
                            <div class="titoloDescr">
                                
                                <h1><%= bean.getNomeProdotto() %></h1>
                                
                                <hr>
                                
                                <p><%= bean.getDescrizione() %></p>
                                
                            </div>
                            
                            <div class="priceSubmit">
                                
                                <div class="row">
                               		<% if((bean.getTipo().equals("gadget")) == false){ %>
                                		<p id="weight"><%= bean.getPeso() %> Kg</p>
                                	<% }else{ %>
                               			<p id="weight">GADGET</p>
                               		<%} %>
                                <p id="price"><%= bean.getPrezzo() %> &euro;</p>                          
                            </div>
                       
                            <input type="submit" name="" id="" value="Aggiungi al carrello">
                            
                            <p >La quantit&agrave; del prodotto &egrave; modificabile direttamente al carrello.</p>
                        </div>
                        
                    </div>
                    </form>
                </div>
            </div>
			
            <!-- FOOTER -->
    		<jsp:include page="./Footer.jsp"></jsp:include>

        </div>           
        
        
    </body>
</html>