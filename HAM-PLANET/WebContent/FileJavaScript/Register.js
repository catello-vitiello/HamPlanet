


/*###############################################################################################*/
/*###                         FUNZIONE PER CAMBIARE ICONA DELL'EMAIL                          ###*/
/*###############################################################################################*/
var num = 0;
var email_bool = false;
function changeIcon(numero){
    var email = document.getElementById('email').value;
    var letter = document.getElementById('img_email');

    num = numero;

    /**##################################### ZERO ################################## */
    if (num == 0){
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_accept_GREEN.png"    
        }else if (email === '' && email_bool == false){
            letter.src = "./Icon/email_default_WHITE.png";
        }else if (email !== '' && !/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_reject_RED.png";
        }

        
    }

    /**##################################### UNO ################################## */
    else if (num == 1){
        if (email === '' && email_bool == false){
            letter.src = "./Icon/email_default_BLACK.png";
        }
        else if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
            letter.src = "./Icon/email_accept_GREEN.png";
        }else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)|| email ==='') {
            letter.src = "./Icon/email_reject_RED.png";
        }
    }
    

    /**##################################### DUE ################################## */
    else if (num == 2){
        letter.src = "./Icon/email_default_WHITE.png";
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_accept_GREEN.png";
        }else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email) && email !== ''){
            letter.src = "./Icon/email_reject_RED.png";
        }else if (email === ''){
            letter.src = "./Icon/email_reject_RED.png"
        }else{
            letter.src = "./Icon/email_default_WHITE.png";
        }
        email_bool = true;
    }


    /**##################################### TRE ################################## */  
    else if (num == 3){
        if(email === ''){
            letter.src = "./Icon/email_default_BLACK.png";
        }
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_accept_GREEN.png";
        }else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email) && email !== ''){
            letter.src = "./Icon/email_reject_RED.png";
        }
        email_bool = false;
    }

    /**##################################### QUATTRO ################################## */  
    else if (num == 4){
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_accept_GREEN.png";
        }else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email) || email === ''){
            letter.src = "./Icon/email_reject_RED.png";
        }
    }

}


 
 
 /********************************************************************************************************************************************************/
 


 /*###############################################################################################*/
/*###                      FUNZIONE PER MOSTRARE/NASCONDERE LA PASSWORD                        ###*/
/*###############################################################################################*/
 function showPwd(tipo){

    if (tipo == 1){
        var input = document.getElementById('pwd');
        var eyes = document.getElementById('img_pass');
    }
    else if(tipo == 2){
        var input = document.getElementById('pwdRepeat');
        var eyes = document.getElementById('img_confPass');
    }


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


/********************************************************************************************************************************************************/
 


/*###############################################################################################*/
/*###                      FUNZIONE PER CAMBIARE L'ICONA DELLA PASSWORD                       ###*/
/*###############################################################################################*/
var num = 0;
var pass_bool = false;
function changeColor(numero){

    
    var box = document.getElementById('pwd');
    var input = document.getElementById('pwd').value;
    var eyes = document.getElementById('img_pass');

    

    num = numero;

    /**##################################### ZERO ################################## */
    if (num == 0){
        if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
            eyes.src = "./Icon/eyes_show_WHITE.png";
        }
        else if (eyes.src.toString("./Icon/eyes_hidden_BLACK.png") && box.type == "text"){
            eyes.src = "./Icon/eyes_hidden_WHITE.png";
        }
    }


    /**##################################### UNO ################################## */
    else if (num == 1){
        if (input === '' && pass_bool == false){
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
        if ( eyes.src.toString("eyes_show_BLACK.png") && box.type == "password"){
            eyes.src = "./Icon/eyes_show_WHITE.png";
        }
        else if (eyes.src.toString("eyes_hidden_BLACK.png") && box.type == "text"){
            eyes.src = "./Icon/eyes_hidden_WHITE.png";
        }
        pass_bool = true;
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
        pass_bool = false;
    }
    
}



/********************************************************************************************************************************************************/




/*###############################################################################################*/
/*###                 FUNZIONE PER CAMBIARE L'ICONA DELLA CONFERMA PASSWORD                   ###*/
/*###############################################################################################*/
var numConf = 0;
var passConf_bool = false;
function changeColorRepeat(numero){

    
    var boxConf = document.getElementById('pwdRepeat');
    var inputConf = document.getElementById('pwdRepeat').value;
    var eyesConf = document.getElementById('img_confPass');

    

    numConf = numero;

    /**##################################### ZERO ################################## */
    if (numConf == 0){
        if ( eyesConf.src.toString("eyes_show_BLACK.png") && boxConf.type == "password"){
            eyesConf.src = "./Icon/eyes_show_WHITE.png";
        }
        else if (eyesConf.src.toString("eyes_hidden_BLACK.png") && boxConf.type == "text"){
            eyesConf.src = "./Icon/eyes_hidden_WHITE.png";
        }
    }


    /**##################################### UNO ################################## */
    else if (numConf == 1){
        if (inputConf === '' && passConf_bool == false){
            if ( eyesConf.src.toString("eyes_show_WHITE.png") && boxConf.type == "password"){
                eyesConf.src = "./Icon/eyes_show_BLACK.png";
            }
            else if (eyes.src.toString("eyes_hidden_WHITE.png") && boxConf.type == "text"){
                eyes.src = "./Icon/eyes_hidden_BLACK.png";
            }
        }
        else{
            if ( eyesConf.src.toString("eyes_show_BLACK.png") && boxConf.type == "password"){
                eyesConf.src = "./Icon/eyes_show_WHITE.png";
            }
            else if (eyesConf.src.toString("eyes_hidden_BLACK.png") && boxConf.type == "text"){
                eyesConf.src = "./Icon/eyes_hidden_WHITE.png";
            }
        }
    }
    


    /**##################################### DUE ################################## */
    else if (numConf == 2){
        if ( eyesConf.src.toString("eyes_show_BLACK.png") && boxConf.type == "password"){
            eyesConf.src = "./Icon/eyes_show_WHITE.png";
        }
        else if (eyesConf.src.toString("eyes_hidden_BLACK.png") && boxConf.type == "text"){
            eyesConf.src = "./Icon/eyes_hidden_WHITE.png";
        }
        passConf_bool = true;
    }



    /**##################################### TRE ################################## */  
    else if (numConf == 3){
        if(inputConf === ''){
            if ( eyesConf.src.toString("eyes_show_WHITE.png") && boxConf.type == "password"){
                eyesConf.src = "./Icon/eyes_show_BLACK.png";
            }
            else if (eyesConf.src.toString("eyes_hidden_WHITE.png") && boxConf.type == "text"){
                eyesConf.src = "./Icon/eyes_hidden_BLACK.png";
            }
        }
        else{
            if ( eyesConf.src.toString("eyes_show_BLACK.png") && boxConf.type == "password"){
                eyesConf.src = "./Icon/eyes_show_WHITE.png";
            }
            else if (eyesConf.src.toString("eyes_hidden_BLACK.png") && boxConf.type == "text"){
                eyesConf.src = "./Icon/eyes_hidden_WHITE.png";
            }
        }
        passConf_bool = false;
    }
    
}



/********************************************************************************************************************************************************/
 


/*###############################################################################################*/
/*###                  FUNZIONE PER CAMBIARE L'ICONA DELLA NUMERO DI TELEFONO                 ###*/
/*###############################################################################################*/
var num = 0;
var tel_bool = false;
function changeColorTel(numero){
    var inpTel = document.getElementById('tel').value;
    var phone = document.getElementById('img_tel');

    num = numero;

    /**##################################### ZERO ################################## */
    if (num == 0){
        if ( phone.src.toString("phone_BLACK.png")){
            phone.src = "./Icon/phone_WHITE.png";
        }
        else if (phone.src.toString("phone_BLACK.png")){
            phone.src = "./Icon/phone_WHITE.png";
        }
    }


    /**##################################### UNO ################################## */
    else if (num == 1){
        if (inpTel === '' && tel_bool == false){
            if ( phone.src.toString("phone_WHITE.png")){
            phone.src = "./Icon/phone_BLACK.png";
            }
        }
        else{
            if ( phone.src.toString("phone_BLACK.png")){
                phone.src = "./Icon/phone_WHITE.png";
            }
        }
    }
    


    /**##################################### DUE ################################## */
    else if (num == 2){
        if ( phone.src.toString("phone_BLACK.png")){
            phone.src = "./Icon/phone_WHITE.png";
        }
        tel_bool = true;
    }



    /**##################################### TRE ################################## */  
    else if (num == 3){
        if(inpTel === ''){
            if ( phone.src.toString("phone_WHITE.png")){
                phone.src = "./Icon/phone_BLACK.png";
            }
        }
        else{
            if ( phone.src.toString("phone_BLACK.png") ){
                phone.src = "./Icon/phone_WHITE.png";
            }
        }
        tel_bool = false;
    }
    
}



/********************************************************************************************************************************************************/
 


/*###############################################################################################*/
/*###                          FUNZIONE DI CONTROLLO DEL GIORNO/MESE                          ###*/
/*###############################################################################################*/

//GIORNO
function controlDay(){
    var day = document.getElementById('day');

    //controllo caratteri
    if ( (/[^0-9]/.test(day.value))){   
        day.value = day.value.substring(0,day.value.length-1);
    }

    //controllo se giorno max si trova con mese
    if (month.value.toString(02) && day.value>28){
        day.value = 28;
    }else if ( ((month.value == 04) || (month.value ==06) || (month.value ==09) || (month.value ==11)) && day.value>30){
        day.value = 30;
    }else if (day.value>31) {
        day.value = 31;
    }

    //quando scrivo qualcosa cambio colore sfondo
    if (day.value != ''){
        day.style.background = 'black';
        day.style.color = 'white';
    }
}

//MESE
function controlMonth(){
    var day = document.getElementById('day');
    var month = document.getElementById('month');
    
    //controllo caratteri
    if ( (/[^0-9]/.test(month.value))){   
        month.value = month.value.substring(0,month.value.length-1);
    }

    //max mese dicembre
    if (month.value>12){
        month.value = 12;
    }

    //controllo se giorno max si trova con mese
    if (month.value == 2 && day.value != ''){
        day.value = 28;
    }else if ( ((month.value == 04) || (month.value ==06) || (month.value ==09) || (month.value ==11)) && day.value>30){
        day.value = 30;
    }else if (day.value>31) {
        day.value = 31;
    }

    //quando scrivo qualcosa cambio colore sfondo
    if (day.value != ''){
        day.style.background = 'black';
        day.style.color = 'white';
    }

    //quando scrivo qualcosa cambio colore sfondo
    if (month.value != ''){
        month.style.background = 'black';
        month.style.color = 'white';
    }
}

//ANNO
function controlYear(){
    var year = document.getElementById('year');

    //controllo caratteri
    if ( (/[^0-9]/.test(year.value))){   
        year.value = year.value.substring(0,year.value.length-1);
    }

    if (year.value >2023){
        year.value = 2023;
    }

    //quando scrivo qualcosa cambio colore sfondo
    if (year.value != ''){
        year.style.background = 'black';
        year.style.color = 'white';
    }
}


function controlCifra(type){
    var day = document.getElementById('day');
    var month = document.getElementById('month');
    var year = document.getElementById('year');
    


    //giorno
    if (type === 1){
        if (day.value.length == 1){
            day.value =  "0" + day.value;
        }

        if(day.value == ''){
            day.style.background = 'white';
            day.style.color = 'black';
        }
    }


    //mese
    else if (type === 2){          
        if (month.value.length == 1){
            month.value = "0" + month.value;
        }

        if(month.value == ''){
            month.style.background = 'white';
            month.style.color = 'black';
        }
    }


    //anno
    else if (type === 3){
        if (year.value <1900 && year.value > 1){
            year.value = 1900;
        } 

        if(year.value == ''){
            year.style.background = 'white';
            year.style.color = 'black';
        }
    }
        
}






/********************************************************************************************************************************************************/




/*###############################################################################################*/
/*###                         CAMBIA COLORE CAMPI DELLA DATA                                  ###*/  
/*###############################################################################################*/

//FUNZIONE CHE CAMBIA COLORE QUANDO CI PASSI SOPRA
function changeInWhite(type){
    var day = document.getElementById('day');
    var month = document.getElementById('month');
    var year = document.getElementById('year');
    
    
    //giorno
    if (type === 1){
        if(day.value == ''){
            day.style.background = 'black';
            day.style.color = 'white';
        }
    }


    //mese
    else if (type === 2){ 
        if(month.value == ''){
            month.style.background = 'black';
            month.style.color = 'white';
        }
    }


    //anno
    else if (type === 3){
        if(year.value == ''){
            year.style.background = 'black';
            year.style.color = 'white';
        }
    }
}


//FUNZIONE CHE CAMBIA COLORE QUANDO TOLGO DA SOPRA
function changeInBlack(type){
    var day = document.getElementById('day');
    var month = document.getElementById('month');
    var year = document.getElementById('year');
    
    
    //giorno
    if (type === 1){
        if(day.value == ''){
            day.style.background = 'white';
            day.style.color = 'black';
        }
    }


    //mese
    else if (type === 2){ 
        if(month.value == ''){
            month.style.background = 'white';
            month.style.color = 'black';
        }
    }


    //anno
    else if (type === 3){
        if(year.value == ''){
            year.style.background = 'white';
            year.style.color = 'black';
        }
    }
}






/********************************************************************************************************************************************************/




/*###############################################################################################*/
/*###                         CAMBIA SESSO DEL RADIO BUTTON                                   ###*/  
/*###############################################################################################*/

function changeSex(buttonType){
    var radioMan = document.getElementById('radioMan');
    var radioWoman = document.getElementById('radioWoman');
    var radioNone = document.getElementById('radioNone');

    var imageSex = document.getElementById('sexImg');



    //man
    if (buttonType === 1){
        radioMan.checked = true;
        radioWoman.checked = false;
        radioNone.checked = false;

        document.getElementById('man').style.fontWeight = 800;
        document.getElementById('woman').style.fontWeight = 100;
        document.getElementById('none').style.fontWeight = 100;

        document.getElementById('man').style.fontSize = '15px';
        document.getElementById('woman').style.fontSize = '13px';
        document.getElementById('none').style.fontSize = '13px';

        imageSex.src = "./Icon/choose_male.png";
    }

    //woman
    else if (buttonType === 2){
        radioMan.checked = false;
        radioWoman.checked = true;
        radioNone.checked = false;

        document.getElementById('man').style.fontWeight = 100;
        document.getElementById('woman').style.fontWeight = 800;
        document.getElementById('none').style.fontWeight = 100;

        document.getElementById('man').style.fontSize = '13px';
        document.getElementById('woman').style.fontSize = '15px';
        document.getElementById('none').style.fontSize = '13px';

        imageSex.src = './Icon/choose_female.png';
    }

    //none
    else if (buttonType === 3){
        radioMan.checked = false;
        radioWoman.checked = false;
        radioNone.checked = true;

        document.getElementById('man').style.fontWeight = 100;
        document.getElementById('woman').style.fontWeight = 100;
        document.getElementById('none').style.fontWeight = 800;

        document.getElementById('man').style.fontSize = '13px';
        document.getElementById('woman').style.fontSize = '13px';
        document.getElementById('none').style.fontSize = '14px';

        imageSex.src = './Icon/choose_none.png';
    }

}






/********************************************************************************************************************************************************/




/*###############################################################################################*/
/*###                         CONTROLLA CARATTERI CONSENTITI                                  ###*/  
/*###############################################################################################*/
function controlCaracter(typeCar){
    var tel = document.getElementById('tel');
    var paese = document.getElementById('paese');
    var provincia = document.getElementById('provincia');
    var cap = document.getElementById('cap');

    //numero telefonico
    if (typeCar === 1){
        if ( (/[^0-9]/.test(tel.value))){   
            tel.value = tel.value.substring(0,tel.value.length-1);
        }
    }

    //paese
    else if (typeCar === 2){
        if ( (/[^a-zA-Z]/.test(paese.value))){   
            paese.value = paese.value.substring(0,paese.value.length-1);
        }
    }

    //provincia
    else if (typeCar === 3){
        if ( (/[^a-zA-Z]/.test(provincia.value))){   
            provincia.value = provincia.value.substring(0,provincia.value.length-1);
        }
    }


    //cap
    else if (typeCar === 4){
        if ( (/[^0-9]/.test(cap.value))){   
            cap.value = cap.value.substring(0,cap.value.length-1);
        }
    }




    
}






/********************************************************************************************************************************************************/




/*###############################################################################################*/
/*###                         CAMBIO COLORE ICONA POSIZIONE                                   ###*/  
/*###############################################################################################*/
var num = 0;
var pos_bool = false;

function changeColorPos(numero){
    var inputPos = document.getElementById('via').value;
    var home = document.getElementById('img_pos');

    num = numero;

    /**##################################### ZERO ################################## */
    if (num == 0){
        if ( home.src.toString("phone_BLACK.png")){
            home.src = "./Icon/position_WHITE.png";
        }
        else if (home.src.toString("phone_BLACK.png")){
            home.src = "./Icon/position_WHITE.png";
        }
    }


    /**##################################### UNO ################################## */
    else if (num == 1){
        if (inputPos === '' && pos_bool == false){
            if ( home.src.toString("phone_WHITE.png")){
            home.src = "./Icon/position_BLACK.png";
            }
        }
        else{
            if ( home.src.toString("phone_BLACK.png")){
                home.src = "./Icon/position_WHITE.png";
            }
        }
    }
    


    /**##################################### DUE ################################## */
    else if (num == 2){
        if ( home.src.toString("phone_BLACK.png")){
            home.src = "./Icon/position_WHITE.png";
        }
        pos_bool = true;
    }



    /**##################################### TRE ################################## */  
    else if (num == 3){
        if(inputPos === ''){
            if ( home.src.toString("phone_WHITE.png")){
                home.src = "./Icon/position_BLACK.png";
            }
        }
        else{
            if ( home.src.toString("phone_BLACK.png") ){
                home.src = "./Icon/position_WHITE.png";
            }
        }
        pos_bool = false;
    }
    
}