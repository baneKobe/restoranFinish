package model;


public class RestoranNaziv {

	protected int id;
	protected String nazivRest;
	protected String vrstaRest;
	protected String jelovnik;
	protected String kartaPica;

	public RestoranNaziv(int id, String nazivRest, String vrstaRest, String jelovnik, String kartaPica) {
		super();
		this.id=id;
		this.nazivRest=nazivRest;
		this.vrstaRest=vrstaRest;
		this.jelovnik=jelovnik;
		this.kartaPica=kartaPica;
	}
	public RestoranNaziv(String nazivRest, String vrstaRest, String jelovnik, String kartaPica) {
		
		super();
		this.nazivRest=nazivRest;
		this.vrstaRest=vrstaRest;
		this.jelovnik=jelovnik;
		this.kartaPica=kartaPica;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivRest() {
		return nazivRest;
	}
	public void setNazivRest(String nazivRest) {
		this.nazivRest = nazivRest;
	}
	public String getVrstaRest() {
		return vrstaRest;
	}
	public void setVrstaRest(String vrstaRest) {
		this.vrstaRest = vrstaRest;
	}
	public String getJelovnik() {
		return jelovnik;
	}
	public void setJelovnik(String jelovnik) {
		this.jelovnik = jelovnik;
	}
	public String getKartaPica() {
		return kartaPica;
	}
	public void setKartaPica(String kartaPica) {
		this.kartaPica = kartaPica;
	}
	
	@Override
	public String toString() {
		return "RestoranNaziv [id=" + id + ", nazivRest=" + nazivRest + ", vrstaRest=" + vrstaRest + ", jelovnik="
				+ jelovnik + ", kartaPica=" + kartaPica + "]";
	}
	
	
	
	
}