



/** FUNZIONE PER CAMBIARE ICONA EMAIL */
var num = 0;
var email_bool = false;
function changeIcon(numero){
    var email = document.getElementById('email').value;
    var letter = document.getElementById('img_email');

    num = numero;

    /**##################################### ZERO ################################## */
    if (num == 0){
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            letter.src = "./Icon/email_accept_GREEN.png";   
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
		 
		 
		 
		 
		 
		 
/** FUNZIONE MOSTRA/NASCONDI PASSWORD */
       function showPwd(){
           var input = document.getElementById('pwd');
           var eyes = document.getElementById('img_pass');

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
           var eyes = document.getElementById('img_pass');

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
