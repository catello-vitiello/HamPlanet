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
import model_prodotto.ProdottoModelDS;

@WebServlet("/ProdottoControl")
public class ProdottoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		String servizio = request.getParameter("servizio");
	
		/********************************************************/
		/* 				VEDI PRODOTTI SENZA IMMAGINE		    */
		/********************************************************/
		if(servizio != null && servizio.equals("prodotto")) {
			
			try {
				request.setAttribute("prodotti", model.selectAll_NoImage());
				request.setAttribute("prodotti_no", model.selectAll_NoImage_NotAvailable());
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ProdottoView.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		/********************************************************/
		/* 				 INSERT SENZA IMMAGINE		   			*/
		/********************************************************/
		 if(servizio.equals("insert") && servizio!= null) {

	            int ian = Integer.parseInt(request.getParameter("id"));
	            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
	            double peso = Double.parseDouble(request.getParameter("peso"));
	            String nomeString = request.getParameter("nomeProdotto");
	            String desc = "descrizione";

	            try {
	                model.insert_NoImage(ian, desc, peso, prezzo, nomeString);
	                response.sendRedirect("./Administrator.jsp");
	                return;
	            } catch (SQLException e) {
	                utils.UtilityClass.print(e);
	            }

	        }
		
	}

}
