<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CARRELLO V1.0</title>
        <link rel="stylesheet" href="./FileCSS/Carrello.css">
        <script src="./FileJavaScript/Carrello.js"></script>
    </head>

    <body>
        <div class="content">
            
            <!-- TITOLO DEL CARRELLO -->
            <div class="titleCart">
                <p class="cartTitle">Carrello</p>
                <p id="productOfCart" class="prodTitle" >3 prodotti</p>
            </div>

            <hr>
            
            <!-- CONTENITORE CARRELLO -->
            <div class="contentCart">

                <!-- LISTA PRODOTTI -->
                <div class="boxProduct">

                    <p id="cartEmpty">Carrello Vuoto</p>

                    <!-- PRODOTTO -->
                    <div id="item0" class="item">

                        <!-- IMAGE -->
                        <div class="img"></div>

                        <!-- DESCRIPTION -->
                        <div class="itemContent">
                            <div class="firstRow">
                                <p id="nameProduct0" class="nameProduct">Prosciutto</p>
                            </div>
                            
                            <div class="secondRow">
                                <p id="singlePrice0" class="singlePrice" >&euro; 2.99</p>
                                <p id="priceProduct0" class="priceProduct" >&euro; 5.98</p>
                            </div>
                            
                            <div class="thirdRow">
                                <button id="0meno" class="menoButton" onclick="changeValue(0, event)">-</button>
                                <input id="numProdotti0" class="numProdotti" oninput="inputControl(event)" onblur="minValue()" type="text" value="2">
                                <button id="0piu" class="piuButton" onclick="changeValue(1, event)">+</button>
                            </div>
                        </div>

                    </div>

                    <div id="item1" class="item">

                        <!-- IMAGE -->
                        <div class="img"></div>

                        <!-- DESCRIPTION -->
                        <div class="itemContent">
                            <div class="firstRow">
                                <p id="nameProduct1" class="nameProduct">Prosciutto</p>
                            </div>
                            
                            <div class="secondRow">
                                <p id="singlePrice1" class="singlePrice" >&euro; 2.99</p>
                                <p id="priceProduct1" class="priceProduct" >&euro; 5.98</p>
                            </div>
                            
                            <div class="thirdRow">
                                <button id="1meno" class="menoButton" onclick="changeValue(0, event)">-</button>
                                <input id="numProdotti1" class="numProdotti" oninput="inputControl(event)" onblur="minValue()" type="text" value="2">
                                <button id="1piu" class="piuButton" onclick="changeValue(1, event)">+</button>
                            </div>
                        </div>

                    </div>

                    <div id="item2" class="item">

                        <!-- IMAGE -->
                        <div class="img"></div>

                        <!-- DESCRIPTION -->
                        <div class="itemContent">
                            <div class="firstRow">
                                <p id="nameProduct2" class="nameProduct">Prosciutto</p>
                            </div>
                            
                            <div class="secondRow">
                                <p id="singlePrice2" class="singlePrice" >&euro; 2.99</p>
                                <p id="priceProduct2" class="priceProduct" >&euro; 5.98</p>
                            </div>
                            
                            <div class="thirdRow">
                                <button id="2meno" class="menoButton" onclick="changeValue(0, event)">-</button>
                                <input id="numProdotti2" class="numProdotti" oninput="inputControl(event)" onblur="minValue()" type="text" value="2">
                                <button id="2piu" class="piuButton" onclick="changeValue(1, event)">+</button>
                            </div>
                        </div>

                    </div>

                </div>

                <!-- RIEPILOGO -->
                <div class="boxRiepilogo">
                    
                    <h3>Riepilogo</h3>
                    
                    <div class="rowSummary">
                        <p>Subtotale</p>
                        <p id="subtotal" >&euro;17.94</p>
                    </div>

                    <div class="rowSummary">
                        <p>Spedizione</p>
                        <p id="spediction">&euro;5.99</p>
                    </div>

                    <div class="rowSummary" style="font-weight: 600;">
                        <p>Totale</p>
                        <p id="total">&euro;23.93</p>
                    </div>

                    <button id="finishOrder">Continua per pagare</button>

                </div>


            </div>




        </div>
    </body>
</html>