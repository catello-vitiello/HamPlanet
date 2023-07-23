<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                    <img src="" alt="image">				<!-- INSERIRE IMMAGINE DEL PRODOTTO CHE VIENE CLICCATO -->
                </div>

                <!-- CAMPI DEL PRODOTTO -->
                <div class="descriptionProduct">

                    <form class="formProduct" action="">
                        
                        <div class="gradientBorder">

                            
                            <div class="titoloDescr">
                                
                                <h1>Cappellino davvero carino</h1>
                                
                                <hr>
                                
                                <p>Questo è il cappellino di che carino</p>
                                
                            </div>
                            
                            <div class="priceSubmit">
                                
                                <div class="row">
                                <p id="weight">18,00 Kg</p>
                                <p id="price">54,99 &euro;</p>
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