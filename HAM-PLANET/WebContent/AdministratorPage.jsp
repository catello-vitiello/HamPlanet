<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PAGINA AMMINISTRATORE</title>
        <link rel="stylesheet" href="./FileCSS/AdministratorPage.css">
        <script type="text/javascript" src="./FileJavaScript/AdministratorPage.js"></script>
    </head>

    <body>

        <p class="titolPage">Administrator Page</p>

        <div class="content">

            <!--######################################### INSERIMENTO PRODOTTO #############################################-->
            <div class="gradientBack">
                <div class="section">
    
                    <p style="color: #7d1e11;">Nuovo Prodotto</p>
                        
                        <!-- FORM PER AGGIUNGERE CAMPI PRODOTTO -->
                    <form class="formNewProduct" action="ProdottoControl" method="post">
                        
                        <div class="row1">
                            <p>IAN</p>
                            <input id="idNP" name="id" type="text" oninput="controlCaracter(0)" required>
                            
                            <p>Nome</p>
                            <input id="nameNP" name="nomeProdotto" type="text" required>
                        </div>
                        
                        <div class="row1">
                            <p>Prezzo</p>
                            <input id="priceNP" name="prezzo" type="text" oninput="controlCaracter(2)" required>
                            
                            <p>Peso</p>
                            <input id="weightNP" name="peso" type="text" oninput="controlCaracter(3)" required>
                        </div>
                        
                        <p style="margin: 1% 0 0.5% 0;">Descrizione</p>
                        <textarea name="descrizione" rows="2" required></textarea>
                        <input type="text" name="servizio" value="insert" hidden>
                        <input type="submit" value="Inserisci Prodotto">
                    </form>
    
                    <!-- PER AGGIUNGERE IMMAGINE -->
                    <form class="formNewProduct" action="AddProsciuttiImg" method="post" enctype="multipart/form-data">
                        <p style="margin: 2% 0 0.5% 0;">Inserisci IAN e immagine del prodotto</p>
                        <div class="row1">
                            <input id="idNP2" name="ianP" type="text" oninput="controlCaracter(1)" required>
                            <input type="file" id="file" name="imageFile" required>
                            <input type="submit" value="Inserisci">
                        </div>
                    </form>
                    
                </div>
            </div>
            
            <!--##################################### VISTA DATI  #########################################################à-->
            
            <div class="gradientBack">
                <div class="section">
                    <p style="color: #7d1e11;">Vista Dati</p>
                    <form id="formView" class="formNewProduct" action="Filter" method="post">
                        <select name="servizio">
                            <option value="cliente">Utenti</option>
                            <option value="prodotto">Prodotti</option>
                        </select>
                        <input type="submit" value="Mostra">
                    </form>
                </div>
            </div>

            <!--####################################### ORDINI PER EMAIL #########################################################à-->
            
            <div class="gradientBack">
                <div class="section">
                    <p style="color: #7d1e11;">Ordini Cliente</p>
                    <form id="formOrder" class="formNewProduct" action="">
                        <select name="emailUser">
                            <option value=""></option>
                        </select> 
                        <input type="submit" value="Mostra">
                    </form>
                </div>
            </div>
            


            <!--######################################## ELIMINAZIONE ##################################################à-->
            <div class="gradientBack">
                <div class="section">
                    <p style="color: #7d1e11;">Eliminazione</p>

					<p>Elimina Account</p>
                    <form id="formDelete" class="formNewProduct" action="ClienteControl" method="post">
                        <div class="row1">
                            <p>Email</p>
                            <input type="text" name="chiave" required>
                            <input type="submit" value="ELIMINA">
                        </div>
                     </form>
				
					<p>Rendi prodotto non disponibile</p>
					<form id="formDelete" class="formNewProduct" action="ProdottoControl" method="post">
                        <div class="row1">
                            <p>IAN</p>
                            <input id="idNP3" name="id" type="text" oninput="controlCaracter(4)" required>
                            <input type="text" name="servizio" value="elimina" hidden>
                            <input type="submit" value="RENDI NON DISPONIBILE">
                        </div>
                    </form>

                </div>
            </div>

          </div>  

    </body>
</html>
