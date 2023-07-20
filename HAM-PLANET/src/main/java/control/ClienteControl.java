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
		
		String newPass = request.getParameter("nuova");
		
		String data_nascita, paese, provincia, cap;
		data_nascita = request.getParameter("anno") + "-" + request.getParameter("mese") + "-" + request.getParameter("giorno");
		if(data_nascita != null)
			utils.UtilityClass.print(data_nascita.toString());
		paese = request.getParameter("paese");
		provincia = request.getParameter("provincia");
		cap = request.getParameter("cap");
		String service = request.getParameter("service");
		//if(service != null)
		//	utils.UtilityClass.print(service.toString());

		String chiave = request.getParameter("chiave");
		
		/********************************************************/
		/* 					LOGIN AMMINISTRATORE 				*/
		/********************************************************/
		if(service.equals("login")) {
			if(email.equals("Admin") && pass.equals("Admin")) {
				response.sendRedirect("./AdministratorPage.jsp");
				return;
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
			return;
		}

		/********************************************************/
		/* 					REGISTRAZIONE	 					*/
		/********************************************************/
		if (service.equals("insert")) {
			try {
				char sex = sesso.charAt(0);
				model.insert(email, pass, nome, cognome, sex, indirizzo, cellulare, data_nascita, paese, provincia, cap);
				response.sendRedirect("AdministratorPage.jsp"); // riga da eliminare ---> solo per test
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
				response.sendRedirect("AdministratorPage.jsp"); 
				/* Dopo che l'admin ha eliminato un utente viene reindirizzato alla pagina di amministratore*/
				return;
			} catch (SQLException e) {
				utils.UtilityClass.print(e);	
			}
		}

		/********************************************************/
		/* 						LOGIN 							*/
		/********************************************************/
		if (email != null && pass != null && service.equals("login")) {
			utils.UtilityClass.print("login");
			
			request.setAttribute("email", email);
			request.setAttribute("password", pass);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
			requestDispatcher.forward(request, response);
			} else if(service.equals("login")) {
				response.sendRedirect("/Login.jsp"); // riga da eliminare --> solo per test
				// response.sendRedirect(""); /*Se l'utente non esiste la response reindirizza
				// alla pagina di login*/		
				return;
			}	
		
		/****************************************************************************/
		/*								CAMBIO PASSWORD								*/
		/****************************************************************************/
		if (service.equals("cambioP")) {
			try {
				model.changePassword(email, newPass);
				request.setAttribute("email", email);
				request.setAttribute("password", newPass);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
				requestDispatcher.forward(request, response);
			}catch(SQLException e) {
				utils.UtilityClass.print(e);
			}
		}
		
		/****************************************************************************/
		/*							CAMBIO INDIRIZZO								*/
		/****************************************************************************/
		if(service.equals("cambioI")) {
			try {
				model.changeAddress(email, indirizzo, paese, provincia, cap);
				request.setAttribute("email", email);
				request.setAttribute("password", pass);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
				requestDispatcher.forward(request, response);
			}catch(SQLException e) {
				utils.UtilityClass.print(e);
			}
		}
		
		/****************************************************************************/
		/*							CAMBIO TELEFONO									*/
		/****************************************************************************/
		if(service.equals("cambioC")) {
			
			try {
				model.changePhone(email, cellulare);
				request.setAttribute("email", email);
				request.setAttribute("password", pass);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
				requestDispatcher.forward(request, response);
			}catch(SQLException e) {
				utils.UtilityClass.print(e);
			}
			
		}
	}

}
