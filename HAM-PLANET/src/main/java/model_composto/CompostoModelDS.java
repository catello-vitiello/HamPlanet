package model_composto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class CompostoModelDS implements CompostoModel<CompostoBean> {
	private DataSource ds = null;

	/********************************************************/
	/* 			COSTRUTTORE CON DATASOURCE 					*/
	/********************************************************/

	public CompostoModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/* 						SELECT ALL 						*/
	/********************************************************/

	@Override
	public Collection<CompostoBean> selectAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM composto";
		Collection<CompostoBean> composti = new LinkedList<CompostoBean>();
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SU COMPOSTI " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CompostoBean cb = new CompostoBean();
				cb.setId_c(rs.getInt("id_c"));
				cb.setId_ordine(rs.getInt("id_ordine"));
				cb.setIan_prodotto(rs.getInt("ian_prodotto"));
				cb.setPrezzo(rs.getDouble("prezzo"));
				cb.setQuantity(rs.getInt("quantity"));

				composti.add(cb);
			}

		} finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

		return composti;
	}

	/********************************************************/
	/* 						DELETE 							*/
	/********************************************************/

	@Override
	public void deleteComposto(int id_c) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM composto WHERE id_c = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id_c);
			utils.UtilityClass.print(">.DELETE " + preparedStatement);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

	}

}
