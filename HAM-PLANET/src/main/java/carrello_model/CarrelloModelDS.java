package carrello_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class CarrelloModelDS implements CarrelloModel<CarrelloBean> {
	
	private DataSource ds = null;
	
	/********************************************************/
	/*				COSTRUTTORE CON DATASOURCE				*/
	/********************************************************/
	public CarrelloModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	/********************************************************/
	/*				RECUPERO PRODOTTI DAL CARRELLO			*/
	/********************************************************/
	public Collection<?> getAllOrderByEmail(String email) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT prodotto.nomeProdotto, prodotto.prezzo, prodotto.descrizione, prodotto.IAN, composto.quantity "
				+ "FROM prodotto, composto, ordine, cliente "
				+ "WHERE prodotto.IAN = composto.ian_prodotto "
				+ "AND composto.id_ordine = ordine.id "
				+ "AND ordine.email = cliente.e_mail "
				+ "AND ordine.stato = 'salvato' AND cliente.e_mail = ?";
		
		Collection<CarrelloBean> carrello = new LinkedList<CarrelloBean>();
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			utils.UtilityClass.print(">.SELECT ALL SUL CARRELLO: " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				CarrelloBean bean = new CarrelloBean();
				bean.setNomeProdotto(rs.getString("nomeProdotto"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setIan(rs.getInt("IAN"));
				bean.setQuantity(rs.getInt("quantity"));
				
				carrello.add(bean);
			}
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		return carrello;
	}

}
