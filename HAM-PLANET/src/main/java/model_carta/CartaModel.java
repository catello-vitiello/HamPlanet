package model_carta;
import java.sql.SQLException;
import java.util.Collection;

public interface CartaModel <T> {
	
	public Collection<T> selectAll() throws SQLException;
	

}
