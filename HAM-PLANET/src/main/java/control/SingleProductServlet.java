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

@WebServlet("/SingleProductServlet")
public class SingleProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SingleProductServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		int ian = Integer.parseInt(request.getParameter("ianProdotto"));
		
		try {
			request.setAttribute("ProdottoBean", model.getByIan(ian));
			
		}catch (SQLException e) {
			utils.UtilityClass.print(e);
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewProduct.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
