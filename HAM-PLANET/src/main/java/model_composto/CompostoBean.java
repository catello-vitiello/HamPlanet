package model_composto;

import java.io.Serializable;

public class CompostoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id_c, id_ordine, ian_prodotto, quantity;
	private double prezzo;

	public CompostoBean() {

	}

	public CompostoBean(int id_c, int id_ordine, int ian_prodotto, int quantity, double prezzo) {
		this.id_c = id_c;
		this.id_ordine = id_ordine;
		this.ian_prodotto = ian_prodotto;
		this.quantity = quantity;
		this.prezzo = prezzo;
	}

	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public int getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public int getIan_prodotto() {
		return ian_prodotto;
	}

	public void setIan_prodotto(int ian_prodotto) {
		this.ian_prodotto = ian_prodotto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/****************************************************************************/
	/* 								TOSTRING 									*/
	/****************************************************************************/

	public String toString() {
		String s = getClass().getName() + "[id composto=" + id_c + ",id ordine= " + id_ordine + ",ian prodotto= "
				+ ian_prodotto + ",quantità= " + quantity + ",prezzo= " + prezzo + "]";
		return s;
	}
}
