package model_ha;

import java.sql.SQLException;
import java.util.Collection;


public interface HaModel <T> {
	
	public Collection<T> selectAll() throws SQLException;

}
