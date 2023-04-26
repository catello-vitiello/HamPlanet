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
			String cellulare) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?)";
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
		java.sql.Statement stm = null;
		String sql = "SELECT pass FROM cliente WHERE e_mail = " + email;
		ClienteBean bean = new ClienteBean();
		
		try {
			connection = ds.getConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
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
		String sql = "select nome,sesso from cliente where e_mail = ? and pass = ?";
		
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
			}
			
			return cb;
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}

}