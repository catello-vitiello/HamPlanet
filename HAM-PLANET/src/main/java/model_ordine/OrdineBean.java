package model_ordine;

import java.io.Serializable;
import java.util.Date;

public class OrdineBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private Date data_acquisto;
	private String stato; //salvato, effettuato, spedito
	private String metodoPagamento;
	private String email;
	
	public OrdineBean() {
		
	}
	
	public OrdineBean(int id, Date data_acquisto, String stato, String metodoPagamento, String email) {
		this.id = id;
		this.data_acquisto = data_acquisto;
		this.stato = stato;
		this.metodoPagamento = metodoPagamento;
		this.email = email;
	}

	public Date getData_acquisto() {
		return data_acquisto;
	}

	public void setData_acquisto(Date data_acquisto) {
		this.data_acquisto = data_acquisto;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[data_acquisto=" + data_acquisto + ", stato=" + stato + ", metodoPagamento="
				+ metodoPagamento + ", email=" + email + "]";
	}
	
	
	
}
