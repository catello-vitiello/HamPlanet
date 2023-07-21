package model_prodotto;

import java.io.Serializable;

public class ProdottoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int IAN, visualizza, quantity;
	private String descrizione, nomeProdotto, tipo;
	private double peso, prezzo;
	
	public ProdottoBean() {

	}

	public ProdottoBean(int IAN, String descrizione, double peso, double prezzo, String nomeProdotto, String tipo) {
		this.IAN = IAN;
		this.descrizione = descrizione;
		this.peso = peso;
		this.prezzo = prezzo;
		this.nomeProdotto = nomeProdotto;
		this.tipo = tipo;
		this.visualizza = 1;
		this.quantity = 1;
	}

	public int getIAN() {
		return IAN;
	}

	public void setIAN(int iAN) {
		IAN = iAN;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	public int getVisualizza() {
		return visualizza;
	}
	
	public void setVisualizza(int newV) {
		visualizza = newV;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String newType) {
		tipo = newType;
	}
	
	/****************************************************************************/
	/* 								Quantità 									*/
	/****************************************************************************/
	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(int q){
		this.quantity+=q;
	}

	/****************************************************************************/
	/* 								TOSTRING-JS 								*/
	/****************************************************************************/
	public String toStringJS(){
		return IAN + "," + descrizione + "," + peso + ","
			+ prezzo + "," + nomeProdotto + "," + quantity + "," + tipo;
	}

	/****************************************************************************/
	/* 								TOSTRING 									*/
	/****************************************************************************/
	public String toString() {
		 return getClass().getName() + "[IAN= " + IAN + ", descrizione= " + descrizione + ", peso= " + peso
				+ ", prezzo= " + prezzo + ", nome prodotto= " + nomeProdotto + ", quantitativo= " + quantity + ", tipo= " + tipo +"]";
	}

}
