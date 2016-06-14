package model.marko;

public class Pazar {
	protected int idracun;
	protected Jelo Jelo;
	protected Pice Pice;
	protected Konobar Konobar;
	protected Restoran Restoran;
	protected double cijena;
	public Pazar(int idracun, model.marko.Jelo jelo, model.marko.Pice pice, model.marko.Konobar konobar, model.marko.Restoran restoran,
			double cijena) {
		super();
		this.idracun = idracun;
		Jelo = jelo;
		Pice = pice;
		Konobar = konobar;
		Restoran = restoran;
		this.cijena = cijena;
	}
	public Pazar(model.marko.Jelo jelo, model.marko.Pice pice, model.marko.Konobar konobar, model.marko.Restoran restoran, double cijena) {
		super();
		Jelo = jelo;
		Pice = pice;
		Konobar = konobar;
		Restoran = restoran;
		this.cijena = cijena;
	}
	public int getIdracun() {
		return idracun;
	}
	public void setIdracun(int idracun) {
		this.idracun = idracun;
	}
	public Jelo getJelo() {
		return Jelo;
	}
	public void setJelo(Jelo jelo) {
		Jelo = jelo;
	}
	public Pice getPice() {
		return Pice;
	}
	public void setPice(Pice pice) {
		Pice = pice;
	}
	public Konobar getKonobar() {
		return Konobar;
	}
	public void setKonobar(Konobar konobar) {
		Konobar = konobar;
	}
	public Restoran getRestoran() {
		return Restoran;
	}
	public void setRestoran(Restoran restoran) {
		Restoran = restoran;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	@Override
	public String toString() {
		return "Pazar [idracun=" + idracun + ", Jelo=" + Jelo + ", Pice=" + Pice + ", Konobar=" + Konobar
				+ ", Restoran=" + Restoran + ", cijena=" + cijena + "]";
	}
	
	
}
