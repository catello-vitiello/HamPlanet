package gestione_funz;

import java.sql.SQLException;
import java.util.Collection;

public interface VistaOrdiniModel<T> {

	public Collection<T> getOrdiniByemail(String email) throws SQLException;
	
}
