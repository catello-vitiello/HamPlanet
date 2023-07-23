package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model_prodotto.ProdottoBean;
import model_prodotto.ProdottoModelDS;

import com.google.gson.Gson;

@WebServlet("/RecuperoTipologia")
public class RecuperoTipologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RecuperoTipologia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoModelDS model = new ProdottoModelDS(ds);
		
		/********************************************************/
		/* 					  SELECT ALL						*/
		/********************************************************/
		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
		try {
				prodotti = model.selectAll();
			}catch (SQLException e) {
				utils.UtilityClass.print(e);
			}
		
			ArrayList<String> stringhe = new ArrayList<String>();
		
			prodotti.stream().forEach(elemento -> stringhe.add(elemento.getTipo()));
		
			 String json = new Gson().toJson(stringhe);

		        // Imposta il tipo di contenuto della risposta come JSON
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");

		        // Invia la risposta JSON al client
		        PrintWriter out = response.getWriter();
		        out.print(json);
		        out.flush();
			
			return;
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
