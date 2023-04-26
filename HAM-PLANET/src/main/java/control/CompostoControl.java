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
import model_composto.CompostoModelDS;

@WebServlet("/CompostoControl")
public class CompostoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	   CompostoModelDS model = new CompostoModelDS(ds);
	   
	   String servizio = request.getParameter("servizio");
	   
	   if(servizio != null && servizio.equals("composto")) {
		   
		   try {
				request.setAttribute("composti", model.selectAll());
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CompostoView.jsp");
			requestDispatcher.forward(request, response);
		   
	   }
	   
   }

}
