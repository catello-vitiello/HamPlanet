package gestione_funz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/PrintCreditCard")
public class PrintCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrintCreditCard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = (String) request.getAttribute("email");

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CercaCarteModelDS modelDS = new CercaCarteModelDS(ds);
		HttpSession session = request.getSession(false);
		utils.UtilityClass.print("sessione: " + session.getId());
		
		try {
			
				LinkedList<CercaCarteClienteBean> carte = (LinkedList<CercaCarteClienteBean>) modelDS.getCardByEmail(email);
				request.setAttribute("ListaCarte", carte); //setto l'attributo che contiene una lista di carte nella mappa della richiesta e lo passo
				session.setAttribute("ListaCarte1", carte);
				getServletContext().removeAttribute("ListaCarte0");
				getServletContext().setAttribute("ListaCarte0", carte);
				
				request.setAttribute("Ncard", modelDS.getNumCarte(email)); //setto l'attributo che contiene il numero di
				session.setAttribute("Ncard1", modelDS.getNumCarte(email));															//carte nella mappa della richiesta e lo passo
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UserArea.jsp");
		        requestDispatcher.forward(request, response);
				
		} catch (SQLException e) {
			utils.UtilityClass.print(e);
		}

	}

	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        doGet(req, resp);
	    }
	
}
