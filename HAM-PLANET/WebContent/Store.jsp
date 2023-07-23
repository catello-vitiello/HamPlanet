<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Store Ham Planet</title>
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
            
                    <!-- ITEM -->
                    <div class="formedItem">
            
                        <form class="formItem" action="">
                            
                            <img src="" alt="">
            
                            <input type="text" name="" id="" value="1" hidden>
                            
                            <div class="rowItem">
                                <p class="nomeItem">Cocco Bello</p>
                                <p class="priceItem">10.99&euro;</p>
                            </div>
            
                            <input type="submit" value="">
                            
                        </form>
                        
                    </div> 
            
            
                </div>
            
                
                


                <hr>
                
                <!-- FOOTER -->
    			<jsp:include page="./Footer.jsp"></jsp:include>
                
            </div>
    </body>
</html>