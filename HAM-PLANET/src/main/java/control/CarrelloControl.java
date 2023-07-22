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

import carrello_model.CarrelloModelDS;
import model_cliente.ClienteBean;

@WebServlet("/CarrelloControl")
public class CarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public CarrelloControl() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CarrelloModelDS model = new CarrelloModelDS(ds);
		
		HttpSession session = request.getSession(false);
		ClienteBean user = (ClienteBean) session.getAttribute("user");
		
		try {
			request.setAttribute("prodotti", model.getAllOrderByEmail(user.getEmail()));	
		}catch (SQLException e) {
			utils.UtilityClass.print(e);
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
