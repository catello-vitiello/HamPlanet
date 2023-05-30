


//#####################################################################################
//############         CONTROLLO PER VEDERE QUALE PAGINA MOSTRARE        ##############
//#####################################################################################

function changePage (value){
    var one = document.getElementById('one')    
    var two = document.getElementById('two')
    var three = document.getElementById('three')  
    

    //prima pagina -> INFORMAZIONI PERSONALI
    if (value == 0){
        if (three.style.display == 'block'){
            three.style.opacity = '0%';
            setTimeout(function(){three.style.opacity = '100%';}, 410)
        }
        else if (two.style.display == 'block'){
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
        
    }
}




//#####################################################################################
//############         AGGIUNGERE ELEMENTI DINAMICAMENTE        ##############
//#####################################################################################
var i=1
function addCard(){

    // Step 1: Recupera il riferimento all'elemento genitore
    var boxCarte = document.getElementById("contenitoreCarte");

    var card = document.createElement('div'); card.className = 'card'; card.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) + 1);
    var icon = document.createElement('img'); icon.className = 'iconRemoveCard'; icon.id = 'cardN' + (parseInt(document.getElementById('CarteSalvate').textContent) +1) +'_remove'; icon.onclick = function() {confermaEliminazione(this)}; icon.src = "C:\\Users\\catel\\Desktop\\X_V1.png";
    var content = document.createElement('div'); content.className = 'content';
    var numberCard = document.createElement('p'); numberCard.id = 'numberCard'; numberCard.innerHTML = '****  ****  ****  777' + i++;
    var NameExpiration = document.createElement('div'); NameExpiration.className = 'NameExpiration';
    var monthyear = document.createElement('p'); monthyear.id = 'monthyear'; monthyear.innerHTML = 'MESE/ANNO';
    var row = document.createElement('div'); row.className = 'row';
    var owner = document.createElement('p'); owner.id = 'owner'; owner.innerHTML = 'VITIELLO CATELLO'
    var valid = document.createElement('p'); valid.id = 'valid'; valid.innerHTML = 'VALID'+'<br>'+ 'THRU';
    var expiration = document.createElement('p'); expiration.id = 'expiration'; expiration.innerHTML = '19/12';


    row.appendChild(owner), row.appendChild(valid), row.appendChild(expiration);
    NameExpiration.appendChild(monthyear); NameExpiration.appendChild(row);
    content.appendChild(numberCard); content.appendChild(NameExpiration);
    card.appendChild(icon); card.appendChild(content);


    // Step 4: Aggiungi l'elemento all'elemento genitore 
    boxCarte.insertBefore(card, boxCarte.childNodes[boxCarte.childNodes.length - 3]);
    
    
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




/*
function confermaEliminazione (item) {

    var itemRemove = document.getElementById(this.id);
    
    alert('id: ' + this.id);
    if (this.id == undefined){
        itemRemove = document.getElementById(item.id);

    }
    
    var conferma = window.confirm("Sei sicuro di voler eliminare questa carta?");

    if (conferma){
        itemRemove.remove();

        // Decrementare il contatore delle carte
        document.getElementById('CarteSalvate').innerHTML = parseInt(document.getElementById('CarteSalvate').textContent) - 1; 
    }
}

*/





//  ESEMPIO DI COME PRENDERE I DATI



