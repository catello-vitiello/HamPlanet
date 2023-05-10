package control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model_prodotto.ProdottoModelDS;

@WebServlet("/AddProsciuttiImg")
public class AddProsciuttiImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//metodo doGet da sostituire con doPost
	//doGet usato solo per test
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		try {
			//inserimento manuale del file
			//succesivamente verrà inserito un modo per fare inserire il file da interfaccia grafica
			model.addImageToProduct(2, new File("C:/Users/mario/Downloads/parmacotto.jpg"));
		}catch(SQLException e){
			utils.UtilityClass.print(e);
		}
    	
	}

}
