package model_cliente;

import java.sql.SQLException;
import java.util.Collection;

public interface ClienteModel<T> {

	public Collection<T> selectAll() throws SQLException;
	
	public void insert(String email, String pass, String nome, String cognome, char sesso, String indirizzo, String cellulare,
			String data_nascita, String paese, String provincia, String cap) throws SQLException;
	
	public ClienteBean getByEmail(String email) throws SQLException;
	
	public void deleteCliente(String email) throws SQLException;
	
	public ClienteBean tryLogIn(String email, String password) throws SQLException;
	
	public void changePassword(String email, String password) throws SQLException;
	
	public void changeAddress(String email, String indirizzo, String paese, String provincia, String cap) throws SQLException;
	
	public void changePhone(String email, String phone) throws SQLException;
	
}
