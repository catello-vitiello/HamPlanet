


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
            backOrd.src = 'C:\\Users\\catel\\Desktop\\HamPlanet_ORDER_V2.png'  
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


