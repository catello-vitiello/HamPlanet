package model_bigBean;

import java.io.Serializable;

public class BigBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeProdotto;
	private int quantity, id, ian;
	private double price;
	
	public BigBean () {
		
	}
	
	public BigBean(String nomeProdotto, int quantity, double price, int id, int ian) {
		this.nomeProdotto = nomeProdotto;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
		this.ian = ian;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIan() {
		return ian;
	}

	public void setIan(int ian) {
		this.ian = ian;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [nomeProdotto= " + nomeProdotto + ", quantity= " + quantity + ", price= " + price + ", id ordine: " + id +"]";
	}
	
	

}
