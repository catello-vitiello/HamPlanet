//#########################################################################################################
//#####################################		MOSTRARE MENU CON BOTTONE	###################################
//#########################################################################################################


var aperto = false;

function showMenu(){
    var menu = document.getElementById('headerMenu')

    //devo chiudere
    if (aperto == false){

        menu.style.height = '200%';
        menu.style.overflow = 'hidden';

        aperto = true;
    }

    //devo aprire
    else if (aperto == true){
        menu.style.height = '0';
        menu.style.overflow = 'hidden';
        
        aperto = false;
    }


    
}


//#########################################################################################################
//#################################		RENDERE VISIBILE MENU IN MEZZO	###################################
//#########################################################################################################
function showMenuOverSize(){    
    //recupero valori    
    var larg = window.innerWidth;
    var menu = document.getElementById('headerMenu')
    
    //controllo se dimensione è maggiore di 768
    if (larg > 768){

        menu.style.height = '100%';
        menu.style.overflow = 'hidden';

        aperto = true;

    }
    
    else if ( larg <= 768){
		menu.style.height = '0';	
	}
    
    
}

//chiamata ad ogni resize della finestra
window.addEventListener('resize', showMenuOverSize);

//chiamata all'inizio
showMenuOverSize();





//##################################################################################
//##############     FUNZIONE PER RENDERE VISIBILE SELECT   ########################
//##################################################################################
var boolSearch = false;

function showSearch(){
    var searchBarID = document.getElementById('searchBarID');


    if (boolSearch){
        searchBarID.style.width = '0';
        
        setTimeout(function(){
            searchBarID.style.opacity = '0';
        }, 50)
    
        boolSearch = false;

       
    }

    else {

        searchBarID.style.opacity = '1';
    
        setTimeout(function(){
            searchBarID.style.width = '40%';
        }, 100)

        boolSearch = true;
    }


}
