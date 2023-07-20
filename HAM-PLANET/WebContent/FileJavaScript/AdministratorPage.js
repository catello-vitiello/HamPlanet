

function controlCaracter (operation){

    var id = document.getElementById('idNP')
    var nome = document.getElementById('nameNP')
    var price = document.getElementById('priceNP');
    var peso = document.getElementById('weightNP')


    //ID
    if (operation == 0){
        id.value = id.value.replace(/[^\d]/g, "")
    }
    
    
    //NOME
    else if (operation == 1){
        id = document.getElementById('idNP2')
        
        id.value = id.value.replace(/[^\d]/g, "");
    }


    //PREZZO
    else if (operation == 2){

        //rimozione caratteri non validi
        price.value = price.value.replace(/[^\d.]/g, "");

        //controllo che non inizia con punto
        if (price.value == '.'){
            price.value = '';
        }

        //controllare che possiede un solo punto
        if (price.value.match(/\./g).length > 1 && price.value.substring(price.value.length -1, price.value.length) == '.'){
            price.value = price.value.substring(0, price.value.length-1);
        }
        
        //avere al massimo due caratteri dopo la virgola
        if (price.value.indexOf('.') != -1){
            if((price.value.length - price.value.indexOf('.') -1) > 2 ){
                price.value = price.value.substring(0, price.value.length-1);
            }
        }
    }


    //PESO
    else if (operation == 3){
        peso.value = peso.value.replace(/[^\d,]/g, "");


        //controllo che non inizia con punto
        if (peso.value == ','){
            peso.value = '';
        }

        //controllare che possiede un solo punto
        if (peso.value.match(/\,/g).length > 1 && peso.value.substring(peso.value.length -1, peso.value.length) == ','){
            peso.value = peso.value.substring(0, peso.value.length-1);
        }
        
        //avere al massimo due caratteri dopo la virgola
        if (peso.value.indexOf(',') != -1){
            if((peso.value.length - peso.value.indexOf(',') -1) > 2 ){
                peso.value = peso.value.substring(0, peso.value.length-1);
            }
        }
    }

    else if (operation == 4){
        id = document.getElementById('idNP3')
        
        id.value = id.value.replace(/[^\d]/g, "");
    }

}






