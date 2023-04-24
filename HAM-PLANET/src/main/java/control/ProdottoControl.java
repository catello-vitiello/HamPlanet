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
		
		if(servizio != null && servizio.equals("prodotto")) {
			
			try {
				request.setAttribute("prodotti", model.selectAll_NoImage());
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
				e.printStackTrace();
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ProdottoView.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

}
