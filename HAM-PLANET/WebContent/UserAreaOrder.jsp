<%@page import="utils.UtilityClass"%>
<%@page import="model_carta.CartaBean"%>
<%@page import="java.util.*"%>
<%@page import="gestione_funz.CercaCarteClienteBean"%>
<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ClienteBean user = (ClienteBean) session.getAttribute("user"); //campi user
String nCard = (String) session.getAttribute("Ncard1"); //quante carte ha l'user
%>


<!DOCTYPE html>
<html>
<head>
<title>My Area</title>
	<link rel="stylesheet" href="./FileCSS/UserArea.css">
	<script src="./FileJavaScript/UserArea.js"></script>
    <link rel="Website Icon" type="png" href="./Icon/OnlyLogo_RED.svg">
<meta charset="ISO-8859-1">
</head>
<body id=body>

<!-- HEADER -->
<jsp:include page="./Header.jsp"></jsp:include>



<!--CONTENITORE-->
	<div id="contenitore" class="boxArea">

		<!--LEFT BOX-->
		<div class="left">

			<!--PARTE SOPRA-->
			<div class="top">
				<img id="UserIcon" src="./Icon/user_BLACK.png" alt="UserIcon">
				<span><p id="Welcome">Benvenuto</p></span> <span><p id="Nome">
						<%=user.getNome()%>&nbsp;<%=user.getCognome()%>!
					</p></span>
			</div>

			<!--LINEA DIVISORIA-->
			<hr>

			<!--PARTE SOTTO-->
			<div class="down">
				<div class="listSez">
					<ul>
						<a href="UserArea.jsp" id="infPers">Dati Personali</a>
					</ul>
					<ul>
						<a href="UserAreaOrder.jsp" id="order">Ordini</a>
					</ul>
					<ul>
						<a href="./UserAreaCard.jsp" id="creditCard">Carte</a>
						<p id="CarteSalvate"><%=nCard%></p>
					</ul>
					<!-- STRINGA DA RECUPERARE DAL DB -->
				</div>

				<!--BOTTONE LOGOUT-->
				
				
				<!-- <button id="LogOut">Log out</button> -->
				<form id="LogOut" action="LogOutServlet" method="post">
					<input type="submit" value="Log out" >
				</form>
			</div>
		</div>
		
		
		<!--################################   ORDINI  ########################################################################-->
		<div id="two" class="right">

			<!-- TITOLO -->
			<p class="title">Ordini</p>

			<!-- CONTENITORE ORDINI -->
			<div id="boxOrder" class="boxOrdini">
				
					
				<!--  ORDINE 1 -->
				
				<div class="order">

                    <!--PARTE SOPRA ORDINE CON NUMERO, DATA, PRODOTTI-->
                    <div class="parteSopra">
                        <div class="orderID">
                            <p>ID Ordine:</p>
                            <h4>10001</h4>					<!-- NUMERO ORDINE -->
                        </div>


                        <div class="orderData">
                            <p>Ordine effettuato il</p>
                            <h4>07-12-2022</h4>				<!--  DATA DELL'ORDINE -->
                        </div>

                        <div class="orderNumberProduct">
                            <p>Prodotti:</p>
                            <h4>4</h4>						<!-- NUMERO PRODOTTI DELL'ORDINE -->
                        </div>

                    </div>


                    <!--LISTA PRODOTTI-->
                    <div class="listaItem">

                        <hr>
                        
                        
                        
                        
                        <!-- ITEM DEL CARRELLO RIPETERE N VOLTE IN BASE A QUANTI PRODOTTI -->
                        <div class="item">

                            <img class="backgroundOrder" src="" alt="">			<!-- AGGIUNGERE IMMAGINE  -->


                            <!--PARTE SINISTRA-->
                            <div class="leftOrder"></div>

                            <!--PARTE DESTRA-->
                            <div class="rightOrder">
                                <div class="orderRow">
                                    <div class="itemNome">
                                        <h3>Prosciutto Crudo di Bassiano con osso</h3>			<!--  NOME ORDINE -->
                                    </div>

                                    <div class="itemPrezzo">
                                        <h3>&euro;</h3>	
                                        <h3>22,99</h3>					<!-- PREZZO -->
                                    </div>
                                </div>

                                <div class="orderRow2">

                                    <div class="itemDescription">
                                        <p></p>								<!-- DESCRIZIONE -->
                                    </div>

                                    <div class="itemQuantita">
                                        <p>Quantità:</p>
                                        <h4>2</h4>							<!--  QUANTITA    -->
                                    </div>
                                </div>

                            </div>


                        </div>
                        <hr>
                        <hr>

                        
                    </div>

                    <!--PARTE SOTTO ORDINE CON PREZZO-->
                    <div class="parteSotto">
                            
                        <p>Totale &euro;</p>
                        <h4>99,99</h4>				<!--  TOTALE SPESO -->
                        
                    </div>

                </div>
				
			</div>

		</div>


</body>
</html>