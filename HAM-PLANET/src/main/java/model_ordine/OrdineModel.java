package model_ordine;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdineModel<T>{

	public Collection<T> getAll() throws SQLException;
	
	public void insert(String data_acquisto, String stato, String metodoPagamento, String email) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	public void setStato(String stato, int id) throws SQLException;
	
	public Collection<?> getOrdiniEffettuati(String email) throws SQLException;
	
}
