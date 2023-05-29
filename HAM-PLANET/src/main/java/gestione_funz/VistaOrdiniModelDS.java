package gestione_funz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

public class VistaOrdiniModelDS implements VistaOrdiniModel<VistaOrdiniBean> {

	private DataSource ds = null;
	
	/********************************************************/
	/*				COSTRUTTORE CON DATASOURCE				*/
	/********************************************************/
	public VistaOrdiniModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Collection<VistaOrdiniBean> getOrdiniByemail(String email) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT ordine.data_acquisto, composto.ian_prodotto, "
				+ "prodotto.nomeProdotto, prodotto.descrizione, prodotto.prezzo, prodotto.peso "
				+ "FROM cliente, ordine, composto, prodotto "
				+ "WHERE ordine.email = cliente.e_mail AND composto.ian_prodotto = prodotto.IAN "
				+ "AND composto.id_ordine = ordine.id and cliente.e_mail = ?";
		
		Collection<VistaOrdiniBean> ordini = new LinkedList<VistaOrdiniBean>();
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, email);
			utils.UtilityClass.print("Vista ordini " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				VistaOrdiniBean bean = new VistaOrdiniBean();
				
				bean.setData(rs.getDate("data_acquisto"));
				//System.out.println(bean.getData().toString());
				bean.setIan(rs.getInt("ian_prodotto"));
				//System.out.println(bean.getIan());
				bean.setNomeProdotto(rs.getString("nomeProdotto"));
				//System.out.println(bean.getNomeProdotto());
				bean.setDescrizione(rs.getString("descrizione"));
				//System.out.println(bean.getDescrizione());
				bean.setPrezzo(rs.getDouble("prezzo"));
				//System.out.println(bean.getPrezzo());
				bean.setPeso(rs.getDouble("peso"));
				//bean.setQuantity(rs.getInt("quantity"));
				
				ordini.add(bean);
			}
			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		return ordini;
	}

}
