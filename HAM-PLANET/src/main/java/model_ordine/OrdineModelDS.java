package model_ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.sql.DataSource;

public class OrdineModelDS implements OrdineModel<OrdineBean>{
	
	private DataSource ds = null;
	
	/********************************************************/
	/*				COSTRUTTORE CON DATASOURCE				*/
	/********************************************************/
	public OrdineModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/*						SELECT ALL						*/
	/********************************************************/
	public Collection<OrdineBean> getAll() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM ordine";
		Collection<OrdineBean> ordini = new LinkedList<OrdineBean>();
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print("SELECT ALL SU ORDINE " + preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				OrdineBean ob = new OrdineBean();
				ob.setId(rs.getInt("id"));
				ob.setData_acquisto(rs.getDate("data_acquisto"));
				ob.setStato(rs.getString("stato"));
				ob.setMetodoPagamento(rs.getString("metodo_pagamento"));
				ob.setEmail(rs.getString("email"));
				
				ordini.add(ob);
			}
			
		} finally {
			
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
			
		}
		return ordini;
	}

	/********************************************************/
	/*						INSERT							*/
	/********************************************************/
	public void insert(String data_acquisto, String stato, String metodoPagamento, String email) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "insert into ordine (data_acquisto, stato, metodo_pagamento, email) values (?,?,?,?)";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			java.sql.Date d2 = java.sql.Date.valueOf(data_acquisto);
			utils.UtilityClass.print("IN model= " + d2.toString());
			preparedStatement.setDate(1, d2,new  GregorianCalendar());
			preparedStatement.setString(2, stato);
			preparedStatement.setString(3, metodoPagamento);
			preparedStatement.setString(4, email);
			
			utils.UtilityClass.print("INSERT SU ORDINE " + preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}
	
	/********************************************************/
	/*	FUNZIONE AD HOC PER IL RESET DI AUTO_INCREMENT		*/
	/********************************************************/
	private void resetAuto_increment() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null, ps = null;
		String sql = "select max(id) as max from ordine";
		String sql1 = " ALTER TABLE ordine AUTO_INCREMENT = ?";
		
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

	/********************************************************/
	/*						DELETE							*/
	/********************************************************/
	public void delete(int chiave) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM ordine WHERE id = ?";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, chiave);
			
			utils.UtilityClass.print("DELETE SU ORDINE " + preparedStatement);
			
			preparedStatement.executeUpdate();
			resetAuto_increment();
			
		} finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
	}

	/********************************************************/
	/*						SET STATO						*/
	/********************************************************/
	public void setStato(String stato) throws SQLException {
		
	}

}
