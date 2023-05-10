package control;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model_prodotto.ProdottoModelDS;

@WebServlet("/ImageProductServlet")
public class ImageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	   ProdottoModelDS modelDS = new ProdottoModelDS(ds);
	   
	   String id = request.getParameter("id");
	   int ian = Integer.parseInt(id);
	   
	   OutputStream out = null;
	   
	   response.setContentType("image/jpeg");
	   out = response.getOutputStream();
	   try {
		out.write(modelDS.getImageByKey(ian));
	} catch (IOException | SQLException e) {
		utils.UtilityClass.print(e);
	}
	   
	   
   }

}
