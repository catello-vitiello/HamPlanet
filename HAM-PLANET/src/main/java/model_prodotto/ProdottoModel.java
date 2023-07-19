package model_prodotto;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel<T> {
	public Collection<T> selectAll_NoImage() throws SQLException;
	
	public Collection<T> selectAll_NoImage_NotAvailable() throws SQLException;
	
	public void insert_NoImage(int IAN,String descrizione,double peso,double prezzo, String nomeProdotto)throws SQLException;
	
	public void delete(int IAN)throws SQLException;
	
	public void returnAvailable(int IAN) throws SQLException;

	public void addImageToProduct(int ian,InputStream io)throws SQLException;
	
	public byte[] getImageByKey(int id)throws SQLException;
}
