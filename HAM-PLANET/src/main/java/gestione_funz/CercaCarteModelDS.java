package gestione_funz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

public class CercaCarteModelDS implements CercaCardModel<CercaCarteClienteBean>{

	private DataSource ds = null;
	
	/********************************************************/
	/*				COSTRUTTORE CON DATASOURCE				*/
	/********************************************************/

	public CercaCarteModelDS(DataSource ds) {
		this.ds = ds;
	}
	
	
	/********************************************************/
	/*				RECUPERO DATI DELLA CARTA				*/
	/********************************************************/
	@Override
	public  Collection<CercaCarteClienteBean> getCardByEmail(String email) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT c.numeroCarta, c.cvv, c.scadenza "
				+ "FROM cliente cl, carta c, Ha h "
				+ "WHERE h.n_card=c.numeroCarta AND "
				+ "h.email_u=cl.e_mail AND "
				+ "e_mail = ?";
		Collection<CercaCarteClienteBean> listaCarte = new LinkedList<CercaCarteClienteBean>();
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, email);
			
			utils.UtilityClass.print("Select delle carte " + preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				CercaCarteClienteBean ccb = new CercaCarteClienteBean();
				ccb.setNc(rs.getString("numeroCarta"));
				ccb.setCvv(rs.getInt("cvv"));
				ccb.setScadenza(rs.getString("scadenza"));
				
				listaCarte.add(ccb);
			}
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		return listaCarte;
	}
	
	
	/********************************************************/
	/*				RECUPERO NUMERO DI CARTE				*/
	/********************************************************/
	public int getNumCarte(String email) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT COUNT(*) AS n FROM cliente cl, carta c, Ha h "
				+ "WHERE h.n_card=c.numeroCarta AND "
				+ "h.email_u=cl.e_mail AND "
				+ "e_mail = ?";
		
		int n = 0;
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			utils.UtilityClass.print("Select delle carte " + preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				n =  rs.getInt("n");
			}
			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		}
		
		return n;
	}

}
