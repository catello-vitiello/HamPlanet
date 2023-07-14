<%@page import="java.util.Collection"%>
<%@page import="gestione_funz.CercaCarteClienteBean"%>
<%@page import="model_cliente.ClienteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ClienteBean user = (ClienteBean) session.getAttribute("user");
String nCard = request.getAttribute("Ncard").toString();
Collection<?> listaCarte = (Collection<?>) request.getAttribute("carte");

if (user == null) {
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




	<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CAMPI PER MODIFICARE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->

	<!-- MODIFICARE NUMERO -->
	<div id="modifyNumber">
		<form id="formModifyNumber" method="post" action="">

			<!-- BOTTONE PER CHIUDERE LA MODIFICA -->
			<img id="annullOperation_0" onclick="resizeWindow(event, 0, 'annul')"
				src="./Icon/x_V2.png" alt="">

			<!-- TITOLO -->
			<p id="titleModify0">Inserisci il nuovo numero</p>


			<!--NUMERO DI TELEFONO-->
			<div class="inputbox">
				<input id="tel" oninput="controlCaracter(0)" type="text"
					minlength="9" maxlength="10" name="cellulare" autocomplete="off"
					required>
			</div>

			<!-- BOTTONE INVIO -->
			<button id="buttonInvio_0" class="buttonSubmitModify"
				onclick="resizeWindow(event, 0, 'submit')" type="submit">Invio</button>

		</form>
	</div>

	<!-- MODIFICARE PASSWORD -->
	<div id="modifyPass">
		<form id="formModifyPass" method="post" action="">

			<!-- BOTTONE PER CHIUDERE LA MODIFICA -->
			<img id="annullOperation_1" onclick="resizeWindow(event, 1, 'annul')"
				src="./Icon/x_V2.png" alt="">

			<!-- TITOLO -->
			<p id="titleModify1">Modifica Password</p>


			<!-- VECCHIA PASSWORD -->
			<div class="inputbox">
				<input id="pass0" oninput="controlCaracter(1)" type="password"
					name="lastPass" autocomplete="off" required> <label for="">Vecchia
					Password</label> <img id="eyesIcon0" class="img_pass"
					src="./Icon/eyes_hidden_WHITE.png" alt="show" onclick="showPwd(0)">
				<p id="mess0">manca valore</p>
			</div>

			<hr>

			<!-- NUOVA PASSWORD -->
			<div class="inputbox">
				<input id="pass1" oninput="controlCaracter(1)"
					onfocus="attribRequest()" onblur="attribRequestHidden()"
					type="password" name="newPass" autocomplete="off" required>
				<label for="">Nuova Password</label> <img id="eyesIcon1"
					class="img_pass" src="./Icon/eyes_hidden_WHITE.png" alt="show"
					onclick="showPwd(1)">
				<p id="mess1"></p>
			</div>

			<!-- CONFERMA PASSWORD -->
			<div class="inputbox">
				<input id="pass2" oninput="controlCaracter(1)" type="password"
					name="confPass" autocomplete="off" required> <label for="">Conferma
					Password</label> <img id="eyesIcon2" class="img_pass"
					src="./Icon/eyes_hidden_WHITE.png" alt="show" onclick="showPwd(2)">
				<p id="mess2"></p>
			</div>

			<div id="ToDoList">
				<p id="passTit">La tua password deve avere:</p>

				<p id="lunghezza">minimo 8 caratteri</p>
				<p id="number">almeno un numero</p>
				<p id="special">almeno un carattere speciale</p>
				<p id="uppercase">almeno una lettera maiuscola</p>

				<p id="securityTit">Sicurezza:</p>
				<div class="progress">
					<div id="progress-done"></div>
				</div>
				<p id="evitTit">Evita password semplici da indovinare o usate in
					altri siti web.</p>
			</div>

			<!-- BOTTONE INVIO -->
			<button id="buttonInvio_1" class="buttonSubmitModify"
				onclick="resizeWindow(event, 1, 'submit')" type="submit">Invio</button>

		</form>
	</div>


	<!-- MODIFICARE INDIRIZZO -->
	<div id="modifyAddress">
		<form id="formModifyAddress" method="post" action="">

			<!-- BOTTONE PER CHIUDERE LA MODIFICA -->
			<img id="annullOperation_2"
				onclick="submitModifyAddress(event, 'annul')"
				src="./Icon/x_V2.png" alt="">

			<!-- TITOLO -->
			<p id="titleModify2">Modifica Indirizzo</p>

			<!--VIA-->
			<div class="inputbox">
				<input id="via" oninput="controllAddressField(0)" autocomplete="off"
					type="text" name="Indirizzo" required> <label for="">Via</label>
			</div>
			<div class="inputboxNC">

				<!--PAESE-->
				<div class="inputbox">
					<input id="paese" oninput="controllAddressField(1)"
						autocomplete="off" type="text" name="paese" name="" required>
					<label for="">Paese</label>
				</div>

				&nbsp;&nbsp;

				<!--PROVINCIA-->
				<div class="inputbox">
					<input id="provincia" oninput="controllAddressField(2)"
						autocomplete="off" type="text" name="provincia" maxlength="2"
						required> <label for="">Provincia</label>
				</div>

				&nbsp;&nbsp;

				<!--CAP-->
				<div class="inputbox">
					<input id="cap" oninput="controllAddressField(3)"
						autocomplete="off" type="text" name="cap" maxlength="5" required>
					<label for="">Cap</label>
				</div>
			</div>

			<!-- BOTTONE INVIO -->
			<button id="buttonInvio_2" class="buttonSubmitModify"
				onclick="submitModifyAddress(event, 'submit')" type="submit">Invio</button>

		</form>
	</div>
	
	
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

             <form id="formForCard" class="frm" action="">

                <!-- NUMERO CARTA -->
                <div class="inputboxNumber">
                    <input id="inputNewNumber" type="text" maxlength="16" oninput="addTextToCard(0)" required>
                    <div class="textInputbox">
                        <label class="labelCard" for="">Numero Carta</label>
                    </div>
                </div>

                
                <!-- PROPRIETARIO -->
                <div class="inputboxNumber">
                    <input id="inputNewOwner" type="text" maxlength="25" oninput="addTextToCard(1)" style="text-transform: capitalize;" required>
                    <div class="textInputbox">
                        <label class="labelCard" for="">Proprietario</label>
                    </div>
                </div>
                
                <!-- CONTENITORE RIGO -->
                <div class="containerMAC">

                    <!-- MESE -->
                    <div class="inputboxMAC">
                        <input id="inputNewMonth" type="text" maxlength="2" oninput="addTextToCard(2)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">Mese</label>
                        </div>
                    </div>


                    <!-- ANNO -->
                    <div class="inputboxMAC">
                        <input id="inputNewYear" type="text" maxlength="2" oninput="addTextToCard(3)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">Anno</label>
                        </div>
                    </div>


                    <!-- CVV -->
                    <div class="inputboxMAC">
                        <input id="inputNewCvv" type="text" maxlength="4" onfocus="changeFront(1)" onblur="changeFront(0)" oninput="addTextToCard(4)" required>
                        <div class="textInputbox">
                            <label class="labelCard" for="">CVV</label>
                        </div>
                    </div>


                </div>

                 <!-- BOTTONE INVIO -->
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
						<button id="infPers" onclick="changePage(0)">Dati
							Personali</button>
					</ul>
					<ul>
						<button id="order" onclick="changePage(1)">Ordini</button>
					</ul>
					<ul>
						<button id="creditCard" onclick="changePage(2)">Carte</button>
						<p id="CarteSalvate"><%=nCard%></p>
					</ul>
					<!-- STRINGA DA RECUPERARE DAL DB -->
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
							<p>
								<%=user.getNome()%>&nbsp;<%=user.getCognome()%></p>
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
							<p><%=user.getData_nascita()%></p>
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
							<p>
								<%=user.getCellulare().substring(0, 3)%>&nbsp;<%=user.getCellulare().substring(3, 6)%>&nbsp;<%=user.getCellulare().substring(6)%></p>
						</div>

						<!--Icona Matita-->
						<img id="matita0" class="IconPencil" onclick="changeValue(0)"
							src="./Icon/pencil.png" alt="Modify">
					</div>


					<!--Sesso-->
					<div class="boxCampi">

						<!--Icona Campo-->
						<img class="Icon" src="./Icon/defaultMaleFemale_BLACK.png"
							alt="Sesso">
						<div class="boxTitVal">

							<!--Titolo-->
							<p>Sesso</p>
							<!--Valore-->
							<p>
								<%
								if (user.getSesso() == 'M') {
								%>
								Uomo
								<%
								} else if (user.getSesso() == 'F') {
								%>
								Donna
								<%
								} else {
								%>
								-
								<%
								}
								%>
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
							<p>
								<%=user.getEmail()%>
							</p>
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
						<img id="matita1" class="IconPencil" onclick="changeValue(1)"
							src="./Icon/pencil.png" alt="Modify">
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
							<p><%=user.getIndirizzo()%></p>
						</div>

						<div class="boxPaese">

							<!--Titolo-->
							<p>Paese</p>
							<!--Valore-->
							<p><%=user.getPaese()%></p>
						</div>

						<div class="boxProv">

							<!--Titolo-->
							<p>Provincia</p>
							<!--Valore-->
							<p><%=user.getProvincia()%></p>
						</div>

						<div class="boxCap">

							<!--Titolo-->
							<p>Cap</p>
							<!--Valore-->
							<p><%=user.getCap()%></p>
						</div>

						<!--Icona Matita-->
						<img id="matita2" class="IconPencil" onclick="changeValue(2)"
							src="./Icon/pencil.png" alt="Modify">
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
			<div id="contenitoreCarte" class="boxCarte"></div>

		</div>
</body>

</html>