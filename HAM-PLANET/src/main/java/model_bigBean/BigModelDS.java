package model_bigBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class BigModelDS implements BigModel<BigBean> {
	
	private DataSource ds = null;
	
	public BigModelDS(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Collection<BigBean> selectAll(String email) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT prodotto.nomeProdotto, composto.quantity, prodotto.prezzo, ordine.id, prodotto.IAN "
				+ "FROM composto, prodotto, ordine, cliente "
				+ "WHERE cliente.e_mail = ordine.email "
				+ "AND composto.id_ordine = ordine.id "
				+ "AND composto.ian_prodotto = prodotto.IAN "
				+ "AND cliente.e_mail = ? AND ordine.stato = 'effettuato'";
		Collection<BigBean> ordini = new LinkedList<BigBean>();

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			utils.UtilityClass.print(">.SELECT ALL SU ORDINI PER CLIENTE: " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BigBean cb = new BigBean();
				cb.setNomeProdotto(rs.getString("prodotto.nomeProdotto"));
				cb.setQuantity(rs.getInt("composto.quantity"));
				cb.setPrice(rs.getDouble("prodotto.prezzo"));
				cb.setId(rs.getInt("ordine.id"));
				cb.setIan(rs.getInt("prodotto.IAN"));
				
				ordini.add(cb);
			}

		} finally {
			
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		return ordini;
	
	}

}
