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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		String servizio = request.getParameter("servizio");
		utils.UtilityClass.print("Servizio: " + servizio);
	
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
	            String desc = request.getParameter("descrizione");
	            String tipo = request.getParameter("tipo");
	            
	            request.setAttribute("key", "admin");

	            try {
	                model.insert_NoImage(ian, desc, peso, prezzo, nomeString, tipo);
	                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/GetEmailCliente");
					requestDispatcher.forward(request, response);
	                return;
	            } catch (SQLException e) {
	                utils.UtilityClass.print(e);
	            }

	        }
		
		/********************************************************/
		/* 						DELETE		   		   			*/
		/********************************************************/
		if(servizio.equals("elimina")) {
			 int ian = Integer.parseInt(request.getParameter("id"));
			 request.setAttribute("key", "admin");
			 
			 try {
				 model.delete(ian);
				 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/GetEmailCliente");
				 requestDispatcher.forward(request, response);
	             return;
			 } catch (SQLException e) {
	                utils.UtilityClass.print(e);
	            }
			 
		}
		
		/********************************************************/
		/* 						AVAILABLE	   		   			*/
		/********************************************************/
		if(servizio.equals("available")) {
			 int ian = Integer.parseInt(request.getParameter("id"));
			 request.setAttribute("key", "admin");
			 
			 try {
				 model.returnAvailable(ian);
				 request.setAttribute("key", "admin");
				 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/GetEmailCliente");
				 requestDispatcher.forward(request, response);
	             return;
			 } catch (SQLException e) {
	                utils.UtilityClass.print(e);
	            }
			 
		}
		
		/********************************************************/
		/* 				  SEARCH BY CATEGORY					*/
		/********************************************************/
		if(servizio.equals("getByCategory")) {
			String tipo = request.getParameter("tipologiaProdotto");
			utils.UtilityClass.print("Categoria: " + tipo);
			try {
				request.setAttribute("prodottiByCategory", model.getByCategoria(tipo));
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewListProduct.jsp");
				requestDispatcher.forward(request, response);
				return;
			}catch (SQLException e) {
				utils.UtilityClass.print(e);
			}
		}
		 
	}

}
