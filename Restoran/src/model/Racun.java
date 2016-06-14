package model;

public class Racun {
protected int idRacun;
protected Jelo jelo;
protected Pice pice;
protected Konobar konobar;
protected Restoran restoran;
protected Porudzbina porudzbina;
protected double cijena;
public Racun(int idRacun, Jelo jelo, Pice pice, Konobar konobar, Restoran restoran, Porudzbina porudzbina,
		double cijena) {
	super();
	this.idRacun = idRacun;
	this.jelo = jelo;
	this.pice = pice;
	this.konobar = konobar;
	this.restoran = restoran;
	this.porudzbina = porudzbina;
	this.cijena = cijena;
}
public Racun(Jelo jelo, Pice pice, Konobar konobar, Restoran restoran, Porudzbina porudzbina, double cijena) {
	super();
	this.jelo = jelo;
	this.pice = pice;
	this.konobar = konobar;
	this.restoran = restoran;
	this.porudzbina = porudzbina;
	this.cijena = cijena;
}
public int getIdRacun() {
	return idRacun;
}
public void setIdRacun(int idRacun) {
	this.idRacun = idRacun;
}
public Jelo getJelo() {
	return jelo;
}
public void setJelo(Jelo jelo) {
	this.jelo = jelo;
}
public Pice getPice() {
	return pice;
}
public void setPice(Pice pice) {
	this.pice = pice;
}
public Konobar getKonobar() {
	return konobar;
}
public void setKonobar(Konobar konobar) {
	this.konobar = konobar;
}
public Restoran getRestoran() {
	return restoran;
}
public void setRestoran(Restoran restoran) {
	this.restoran = restoran;
}
public Porudzbina getPorudzbina() {
	return porudzbina;
}
public void setPorudzbina(Porudzbina porudzbina) {
	this.porudzbina = porudzbina;
}
public double getCijena() {
	return cijena;
}
public void setCijena(double cijena) {
	this.cijena = cijena;
}
@Override
public String toString() {
	return "Racun [idRacun=" + idRacun + ", jelo=" + jelo + ", pice=" + pice + ", konobar=" + konobar + ", restoran="
			+ restoran + ", porudzbina=" + porudzbina + ", cijena=" + cijena + "]";
}


}
