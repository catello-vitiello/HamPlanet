package model_prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class ProdottoModelDS implements ProdottoModel<ProdottoBean> {

	private DataSource ds = null;

	/********************************************************/
	/* 			COSTRUTTORE CON DATASOURCE 					*/
	/********************************************************/

	public ProdottoModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/* 				SELECT ALL NO IMAGE 					*/
	/********************************************************/

	@Override
	public Collection<ProdottoBean> selectAll_NoImage() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM prodotto";
		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SU PRODOTTI " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ProdottoBean pb = new ProdottoBean();
				pb.setIAN(rs.getInt("IAN"));
				pb.setDescrizione(rs.getString("descrizione"));
				pb.setPeso(rs.getDouble("peso"));
				pb.setPrezzo(rs.getDouble("prezzo"));
				pb.setNomeProdotto(rs.getString("nomeProdotto"));

				prodotti.add(pb);
			}
		} finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

		return prodotti;
	}

	/********************************************************/
	/* 					INSERT NO IMAGE 					*/
	/********************************************************/

	@Override
	public void insert_NoImage(int IAN, String descrizione, double peso, double prezzo, String nomeProdotto)
			throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO prodotto (IAN,prezzo,peso,descrizione,nomeProdotto) VALUES (?, ?, ?, ?, ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, IAN);
			preparedStatement.setDouble(2, prezzo);
			preparedStatement.setDouble(3, peso);
			preparedStatement.setString(4, descrizione);
			preparedStatement.setString(5, nomeProdotto);

			utils.UtilityClass.print(">.INSERT " + preparedStatement);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
	}

	/********************************************************/
	/* 						DELETE 							*/
	/********************************************************/

	@Override
	public void delete(int IAN) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM prodotto WHERE IAN = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, IAN);
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