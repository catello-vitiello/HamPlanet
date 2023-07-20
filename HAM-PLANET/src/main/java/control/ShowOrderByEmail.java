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
import model_bigBean.BigModelDS;

@WebServlet("/ShowOrderByEmail")
public class ShowOrderByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public ShowOrderByEmail() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("emailUser");
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		BigModelDS model = new BigModelDS(ds);
		
		try {
			request.setAttribute("OrdiniView", model.selectAll(email));
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/OrderByEmail.jsp");
			requestDispatcher.forward(request, response);
			return;
			
		}catch(SQLException e) {
			utils.UtilityClass.print(e);
		}
		
	}

}
