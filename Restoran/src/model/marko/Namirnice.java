package model.marko;

public class Namirnice {
	protected int idNamirnicaPica;
	protected String naziv;
	protected String kolicina;
	protected String cena;
	
	
	public Namirnice(int idNamirnicaPica, String naziv, String kolicina,String cena) {
		super();
		this.idNamirnicaPica = idNamirnicaPica;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.cena=cena;
	}


	public Namirnice(int idNamirnicaPica, String naziv, String kolicina) {
		super();
		this.idNamirnicaPica = idNamirnicaPica;
		this.naziv = naziv;
		this.kolicina = kolicina;
	}


	public Namirnice(String cena) {
		this.cena=cena;
	}


	public Namirnice(int id, String cena) {
		this.idNamirnicaPica = id;
		this.cena=cena;
	}


	public String getCena() {
		return cena;
	}


	public void setCena(String cena) {
		this.cena = cena;
	}


	public int getIdNamirnicaPica() {
		return idNamirnicaPica;
	}


	public void setIdNamirnicaPica(int idNamirnicaPica) {
		this.idNamirnicaPica = idNamirnicaPica;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getKolicina() {
		return kolicina;
	}


	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}


	@Override
	public String toString() {
		return "Namirnice [idNamirnicaPica=" + idNamirnicaPica + ", naziv=" + naziv + ", kolicina=" + kolicina + "]";
	}
	
	
}

