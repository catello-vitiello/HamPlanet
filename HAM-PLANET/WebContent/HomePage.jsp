<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>Ham Planet Home</title>
        <link rel="stylesheet" href="./FileCSS/HomePage.css">
        <script type="text/javascript" src="./FileJavaScript/HomePage.js"></script>
</head>
<body>

	
	<!-- HEADER -->
    <jsp:include page="./Header.jsp"></jsp:include>


	<!-- CONTENITORE -->
	<div class="contentPage">
            
            <div class="section1">
                <img class="sfondo" src="C:\Users\catel\Desktop\fotoProject\salumi_One.jpg" alt="">
                <img class="sfondoScroll" src="C:\Users\catel\Desktop\fotoProject\salumi_OneCopert.png" alt="">
                <img id="logoHamPlanet" class="logoSite" src="D:\Document\catello\FIGMA\Logo\logoComplete_V2_WHITE.svg" alt="">
            </div>
            

            <!--SEZIONE PICCOLA - SERVIZIO CLIENTI + SPEDIZIONI + ORDINI FACILI-->
            <div class="section2">
                <div class="son">
                    <img src="C:\Users\catel\Desktop\tell_WHITE.svg" alt="">
                    <div class="testoSection2">
                        <h3>Servizio Clienti</h3>
                        <p>Lun – Ven / dalle 8 alle 12 e dalle 13 alle 17<br>Telefono e Whatsapp +39 331 23 69 171</p>
                    </div>
                </div>

                <div class="son">
                    <img src="C:\Users\catel\Desktop\van_WHITE.svg" alt="">
                    <div class="testoSection2">
                        <h3>Spedizioni gratuite</h3>
                        <p>per ordini superiori ai 160€<br>(solo in italia)</p>
                    </div>
                </div>

                <div class="son">
                    <img src="C:\Users\catel\Desktop\rocket_WHITE.svg" alt="">
                    <div class="testoSection2">
                        <h3>Ordini facili e veloci</h3>
                        <p>con consegne garantite entro 72 ore</p>
                    </div>
                </div>

            </div>

            <div class="section3">

                <div class="sonTwo">
                    <img class="town" src="C:\Users\catel\Desktop\mockup_HamPlanet\FOTO\Stabilimento_HamPlanet.png" alt="">
                </div>

                <div class="sonTwo">
                    <h2>Ham Planet Town</h2>

                    <p>Nostro centro operativo.....
                        Quartier generale
                    </p>
                </div>

            </div>

            <div class="section4">
                
            </div>
            
            
            
            <!-- FOOTER -->
            
            
     </div>

</body>
</html>