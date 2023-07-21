<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title></title>
	<link rel="stylesheet" href="./FileCSS/Header.css">
	<script type="text/javascript" src="./FileJavaScript/Header.js"></script>
</head>

<body>
<header class="header">
            <div class="header_content">

                <div class="header_hamburger">
                    <img src="./Icon/menuHamburger.png" onclick="showMenu()" alt="">
                </div>


                <!-- logo ham planet -->
                <a class="header_logo" href="">  <!--LINK TO HOME-->
                    <img type="svg" src="./Icon/logo_WHITE.svg" alt="">
                </a>

                <!-- lista menu -->
                <ul id="headerMenu" class="header_menu">
                    <li><a href="">Store</a></li>
                    <li><a href="">Chi Siamo</a></li>
                </ul>

                <!-- icone cercare e carrello-->
                <div class="header_icon">
                    <!-- SEARCH -->
                    <img src="./Icon/search2_WHITE.png" alt="">
                    
                    <!-- USER -->
                    <a href="./UserArea.jsp">
                        <img src="./Icon/user_WHITE.png" alt="">
                    </a>
                    
                    <!-- CARRELLO -->
                    <a href="./Carrello.jsp">  <!--LINK TO CARRELLO-->
                        <img src="./Icon/cart_WHITE.png" alt="">
                    </a>
                </div>

            </div>
        </header>

</body>
</html>