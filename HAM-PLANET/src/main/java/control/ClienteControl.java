package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model_cliente.ClienteBean;
import model_cliente.ClienteModelDS;

@WebServlet("/ClienteControl")
public class ClienteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ClienteModelDS model = new ClienteModelDS(ds);
		
		String servizio = request.getParameter("servizio");

		String email, pass, nome, cognome, indirizzo;
		String sesso = request.getParameter("sesso");
		String cellulare = request.getParameter("cellulare");

		email = request.getParameter("email");
		pass = request.getParameter("pass");
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		indirizzo = request.getParameter("indirizzo");

		String chiave = request.getParameter("chiave");

		/********************************************************/
		/* 					REGISTRAZIONE	 					*/
		/********************************************************/
		if (email != null && pass != null && nome != null && cognome != null && sesso != null && indirizzo != null
				&& cellulare != null) {
			try {
				char sex = sesso.charAt(0);
				model.insert(email, pass, nome, cognome, sex, indirizzo, cellulare);
				response.sendRedirect("Admin.html"); // riga da eliminare ---> solo per test
				// response.sendRedirect(""); /*dopo la registrazione ti reindirizza verso
				// l'area di login*/
				return;
			} catch (SQLException e) {
				utils.UtilityClass.print(e);	
			}
		}

		/********************************************************/
		/* 						ELIMINAZIONE 					*/
		/********************************************************/
		if (chiave != null) {
			try {
				model.deleteCliente(chiave);
				response.sendRedirect("Admin.html"); /*
														 * Dopo che l'admin ha eliminato un utente viene reindirizzato
														 * alla pagina di amministratore
														 */
				return;
			} catch (SQLException e) {
				utils.UtilityClass.print(e);	
			}
		}

		/********************************************************/
		/* 						LOGIN 							*/
		/********************************************************/
		if (email != null && pass != null) {
			utils.UtilityClass.print("login");
			try {

				ClienteBean n = model.tryLogIn(email, pass);
				utils.UtilityClass.print("Test: " + n.getNome() + " " + n.getSesso());
				if (n.getNome() != null) {
					request.setAttribute("user", n);
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
					requestDispatcher.forward(request, response);
					return;
				} else {
					response.sendRedirect("Admin.html"); // riga da eliminare --> solo per test
					// response.sendRedirect(""); /*Se l'utente non esiste la response reindirizza
					// alla pagina di login*/
					return;
				}
			} catch (SQLException e) {
				utils.UtilityClass.print(e);		
			}
		}

		/********************************************************/
		/* 		VISUALIZZAZIONE DELLA TABELLA CLIENTI 			*/
		/********************************************************/
		if (servizio != null && servizio.equals("cliente")) {

			try {
				request.setAttribute("clienti", model.selectAll());
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ClienteView.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
