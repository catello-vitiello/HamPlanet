package control;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String servizio = request.getParameter("servizio");
	   if(servizio.equals("cliente")) {
		   RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ClienteControl");
		   requestDispatcher.forward(request, response);
		   return;
	   }
	   if(servizio.equals("ordine")) {
		   RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/OrdineControl");
		   requestDispatcher.forward(request, response);
		   return;
	   }
	   
	}

}
