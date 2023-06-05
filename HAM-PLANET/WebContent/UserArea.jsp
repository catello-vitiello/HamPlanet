<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ClienteBean user = (ClienteBean) session.getAttribute("user");
	String nCard = request.getAttribute("Ncard").toString();

	if (user == null){
		response.sendRedirect("Admin.html");
		return;
	}
%>

<!DOCTYPE html>

<html>

    <head>
        <title></title>
        <link rel="stylesheet" href="./FileCSS/UserArea.css">
        <script src="./FileJavaScript/UserArea.js"></script>
    </head>

    <body id="body">

        <!--CONTENITORE-->
        <div class="boxArea">

            <!--LEFT BOX-->
            <div class="left">

                <!--PARTE SOPRA-->
                <div class="top">
                    <img id="UserIcon" src="./Icon/user_BLACK.png" alt="UserIcon">
                    <span><p id="Welcome">Benvenuto</p></span>
                    <span><p id="Nome"> <%= user.getNome() %>&nbsp;<%= user.getCognome() %>!</p></span>
                </div>

                <!--LINEA DIVISORIA-->
                <hr>

                <!--PARTE SOTTO-->
                <div class="down">
                    <div class="listSez">
                        <ul><button id="infPers" onclick="changePage(0)">Dati Personali</button></ul>
                        <ul><button id="order" onclick="changePage(1)">Ordini</button></ul>
                        <ul><button id="creditCard" onclick="changePage(2)">Carte</button><p id="CarteSalvate"><%= nCard %></p></ul>   <!-- STRINGA DA RECUPERARE DAL DB -->
                    </div>

                    <!--BOTTONE LOGOUT-->
                    <button id="LogOut">Log out</button>
                </div>
            </div>

    



<!--################################   DETTAGLI PERSONALI  ########################################################################àà-->
            <div id="one" class="right">
                <p class="title">&nbsp;Dati Personali&nbsp;</p>

                <div class="top">

                    <div class="rigo">
                        
                        <!--Nome-->
                        <div class="boxCampi">
                            <!--Icona Campo-->
                            <img class="Icon" src="./Icon/userLittle_BLACK.png" alt="Nome">
                            <div class="boxTitVal">

                                <!--Titolo-->
                                <p>Nome</p>
                                <!--Valore-->
                                <p> <%= user.getNome() %>&nbsp;<%= user.getCognome() %></p>
                            </div>

                        </div>


                        <!--Data di Nascita-->
                        <div class="boxCampi">

                            <!--Icona Campo-->
                            <img class="Icon" src="./Icon/calendar_BLACK.png" alt="Data">
                            <div class="boxTitVal">

                                <!--Titolo-->
                                <p>Data di nascita</p>
                                <!--Valore-->
                                <p><%= user.getData_nascita() %></p>
                            </div>

                        </div>
                
                    </div>


                <div class="rigo">
                    <!--Numero di telefono-->
                    <div class="boxCampi">
                      <!--Icona Campo-->
                        <img class="Icon" src="./Icon/phone_BLACK.png" alt="Numero">
                        <div class="boxTitVal">

                            <!--Titolo-->
                            <p>Numero di telefono</p>
                            <!--Valore-->
                            <p> <%= user.getCellulare().substring(0, 3) %>&nbsp;<%= user.getCellulare().substring(3, 6) %>&nbsp;<%= user.getCellulare().substring(6) %></p>
                        </div>

                        <!--Icona Matita-->
                        <img class="IconPencil" onclick="changeValue()" src="./Icon/pencil.png" alt="Modify">
                    </div>


                    <!--Sesso-->
                    <div class="boxCampi">

                        <!--Icona Campo-->
                        <img class="Icon" src="./Icon/defaultMaleFemale_BLACK.png" alt="Sesso">
                        <div class="boxTitVal">

                            <!--Titolo-->
                            <p>Sesso</p>
                            <!--Valore-->
                            <p> 
                            	<% if(user.getSesso() == 'M') {	%>
                            		Uomo
                            	<% } else if (user.getSesso() == 'F') {%>
                            		Donna
                            	<%} else {%>
                            		-
                            	<% } %>
                            </p>
                        </div>

                    </div>
                </div>

                </div>

                <!--BARRA-->
                <hr id="hr1">

                <div class="down">


                    <div class="rigo">

                    <!--email-->
                    <div class="boxCampi">
                        <!--Icona Campo-->
                        <img class="Icon" src="./Icon/email_default_BLACK.png" alt="Email">
                        <div class="boxTitVal">

                            <!--Titolo-->
                            <p>Email</p>
                            <!--Valore-->
                            <p> <%= user.getEmail() %> </p>
                        </div>

                    </div>


                    <!--password-->
                    <div class="boxCampi">

                        <!--Icona Campo-->
                        <img class="Icon" src="./Icon/key_BLACK.png" alt="pass">
                        <div class="boxTitVal">

                            <!--Titolo-->
                            <p>Password</p>
                            <!--Valore-->
                            <p>****************</p>
                        </div>

                        <!--Icona Matita-->
                        <img class="IconPencil" onclick="changeValue()" src="./Icon/pencil.png" alt="Modify">
                    </div>
                
                    </div>


                <div class="rigo">
                    <!--Indirizzo-->
                    <div class="boxAddress">
                      <!--Icona Campo-->
                        <img class="Icon" src="./Icon/position_BLACK.png" alt="Position">
                        <div class="boxVia">

                            <!--Titolo-->
                            <p>Via</p>
                            <!--Valore-->
                            <p><%= user.getIndirizzo() %></p>
                        </div>

                        <div class="boxPaese">

                            <!--Titolo-->
                            <p>Paese</p>
                            <!--Valore-->
                            <p><%= user.getPaese() %></p>
                        </div>

                        <div class="boxProv">

                            <!--Titolo-->
                            <p>Provincia</p>
                            <!--Valore-->
                            <p><%= user.getProvincia() %></p>
                        </div>

                        <div class="boxCap">

                            <!--Titolo-->
                            <p>Cap</p>
                            <!--Valore-->
                            <p><%= user.getCap() %></p>
                        </div>

                        <!--Icona Matita-->
                        <img class="IconPencil" onclick="changeValue()" src="./Icon/pencil.png" alt="Modify">
                    </div>


                    
                </div>
                    
                </div>

            </div>

<!--################################   ORDINI  ########################################################################-->
            <div id="two" class="right">
           		
           		<!-- TITOLO -->
           		<p class="title">Ordini</p>

				<!-- CONTENITORE ORDINI -->
            	<div id="boxOrder" class="boxOrdini"></div>

            </div>

<!--################################   CARTE  ########################################################################-->
            <div id="three" class="right">
            
            	<!-- TITOLO -->
                <p class="title">Carte</p>

				<!-- CONTENITORE OGGETTI -->
                <div id="contenitoreCarte" class="boxCarte">


                </div>
                
            </div>

    </body>

</html>