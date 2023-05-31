package gestione_funz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/PrintCreditCard")
public class PrintCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrintCreditCard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String email = request.getParameter("email");

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CercaCarteModelDS modelDS = new CercaCarteModelDS(ds);
		PrintWriter out = response.getWriter();

		try {
			if (op.equals("carte")) {
				LinkedList<CercaCarteClienteBean> carte = (LinkedList<CercaCarteClienteBean>) modelDS
						.getCardByEmail(email);
				for (int x = 0; x < carte.size(); x++) {
					CercaCarteClienteBean bean = carte.get(x);
					out.println(bean.toString());
				}
			}
			if (op.equals("number")) {
				// out.println("\nNumero carte");
				out.println(modelDS.getNumCarte(email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
