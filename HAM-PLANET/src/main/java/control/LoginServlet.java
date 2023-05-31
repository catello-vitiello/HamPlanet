package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model_cliente.ClienteBean;
import model_cliente.ClienteModelDS;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	utils.UtilityClass.print("Mi trovo nella servlet di login ora"); //riga da eliminare
    	
    	DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ClienteModelDS model = new ClienteModelDS(ds);
    		
    	try {
    		
    		String email = (String) request.getAttribute("email");
    		String pass = (String) request.getAttribute("password");
    		
			ClienteBean n = model.tryLogIn(email, pass);
			utils.UtilityClass.print("Test: " + n.getNome() + " " + n.getSesso());
			if (n.getNome() != null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user", n);
				utils.UtilityClass.print("ID sessione: " + session.getId()); //controllo su id sessione --> riga da eliminare
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UserArea.jsp");
				requestDispatcher.forward(request, response);
				} else {
				response.sendRedirect("Login.jsp"); // riga da eliminare --> solo per test
				// response.sendRedirect(""); /*Se l'utente non esiste la response reindirizza
				// alla pagina di login*/
				return;
			}
		} catch (SQLException e) {
			utils.UtilityClass.print(e);		
		}
    	
	}

}
