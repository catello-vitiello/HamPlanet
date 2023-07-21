package carrello_model;

import java.sql.SQLException;
import java.util.Collection;

public interface CarrelloModel<T> {
	
	public Collection<?> getAllOrderByEmail(String email) throws SQLException;

}
