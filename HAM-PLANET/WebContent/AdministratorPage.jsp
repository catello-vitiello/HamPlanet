<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PAGINA AMMINISTRATORE</title>
        <link rel="stylesheet" href="../FileCSS/AdministratorPage.css">
        <script type="text/javascript" src="../FileJavaScript/AdministratorPage2.js"></script>
    </head>

    <body>

        <p class="titolPage">Administrator Page</p>

        <div class="content">

            <!--######################################### INSERIMENTO PRODOTTO #############################################-->
            <div class="gradientBack">
                <div class="section">
    
                    <p style="color: #7d1e11;">Nuovo Prodotto</p>
                        
                        <!-- FORM PER AGGIUNGERE CAMPI PRODOTTO -->
                    <form class="formNewProduct" action="">
                        
                        <div class="row1">
                            <p>IAN</p>
                            <input id="idNP" type="text" oninput="controlCaracter(0)" required>
                            
                            <p>Nome</p>
                            <input id="nameNP" type="text" required>
                        </div>
                        
                        <div class="row1">
                            <p>Prezzo</p>
                            <input id="priceNP" type="text" oninput="controlCaracter(2)" required>
                            
                            <p>Peso</p>
                            <input id="weightNP" type="text" oninput="controlCaracter(3)" required>
                        </div>
                        
                        <p style="margin: 1% 0 0.5% 0;">Descrizione</p>
                        <textarea name="descrizione" rows="2" required></textarea>
                        <button>Invia</button>
                    </form>
    
                    <!-- PER AGGIUNGERE IMMAGINE -->
                    <form class="formNewProduct" action="">
                        <p style="margin: 2% 0 0.5% 0;">Inserisci IAN e immagine del prodotto</p>
                        <div class="row1">
                            <input id="idNP2" type="text" oninput="controlCaracter(1)" required>
                            <input type="file" id="file" accept=".jpeg, .jpg, .png" required>
                            <button>Invia</button>
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

                    <form id="formDelete" class="formNewProduct" action="">

                        <p>Elimina Account</p>
                        <div class="row1">
                            <p>Email</p>
                            <input type="text" required>
                            <button>Elimina</button>
                        </div>

                        <p>Elimina Prodotto</p>
                        <div class="row1">
                            <p>IAN</p>
                            <input id="idNP3" type="text" oninput="controlCaracter(4)" required>
                            <button>Elimina</button>
                        </div>
                        
                    </form>

                </div>
            </div>

            
        </div>
    </body>
</html>
