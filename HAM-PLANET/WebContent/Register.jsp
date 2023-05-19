<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
    <head>
        <title>Crea il tuo account HamPlanet</title>     
        <link rel="stylesheet" href="./FileCSS/Register.css">
        <link rel="shortcut icon" href="./Icon/logo_HamPlanet_RED.png">  
        <script type="text/javascript" src="./FileJavaScript/Register.js"></script>
    </head>
    
    <body>
    
        <div class="form-box">
            <form action="ClienteControl" method="post">

                <!--TITOLO-->
                <h2 id="titolo">Crea il tuo<br>ID Ham Planet</h2>
                
                <!--INFO-->
                <p id="info">L'ID Ham Planet ti permette di accedere a tutti i servizi Ham Planet.</p>
                
                <!--LINK TO LOGIN-->
                <div class="forLog">
                    <p>Hai già un ID Ham Planet? <a href="./Login.jsp">Accedi qui ></a></p>
                </div>
                
            
                <!--NOME E COGNOME-->
                <div class="inputboxNC">

                    <!--NOME-->
                    <div class="inputbox" id="nome">
                        <input id="inNome" oninput="firstLetterUpper()" type="text" name="nome" required>
                        <div class="testo">
                            <label class="uno">N</label>
                            <label class="due">o</label>
                            <label class="tre">m</label>
                            <label class="quattro">e</label>
                        </div>
                    </div>
                    &nbsp;&nbsp;&nbsp;
                    <!--COGNOME-->
                    <div class="inputbox" id="cognome">
                        <input id="inCognome" oninput="firstLetterUpper()" type="text" name="cognome" required>
                        <div class="testo">
                            <label class="uno">C</label>
                            <label class="due">o</label>
                            <label class="tre">g</label>
                            <label class="quattro">n</label>
                            <label class="cinque">o</label>
                            <label class="sei">m</label>
                            <label class="sette">e</label>
                        </div>
                    </div>
                </div>


                
                

                <!--EMAIL-->
                <div class="inputbox">
                    <input id="email" onpointerover="changeIcon(0)"
                                      onpointerleave="changeIcon(1)"
                                      onclick="changeIcon(2)"
                                      onblur="changeIcon(3)"
                                      oninput="changeIcon(4)"
                                      type="text" name="email" required>
                    <div class="testo">
                        <label class="uno">E</label>
                        <label class="due">m</label>
                        <label class="tre">a</label>
                        <label class="quattro">i</label>
                        <label class="cinque">l</label>
                    </div>
                    <img id="img_email" src="./Icon/email_default_BLACK.png" alt="show" height="40px">
                </div>
                

                <!--PASSWORD-->
                <div class="inputbox">
                    <input id="pwd" onpointerover="changeColor(0)"
                                    onpointerleave="changeColor(1)"
                                    onclick="changeColor(2)"
                                    onblur="changeColor(3)"
                                    type="password" name="pass" required>
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
                    <img id="img_pass" src="./Icon/eyes_show_BLACK.png" alt="show" onclick="showPwd(1)">
                </div>

                
                <!--CONFERMA PASSWORD-->
                <div class="inputbox">
                    <input id="pwdRepeat"   onpointerover="changeColorRepeat(0)"
                                            onpointerleave="changeColorRepeat(1)"
                                            onclick="changeColorRepeat(2)"
                                            onblur="changeColorRepeat(3)"
                                            type="password" required>
                    <div class="testo">
                        <label class="uno">C</label>
                        <label class="due">o</label>
                        <label class="tre">n</label>
                        <label class="quattro">f</label>
                        <label class="cinque">e</label>
                        <label class="sei">r</label>
                        <label class="sette">m</label>
                        <label class="otto">a</label>
                        &nbsp;
                        <label class="nove">P</label>
                        <label class="dieci">a</label>
                        <label class="undici">s</label>
                        <label class="dodici">s</label>
                        <label class="tredici">w</label>
                        <label class="quattordici">o</label>
                        <label class="quindici">r</label>
                        <label class="sedici">d</label>
                    </div>
                    <img id="img_confPass" src="./Icon/eyes_show_BLACK.png" alt="show" onclick="showPwd(2)">
                </div>

        



                <!-- SESSO -->
                <div class="inputboxSEX">
                    
                    <input id="radioMan" type="radio" name="sesso" value="M"> <button id="man" type="button" onclick="changeSex(1)">Uomo</button>                    
                    <input id="radioWoman" type="radio" name="sesso" value="F"> <button id="woman" type="button" onclick="changeSex(2)">Donna</button>
                    <div class="boxIMG">
                        <img id="sexImg" src="./Icon/defaultMaleFemale_BLACK.png" alt="imagesex" height="50px">
                    </div>
                    <input id="radioNone" type="radio" name="sesso" value="none"> <button id="none" type="button" onclick="changeSex(3)">Preferisco non specificare</button>
                    
                    
                </div>

                



                <!-- DATA DI NASCITA/ NUMERO DI TELEFONO-->
                <div class="inputboxNC">

                    <!--DATA DI NASCITA-->
                    <div class="boxBirth">
                        <label class="testoStatic" for="">Data di nascita</label>
                        <div class="inputboxBirth">
                            <input id="day" placeholder="gg" name="giorno" 
                                            onpointerover="changeInWhite(1)" 
                                            onpointerleave="changeInBlack(1)"  
                                            oninput="controlDay()" 
                                            onblur="controlCifra(1)" 
                                            type="text" minlength="2" maxlength="2">
                        </div>
                        
                        <div class="inputboxBirth">
                            <input id="month" placeholder="mm" name="mese" 
                                            onpointerover="changeInWhite(2)" 
                                            onpointerleave="changeInBlack(2)" 
                                            oninput="controlMonth()" 
                                            onblur="controlCifra(2)" 
                                            type="text" minlength="2" maxlength="2">
                        </div>
                        
                        <div class="inputboxBirth">
                            <input id="year" placeholder="aaaa" name="anno" 
                                            onpointerover="changeInWhite(3)" 
                                            onpointerleave="changeInBlack(3)" 
                                            oninput="controlYear()" 
                                            onblur="controlCifra(3)" 
                                            type="text" minlength="4" maxlength="4">
                        </div>
                    </div>

                    &nbsp;&nbsp;&nbsp;

                    <!--NUMERO DI TELEFONO-->
                    <div class="inputbox">
                        <input id="tel" onpointerover="changeColorTel(0)"
                                onpointerleave="changeColorTel(1)"
                                onclick="changeColorTel(2)"
                                onblur="changeColorTel(3)"
                                oninput="controlCaracter(1)"
                                type="text" maxlength="10" name="cellulare" required>
                        <div class="testo">
                            <label class="uno">T</label>
                            <label class="due">e</label>
                            <label class="tre">l</label>
                            <label class="quattro">e</label>
                            <label class="cinque">f</label>
                            <label class="sei">o</label>
                            <label class="sette">n</label>
                            <label class="otto">o</label>
                        </div>
                        <img id="img_tel" src="./Icon/phone_BLACK.png" alt="cellulare">
                    </div>
                </div>


                

                <!--INDIRIZZO DI CASA-->
                <!--VIA-->
                <div class="inputbox">
                    <input id="via" type="text" onpointerover="changeColorPos(0)"
                                                onpointerleave="changeColorPos(1)"
                                                onclick="changeColorPos(2)"
                                                onblur="changeColorPos(3)" 
                                                name="Indirizzo" required>
                    <div class="testo">
                        <label class="uno">V</label>
                        <label class="due">i</label>
                        <label class="tre">a</label>
                    </div>
                    <img id="img_pos" src="./Icon/position_BLACK.png" alt="casa">
                </div>
                <div class="inputboxNC">

                    <!--PAESE-->
                    <div class="inputbox">
                        <input id="paese" type="text" name="paese" oninput="controlCaracter(2)" name="" required>
                        <div class="testo">
                            <label class="uno">P</label>
                            <label class="due">a</label>
                            <label class="tre">e</label>
                            <label class="quattro">s</label>
                            <label class="cinque">e</label>

                        </div>
                    </div>

                    &nbsp;&nbsp;&nbsp;

                    <!--PROVINCIA-->
                    <div class="inputbox">
                        <input id="provincia" type="text" name="provincia" oninput="controlCaracter(3)"" maxlength="2" required>
                        <div class="testo">
                            <label class="uno">P</label>
                            <label class="due">r</label>
                            <label class="tre">o</label>
                            <label class="quattro">v</label>
                            <label class="cinque">i</label>
                            <label class="sei">n</label>
                            <label class="sette">c</label>
                            <label class="otto">i</label>
                            <label class="nove">a</label>
                        </div>
                    </div>

                    &nbsp;&nbsp;&nbsp;

                    <!--CAP-->
                    <div class="inputbox">
                        <input id="cap" type="text" name="cap" oninput="controlCaracter(4)" maxlength="5" required>
                        <div class="testo">
                            <label class="uno">C</label>
                            <label class="due">a</label>
                            <label class="tre">p</label>
                        </div>
                    </div>
                </div>
                


                <!--BOTTONE REGISTRAZIONE-->
                <button id="buttonReg" type="submit">Registrati</button>
            
            </form>
        
    </body>
    
</html>
