package gestione_funz;
import java.io.Serializable;

public class CercaCarteClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nc, scadenza, titolare;
	private int cvv;
	
	public CercaCarteClienteBean() {
		
	}
	
	public CercaCarteClienteBean(String nc, int cvv, String scadenza, String titolare) {
		this.nc = nc;
		this.cvv = cvv;
		this.scadenza = scadenza;
		this.titolare = titolare;
	}

	public String getNc() {
		return nc;
	}

	public void setNc(String nc) {
		this.nc = nc;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	
	public String getTitolare() {
		return titolare;
	}
	
	public void setTitolare(String newName) {
		titolare = newName;
	}

	@Override
	public String toString() {
		return "CercaCarteClienteBean [nc=" + nc + ", scadenza=" + scadenza + ", cvv=" + cvv + ", nome titolare= " + titolare +"]";
	}
	
}
