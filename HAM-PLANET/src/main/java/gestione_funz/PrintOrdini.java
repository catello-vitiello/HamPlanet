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

@WebServlet("/PrintOrdini")
public class PrintOrdini extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public PrintOrdini() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	   VistaOrdiniModelDS modelDS = new VistaOrdiniModelDS(ds);
	   PrintWriter out = response.getWriter();
	   
	   try {
		   
		   LinkedList<VistaOrdiniBean> ordini = (LinkedList<VistaOrdiniBean>) modelDS.getOrdiniByemail("lino69@email.it");
		   for(int x=0; x<ordini.size(); x++) {
			   VistaOrdiniBean b = ordini.get(x);
			   out.println(b.toString());
		   }
		   
		   
	   }catch (SQLException e) {
		   e.printStackTrace();
	}
	   
   }

}
