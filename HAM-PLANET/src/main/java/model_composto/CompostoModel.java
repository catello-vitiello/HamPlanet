package model_composto;

import java.sql.SQLException;
import java.util.Collection;

public interface CompostoModel<T> {

	public Collection<T> selectAll() throws SQLException;

	public void deleteComposto(int id_c) throws SQLException;

}
