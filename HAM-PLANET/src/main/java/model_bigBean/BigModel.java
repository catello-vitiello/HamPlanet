package model_bigBean;

import java.sql.SQLException;
import java.util.Collection;

public interface BigModel<T> {

	public Collection<T> selectAll(String email) throws SQLException;
}
