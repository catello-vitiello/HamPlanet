package gestione_funz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
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

		//String op = (String) request.getAttribute("op");
		String email = (String) request.getAttribute("email");

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CercaCarteModelDS modelDS = new CercaCarteModelDS(ds);
		HttpSession session = request.getSession(false);
		
		try {
			//if (op.equals("carte")) {
				LinkedList<CercaCarteClienteBean> carte = (LinkedList<CercaCarteClienteBean>) modelDS
						.getCardByEmail(email);
				request.setAttribute("ListaCarte", carte); //setto l'attributo che contiene una lista di carte nella mappa della richiesta e lo passo
				session.setAttribute("ListaCarte1", carte);
				/*for (int x = 0; x < carte.size(); x++) {
					CercaCarteClienteBean bean = carte.get(x);
					out.println(bean.toString());
				}*/
			//}
			//if (op.equals("number")) {
				// out.println("\nNumero carte");
				request.setAttribute("Ncard", modelDS.getNumCarte(email)); //setto l'attributo che contiene il numero di
																			//carte nella mappa della richiesta e lo passo
				//}
		} catch (SQLException e) {
			utils.UtilityClass.print(e);
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UserArea.jsp");
        requestDispatcher.forward(request, response);

	}

	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        doGet(req, resp);
	    }
	
}
