package model_carta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class CartaModelDS implements CartaModel<CartaBean> {

	private DataSource ds = null;

	/********************************************************/
	/*  		COSTRUTTORE CON DATASOURCE 					*/
	/********************************************************/

	public CartaModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/* 					  SELECT ALL 						*/
	/********************************************************/

	public Collection<CartaBean> selectAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM carta";
		Collection<CartaBean> carte = new LinkedList<CartaBean>();

		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SU CARTE " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CartaBean cb = new CartaBean();
				cb.setNomeTitolare(rs.getString("nomeTitolare"));
				cb.setCognomeTitolare(rs.getString("cognomeTitolare"));
				cb.setNumeroCarta(rs.getString("numeroCarta"));
				cb.setScadenza(rs.getString("scadenza"));
				cb.setCvv(rs.getInt("cvv"));

				carte.add(cb);
			}

		}finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return carte;

	}
	
	/********************************************************************/
	/*						ELIMINAZIONE CARTA							*/
	/********************************************************************/
	public void deleteCard(String numeroCarta) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM carta WHERE numeroCarta = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.ELEIMINAZIONE CARTA NUMERO " + numeroCarta);
			
			preparedStatement.setString(1, numeroCarta);
			preparedStatement.executeUpdate();
		}finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		
	}

}
