package model.marko;

public class Restoran {
protected int idRest;
protected String nazivRest;
protected String vrstaRest;
protected Jelovnik jelovnik;
protected KartaPica kartapica;


public Restoran(int idRest, String nazivRest, String vrstaRest, Jelovnik jelovnik, KartaPica kartapica) {
	super();
	this.idRest = idRest;
	this.nazivRest = nazivRest;
	this.vrstaRest = vrstaRest;
	this.jelovnik = jelovnik;
	this.kartapica = kartapica;
}


public Restoran(String nazivRest, String vrstaRest, Jelovnik jelovnik, KartaPica kartapica) {
	super();
	this.nazivRest = nazivRest;
	this.vrstaRest = vrstaRest;
	this.jelovnik = jelovnik;
	this.kartapica = kartapica;
}


public int getIdRest() {
	return idRest;
}


public void setIdRest(int idRest) {
	this.idRest = idRest;
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


public Jelovnik getJelovnik() {
	return jelovnik;
}


public void setJelovnik(Jelovnik jelovnik) {
	this.jelovnik = jelovnik;
}


public KartaPica getKartapica() {
	return kartapica;
}


public void setKartapica(KartaPica kartapica) {
	this.kartapica = kartapica;
}


@Override
public String toString() {
	return "Restoran [idRest=" + idRest + ", nazivRest=" + nazivRest + ", vrstaRest=" + vrstaRest + ",Jelovnik idJelovnik="
			+ jelovnik.getIdJelovnik() + ", KartaPica idKarte=" + kartapica.getIdKarte() + "]";
}


}
