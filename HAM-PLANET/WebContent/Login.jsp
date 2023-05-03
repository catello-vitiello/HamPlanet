<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Gestisci il tuo ID HamPlanet</title>
        <link rel="stylesheet" href="./FileStyleCSS/Login.css">
        <link rel="shortcut icon" href=""> <!-- AGGIUNGERE PERCORSO LOGO PICCOLO -->
    </head>

<!-- ##############   BODY   ##############-->
    <body>
        <div class="form-box">
            <form action="ClienteControl" method="post"> 

                <!--LOGO-->
                <!--   <img id="logo" src="" alt="Ham Planet" height="130x">  aggiungere logo black -->
            

                <!--TITOLO-->
                <h2 id="titolo">Accedi</h2>
                <!--INFO-->
                <p id="sott">Gestisci il tuo account Ham Planet.</p>
                

                <!--EMAIL-->
                <div class="inputbox">
                    <input  type="text" name="email" required>
                    <label for="">Email</label>
                </div>

                <!--PASSWORD-->
                <div class="inputbox">
                    <input  type="password" name="pass" required>
                    <label for="">Password</label>
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