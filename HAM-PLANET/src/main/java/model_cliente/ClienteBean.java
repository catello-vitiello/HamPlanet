package model_cliente;

import java.io.Serializable;

public class ClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email, pass, nome, cognome, indirizzo;
	private char sesso;
	private String cellulare;
	
	public ClienteBean() {
		
	}
	
	public ClienteBean(String email, String pass, String nome, String cognome, char sesso, String indirizzo, String cellulare) {
		this.email = email;
		this.pass = pass;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.indirizzo = indirizzo;
		this.cellulare = cellulare;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/****************************************************************************/
	/* 								TOSTRING									*/
	/****************************************************************************/

	public String toString() {
		String s = getClass().getName() + "[e-mail= " + email + ", password= " + pass + ", nome= " + nome + ", cognome= " + cognome
				+ ", sesso= " + sesso + ", indirizzo= " + indirizzo + ", cellulare= " + cellulare + "]";
		return s;
	}
	
}
