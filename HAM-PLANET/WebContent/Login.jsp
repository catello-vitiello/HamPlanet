<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Gestisci il tuo ID HamPlanet</title>
        <link rel="stylesheet" href="./FileCSS/Login.css">
		<script type="text/javascript">

        /** FUNZIONE MOSTRA/NASCONDI PASSWORD */


       function showPwd(){
           var input = document.getElementById('pwd');
           var eyes = document.getElementById('img');

           if(input.value === ''){
               if(input.type == "password"){
                   if (eyes.src.toString("eyes_show_BLACK.png")){
                       eyes.src = "./Icon/eyes_hidden_BLACK.png";
                   }
                   else{
                       eyes.src = "./Icon/eyes_hidden_WHITE.png";
                   }
                   input.type = "text";
               }
               else{
                   if (eyes.src.toString("eyes_hidden_BLACK.png")){
                       eyes.src = "./Icon/eyes_show_BLACK.png";
                   }
                   else{
                       eyes.src = "./Icon/eyes_show_WHITE.png";
                   }
                   input.type = "password";
               }
           }else{
               if(input.type == "password"){
                   if (eyes.src.toString("eyes_show_BLACK.png")){
                       eyes.src = "./Icon/eyes_hidden_WHITE.png";
                   }
                   else{
                       eyes.src = "./Icon/eyes_hidden_BLACK.png";
                   }
                   input.type = "text";
               }
               else{
                   if (eyes.src.toString("eyes_hidden_BLACK.png")){
                       eyes.src = "./Icon/eyes_show_WHITE.png";
                   }
                   else{
                       eyes.src = "./Icon/eyes_show_BLACK.png";
                   }
                   input.type = "password";
               }
           }
       }




       var num = 0;
       var mom = false;
       function changeColor(numero){
           var box = document.getElementById('pwd');
           var input = document.getElementById('pwd').value;
           var eyes = document.getElementById('img');

           num = numero;

           /**##################################### ZERO ################################## */
           if (num == 0){
               if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
                   eyes.src = "./Icon/eyes_show_WHITE.png";
               }
               else if (eyes.src.toString("eyes_hidden_BLACK.png") && box.type == "text"){
                   eyes.src = "./Icon/eyes_hidden_WHITE.png";
               }
           }


           /**##################################### UNO ################################## */
           else if (num == 1){
               if (input === '' && mom == false){
                   if ( eyes.src.toString("eyes_show_WHITE.png") && box.type == "password"){
                       eyes.src = "./Icon/eyes_show_BLACK.png";
                   }
                   else if (eyes.src.toString("eyes_hidden_WHITE.png") && box.type == "text"){
                       eyes.src = "./Icon/eyes_hidden_BLACK.png";
                   }
               }
               else{
                   if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
                       eyes.src = "./Icon/eyes_show_WHITE.png";
                   }
                   else if (eyes.src.toString("eyes_hidden_BLACK.png") && box.type == "text"){
                       eyes.src = "./Icon/eyes_hidden_WHITE.png";
                   }
               }
           }
           


           /**##################################### DUE ################################## */
           else if (num == 2){
               mom = true;
               if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
                   eyes.src = "./Icon/eyes_show_WHITE.png";
               }
               else if (eyes.src.toString("eyes_hidden_BLACK.png") && box.type == "text"){
                   eyes.src = "./Icon/eyes_hidden_WHITE.png";
               }
           }



           /**##################################### TRE ################################## */  
           else if (num == 3){
               if(input === ''){
                   if ( eyes.src.toString("eyes_show_WHITE.png") && box.type == "password"){
                       eyes.src = "./Icon/eyes_show_BLACK.png";
                   }
                   else if (eyes.src.toString("eyes_hidden_WHITE.png") && box.type == "text"){
                       eyes.src = "./Icon/eyes_hidden_BLACK.png";
                   }
               }
               else{
                   if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
                       eyes.src = "./Icon/eyes_show_WHITE.png";
                   }
                   else if (eyes.src.toString("eyes_hidden_BLACK.png") && box.type == "text"){
                       eyes.src = "./Icon/eyes_hidden_WHITE.png";
                   }
               }
               mom = false;
           }
           
       }
</script>
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
                    <div class="testo">
                        <label class="uno">E</label>
                        <label class="due">m</label>
                        <label class="tre">a</label>
                        <label class="quattro">i</label>
                        <label class="cinque">l</label>
                    </div>
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
                    <img id="img" src="./Icon/eyes_show_BLACK.png" alt="show" onclick="showPwd()">
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