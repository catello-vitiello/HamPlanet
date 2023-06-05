package model_cliente;

import java.io.Serializable;

public class ClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email, pass, nome, cognome, indirizzo, data_nascita;
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

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	/****************************************************************************/
	/* 								TOSTRING									*/
	/****************************************************************************/

	public String toString() {
		 return getClass().getName() + "[e-mail= " + email + ", password= " + pass + ", nome= " + nome + ", cognome= " + cognome
				+ ", sesso= " + sesso + ", indirizzo= " + indirizzo + ", cellulare= " + cellulare + ", data di nascita= " + data_nascita + "]";
	}
	
}
