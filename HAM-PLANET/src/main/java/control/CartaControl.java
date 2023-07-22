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

import gestione_funz.CercaCarteClienteBean;
import gestione_funz.CercaCarteModelDS;
import model_carta.CartaModelDS;

@WebServlet("/CartaControl")
public class CartaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartaControl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servizio = request.getParameter("op");
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CercaCarteModelDS model = new CercaCarteModelDS(ds);
		CartaModelDS modelDS = new CartaModelDS(ds);
		
		
		/********************************************************************/
		/*						INSERIMENTO CARTA							*/
		/********************************************************************/
		if(servizio.equals("insert")) {
			String numero = request.getParameter("numeroCarta");
			String titolare = request.getParameter("proprietario");
			String mese = request.getParameter("mese");
			String anno = request.getParameter("anno");
			int cvv = Integer.parseInt(request.getParameter("cvv"));
			String scadenza = mese+"/"+anno;
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			utils.UtilityClass.print("Email: " + email + ", password: " + pass);
			
			CercaCarteClienteBean bean = new CercaCarteClienteBean(numero, cvv, scadenza, titolare);
			
			try {
				model.insertNewCard(bean, email);
				request.setAttribute("email", email);
				request.setAttribute("password", pass);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/LoginServlet");
				requestDispatcher.forward(request, response);
			}catch (SQLException e) {
				utils.UtilityClass.print(e);
			}
			
		}
		
		/********************************************************************/
		/*						ELIMINAZIONE CARTA							*/
		/********************************************************************/
		if(servizio.equals("delete")) {
			String numero = request.getParameter("NumeroCarta");
			try {
				modelDS.deleteCard(numero);
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}
		}
		
		
	}

}
