package model_prodotto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

import java.sql.Blob;

public class ProdottoModelDS implements ProdottoModel<ProdottoBean> {

	private DataSource ds = null;

	/********************************************************/
	/* 			COSTRUTTORE CON DATASOURCE 					*/
	/********************************************************/

	public ProdottoModelDS(DataSource ds) {
		this.ds = ds;
	}

	/********************************************************/
	/* 				SELECT ALL NO IMAGE 					*/
	/********************************************************/

	@Override
	public Collection<ProdottoBean> selectAll_NoImage() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM prodotto";
		Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			utils.UtilityClass.print(">.SELECT ALL SU PRODOTTI " + preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ProdottoBean pb = new ProdottoBean();
				pb.setIAN(rs.getInt("IAN"));
				pb.setDescrizione(rs.getString("descrizione"));
				pb.setPeso(rs.getDouble("peso"));
				pb.setPrezzo(rs.getDouble("prezzo"));
				pb.setNomeProdotto(rs.getString("nomeProdotto"));

				prodotti.add(pb);
			}
		} finally {

			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

		return prodotti;
	}

	/********************************************************/
	/* 					INSERT NO IMAGE 					*/
	/********************************************************/

	@Override
	public void insert_NoImage(int IAN, String descrizione, double peso, double prezzo, String nomeProdotto)
			throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO prodotto (IAN,prezzo,peso,descrizione,nomeProdotto) VALUES (?, ?, ?, ?, ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, IAN);
			preparedStatement.setDouble(2, prezzo);
			preparedStatement.setDouble(3, peso);
			preparedStatement.setString(4, descrizione);
			preparedStatement.setString(5, nomeProdotto);

			utils.UtilityClass.print(">.INSERT " + preparedStatement);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}
	}

	/********************************************************/
	/* 						DELETE 							*/
	/********************************************************/

	@Override
	public void delete(int IAN) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM prodotto WHERE IAN = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, IAN);
			utils.UtilityClass.print(">.DELETE " + preparedStatement);
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

	}
	
	
	/********************************************************/
	/* 						INSERT IMAGE					*/
	/********************************************************/
	@Override
	public void addImageToProduct(int ian, File file) throws SQLException {

		try {
			File file2 = new File(file.getPath());
			FileInputStream fis = new FileInputStream(file2);

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String sql = "UPDATE  prodotto SET image = ? WHERE IAN = ?";
			
			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setBinaryStream(1, fis, (int) file2.length());
				preparedStatement.setInt(2, ian);

				utils.UtilityClass.print("Inserimento immagine in prodotto " + preparedStatement.toString());
				preparedStatement.executeUpdate();

			} finally {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			}
		} catch (FileNotFoundException e) {
			utils.UtilityClass.print(e);
		}
		
	}
	
	
	/********************************************************/
	/* 						GET IMAGE					    */
	/********************************************************/
	
	
	public byte[] getImageByKey(int id) throws SQLException{

        byte[] imageBytes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT image FROM prodotto WHERE IAN = ?";

        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                // Leggi l'immagine dal risultato della query
                Blob imageBlob = rs.getBlob("image");
                //inserimento controllo per vedere se l'immagine esiste
                if(imageBlob != null)
                	imageBytes = imageBlob.getBytes(1, (int)imageBlob.length());
                else
                	return null;
            }

        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return imageBytes;

    }

	
}