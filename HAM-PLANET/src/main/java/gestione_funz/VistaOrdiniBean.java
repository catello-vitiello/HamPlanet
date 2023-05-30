package gestione_funz;

import java.io.Serializable;
import java.util.Date;

public class VistaOrdiniBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private int ian, quantity;
	private String nomeProdotto, descrizione;
	private double prezzo, peso;
	
	public VistaOrdiniBean() {
		
	}

	public VistaOrdiniBean(Date data, int ian, String nomeProdotto, String descrizione, double prezzo, double peso, int quantity) {
		this.data = data;
		this.ian = ian;
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.peso = peso;
		this.quantity = quantity;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIan() {
		return ian;
	}

	public void setIan(int ian) {
		this.ian = ian;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "VistaOrdiniBean [data=" + data + ", ian=" + ian + ", quantity=" + quantity + ", nomeProdotto="
				+ nomeProdotto + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", peso=" + peso + "]";
	}

}
