


//#################################################################################################################
//##########################         CONTROLLO PER VEDERE QUALE PAGINA MOSTRARE        ############################
//#################################################################################################################

function changePage (value){
    var one = document.getElementById('one')    
    var two = document.getElementById('two')
    var three = document.getElementById('three')  
    

    //prima pagina -> INFORMAZIONI PERSONALI
    if (value == 0){
        if (three.style.display == 'flex'){
            three.style.opacity = '0%';
            setTimeout(function(){three.style.opacity = '100%';}, 410)
        }
        else if (two.style.display == 'flex'){
            two.style.opacity = '0%';
            setTimeout(function(){two.style.opacity = '100%';}, 410)
        }

        setTimeout(function(){
        one.style.display = 'flex';
        two.style.display = 'none';
        three.style.display = 'none';
        }, 400);

        //cambia spessore testo quando lo clicco
        document.getElementById('infPers').style.fontWeight = 600;
        document.getElementById('order').style.fontWeight = 300;
        document.getElementById('creditCard').style.fontWeight = 300;
    }


    //seconda pagina -> ORDINI
    else if (value == 1){

        if (one.style.display != 'none'){
            one.style.opacity = '0%';
            setTimeout(function(){one.style.opacity = '100%';}, 410)
        }
        else if (three.style.display == 'flex'){
            three.style.opacity = '0%';
            setTimeout(function(){three.style.opacity = '100%';}, 410)
        }

        setTimeout(function(){
        one.style.display = 'none';
        two.style.display = 'flex';
        three.style.display = 'none';
        }, 400);

        //cambia spessore testo quando lo clicco
        document.getElementById('infPers').style.fontWeight = 300;
        document.getElementById('order').style.fontWeight = 600;
        document.getElementById('creditCard').style.fontWeight = 300;

        createOrderDinamic();
    }


    //terza pagina -> CARTE
    else if (value == 2){


        if (one.style.display != 'none'){
            one.style.opacity = '0%';
            setTimeout(function(){one.style.opacity = '100%';}, 410)
        }
        else if (two.style.display == 'flex'){
            two.style.opacity = '0%';
            setTimeout(function(){two.style.opacity = '100%';}, 410)
        }
        

        setTimeout(function(){
        one.style.display = 'none';
        two.style.display = 'none';
        three.style.display = 'flex';
        }, 400);
        
        //cambia spessore testo quando lo clicco
        document.getElementById('infPers').style.fontWeight = 300;
        document.getElementById('order').style.fontWeight = 300;
        document.getElementById('creditCard').style.fontWeight = 600;
        
        createCardDinamic();
    }
}



//#################################################################################################################
//##########################         CREAZIONE DI TUTTE LE CARTE DINAMICAMENTE        #############################
//#################################################################################################################
function createCardDinamic(){
	var carteRegistrate = parseInt(document.getElementById('CarteSalvate').textContent);
        
    //recuperare oggetto contenitore
    var boxCarte = document.getElementById("contenitoreCarte");
        
    boxCarte.innerHTML = '';

    for (var contatore = 1; contatore <= carteRegistrate ; contatore++){


        //creazione carta
        var card = document.createElement('div'); 
        card.className = 'card'; 
        card.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) + 1);
        
        //icona per rimuovere
        var icon = document.createElement('img'); 
        icon.className = 'iconRemoveCard'; 
        icon.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) +1) +'_remove'; 
        icon.onclick = function() {confermaEliminazione(this)}; 
        icon.src = "./Icon/removeX_RED.png";
        
        //contenitore content
        var content = document.createElement('div'); 
        content.className = 'content';
        
        //numero della carta
        var numberCard = document.createElement('p'); 
        numberCard.className = 'numberCard'; 
        numberCard.innerHTML = '****  ****  ****  777' + i++;            //prendere numero carta dal db
        
        //contenitore scritte
        var NameExpiration = document.createElement('div'); 
        NameExpiration.className = 'NameExpiration';
        
        //scritta mese/anno
        var monthyear = document.createElement('p'); 
        monthyear.className = 'monthyear'; 
        monthyear.innerHTML = 'MESE/ANNO';
        
        //rigo
        var row = document.createElement('div'); 
        row.className = 'row';
        
        //proprietario
        var owner = document.createElement('p'); 
        owner.className = 'owner'; 
        owner.innerHTML = 'VITIELLO CATELLO'                        //prendere nome proprietario dal db
        
        //scritta VALID THRU
        var valid = document.createElement('p'); 
        valid.className = 'valid'; 
        valid.innerHTML = 'VALID'+'<br>'+ 'THRU';
        
        //scadena
        var expiration = document.createElement('p');
        expiration.className = 'expiration'; 
        expiration.innerHTML = '19/12';                         //prendere scadenza dal db


        row.appendChild(owner), row.appendChild(valid), row.appendChild(expiration);
        NameExpiration.appendChild(monthyear); NameExpiration.appendChild(row);
        content.appendChild(numberCard); content.appendChild(NameExpiration);
        card.appendChild(icon); card.appendChild(content);


        //Aggiungi l'elemento all'elemento genitore 
        boxCarte.insertBefore(card, boxCarte.childNodes[boxCarte.childNodes.length - 3]);
        


    }
    
    
    var addCards = document.createElement('div');
    addCards.className = 'addCard';
	addCards.onclick = function(){
		addCard(this);
	};
	
    
    boxCarte.appendChild(addCards);
	
}








//#################################################################################################################
//##########################         AGGIUNGERE UNA CARTA NUOVA DINAMICAMENTE        ##############################
//#################################################################################################################
	var i=1

function addCard(oggetto){
	
	
    //recupera il riferimento all'elemento genitore
    var boxCarte = document.getElementById("contenitoreCarte");

    //creazione carta
        var card = document.createElement('div'); 
        card.className = 'card'; 
        card.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) + 1);
        
        //icona per rimuovere
        var icon = document.createElement('img'); 
        icon.className = 'iconRemoveCard'; 
        icon.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) +1) +'_remove'; 
        icon.onclick = function() {confermaEliminazione(this)}; 
        icon.src = "./Icon/removeX_RED.png";
        
        //contenitore content
        var content = document.createElement('div'); 
        content.className = 'content';
        
        //numero della carta
        var numberCard = document.createElement('p'); 
        numberCard.className = 'numberCard'; 
        numberCard.innerHTML = '****  ****  ****  777' + i++;            //prendere dal db
        
        //contenitore scritte
        var NameExpiration = document.createElement('div'); 
        NameExpiration.className = 'NameExpiration';
        
        //scritta mese/anno
        var monthyear = document.createElement('p'); 
        monthyear.className = 'monthyear'; 
        monthyear.innerHTML = 'MESE/ANNO';
        
        //rigo
        var row = document.createElement('div'); 
        row.className = 'row';
        
        //proprietario
        var owner = document.createElement('p'); 
        owner.className = 'owner'; 
        owner.innerHTML = 'VITIELLO CATELLO'                        //prendere dal db
        
        //scritta VALID THRU
        var valid = document.createElement('p'); 
        valid.className = 'valid'; 
        valid.innerHTML = 'VALID'+'<br>'+ 'THRU';
        
        //scadena
        var expiration = document.createElement('p');
        expiration.className = 'expiration'; 
        expiration.innerHTML = '19/12';                         //prendere dal db


        row.appendChild(owner), row.appendChild(valid), row.appendChild(expiration);
        NameExpiration.appendChild(monthyear); NameExpiration.appendChild(row);
        content.appendChild(numberCard); content.appendChild(NameExpiration);
        card.appendChild(icon); card.appendChild(content);




	    //aggiungi l'elemento all'elemento genitore 
    	boxCarte.insertBefore(card, boxCarte.childNodes[boxCarte.childNodes.length - 1]);
    
    
	    // Incrementare il contatore delle carte
    	document.getElementById('CarteSalvate').innerHTML = parseInt(document.getElementById('CarteSalvate').textContent) + 1; 


}


function confermaEliminazione (item) {

    var figlio = document.getElementById(item.id);
    
    var padre = document.getElementById(figlio.parentNode.id);


    
    var conferma = window.confirm("Sei sicuro di voler eliminare questa carta?");

    if (conferma){
        padre.remove();

        // Decrementare il contatore delle carte
        document.getElementById('CarteSalvate').innerHTML = parseInt(document.getElementById('CarteSalvate').textContent) - 1; 
    }
}





//#################################################################################################################
//##########################         CREAZIONE DINAMICA DEGLI ORDINI EFFETTUATI        ############################
//#################################################################################################################
function createOrderDinamic(){
    

    var spazio = document.createElement('p');
    spazio.textContent = ' ';


    var boxOrdini = document.getElementById('boxOrder');
    console.log('preso oggetto padre');

    //rimuovo tutti i figli
    boxOrdini.innerHTML = '';

    for ( var contatoreOrdini = 1; contatoreOrdini <= 6 ; contatoreOrdini++){     //bisogna recuperare il numero degli ordnin
        console.log('nel for');
        
        //creo oggetto order
        var order = document.createElement('div');
        order.className = 'order';
        order.id = 'ordineNumero_' + contatoreOrdini;
        console.log('creo oggetto order');
        
        //creo sezione numero ordine, data, prodotti
        var parteSopra = document.createElement('div');
        parteSopra.className = 'parteSopra';
        console.log('creo numero ordine');


        //creo ID ordine
        var orderID = document.createElement('div');
        orderID.className = 'orderID';
        var idText = document.createElement('p');
        idText.textContent = 'ID Ordine: '
        var idNum = document.createElement('h4');
        idNum.textContent = 10000 + contatoreOrdini;        //bisogna prendere dinamicamente questo numero

        orderID.appendChild(idText); orderID.appendChild(idNum);
        parteSopra.appendChild(orderID);
        console.log('creato id');

        
        //creo data ordine
        var orderData = document.createElement('div');
        orderData.className = 'orderData';
        var dataText = document.createElement('p');
        dataText.textContent = 'Ordine effettuato il ';
        var dataNum = document.createElement('h4');
        dataNum.textContent = '07-12-2020'                 //bisogna prendere la data dal db
        console.log('creata data');

        orderData.appendChild(dataText); orderData.appendChild(dataNum);
        parteSopra.appendChild(orderData);

        
        //creo numero prodotti ordine
        var orderNumberProduct = document.createElement('div');
        orderNumberProduct.className = 'orderNumberProduct';
        var numProdText = document.createElement('p');
        numProdText.textContent = 'Prodotti: ';
        var numProdNum = document.createElement('h4');
        numProdNum.textContent = 5;                         //prendere valore dinamicamente da db


        orderNumberProduct.appendChild(numProdText); orderNumberProduct.appendChild(numProdNum);
        parteSopra.appendChild(orderNumberProduct);




        
        //creo sezione lista prodotti
        var listaItem = document.createElement('div');
        listaItem.className = 'listaItem';
        console.log('creo lista prodotti');
        
        order.appendChild(parteSopra);
        console.log('aggiungo parte sopra');
        
        order.appendChild(listaItem);
        console.log('aggiungo lista item')


        //creo prodotti
        for ( var contatoreItem = 1 ; contatoreItem <= 3 ;  contatoreItem++){              //bisogna recuperare il numero dei prodotti
            console.log('nel secondo for');


            //creazione e aggiunta linea divisoria
            var hr1 = document.createElement('hr');
            listaItem.appendChild(hr1);
            console.log('creo prima linea');

            //creo item
            var item = document.createElement('div');
            item.className = 'item';
            console.log('creo prodotto');
            
            //creo sfondo
            var backOrd = document.createElement('img');
            backOrd.className = 'backgroundOrder';
            backOrd.src = './img/HamPlanet_ORDER.png'  
            console.log('creo sfondo prodotto');

            //parte sinistra con immagine
            var leftOrder = document.createElement('div');
            leftOrder.className = 'leftOrder';
            leftOrder.style.backgroundImage = 'D:\\Document\\catello\\HamPlanet\\Product\\prosciutto_crudo_01.jpg';       //ogni volta devo recuperare l'immagine del prodotto
            console.log('creo immagiine sx del prodotto');

            //parte destra
            var rightOrder = document.createElement('div');
            rightOrder.className = 'rightOrder';
            console.log('creo contenitore parte dx');

            //rigo1
            var orderRow1 = document.createElement('div');
            orderRow1.className = 'orderRow';
            console.log('creo rigo 1');

            //nome prodotto
            var itemNome = document.createElement('div');
            itemNome.className = 'itemNome';
            var titolo = document.createElement('h3');
            titolo.textContent = 'nuovo titolo' + contatoreItem ;                         //recuperare titolo da database
            console.log('creo nome prodotto');

            itemNome.appendChild(titolo);
            console.log('aggiungo titolo');

            //prezzo prodotto
            var itemPrezzo = document.createElement('div');
            itemPrezzo.className = 'itemPrezzo';
            var iPr1 = document.createElement('h3');
            iPr1.innerHTML = '&euro;';
            var costoProdotto = document.createElement('h3');
            costoProdotto.textContent = '00,00'                         //recuperare prezzo da db
            console.log('creo prezzo');

            itemPrezzo.appendChild(iPr1); itemPrezzo.appendChild(costoProdotto);
            console.log('aggiungo prexxo');

            orderRow1.appendChild(itemNome);
            orderRow1.appendChild(itemPrezzo);
            console.log('aggiungo nome e prezzo al primo rigo');

            //rigo2
            var orderRow2 = document.createElement('div');
            orderRow2.className = 'orderRow2';
            console.log('creo secondo rigo');

            //descrizione prodotto
            var itemDescription = document.createElement('div');
            itemDescription.className = 'itemDescription';
            var descr = document.createElement('p');
            descr.textContent = 'descrizione del prodotto'              //bisogna prendere le informazioni del prodotto dal db
            console.log('creo descrizione prodotto');

            itemDescription.appendChild(descr);
            console.log('add descrizione');

            //quantita prodotto
            var itemQuantita = document.createElement('div');
            itemQuantita.className = 'itemQuantita';
            var iPr2 = document.createElement('p');
            iPr2.innerHTML = 'Quantit'+'\u00E0'+':';
            var quantitaProdotto = document.createElement('h4');
            quantitaProdotto.textContent = '3'                          //recuperare quantita acquistata da db
            console.log('creo quantità');

            itemQuantita.appendChild(iPr2); itemQuantita.appendChild(quantitaProdotto);
            console.log('add oggetti');

            orderRow2.appendChild(itemDescription);
            orderRow2.appendChild(itemQuantita);
            console.log('aggiungo oggetti al rigo 2');

            //comporre item
            rightOrder.appendChild(orderRow1);
            rightOrder.appendChild(orderRow2);
            console.log('aggiungo i due rigi a parte destra ordine');

            item.appendChild(backOrd);
            item.appendChild(leftOrder);
            item.appendChild(rightOrder);
            console.log('aggiungo tutte le cose a prodotto');


            listaItem.appendChild(item);
            console.log('aggiungo prodotto a lista prodotti');


            //creazione e aggiunta linea divisoria 
            var hr2 = document.createElement('hr');
            listaItem.appendChild(hr2);
            console.log('aggiungo seconda linea');

        }
        
        //creo sezione prezzo
        var parteSotto = document.createElement('div');
        parteSotto.className = 'parteSotto';
        console.log('creo parte sotto');


        //aggiungo prezzo
        var priceText = document.createElement('p');
        priceText.innerHTML = 'Totale &euro;';
        var priceNum = document.createElement('h4');
        priceNum.textContent = ' 99,99' ;                   //prendere valore da db

        parteSotto.appendChild(priceText);
        parteSotto.appendChild(priceNum);



        
        order.appendChild(parteSotto);
        console.log('aggiungo parte sotto');

        boxOrdini.appendChild(order);
        console.log('aggiungo ordine a lista ordini');

    }
       
}




//#####################################################################################
//##############         MODIFICA CAMPI INFORMAZIONI PERSONALI        #################
//#####################################################################################
function changeValue(value){
	
	
    
    //per evitare che clicca altro
    document.getElementById('contenitore').style.pointerEvents = 'none';

    
    //NUMERO DI TELEFONO
    if (value == 0){
	
        //FAR COMPARIRE FORM
        var box = document.getElementById('modifyNumber');      //box che deve visualizzare [cambiare]
        
        //icona x annullamento
        var x = document.getElementById('annullOperation_0');
        
        
        //effetto blur sfondo
        document.getElementById('contenitore').style.filter = 'blur(10px)';
        
        //dispay flex
        box.style.display = 'flex';
        document.getElementById('formModifyNumber').style.display = 'flex';
        
        
        
        //mostrare finestra
        box.style.opacity = '100';
        
        //dimensioni
        setTimeout(function(){ 
            box.style.bottom = 'calc(50% - 75px)';
            box.style.height = '150px'; 
            box.style.width = '350px'; 
            document.getElementById('titleModify0').style.fontSize = '20px';
            
            //icona x annullamento
            x.style.height = '19%';

        }, 80)

        setTimeout(function(){
            x.style.rotate = '360deg'
        },150)
        
        

    }



    
    //PASSWORD
    else if (value == 1){

        //oggetto contenitore
        var box = document.getElementById('modifyPass');
        
        //icona x annullamento
        var x = document.getElementById('annullOperation_1');
        
        //effetto blur sfondo
        document.getElementById('contenitore').style.filter = 'blur(10px)';
        
        //dispay flex
        box.style.display = 'flex';
        document.getElementById('formModifyPass').style.display = 'flex';
        
        //mostrare finestra
        box.style.opacity = '100';
        
        //dimensioni
        setTimeout(function(){ 
            box.style.bottom = 'calc(50% - 175px)';
            box.style.height = '350px'; 
            box.style.width = '350px'; 
            document.getElementById('titleModify1').style.fontSize = '20px';
            
            //icona x annullamento
            x.style.height = '9.5%';

        }, 80)

        setTimeout(function(){
            x.style.rotate = '360deg'
        },150)
        
        
    }


    
    //INDIRIZZO
    else if (value == 2){
        //oggetto contenitore
        var box = document.getElementById('modifyAddress');
        
        //icona x annullamento
        var x = document.getElementById('annullOperation_2');
        
        //effetto blur sfondo
        document.getElementById('contenitore').style.filter = 'blur(10px)';
        
        //dispay flex
        box.style.display = 'flex';
        document.getElementById('formModifyAddress').style.display = 'flex';
        
        //mostrare finestra
        box.style.opacity = '100';
        
        //dimensioni
        setTimeout(function(){ 
            box.style.bottom = 'calc(50% - 125px)';
            box.style.height = '250px'; 
            box.style.width = '350px'; 
            document.getElementById('titleModify2').style.fontSize = '20px';
            
            //icona x annullamento
            x.style.height = '13.3%';

        }, 80)

        setTimeout(function(){
            x.style.rotate = '360deg'
        },150)
    }

}






//#####################################################################################
//###################         CONTROLLA SE INPUT E' VALIDO        #####################
//#####################################################################################
var campo_valid = false
var requiredPoint = 0


function controlCaracter(typeCar){
    var tel = document.getElementById('tel');

    
    //numero telefonico
    if (typeCar == 0){
        if ( (/[^0-9]/.test(tel.value))){   
            tel.value = tel.value.substring(0,tel.value.length-1);
            campo_valid = false;
        }
        
        if (tel.value.length == 9 || tel.value.length == 10){
            campo_valid = true;
        }
    }


    else if (typeCar == 1){

        //controllo per css se il campo è vuoto

        var pass0 = document.getElementById('pass0').value;
        var pass1 = document.getElementById('pass1').value;
        var pass2 = document.getElementById('pass2').value;

        //controllo se un campo è vuoto
        if (pass0 == ''){
            campo_valid = false
        }
        if (pass1 == ''){
            campo_valid = false
        }
        if (pass2 == ''){
            campo_valid = false
        }



        //------------------------------------------------------> controllo se la vecchia password è quella giusta



        //controllo se le password sono uguali
        if (pass1 == pass2 && pass1 != ''){
            campo_valid = true;
        } else {
            campo_valid = false;
        }


        
        //controllo sulla fotmattazione della password

        var pass = document.getElementById('pass1');
        var progressBar = document.getElementById('progress-done');
    
        var larghezza = 0;
        
        //controlla lunghezza
        if (pass.value.length >= 8){
            document.getElementById('lunghezza').style.color = '#007d1b'; //metto a verde
            larghezza = larghezza + 25;
        }
        else{
            document.getElementById('lunghezza').style.color = 'gray';   //metto a grigio     
        }
    
        //controlla numero
        if (/[1234567890]/.test(pass.value)){
            document.getElementById('number').style.color = '#007d1b'; //metto a verde
            larghezza = larghezza + 25;
        }
        else{
            document.getElementById('number').style.color = 'gray';   //metto a grigio
        }
        
        //controlla carattere speciale
        if (/[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]/.test(pass.value)){
            document.getElementById('special').style.color = '#007d1b'; //metto a verde
            larghezza = larghezza + 25;
        }
        else{
            document.getElementById('special').style.color = 'gray';   //metto a grigio
        }
        
        
        //controlla lettera maiuscola
        if (/[A-Z]/.test(pass.value)){
            document.getElementById('uppercase').style.color = '#007d1b'; //metto a verde
            larghezza = larghezza + 25;
        }
        else{
            document.getElementById('uppercase').style.color = 'gray';   //metto a grigio
        }
    
        if (requiredPoint < 100){campo_valid = false}

        requiredPoint = larghezza;
        progressBar.style.width = larghezza +'%';
       
    }    

    else if (typeCar == 2){

    }
}


//#####################################################################################
//#################         CONTROLLO FORMATTAZIONE PASSWORD        ####################
//#####################################################################################
function attribRequest (){

    //oggetto lista
    var toDoList = document.getElementById('ToDoList');
    
    //nascondere quello che c'è prima
    document.getElementById('mess1').style.scale = 0;
    document.getElementById('mess1').style.transform = 'translateY(0)';
    
    //mostrare lista
    toDoList.style.scale = 1;
    
}


function attribRequestHidden (){
    
    var toDoList = document.getElementById('ToDoList');

    //nascondere lista
    toDoList.style.scale = 0;  

    
}







//#####################################################################################
//#################         MOSTRARE/NASCONDERE LA PASSWORD        ####################
//#####################################################################################
function showPwd(num){
    var eyes = document.getElementById(('eyesIcon' + num));

    //creo id in base a quello dell'occhio
    var boxPass = document.getElementById(('pass' + num));

    //se occhio è aperto, quindi password visibile metto invisibile
    if (boxPass.type == 'text'){
        boxPass.type = 'password';
        eyes.src = './Icon/eyes_hidden2_WHITE.png'
    }

    //se occhio è chiuso, quindi password invisibile metto visibile
    else if (boxPass.type == 'password'){
        boxPass.type = 'text';
        eyes.src = './Icon/eyes_show_WHITE.png'
    }
}







//#####################################################################################
//#####################         RIMPICCIOLIRE LA FINESTRA        ######################
//#####################################################################################
var clicked = false;
function resizeWindow(event, value){

    //controllo se è finstra modifica numero
    if (event.target.id.substring(event.target.id.length -1, event.target.id.length) == 0){
        
        //contenitore
        var box = document.getElementById('modifyNumber');
        
        //form
        var form = document.getElementById('formModifyNumber');
        
        //bottone x
        var buttonX = document.getElementById('annullOperation_0');
        
        //titolo
        var titolo = document.getElementById('titleModify0');
    }

    //controllo se è finestra modifica password
    else if ( event.target.id.substring(event.target.id.length -1, event.target.id.length) == 1 ){
        
        //contenitore
        var box = document.getElementById('modifyPass');
        
        //form
        var form = document.getElementById('formModifyPass');
        
        //bottone x
        var buttonX = document.getElementById('annullOperation_1');
        
        //titolo
        var titolo = document.getElementById('titleModify1');
    }


    //controllo se è finestra modifica indirizzo
    else if (event.target.id.substring(event.target.id.length -1, event.target.id.length) == 2){
        //contenitore
        var box = document.getElementById('modifyAddress');
        
        //form
        var form = document.getElementById('formModifyAddress');
        
        //bottone x
        var buttonX = document.getElementById('annullOperation_2');
        
        //titolo
        var titolo = document.getElementById('titleModify2');
    }




    //non inviare la form subito
    event.preventDefault(); 


    if (campo_valid == true || value == 'annull'){
	
        if(event.target.id == 'buttonInvio_1')


        buttonX.style.scale = '0';

        //cambiare dimensioni form
        form.style.opacity = '0';

        setTimeout(function(){
            box.style.padding = '2%'
            box.style.bottom = '50%'
            box.style.height = '0';
            box.style.width = '0';
            titolo.style.fontSize = '0px';
            box.style.filter = 'none';

        },400)
  
        
        //mostrare iconcina faccina
        setTimeout(function(){

            //per fare in modo che clicchi una sola volta
            if(!clicked){
                var iconaOK = document.createElement('img');
    
                if (value == 'annull'){
                    iconaOK.src = "./Icon/noWink_WHITE.png"
                } 
                else {
                    iconaOK.src = "./Icon/wink_WHITE.png"
                }
                iconaOK.style.display = 'absolute';
                iconaOK.style.height = '100px'
                iconaOK.style.top = '0'
    
                box.appendChild(iconaOK);
                
                clicked = true;
            }
        },700)
        
    }

    
    if (campo_valid == true){
	
	
	
	  closeWindow(buttonX, form, box, titolo, value);

        //inviare la form dopo 500ms
        setTimeout(function(){

            //invia form
            form.submit();
        }, 2000)
        
    }

    else if (campo_valid == false){

        var pass0 = document.getElementById('pass0');
        var pass1 = document.getElementById('pass1');
        var pass2 = document.getElementById('pass2');

        var mess0 = document.getElementById('mess0');
        var mess1 = document.getElementById('mess1');
        var mess2 = document.getElementById('mess2');

        
        
        
        //vede se uno dei campi è vuoto
        if (pass0.value == '' || pass1.value == '' || pass2.value == ''){
            if (pass0.value == ''){
                mess0.style.scale = 1;
                mess0.style.transform = 'translateY(150%)';
                mess0.innerHTML = 'Inserire Password';
                setTimeout(function(){mess0.style.scale = 0;}, 1500)
            }

            if (pass1.value == ''){
                
                document.getElementById('ToDoList').style.scale = 0;
                document.getElementById('ToDoList').style.transform = 'translateY(0)'

                mess1.style.scale = 1;
                mess1.style.transform = 'translateY(150%)';
                mess1.innerHTML = 'Inserire Password';
                setTimeout(function(){mess1.style.scale = 0;}, 1500)
            }

            if (pass2.value == ''){
                mess2.style.scale = 1;
                mess2.style.transform = 'translateY(150%)';
                mess2.innerHTML = 'Inserire Password';
                setTimeout(function(){mess2.style.scale = 0;}, 1500)
            }
        }



        //se password vecchia corrisponde con quella originale
        else if (false){
            
            //----------------------------------------------------> aggiungere controllo sulla vecchia password dal DB
            
            mess0.style.scale = 1;
            mess0.style.transform = 'translateY(150%)';
            mess0.innerHTML = 'Password sbagliata';
            setTimeout(function(){mess0.style.scale = 0;}, 1500)
        }



        //se password non rispetta valori
        else if (requiredPoint < 100){
            mess1.style.scale = 1;
            mess1.style.transform = 'translateY(150%)';
            mess1.innerHTML = 'Password non valida';
            setTimeout(function(){mess1.style.scale = 0;}, 1500)
        }

        //password diverse
        if (pass1.value != pass2.value){

            //effetto vibrazione
            pass1.style.transform = 'translateX(-4%)'; pass2.style.transform = 'translateX(-4%)';
            setTimeout(function(){ pass1.style.transform = 'translateX(4%)'; pass2.style.transform = 'translateX(4%)' },100)
            setTimeout(function(){ pass1.style.transform = 'translateX(-4%)'; pass2.style.transform = 'translateX(-4%)' },200)
            setTimeout(function(){ pass1.style.transform = 'translateX(4%)'; pass2.style.transform = 'translateX(4%)' },300)
            setTimeout(function(){ pass1.style.transform = 'translateX(0%)'; pass2.style.transform = 'translateX(0%)' },400)
            
            //messaggio popup
            mess2.style.scale = 1;
            mess2.style.transform = 'translateY(150%)'
            mess2.innerHTML = 'La password non corrisponde';
            

            setTimeout(function(){mess2.style.scale = 0}, 1500)
        }


		if(value == 'annull'){
			setTimeout(function(){
            	location.reload();
        	}, 2000)	
		}
    }


}



//#####################################################################################
//#######################         INVIO FORM INDIRIZZO        #########################
//#####################################################################################

function submitModifyAddress (event, operation) {

    //contenitore
    var box = document.getElementById('modifyAddress');
        
    //form
    var form = document.getElementById('formModifyAddress');
    
    //bottone x
    var buttonX = document.getElementById('annullOperation_2');
    
    //titolo
    var titolo = document.getElementById('titleModify2');


    
    
    //PER ANNULLARE LA FORM
    if (operation == 'annull'){
        closeWindow(buttonX, form, box, titolo, operation);
        
        setTimeout(function(){
            box.style.opacity = 0;
            document.getElementById('contenitore').style.filter = 'none';
            
            
            //non inviare la form subito
            event.preventDefault(); 
            location.reload();
        }, 1500)
    }
    



    //PER INVIARE LA FORM CON MODIFICHE
    else if( operation == 'submit'){
        
        //non inviare la form subito
        event.preventDefault();
        
        
        //controllo se campi non sono vuoti
        if (fieldVoid()){
            //chiusura finestra
            closeWindow(buttonX, form, box, titolo, operation);
            
            setTimeout(function(){
                box.style.opacity = 0;
                document.getElementById('contenitore').style.filter = 'none';
                
                //inviare la form subito
                form.submit();
            }, 1500)
        }
            

        
    }

}




//#####################################################################################
//##################         FUNZIONE PER CHIUDERE FINESTRA        ####################
//#####################################################################################

function closeWindow(buttonX, form, box, titolo, operation){
	
    buttonX.style.scale = '0';

        //cambiare dimensioni form
        form.style.opacity = '0';

        setTimeout(function(){
            box.style.padding = '2%'
            box.style.bottom = '50%'
            box.style.height = '0';
            box.style.width = '0';
            titolo.style.fontSize = '0px';
            box.style.filter = 'none';

        },400)
  
        
        //mostrare iconcina faccina
        setTimeout(function(){

            //per fare in modo che clicchi una sola volta
            if(!clicked){
                var iconaOK = document.createElement('img');
    
                if (operation == 'annull'){
                    iconaOK.src = "./Icon/noWink_WHITE.png"
                } 
                else {
                    iconaOK.src = "./Icon/Wink_WHITE.png"
                }
                iconaOK.style.display = 'absolute';
                iconaOK.style.height = '100px'
                iconaOK.style.top = '0'
    
                box.appendChild(iconaOK);
                
                clicked = true;
            }
        },700)
}






//#####################################################################################
//#################         FUNZIONE CONTROLLA SE CAMPI VUOTI        ##################
//#####################################################################################

function fieldVoid(){
    var via = document.getElementById('via');
    var paese = document.getElementById('paese');
    var provincia = document.getElementById('provincia');
    var cap = document.getElementById('cap');

    if(via.value != '' && paese.value != '' && provincia.value != '' && cap.valid != ''){
        return true;
    }
}






//#####################################################################################
//#####################         CONTROLLO CAMPI INDIRIZZO        ######################
//#####################################################################################

function controllAddressField (field) {

    var via = document.getElementById('via');
    var paese = document.getElementById('paese');
    var provincia = document.getElementById('provincia');
    var cap = document.getElementById('cap');


    //via
    if (field == 0){
    }

    //paese
    else if(field == 1){
        if ( (/[0-9!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]/.test(paese.value))){   
            paese.value = paese.value.substring(0,paese.value.length-1);
        }
    }

    //provincia
    else if (field == 2){
        if ( (/[^a-zA-Z]/.test(provincia.value))){   
            provincia.value = provincia.value.substring(0,provincia.value.length-1);
        }

        provincia.value = provincia.value.toUpperCase();
    }

    //cap
    else if (field == 3){
        if ( (/[^0-9]/.test(cap.value))){   
            cap.value = cap.value.substring(0,cap.value.length-1);
        }
    }


}