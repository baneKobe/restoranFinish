package model;

public class Pice {
	protected int idPice;
	protected String naziv;
	protected String opis;
	protected double cijena;
	protected KartaPica idKart; 
	protected int dejanidKart;

	public int getDejanidKart() {
		return dejanidKart;
	}
	
	


	public Pice(String naziv, String opis, double cijena, int dejanidKart) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cijena = cijena;
		this.dejanidKart = dejanidKart;
	}

	public Pice(int idPice, String naziv, String opis, double cijena, KartaPica idKart) {
		super();
		this.idPice = idPice;
		this.naziv = naziv;
		this.opis = opis;
		this.cijena = cijena;
		this.idKart = idKart;
	}
	
	
	public Pice(String naziv, String opis, double cijena, KartaPica idKart) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cijena = cijena;
		this.idKart = idKart;
	}


	public int getIdPice() {
		return idPice;
	}
	public void setIdPice(int idPice) {
		this.idPice = idPice;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	public KartaPica getIdKart() {
		return idKart;
	}
	public void setIdKart(KartaPica idKart) {
		this.idKart = idKart;
	}
	@Override
	public String toString() {
		return "Pice [idPice=" + idPice + ", naziv=" + naziv + ", opis=" + opis + ", cijena=" + cijena + ", idKart="
				+ idKart + "]";
	}
	
	
	
}
