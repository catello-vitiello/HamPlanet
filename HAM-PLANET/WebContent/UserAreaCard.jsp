<%@page import="utils.UtilityClass"%>
<%@page import="model_carta.CartaBean"%>
<%@page import="java.util.*"%>
<%@page import="gestione_funz.CercaCarteClienteBean"%>
<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ClienteBean user = (ClienteBean) session.getAttribute("user");
if(user == null){
	response.sendRedirect("Login.jsp");
	return;
}
String nCard = (String) session.getAttribute("Ncard1"); //quante carte ha l'user
UtilityClass.print("Carte dell'utente: " + nCard);
LinkedList<?> listaCarte1 = (LinkedList<?>) getServletContext().getAttribute("ListaCarte0"); //lista delle carte registrate dell'utente
if(listaCarte1 == null){
	response.sendRedirect("/PrintCreditCard");
	return;
}
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



<!--############################### AGGIUNTA CARTA ##############################-->
    <div id="boxNewCard">

        <!-- BOTTONE PER CHIUDERE LA MODIFICA -->
        <img id="annullOperation_3" onclick="closeWindowCard(event, 'annul')" src="./Icon/x_V2.png" alt="">

        <div id="cardMod">



            <!-- FRONTE CARTA -->
            <div id="frontCard">
                <div id="contentNewCard">
                    
                    <!-- NUMERO CARTA -->
                    <div class="rowNumber">
                        <p id="newNumber">&nbsp;</p>
                    </div>
    
    
                    <div class="rowNC">
    
                        <!-- PROPRIETARIO -->
                        <div class="boxOwner">
                            <label for="">Card Holder</label>
                            <p id="newOwner">&nbsp;</p>
                        </div>
    
                        <!-- DATA SCADENZA -->
                        <div class="boxExpiration">
                            <label for="">Expires</label>
                            <p id="newExpiration">&nbsp;</p>
                        </div>
    
    
                    </div>

                </div>
                
            </div>

            <!-- RETRO CARTA -->
            <div id="backCard">

                <!-- CVV -->
                <div class="boxCVV">
                    <p id="newCVV"></p>
                </div>

            </div>
            
        </div>
        
        <!-- INSERIMENTO CAMPI -->
        <div id="formNewCard">

             <form id="formForCard" class="frm" action="CartaControl" method="post">

                <!-- NUMERO CARTA -->
                <div class="inputboxNumber">
                    <input id="inputNewNumber" name="numeroCarta" type="text" maxlength="16" oninput="addTextToCard(0)" required>
                    <div class="textInputbox">
                        <label class="labelCard" for="">Numero Carta</label>
                    </div>
                </div>

                
                <!-- PROPRIETARIO -->
                <div class="inputboxNumber">
                    <input id="inputNewOwner" name="proprietario" type="text" maxlength="25" oninput="addTextToCard(1)" style="text-transform: capitalize;" required>
                    <div class="textInputbox">
                        <label class="labelCard" for="">Proprietario</label>
                    </div>
                </div>
                
                <!-- CONTENITORE RIGO -->
                <div class="containerMAC">

                    <!-- MESE -->
                    <div class="inputboxMAC">
                        <input id="inputNewMonth" name="mese" type="text" maxlength="2" oninput="addTextToCard(2)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">Mese</label>
                        </div>
                    </div>


                    <!-- ANNO -->
                    <div class="inputboxMAC">
                        <input id="inputNewYear" name="anno" type="text" maxlength="2" oninput="addTextToCard(3)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">Anno</label>
                        </div>
                    </div>


                    <!-- CVV -->
                    <div class="inputboxMAC">
                        <input id="inputNewCvv" name="cvv" type="text" maxlength="4" onfocus="changeFront(1)" onblur="changeFront(0)" oninput="addTextToCard(4)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">CVV</label>
                        </div>
                    </div>


                </div>

                 <!-- BOTTONE INVIO -->
                 <input type="text" name="op" value="insert" hidden>
                 <input type="text" name="email" value="<%= user.getEmail() %>" hidden>
                 <input type="text" name="pass" value="<%= user.getPass() %>" hidden>
                 <input id="buttonAddCard" class="buttonSubmitModify" onclick="closeWindowCard(event, 'submit')" type="submit" value="Aggiungi carta">
           
             </form>

            
        </div>

    </div>
    
    
    
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
						<a href="UserArea.jsp" id="infPers" style="font-weight: 400;">Dati Personali</a>
					</ul>
					<ul>
						<a href="UserAreaOrder.jsp" id="order" style="font-weight: 400;">Ordini</a>
					</ul>
					<ul>
						<a href="./UserAreaCard.jsp" id="creditCard" style="font-weight: 800;">Carte</a>
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
		
		
		<!--################################   CARTE  ########################################################################-->
		<div id="three" class="right">

			<!-- TITOLO -->
			<p class="title">Carte</p>

			<!-- CONTENITORE OGGETTI -->
			<div id="contenitoreCarte" class="boxCarte">
			
				<%
				if(listaCarte1 != null && listaCarte1.size()>0){
				Iterator<?> iterator = listaCarte1.iterator();
				while(iterator.hasNext()){
					CercaCarteClienteBean bean = (CercaCarteClienteBean)iterator.next();
				%>
				
			
				<!--CARTA 1-->
                    <div id="cardN1" class="card">

						<!-- ######################### DELETE CARD	################################################ -->
                        <form class="formDelete" action="CartaControl" method="post">
                            <input class="shadowCampi" type="text" name="op" value="delete" hidden>

                            <input class="shadowCampi" type="text" name="NumeroCarta" value="<%= bean.getNc() %>" hidden>

                            <img id="cardN1_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)"
                                src="./Icon/X_V1.png" alt="X">
                                
                             <input class="shadowCampi" type="text" name="email" value="<%= user.getEmail() %>" hidden>
                             <input class="shadowCampi" type="text" name="pass" value="<%= user.getPass() %>" hidden>
                            <input type="submit">
                        </form>

                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p class="numberCard"><%= bean.getNc() %></p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p class="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p class="owner"><%= bean.getTitolare() %></p>

                                    <!--SCRITTA VALID THRU-->
                                    <p class="valid">VALID<br>THRU</p>

                                    <!--DATA SCADENZA-->
                                    <p class="expiration"><%= bean.getScadenza() %></p>
                                </div>
                            </div>
                        </div>
                    </div>

					<%}} %>

					<!-- #############  FORM NUOVA CARTA  ############# -->
                    <div class="addCard" onclick="addCard()"></div>
				
			
			</div>
			
		</div>
    
	



</body>
</html>