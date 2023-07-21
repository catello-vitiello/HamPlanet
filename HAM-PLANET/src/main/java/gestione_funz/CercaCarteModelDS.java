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
	public String getNumCarte(String email) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT COUNT(*) AS n FROM cliente cl, carta c, Ha h "
				+ "WHERE h.n_card=c.numeroCarta AND "
				+ "h.email_u=cl.e_mail AND "
				+ "e_mail = ?";
		
		Integer n = 0;
		
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
		
		return n.toString();
	}
	
	/********************************************************/
	/*					INSERIMENTO CARTA					*/
	/********************************************************/
	public void insertNewCard(CercaCarteClienteBean bean, String email) throws SQLException{
		
		Connection connection = null;
		Connection connection_1 = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO carta (nomeTitolare, numeroCarta, scadenza, cvv, visualizza) VALUES(?, ?, ?, ?, 1)";
		String sql_1 = "INSERT INTO Ha (email_u, n_card) VALUES (?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bean.getTitolare());
			preparedStatement.setString(2, bean.getNc());
			preparedStatement.setString(3, bean.getScadenza());
			preparedStatement.setInt(4, bean.getCvv());
			utils.UtilityClass.print(">.Inserimento  carta: " + bean.toString());
			preparedStatement.executeUpdate();
			
			connection_1 = ds.getConnection();
			ps = connection_1.prepareStatement(sql_1);
			ps.setString(1, email);
			ps.setString(2, bean.getNc());
			utils.UtilityClass.print(">.Inserimento carta numero al cliente: " + bean.getNc() + " -> " + email);
			ps.executeUpdate();
			
		}finally {
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
			
			/*if(ps != null)
				ps.close();
			if(connection_1 != null)
				connection_1.close();*/
		}
	}

}
