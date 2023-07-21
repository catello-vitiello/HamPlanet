package gestione_funz;
import java.sql.SQLException;
import java.util.Collection;

public interface CercaCardModel<T> {

	public Collection<T> getCardByEmail(String email) throws SQLException;
	
	public String getNumCarte(String email) throws SQLException;
	
	public void insertNewCard(CercaCarteClienteBean bean, String email) throws SQLException;
	
}
