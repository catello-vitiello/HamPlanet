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
	/*				CONTROLLO PRESENZA PRODOTTO				*/
	/********************************************************/
	private int checkQuantity(int ian, String email) throws SQLException{
		
		int quant=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String recuperoCarrello_sql = "SELECT quantity "
				+ "FROM composto, ordine, prodotto, cliente "
				+ "WHERE composto.id_ordine = ordine.id "
				+ "AND composto.ian_prodotto = prodotto.IAN "
				+ "AND ordine.email = cliente.e_mail "
				+ "AND prodotto.IAN = ? AND cliente.e_mail = ?";
		
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(recuperoCarrello_sql);
			preparedStatement.setInt(1, ian);
			preparedStatement.setString(2, email);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				quant = rs.getInt("quantity");
			}
			utils.UtilityClass.print("################################################################Quantità: " + quant);			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		return quant;
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
	
	/********************************************************/
	/*				AGGIUNGI PRODOTTO AL CARRELLO			*/
	/********************************************************/
	public void addKartProd(int ian, String email) throws SQLException{
		
		if(checkQuantity(ian, email)>=1) {
			plusQuantity( ian, email);
			return;
		}
		
		int idOrdine = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		PreparedStatement pp = null;
		String sql = "INSERT INTO composto(id_ordine, ian_prodotto, quantity) VALUES(?, ?, 1)";
		String recuperoCarrello_sql = "SELECT id "
				+ "FROM cliente, ordine "
				+ "WHERE ordine.email = cliente.e_mail "
				+ "AND cliente.e_mail = ? AND ordine.stato = 'salvato'";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(recuperoCarrello_sql);
			preparedStatement.setString(1, email);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
				idOrdine = rs.getInt("id");
			utils.UtilityClass.print("################################################################ID del carrello: " + idOrdine);	
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		if(idOrdine == 0) {
			String sql1 = "INSERT INTO ordine(stato, email) VALUES('salvato',?)";
			connection = ds.getConnection();
			
			try {
				pp = connection.prepareStatement(sql1);
				pp.setString(1, email);
				pp.executeUpdate();
			}finally {
				if(pp != null)
					pp.close();
				if(connection != null)
					connection.close();
			}
			
			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(recuperoCarrello_sql);
				preparedStatement.setString(1, email);
				
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next())
					idOrdine = rs.getInt("id");
				utils.UtilityClass.print("################################################################ID del carrello: " + idOrdine);	
			}finally {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			
		}
		
		try {
			connection = ds.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idOrdine);
			ps.setInt(2, ian);
			utils.UtilityClass.print(">.INSERIMENTO PRODOTTO NEL CARRELLO: " + ps.toString());
			ps.executeUpdate();
		}finally {
			if(ps != null)
				ps.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/********************************************************/
	/*				AGGIUNGI +1 AL CARRELLO					*/
	/********************************************************/
	public void plusQuantity(int ian, String email) throws SQLException{
		
		int id_c = 0, quant=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		String sql = "UPDATE composto SET quantity = ? WHERE id_c = ?";
		
		String recuperoCarrello_sql = "SELECT id_c, quantity "
				+ "FROM composto, ordine, prodotto, cliente "
				+ "WHERE composto.id_ordine = ordine.id "
				+ "AND composto.ian_prodotto = prodotto.IAN "
				+ "AND ordine.email = cliente.e_mail "
				+ "AND prodotto.IAN = ? AND cliente.e_mail = ?";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(recuperoCarrello_sql);
			preparedStatement.setInt(1, ian);
			preparedStatement.setString(2, email);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				id_c = rs.getInt("id_c");
				quant = rs.getInt("quantity");
			}
			utils.UtilityClass.print("################################################################ID del composto: " + id_c);			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		try {
			connection = ds.getConnection();
			ps = connection.prepareStatement(sql);
			quant+=1;
			ps.setInt(1, quant);
			ps.setInt(2, id_c);
			ps.executeUpdate();
			utils.UtilityClass.print(">.Aumento quantity: " + preparedStatement.toString());
		}finally {
			if(ps != null)
				ps.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/********************************************************/
	/*				AGGIUNGI -1 AL CARRELLO					*/
	/********************************************************/
	public void minuQuantity(int ian, String email) throws SQLException{
		int id_c = 0, quant=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		String sql = "UPDATE composto SET quantity = ? WHERE id_c = ?";
		
		String recuperoCarrello_sql = "SELECT id_c, quantity "
				+ "FROM composto, ordine, prodotto, cliente "
				+ "WHERE composto.id_ordine = ordine.id "
				+ "AND composto.ian_prodotto = prodotto.IAN "
				+ "AND ordine.email = cliente.e_mail "
				+ "AND prodotto.IAN = ? AND cliente.e_mail = ?";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(recuperoCarrello_sql);
			preparedStatement.setInt(1, ian);
			preparedStatement.setString(2, email);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				id_c = rs.getInt("id_c");
				quant = rs.getInt("quantity");
			}
			utils.UtilityClass.print("################################################################ID del composto: " + id_c);			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		try {
			connection = ds.getConnection();
			ps = connection.prepareStatement(sql);
			quant-=1;
			ps.setInt(1, quant);
			ps.setInt(2, id_c);
			ps.executeUpdate();
			utils.UtilityClass.print(">.Diminuisco quantity: " + ps.toString());
		}finally {
			if(ps != null)
				ps.close();
			if(connection != null)
				connection.close();
		}
	}
}
