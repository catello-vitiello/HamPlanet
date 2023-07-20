package model_bigBean;

public class BigBean {
	
	private String nomeProdotto;
	private int quantity;
	private double price;
	
	public BigBean () {
		
	}
	
	public BigBean(String nomeProdotto, int quantity, double price) {
		this.nomeProdotto = nomeProdotto;
		this.quantity = quantity;
		this.price = price;
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

	@Override
	public String toString() {
		return getClass().getName() + " [nomeProdotto= " + nomeProdotto + ", quantity= " + quantity + ", price= " + price + "]";
	}
	
	

}
