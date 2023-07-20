package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model_cliente.ClienteModelDS;

@WebServlet("/ShowOrderByEmail")
public class ShowOrderByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public ShowOrderByEmail() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ClienteModelDS model = new ClienteModelDS(ds);
		
		
		
	}

}
