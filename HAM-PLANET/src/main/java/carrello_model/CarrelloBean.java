package carrello_model;

import java.io.Serializable;

public class CarrelloBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeProdotto, descrizione;
	private double prezzo;
	private int ian, quantity;
	
	public CarrelloBean() {
		
	}
	
	public CarrelloBean(String nomeProdotto, double prezzo, String descrizione, int ian, int quantity) {
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.ian = ian;
		this.quantity = quantity;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIan() {
		return ian;
	}

	public void setIan(int ian) {
		this.ian = ian;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return getClass().getName() + "[NomeProdotto= " + nomeProdotto + ", prezzo= " + prezzo + ", descrizione= " + descrizione + ", IAN= " + ian + "]";
	}
	
}
