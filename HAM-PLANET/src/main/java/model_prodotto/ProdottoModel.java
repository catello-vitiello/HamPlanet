package model_prodotto;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel<T> {
	public Collection<T> selectAll_NoImage() throws SQLException;
	
	public void insert_NoImage(int IAN,String descrizione,double peso,double prezzo, String nomeProdotto)throws SQLException;
	
	public void delete(int IAN)throws SQLException;

}
