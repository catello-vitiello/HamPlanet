<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ClienteBean user = (ClienteBean) session.getAttribute("user");

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
                        <ul><button id="infPers" onclick="changePage(0)">Informazioni Personali</button></ul>
                        <ul><button id="order" onclick="changePage(1)">Ordini</button></ul>
                        <ul><button id="creditCard" onclick="changePage(2)">Carte</button><p id="CarteSalvate">6</p></ul>   <!-- STRINGA DA RECUPERARE DAL DB -->
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
                                <p>23-05-2000</p>
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
                            <p>Via Roma</p>
                        </div>

                        <div class="boxPaese">

                            <!--Titolo-->
                            <p>Paese</p>
                            <!--Valore-->
                            <p>Roma</p>
                        </div>

                        <div class="boxProv">

                            <!--Titolo-->
                            <p>Provincia</p>
                            <!--Valore-->
                            <p>RO</p>
                        </div>

                        <div class="boxCap">

                            <!--Titolo-->
                            <p>Cap</p>
                            <!--Valore-->
                            <p>00100</p>
                        </div>

                        <!--Icona Matita-->
                        <img class="IconPencil" onclick="changeValue()" src="./Icon/pencil.png" alt="Modify">
                    </div>


                    
                </div>
                    
                </div>

            </div>

<!--################################   ORDINI  ########################################################################-->
            <div id="two"  class="right">
                <p class="title">Ordini</p>
            </div>

<!--################################   CARTE  ########################################################################-->
            <div id="three" class="right">
                <p class="title">Carte</p>

                <!--Numero Carte-->
                <div class="boxNumCard">
                    <p>Carte Registrate:&nbsp;&nbsp;</p><p id="CarteSalvate">6</p>
                </div>

        
                <div id="contenitoreCarte" class="boxCarte">



                    <!--CARTA 1-->
                    <div id="cardN1" class="card">
                        <img id="cardN1_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>    
                    </div>

                    <!--CARTA 2-->
                    <div id="cardN2" class="card">
                        <img id="cardN2_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>   
                    </div>

                    <!--CARTA 3-->
                    <div id="cardN3" class="card">
                        <img id="cardN3_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>   
                    </div>

                    <!--CARTA 4-->
                    <div id="cardN4" class="card">
                        <img id="cardN4_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>   
                    </div>

                    <!--CARTA 5-->
                    <div id="cardN5" class="card">
                        <img id="cardN5_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>   
                    </div>

                    <!--CARTA 6-->
                    <div id="cardN6" class="card">
                        <img id="cardN5_remove" class="iconRemoveCard" onclick="confermaEliminazione(this)" src="./Icon/removeX_RED.png" alt="X">
                        <div class="content">

                            <!--NUMERO CARTA-->
                            <p id="numberCard">****  ****  ****  1234</p>
                            <div class="NameExpiration">

                                <!--SCRITTA MESE/ANNO-->
                                <p id="monthyear">MESE/ANNO</p>
                                <div class="row">

                                    <!--COGNOME NOME-->
                                    <p id="owner">COGNOME NOME</p>
                                    
                                    <!--SCRITTA VALID THRU-->
                                    <p id="valid">VALID<br>THRU</p>
                                    
                                    <!--DATA SCADENZA-->
                                    <p id="expiration">00/00</p>
                                </div>
                            </div>
                        </div>   
                    </div>


                    <div class="addCard" onclick="addCard()"></div>

                </div>
                
            </div>

    </body>

</html>