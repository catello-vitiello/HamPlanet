var yes = true;

/******************************************************************/
/*                  RESET DELLA SLOT-MACHINE                      */
/******************************************************************/
function Restart(){

    yes = true;

    var immagine1 = document.getElementById('img1');
    var immagine2 = document.getElementById('img2');
    var immagine3 = document.getElementById('img3');

    immagine1.src="notFound.png"
    immagine2.src="notFound.png"
    immagine3.src="notFound.png"
}


/******************************************************************/
/*                         RANDOMIZZATORE                         */
/******************************************************************/
function getRandomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

/******************************************************************/
/*              SETTER DELLE IMMAGINI DI VITTORIA                 */
/******************************************************************/
function setImageToWin(){

    var immagine1 = document.getElementById('img1');
    var immagine2 = document.getElementById('img2');
    var immagine3 = document.getElementById('img3');

    immagine1.src="win.png"
    immagine2.src="win.png"
    immagine3.src="win.png"

    //chiamata alla funzione che si occupa della generazione e distruzione dei coriandoli/confetti
    explodeConfetti();

}

/******************************************************************/
/*                      CONTROLLO VITTORIA                        */
/******************************************************************/
function isWinner(i, j , k){

    if(i==j && i==k && k==j){

        yes = false;
        setTimeout(setImageToWin, 1000);

    }

}

/******************************************************************/
/*              ROTAZIONE DELLE IMMAGINI SLOT-MACHINE             */
/******************************************************************/
function change(){

    if(yes==false){
        return;
    }

    var img = document.getElementById('slot');
    if(img.src.toString("slotMachine_SU.png")){
        img.src="slotMachine_GIU.png";
    }
    setTimeout(function f(){
        img.src="slotMachine_SU.png";
    },320);

    //immagine 1
    var i = getRandomNumber(0,4);
    var immagine = document.getElementById('img1');
    if(i==0){
        immagine.src="puork2.png";
    } 
    if(i==1){
        immagine.src = "puokNotFound.png"; 
    }
    if(i==2){
        immagine.src = "maialeOk.png";
    }
    if(i==3){
        immagine.src = "maialeGoloso.png";
    }
    if(i==4){
        immagine.src = "404.png";
    }

    /*IMMAGINE 2*/
    var j = getRandomNumber(0,4);
    var immagine2 = document.getElementById('img2');
    if(j==0){
        immagine2.src="puork2.png";
    } 
    if(j==1){
        immagine2.src = "puokNotFound.png";
    }
    if(j==2){
        immagine2.src = "maialeOk.png";
    }
    if(j==3){
        immagine2.src = "maialeGoloso.png";
    }
    if(j==4){
        immagine2.src = "404.png";
    }

    /*IMMAGINE 3*/
    var k = getRandomNumber(0,4);
    var immagine3 = document.getElementById('img3');
    if(k==0){
        immagine3.src="puork2.png";
    } 
    if(k==1){
        immagine3.src = "puokNotFound.png"; 
    }
    if(k==2){
        immagine3.src = "maialeOk.png";
    }
    if(k==3){
        immagine3.src = "maialeGoloso.png";
    }
    if(k==4){
        immagine3.src = "404.png";
    }

    isWinner(i,j,k);
}

/******************************************************************/
/*                  FUNZIONE CORIANDOLI/CONFETTI                  */
/******************************************************************/
function createConfetti() {
    //quarto stile di confetti con maiali
    var confettii2 = document.createElement('div_2');
    confettii2.className = 'confettini2';
    confettii2.style.top = Math.random() * window.innerHeight + 'px';
    confettii2.style.left = Math.random() * window.innerWidth + 'px';
    setTimeout(function fun(){
        document.body.appendChild(confettii2);
    },250);
    
    /************************************************************************/    
    // Imposta un timer per rimuovere il coriandolo/confetto in modo graduale  
    
    //facce di maialino
    setTimeout(function() {
        confettii2.remove();
    }, 1550);
}
    /******************************************************************/
    /*               ESPLOSIONE CORIANDOLI/CONFETTI                   */
    /******************************************************************/
    function explodeConfetti() {
      for (var i = 0; i < 700; i++) {
        createConfetti();
    }
}