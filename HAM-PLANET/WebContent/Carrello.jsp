<%@page import="carrello_model.CarrelloBean"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="model_cliente.ClienteBean"%>
<%@page import="gestione_funz.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%
ClienteBean user = (ClienteBean) session.getAttribute("user");

if (user == null) {

	response.sendRedirect("./Login.jsp");

	return;

}

Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");

if (prodotti == null) {

	response.sendRedirect("CarrelloControl");

	return;

}

Collection<?> card = (Collection<?>) session.getAttribute("ListaCarte1");
session.setAttribute("ListaCarte1", card);
%>



<%
int size = 0;

if (prodotti != null && prodotti.size() > 0) {

	Iterator<?> it = prodotti.iterator();

	while (it.hasNext()) {

		CarrelloBean bean = (CarrelloBean) it.next();

		size += bean.getQuantity();

	}
}
%>



<!DOCTYPE html>

<html dir="ltr">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Carrello</title>

<link rel="stylesheet" href="./FileCSS/Carrello.css">

<script src="./FileJavaScript/Carrello.js"></script>

<link rel="Website Icon" type="png" href="./Icon/OnlyLogo_RED.svg">

</head>



<body>





	<jsp:include page="./Header.jsp"></jsp:include>



	<div class="content">



		<!-- TITOLO DEL CARRELLO -->

		<div class="titleCart">

			<p class="cartTitle">Carrello</p>

			<p id="productOfCart" class="prodTitle"><%=size%>

				prodotti

			</p>

		</div>



		<hr>



		<!-- CONTENITORE CARRELLO -->

		<div class="contentCart">



			<!-- LISTA PRODOTTI -->

			<div class="boxProduct">



				<p id="cartEmpty">Carrello Vuoto</p>



				<%
				double tot = 0;

				if (prodotti != null && prodotti.size() > 0) {

					Iterator<?> iterator = prodotti.iterator();

					while (iterator.hasNext()) {

						CarrelloBean bean = (CarrelloBean) iterator.next();

						tot += bean.getPrezzo() * bean.getQuantity();
				%>



				<!-- PRODOTTO -->

				<div id="item0" class="item">



					<!-- IMAGE -->

					<div class="img">

						<img src="./ImageProductServlet?id=<%=bean.getIan()%>" />

					</div>



					<!-- DESCRIPTION -->

					<div class="itemContent">

						<div class="firstRow">

							<p id="nameProduct0" class="nameProduct"><%=bean.getNomeProdotto()%></p>

						</div>



						<div class="secondRow">

							<p id="singlePrice0" class="singlePrice">

								&euro;

								<%=bean.getPrezzo()%></p>

							<p id="priceProduct0" class="priceProduct">

								&euro;

								<%=bean.getPrezzo() * bean.getQuantity()%></p>

						</div>



						<div class="thirdRow">



							<form action="CarrelloControl" method="post" class="menoButton">

								<input type="text" name="ian" value="<%=bean.getIan()%>"
									hidden> <input type="text" name="serv" value="minus"
									hidden> <input type="submit" value="-" id="0meno">

							</form>



							<input id="numProdotti0" class="numProdotti"
								oninput="inputControl(event)" onblur="minValue()" type="text"
								value="<%=bean.getQuantity()%>" readonly="readonly">





							<form action="CarrelloControl" method="post" class="piuButton">

								<input type="text" name="ian" value="<%=bean.getIan()%>"
									hidden> <input type="text" name="serv" value="plus"
									hidden> <input type="submit" value="+" id="0piu">

							</form>

						</div>

					</div>



				</div>

				<%
				}
				}

				String numeroFormattato = String.format("%.2f", tot);

				double sped = 5.99;

				String numeroFormattato1 = String.format("%.2f", tot + sped);
				%>

			</div>



			<!-- RIEPILOGO -->

			<form action="CarrelloControl" method="post" class="boxRiepilogo">


				<!-- VALORI NASCOSTI -->

				<input type="text" name="serv" value="finalizza" hidden>


				<h3>Riepilogo</h3>


				<!-- SUBTOTALE -->

				<div class="rowSummary">

					<p>Subtotale</p>

					<p id="subtotal">
						&euro;<%=numeroFormattato%></p>

				</div>



				<div class="rowSummary">

					<p>Spedizione</p>


					<%
					if (tot >= 160) {
					%>

					<p id="spediction">Gratis</p>

				</div>



				<div class="rowSummary" style="font-weight: 600;">

					<p>Totale</p>

					<p id="total">
						&euro;<%=numeroFormattato%></p>

				</div>


				<%
				} else {
				%>

				<p id="spediction">
					&euro;<%=sped%></p>
		</div>


		<!-- TOTALE 2 -->

		<div class="rowSummary" style="font-weight: 600;">

			<p>Totale</p>

			<p id="total">
				&euro;<%=numeroFormattato1%></p>

		</div>


		<%
		}
		%>


		<!-- SELEZIONE CARTA -->

		<div class="rowSummary">

			<p>Seleziona carta</p>

			<select name="" id="">

				<%
				if (card != null && card.size() > 0) {

					Iterator<?> iterator = card.iterator();

					while (iterator.hasNext()) {

						CercaCarteClienteBean c = (CercaCarteClienteBean) iterator.next();
				%>

				<option><%=c.getNc()%></option>

				<%
				}
				}
				%>

			</select>

		</div>


		<%
		if (size > 0) {
		%>

		<input type="submit" id="finishOrder" value="Continua per acquistare">

		<%
		}
		%>

		</form>

	</div>

	</div>

</body>

</html>