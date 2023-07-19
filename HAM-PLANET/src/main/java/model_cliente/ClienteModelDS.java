package model_cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class ClienteModelDS implements ClienteModel<ClienteBean> {

	private DataSource ds = null;
	
	/********************************************************/
	/*				COSTRUTTORE CON DATASOURCE				*/
	/********************************************************/

	public ClienteModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	/********************************************************/
	/*						SELECT ALL						*/
	/********************************************************/

	@Override
	public Collection<ClienteBean> selectAll() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM cliente";
		Collection<ClienteBean> clienti = new LinkedList<ClienteBean>();

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SU CLIENTI " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ClienteBean cb = new ClienteBean();
				cb.setEmail(rs.getString("e_mail"));
				cb.setPass(rs.getString("pass"));
				cb.setNome(rs.getString("nome"));
				cb.setCognome(rs.getString("cognome"));
				cb.setSesso(rs.getString("sesso").charAt(0));
				cb.setIndirizzo(rs.getString("indirizzo"));
				cb.setCellulare(rs.getString("cellulare"));
				cb.setData_nascita(rs.getString("data_nascita"));
				cb.setPaese(rs.getString("paese"));
				cb.setProvincia(rs.getString("provincia"));
				cb.setCap(rs.getString("cap"));

				clienti.add(cb);
			}

		} finally {
			
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		return clienti;
	}

	/********************************************************/
	/*						INSERT							*/
	/********************************************************/
	
	@Override
	public void insert(String email, String pass, String nome, String cognome, char sesso, String indirizzo,
			String cellulare, String data_nascita, String paese, String provincia, String cap) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Character s = sesso;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, utils.CifraPassword.toHash(pass));
			preparedStatement.setString(3, nome);
			preparedStatement.setString(4, cognome);
			preparedStatement.setString(5, s.toString());
			preparedStatement.setString(6, indirizzo);
			preparedStatement.setString(7, cellulare);
			preparedStatement.setString(8, data_nascita);
			preparedStatement.setString(9, paese);
			preparedStatement.setString(10, provincia);
			preparedStatement.setString(11, cap);
			
			utils.UtilityClass.print(">.INSERT " + preparedStatement);
			preparedStatement.executeUpdate();
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/********************************************************/
	/*						GET BY EMAIL					*/
	/********************************************************/
	public ClienteBean getByEmail(String email) throws SQLException{
		
		Connection connection = null;
		PreparedStatement stm = null;
		String sql = "SELECT pass FROM cliente WHERE e_mail = ?";
		ClienteBean bean = new ClienteBean();
		
		try {
			connection = ds.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				bean.setEmail(rs.getString("e_mail"));
				bean.setPass(rs.getString("pass"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setSesso(rs.getString("sesso").charAt(0));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setCellulare(rs.getString("cellulare"));
			}
			
		}finally {
			if(stm != null)
				stm.close();
			if(connection != null)
				connection.close();
		}
		return bean;
	}
	
	/********************************************************/
	/*						DELETE							*/
	/********************************************************/

	@Override
	public void deleteCliente(String chiave) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM cliente WHERE e_mail = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, chiave);
			utils.UtilityClass.print(">.DELETE " + preparedStatement);
			preparedStatement.executeUpdate();
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
	}
	
	/********************************************************/
	/*						LOG IN							*/
	/********************************************************/
	public ClienteBean tryLogIn(String email, String password) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "select nome, cognome, cellulare, e_mail, data_nascita, indirizzo, sesso, paese, provincia, cap"
				+ " FROM cliente WHERE e_mail = ? and pass = ?";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, utils.CifraPassword.toHash(password));
			utils.UtilityClass.print(">.LOGIN cliente: " + preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			ClienteBean cb = new ClienteBean();
			while(rs.next()) {
				cb.setNome(rs.getString("nome"));
				cb.setSesso(rs.getString("sesso").charAt(0));
				cb.setCognome(rs.getString("cognome"));
				cb.setCellulare(rs.getString("cellulare"));
				cb.setEmail(rs.getString("e_mail"));
				cb.setData_nascita(rs.getString("data_nascita"));
				cb.setIndirizzo(rs.getString("indirizzo"));
				cb.setPaese(rs.getString("paese"));
				cb.setProvincia(rs.getString("provincia"));
				cb.setCap(rs.getString("cap"));
			}
			
			return cb;
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/****************************************************************************/
	/*								CAMBIO PASSWORD								*/
	/****************************************************************************/
	public void changePassword(String email, String password) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "update cliente set pass = ? where e_mail = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, utils.CifraPassword.toHash(password));
			preparedStatement.setString(2, email);
			
			utils.UtilityClass.print(">.Update password per il cliente: " + email);
			preparedStatement.executeUpdate();
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/****************************************************************************/
	/*							CAMBIO INDIRIZZO								*/
	/****************************************************************************/
	
	public void changeAddress(String email, String indirizzo, String paese, String provincia, String cap) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "update cliente set indirizzo = ?, paese = ?, provincia = ?, cap = ? "
				+ "where e_mail = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, indirizzo);
			preparedStatement.setString(2, paese);
			preparedStatement.setString(3, provincia);
			preparedStatement.setString(4, cap);
			preparedStatement.setString(5, email);
			
			utils.UtilityClass.print(">.Update indirizzo: " + preparedStatement.toString());
			preparedStatement.executeUpdate();
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/****************************************************************************/
	/*							CAMBIO TELEFONO									*/
	/****************************************************************************/
	public void changePhone(String email, String phone) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "update cliente set cellulare = ? "
				+ "where e_mail = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, email);
			
			utils.UtilityClass.print(">.Update telefono: " + preparedStatement.toString());
			preparedStatement.executeUpdate();
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
	}

}
