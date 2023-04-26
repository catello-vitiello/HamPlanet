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

import model_ordine.OrdineModelDS;

@WebServlet("/OrdineControl")
public class OrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		OrdineModelDS model = new OrdineModelDS(ds);

		String servizio = request.getParameter("servizio");

		String key = request.getParameter("key");

		String data, stato, metodoP, email;

		data = request.getParameter("data");
		stato = request.getParameter("stato");
		metodoP = request.getParameter("metodoP");
		email = request.getParameter("email");

		if (data != null && stato != null && metodoP != null && email != null) {

			try {
				model.insert(data, stato, metodoP, email);
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

		}

		if (key != null) {

			Integer chiave = Integer.parseInt(key);

			try {
				model.delete(chiave);
				response.sendRedirect("FormClientehtml.html");
				return;
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

		}

		if (servizio != null && servizio.equals("ordine")) {
			try {
				request.setAttribute("ordini", model.getAll());
			} catch (SQLException e) {
				utils.UtilityClass.print(e);
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/OrdiniView.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
