package model_ha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class HaModelDS implements HaModel<HaBean> {

	private DataSource ds = null;

	/********************************************************/
	/*    		COSTRUTTORE CON DATASOURCE  				*/
	/********************************************************/

	public HaModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/* 					   SELECT ALL						*/
	/********************************************************/

	public Collection<HaBean> selectAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM ha";
		Collection<HaBean> ha = new LinkedList<HaBean>();

		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SULLE HA " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				HaBean cb = new HaBean();
				cb.setId(rs.getInt("id"));
				;
				cb.setEmail_u(rs.getString("email_u"));
				;
				cb.setN_card(rs.getString("n_card"));

				ha.add(cb);
			}

		} finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
		return ha;

	}

}
