package carrello_model;

import java.io.Serializable;

public class CarrelloBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeProdotto;
	private double prezzo;
	
	public CarrelloBean() {
		
	}
	
	public CarrelloBean(String nomeProdotto, double prezzo) {
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
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
	
	public String toString() {
		return getClass().getName() + "[NomeProdotto= " + nomeProdotto + ", prezzo= " + prezzo + "]";
	}
	
}
