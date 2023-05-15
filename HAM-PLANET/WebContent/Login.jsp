<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Gestisci il tuo ID HamPlanet</title>
        <link rel="stylesheet" href="./FileCSS/Login.css">
		<script type="text/javascript" src="./FileJavaScript/Login.js"></script>
        <link rel="shortcut icon" href=""> <!-- AGGIUNGERE PERCORSO LOGO PICCOLO -->
    </head>

<!-- ##############   BODY   ##############-->
    <body>
        <div class="form-box">
            <form action="ClienteControl" method="post"> 

                <!--LOGO-->
                <img id="logo" src="./Icon/logo_HamPlanet_BLACK.svg" alt="Ham Planet" height="130x">
                
                
                <!--TITOLO-->
                <h2 id="titolo">Accedi</h2>
                <!--INFO-->
                <p id="sott">Gestisci il tuo account Ham Planet.</p>
                

				<!--EMAIL-->
                <div class="inputbox">
                	<input id="email" onpointerover="changeIcon(0)"
                                      onpointerleave="changeIcon(1)"
                                      onclick="changeIcon(2)"
                                      onblur="changeIcon(3)"
                                      oninput="changeIcon(4)"
                                      type="text"  name="email" required>
                    <div class="testo">
                        <label class="uno">E</label>
                        <label class="due">m</label>
                        <label class="tre">a</label>
                        <label class="quattro">i</label>
                        <label class="cinque">l</label>
                    </div>
                    <img id="img_email" src="./Icon/email_default_BLACK.png" alt="show" height="50px">
                </div>

                <!--PASSWORD-->
                <div class="inputbox">
                    <input id="pwd" onpointerover="changeColor(0)"
                                    onpointerleave="changeColor(1)"
                                    onclick="changeColor(2)"
                                    onblur="changeColor(3)"
                                    type="password" 
                                    name="pass" required>
                    <div class="testo">
                        <label class="uno">P</label>
                        <label class="due">a</label>
                        <label class="tre">s</label>
                        <label class="quattro">s</label>
                        <label class="cinque">w</label>
                        <label class="sei">o</label>
                        <label class="sette">r</label>
                        <label class="otto">d</label>
                    </div>
                    <img id="img_pass" src="./Icon/eyes_show_BLACK.png" alt="show" height="30px" onclick="showPwd()">
                </div>

                <!--PASSWORD DIMENTICATA-->
                <div class="forgotPass">
                    <a href="#">Hai dimenticato la password?</a>
                </div>

                <!--BOTTONE DI ACCESSO-->
                <button id="buttonLogin" type="submit">Accedi</button>
                

                <!--LINK SE NON HAI UN ACCOUONT-->
                <div class="forReg">
                    <p>Non hai un account? <a href="">Crea subito il tuo.</a></p> <!-- AGGIUNGERE LINK PAGINA REGISTRAZIONE -->
                </div>
			
            </form>
        </div>
    </body>
</html>