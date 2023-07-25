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

import com.mysql.cj.Session;

import model_bigBean.BigModelDS;
import model_cliente.ClienteBean;

@WebServlet("/ShowOrderByEmail")
public class ShowOrderByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowOrderByEmail() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("emailUser");
		HttpSession session = request.getSession(false);
		if(email == null) {
			ClienteBean clienteBean = (ClienteBean) session.getAttribute("user");
			email = clienteBean.getEmail();
		}
		String servizio = (String) session.getAttribute("servizio");
		utils.UtilityClass.print("################################################Servizio: " + servizio);

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		BigModelDS model = new BigModelDS(ds);
		
		if(servizio != null && servizio.equals("go")) {
			try {
				getServletContext().setAttribute("orders", model.selectAll(email));
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UserAreaOrder.jsp");
				requestDispatcher.forward(request, response);
				return;
			}catch (SQLException e) {
				utils.UtilityClass.print(e);
			}
		}

		try {
			request.setAttribute("OrdiniView", model.selectAll(email));
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/OrderByEmail.jsp");
			requestDispatcher.forward(request, response);
			return;

		} catch (SQLException e) {
			utils.UtilityClass.print(e);
		}
	}
}
