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

import model_cliente.ClienteModelDS;

@WebServlet("/GetEmailCliente")
public class GetEmailCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public GetEmailCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ClienteModelDS model = new ClienteModelDS(ds);
		
		String valore = (String) request.getParameter("valore");
		if(valore != null)
			request.setAttribute("key", valore);
		
		try {
			request.setAttribute("clienti", model.selectAll());
		} catch (SQLException e) {
			utils.UtilityClass.print(e);
		}

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AdministratorPage.jsp");
		requestDispatcher.forward(request, response);
		return;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
