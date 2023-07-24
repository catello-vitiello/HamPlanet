package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import gestione_funz.CercaCarteClienteBean;
import gestione_funz.CercaCarteModelDS;
import model_cliente.ClienteBean;

@WebServlet("/RecuperaCarteControl")
public class RecuperaCarteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperaCarteControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ClienteBean user = (ClienteBean) session.getAttribute("user");

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		CercaCarteModelDS modelDS = new CercaCarteModelDS(ds);
		
		LinkedList<CercaCarteClienteBean> carte = null;
		try {
			carte = (LinkedList<CercaCarteClienteBean>) modelDS.getCardByEmail(user.getEmail());
			request.setAttribute("ListaCarte1", carte);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UserAreaCard.jsp");
	        requestDispatcher.forward(request, response);
	        return;
		} catch (SQLException e) {
			utils.UtilityClass.print(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
