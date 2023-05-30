package model_carta;

import java.io.Serializable;

public class CartaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeTitolare, cognomeTitolare, numeroCarta, scadenza;
	private int cvv;

	public CartaBean() {

	}

	public CartaBean(String nomeTitolare, String cognomeTitolare, String numeroCarta, String scadenza, int cvv) {

		this.nomeTitolare = nomeTitolare;
		this.cognomeTitolare = cognomeTitolare;
		this.numeroCarta = numeroCarta;
		this.scadenza = scadenza;
		this.cvv = cvv;
	}

	public String getNomeTitolare() {
		return nomeTitolare;
	}

	public void setNomeTitolare(String nomeTitolare) {
		this.nomeTitolare = nomeTitolare;
	}

	public String getCognomeTitolare() {
		return cognomeTitolare;
	}

	public void setCognomeTitolare(String cognomeTitolare) {
		this.cognomeTitolare = cognomeTitolare;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String toString() {

		return getClass().getName() + "[nomeTitolare= " + nomeTitolare + ", cognomeTitolare= " + cognomeTitolare
				+ ", numeroCarta= " + numeroCarta + ", scadenza= " + scadenza + ", cvv= " + cvv + "]";
	}

}
