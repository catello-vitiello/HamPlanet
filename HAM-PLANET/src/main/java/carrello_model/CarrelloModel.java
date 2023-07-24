package carrello_model;

import java.sql.SQLException;
import java.util.Collection;

public interface CarrelloModel<T> {
	
	public Collection<?> getAllOrderByEmail(String email) throws SQLException;
	
	public void addKartProd(int ian, String email) throws SQLException;
	
	public void plusQuantity(int ian, String email) throws SQLException;
	
	public void minuQuantity(int ian, String email) throws SQLException;
	
	public void deleteProductFromKart(int ian, String email) throws SQLException;

}
