package model;

public class Termin {
protected int idTermin;
protected String datum;
protected String vrijeme;
protected String trajanje;
protected Korisnik korisnik;
protected Segment segment;
protected Sto sto;

public Termin(int idTermin, String datum, String vrijeme, String trajanje, Korisnik korisnik, Segment segment,
		Sto sto) {
	super();
	this.idTermin = idTermin;
	this.datum = datum;
	this.vrijeme = vrijeme;
	this.trajanje = trajanje;
	this.korisnik = korisnik;
	this.segment = segment;
	this.sto = sto;
}

public Termin(String datum, String vrijeme, String trajanje, Korisnik korisnik, Segment segment, Sto sto) {
	super();
	this.datum = datum;
	this.vrijeme = vrijeme;
	this.trajanje = trajanje;
	this.korisnik = korisnik;
	this.segment = segment;
	this.sto = sto;
}

public int getIdTermin() {
	return idTermin;
}

public void setIdTermin(int idTermin) {
	this.idTermin = idTermin;
}

public String getDatum() {
	return datum;
}

public void setDatum(String datum) {
	this.datum = datum;
}

public String getVrijeme() {
	return vrijeme;
}

public void setVrijeme(String vrijeme) {
	this.vrijeme = vrijeme;
}

public String getTrajanje() {
	return trajanje;
}

public void setTrajanje(String trajanje) {
	this.trajanje = trajanje;
}

public Korisnik getKorisnik() {
	return korisnik;
}

public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
}

public Segment getSegment() {
	return segment;
}

public void setSegment(Segment segment) {
	this.segment = segment;
}

public Sto getSto() {
	return sto;
}

public void setSto(Sto sto) {
	this.sto = sto;
}

@Override
public String toString() {
	return "Termin [idTermin=" + idTermin + ", datum=" + datum + ", vrijeme=" + vrijeme + ", trajanje=" + trajanje
			+ ", korisnik=" + korisnik + "]";
}



}
