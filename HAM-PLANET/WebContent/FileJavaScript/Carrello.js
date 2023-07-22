//##############################################################################################
//#######################   FUNZIONE CHE CONTROLLA VALORI INPUT    #############################
//##############################################################################################
function inputControl(event){
    var numProd = document.getElementById(event.target.id);
    
    //controlla si inseriscano solo numeri
    if ((/[^0-9]/.test(numProd.value))) {
        numProd.value = numProd.value.substring(0, numProd.value.length - 1);
    }
    
    //avere massimo 10 elementi di un prodotto
    if (numProd.value > 10){
        numProd.value = 10;
    }
    
    
}


//##############################################################################################
//#######################   CONTROLLA CHE CAMPO NON SIA VUOTO    #############################
//##############################################################################################
function minValue(){
    var numProd = document.getElementById('numProdotti');

    //non avere campo vuoto
    if ( numProd.value < 1){
        numProd.value = 1;
    }
}


//##############################################################################################
//#######################   AUMENTARE/DIMINUIRE QUANTITA    #############################
//##############################################################################################


function changeValue(operation, event){

    //per estrarre il numero dell'item del prodotto
    var numeroItem = event.target.id.substring(0,1);

    //prezzo del singolo prodotto
    var singlePrice = document.getElementById('singlePrice'+numeroItem);

    //quantita di un prodotto
    var numProd = document.getElementById('numProdotti'+numeroItem);
    
    //prezzo totale prodotto
    var prezzoTotale = document.getElementById('priceProduct'+numeroItem);

    //subtotale
    var subTotale = document.getElementById('subtotal');

    //spedizione
    var spediction = document.getElementById('spediction');

    //totale
    var totale = document.getElementById('total');
    
    //prezzo prodotto da eliminare
    var priceItemDelete = 0;


    //sottrazione
    if (operation == 0){


        
        //sottraggo 1 alla quantita
        if (numProd.value > 1){
            numProd.value = parseInt(numProd.value) - 1 ;
        }

        //eliminazione del prodotto
        else if (numProd.value == 1){
	
			//recupero stringa del prezzo
            var stringPrice = document.getElementById('singlePrice'+numeroItem).textContent;

            //converto stringa in numero 
            priceItemDelete = parseFloat(stringPrice.substring(1,stringPrice.length));

            
            deleteProduct('item'+numeroItem);
            

            var productOfCart = document.getElementById('productOfCart');
            var item = productOfCart.textContent.substring(0,1);
            if (item == 2){
                productOfCart.textContent = parseInt(item)-1 + ' prodotto'
            }
            else {
                productOfCart.textContent = parseInt(item)-1 + ' prodotti'
            }

            if(item == 1){
                document.getElementById('cartEmpty').style.scale = '1';
            }
        }


    }

    //addizzione
    else if (operation == 1){

        //aggiungo 1 alla quantita
        if (numProd.value <10){
            numProd.value = parseInt(numProd.value) + 1 ;
        }

    }
    
    
    
    
    //estraggo prezzo prodotto
    var costoOne = singlePrice.textContent.substring(2, singlePrice.textContent.length) 

    //estraggo prezzo totale
    var priceTotProd = parseFloat(prezzoTotale.textContent.substring(2,prezzoTotale.textContent.length))
    
    //estraggo valore subtotale
    var valsubtotal = parseFloat(subTotale.textContent.substring(1,subTotale.textContent.length))
    
    //sottraggo valore vecchio sub totale
    valsubtotal = valsubtotal - priceTotProd;
    
      
      
    //se ho eliminato il prodotto sottraggo prezzo del prodotto
    if ( operation== 0 ){
        valsubtotal = valsubtotal - priceItemDelete;
    }
    
    
    
    //aggiorno prezzo totale
    prezzoTotale.innerHTML = "&euro; " + (costoOne * parseInt(numProd.value)).toFixed(2);
    priceTotProd = parseFloat(prezzoTotale.textContent.substring(2,prezzoTotale.textContent.length))

    valsubtotal = (valsubtotal + priceTotProd).toFixed(2);
    subTotale.innerHTML = "&euro;"+valsubtotal;
    
    //totale + spedizione
    if(valsubtotal >= 160.00){
        totale.innerHTML = '&euro;' + valsubtotal;
        spediction.textContent = 'Gratis'
    }
    else{
        valsubtotal = (parseFloat( valsubtotal) + 5.99).toFixed(2);
        totale.innerHTML = '&euro;' + valsubtotal;
        spediction.innerHTML = '&euro;5.99'
    }
    
    
    
    
    if ( parseInt(productOfCart.textContent) == 0){
        totale.innerHTML = '&euro;0.00';
        spediction.innerHTML = '&euro;0.00'
	}

}



//##############################################################################################
//#######################   ELIMINAZIONE PRODOTTO DAL CARRELLO    #############################
//##############################################################################################
function deleteProduct(idProdotto){
    if (confirm("Sei sicuro di voler eliminare il prodotto da carrello?")){
        document.getElementById(idProdotto).remove()
    }
    
}



