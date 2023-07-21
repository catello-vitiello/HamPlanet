package control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import model_prodotto.ProdottoModelDS;

@WebServlet("/AddProsciuttiImg")
@MultipartConfig(
		fileSizeThreshold = 1024 *1024 * 2,
		maxFileSize = 1024 *1024 *10,
		maxRequestSize = 1024 *1024 * 50
	)

public class AddProsciuttiImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//metodo doGet da sostituire con doPost
	//doGet usato solo per test
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Part imagePart = request.getPart("imageFile");
     	int id = Integer.parseInt(request.getParameter("ianP"));
    	InputStream inputStream = imagePart.getInputStream();
		
    	DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		request.setAttribute("key", "admin");
		
		try {
			model.addImageToProduct(id , inputStream);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/GetEmailCliente");
			requestDispatcher.forward(request, response);
            return;
		}catch(SQLException e){
			utils.UtilityClass.print(e);
		}
    	
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }

}
