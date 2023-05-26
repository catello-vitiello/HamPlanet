package model_ha;

import java.io.Serializable;

public class HaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String email_u, n_card;

	public HaBean() {

	}

	public HaBean(int id, String email_u, String n_card) {

		this.id = id;
		this.email_u = email_u;
		this.n_card = n_card;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail_u() {
		return email_u;
	}

	public void setEmail_u(String email_u) {
		this.email_u = email_u;
	}

	public String getN_card() {
		return n_card;
	}

	public void setN_card(String n_card) {
		this.n_card = n_card;
	}

	public String toString() {

		return getClass().getName() + "[id= " + id + ", email_u= " + email_u + ", n_card= " + n_card + "]";
	}

}
