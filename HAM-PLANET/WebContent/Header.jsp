<%@page import="model_prodotto.ProdottoBean"%>
<%@page import="model_cliente.ClienteBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% response.sendRedirect("HomePage.jsp"); %>

<!DOCTYPE html>
<html>
<head>

<script>
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			var jsonString = this.responseText;
			var jsonData = JSON.parse(jsonString);

			var selectElement = document.getElementById("searchBarID");

			for ( var campo in jsonData) {
				if (jsonData.hasOwnProperty(campo)) {
					var option = document.createElement("option");
					option.text = jsonData[campo];
					selectElement.add(option);
				}
			}
		}
	};
	xhttp.open("GET", "RecuperoTipologia", true);
	xhttp.send()
</script>


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
			<a class="header_logo" href="HomePage.jsp"> <!--LINK TO HOME--> <img
				type="svg" src="./Icon/TotalLogo_WHITE.svg" alt="">
			</a>

			<!-- lista menu -->
			<ul id="headerMenu" class="header_menu">
				<li><a href="./Store.jsp">Store</a></li>
				<li><a href="./HamPlanetFamily.jsp">Chi Siamo</a></li>
			</ul>

			<!-- icone cercare e carrello-->
			<div class="header_icon">

				<!-- SELECT PER IL SEARCH -->
                <form id="formSearchBar" class="formSearchBar" action="">
                        <select id="searchBarID" class="searchBar" name="tipologiaProdotto">
                        </select>

                        <input id="" type="submit" name="" >
				</form>

				<!-- SEARCH -->				
				<img src="./Icon/search2_WHITE.png" onclick="showSearch()" alt="">

				<!-- USER -->
				<a href="./UserArea.jsp"> <img src="./Icon/user_WHITE.png"
					alt="">
				</a>

				<!-- CARRELLO -->
				<a href="./Carrello.jsp"> <!--LINK TO CARRELLO--> <img
					src="./Icon/cart_WHITE.png" alt="">
				</a>
			</div>

		</div>
	</header>

</body>
</html>