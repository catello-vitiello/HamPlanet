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
	/********************************************************************************************************************************************/
	/********************************************************/
	/*	FUNZIONE AD HOC PER IL RESET DI AUTO_INCREMENT		*/
	/********************************************************/
	private void resetAuto_increment() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null, ps = null;
		String sql = "select max(id) as max from composto";
		String sql1 = " ALTER TABLE composto AUTO_INCREMENT = ?";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ps = connection.prepareStatement(sql1);
			ResultSet rs = preparedStatement.executeQuery();
			int val=0;
			
			while(rs.next()) {
				val = rs.getInt("max");
				utils.UtilityClass.print("Id massimo: " + val + "\n");
			}
			
			ps.setInt(1, val+1);
			ps.executeUpdate();
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(ps != null)
				ps.close();
			if(connection != null)
				connection.close();
		}
		
	}
	/*********************************************************************************************************************************************/
	
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
			
			//controllo se la quantità va a zero
			//in tal caso elimino il prodotto direttamente
			if(quant < 1) {
				deleteProductFromKart(ian, email); //passo all'eliminazione del prodotto
				return;
			}
			
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
	
	/********************************************************/
	/*		    ELIMINA UN PRODOTTO DAL CARRELLO			*/
	/********************************************************/
	public void deleteProductFromKart(int ian, String email) throws SQLException{
		
		int id_c=0;
		String sqlString = "SELECT id_c "
				+ "FROM composto, ordine, cliente, prodotto "
				+ "WHERE composto.ian_prodotto = prodotto.IAN "
				+ "AND composto.id_ordine = ordine.id "
				+ "AND ordine.email = cliente.e_mail "
				+ "AND prodotto.IAN = ? and cliente.e_mail = ?";
		
		String sql1 = "DELETE FROM composto WHERE id_c = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null, ps = null;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, ian);
			preparedStatement.setString(2, email);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
				id_c = rs.getInt("id_c");
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		try {
			connection = ds.getConnection();
			ps = connection.prepareStatement(sql1);
			ps.setInt(1, id_c);
			ps.executeUpdate();
			utils.UtilityClass.print(">:Eliminazione prodotto con IAN: " + ian + " del cliente: " + email + ", id_c: " + id_c);
			resetAuto_increment();
		}finally {
			if(ps != null)
				ps.close();
			if(connection != null)
				connection.close();
		}
		
		
	}
}
