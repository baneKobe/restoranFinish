package model;

public class Porudzbina {

protected int idPorudzbina;
protected Pice pice;
protected Jelo jelo;
protected int kolicinaPica;
protected int kolicinaJela;
protected double cijena;
protected Korisnik korisnik;
protected Termin termin;
protected Segment segment;
protected Sto sto;
protected Restoran restoran;
protected int prihvacenoKuvar;
protected int prihvacenoSanker;
protected int gotovoKuvar;
protected int gotovoSanker;
protected int odstampano;
public Porudzbina(int idPorudzbina, Pice pice, Jelo jelo, int kolicinaPica, int kolicinaJela, double cijena,
		Korisnik korisnik, Termin termin, Segment segment, Sto sto, Restoran restoran, int prihvacenoKuvar,
		int prihvacenoSanker, int gotovoKuvar, int gotovoSanker, int odstampano) {
	super();
	this.idPorudzbina = idPorudzbina;
	this.pice = pice;
	this.jelo = jelo;
	this.kolicinaPica = kolicinaPica;
	this.kolicinaJela = kolicinaJela;
	this.cijena = cijena;
	this.korisnik = korisnik;
	this.termin = termin;
	this.segment = segment;
	this.sto = sto;
	this.restoran = restoran;
	this.prihvacenoKuvar = prihvacenoKuvar;
	this.prihvacenoSanker = prihvacenoSanker;
	this.gotovoKuvar = gotovoKuvar;
	this.gotovoSanker = gotovoSanker;
	this.odstampano = odstampano;
}
public Porudzbina(Pice pice, Jelo jelo, int kolicinaPica, int kolicinaJela, double cijena, Korisnik korisnik,
		Termin termin, Segment segment, Sto sto, Restoran restoran) {
	super();
	this.pice = pice;
	this.jelo = jelo;
	this.kolicinaPica = kolicinaPica;
	this.kolicinaJela = kolicinaJela;
	this.cijena = cijena;
	this.korisnik = korisnik;
	this.termin = termin;
	this.segment = segment;
	this.sto = sto;
	this.restoran = restoran;
}
public int getIdPorudzbina() {
	return idPorudzbina;
}
public void setIdPorudzbina(int idPorudzbina) {
	this.idPorudzbina = idPorudzbina;
}
public Pice getPice() {
	return pice;
}
public void setPice(Pice pice) {
	this.pice = pice;
}
public Jelo getJelo() {
	return jelo;
}
public void setJelo(Jelo jelo) {
	this.jelo = jelo;
}
public int getKolicinaPica() {
	return kolicinaPica;
}
public void setKolicinaPica(int kolicinaPica) {
	this.kolicinaPica = kolicinaPica;
}
public int getKolicinaJela() {
	return kolicinaJela;
}
public void setKolicinaJela(int kolicinaJela) {
	this.kolicinaJela = kolicinaJela;
}
public double getCijena() {
	return cijena;
}
public void setCijena(double cijena) {
	this.cijena = cijena;
}
public Korisnik getKorisnik() {
	return korisnik;
}
public void setKorisnik(Korisnik korisnik) {
	this.korisnik = korisnik;
}
public Termin getTermin() {
	return termin;
}
public void setTermin(Termin termin) {
	this.termin = termin;
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
public Restoran getRestoran() {
	return restoran;
}
public void setRestoran(Restoran restoran) {
	this.restoran = restoran;
}
public int getPrihvacenoKuvar() {
	return prihvacenoKuvar;
}
public void setPrihvacenoKuvar(int prihvacenoKuvar) {
	this.prihvacenoKuvar = prihvacenoKuvar;
}
public int getPrihvacenoSanker() {
	return prihvacenoSanker;
}
public void setPrihvacenoSanker(int prihvacenoSanker) {
	this.prihvacenoSanker = prihvacenoSanker;
}
public int getGotovoKuvar() {
	return gotovoKuvar;
}
public void setGotovoKuvar(int gotovoKuvar) {
	this.gotovoKuvar = gotovoKuvar;
}
public int getGotovoSanker() {
	return gotovoSanker;
}
public void setGotovoSanker(int gotovoSanker) {
	this.gotovoSanker = gotovoSanker;
}
public int getOdstampano() {
	return odstampano;
}
public void setOdstampano(int odstampano) {
	this.odstampano = odstampano;
}
@Override
public String toString() {
	return "Porudzbina [idPorudzbina=" + idPorudzbina + ", pice=" + pice + ", jelo=" + jelo + ", kolicinaPica="
			+ kolicinaPica + ", kolicinaJela=" + kolicinaJela + ", cijena=" + cijena + ", korisnik=" + korisnik
			+ ", termin=" + termin + ", segment=" + segment + ", sto=" + sto + ", restoran=" + restoran
			+ ", prihvacenoKuvar=" + prihvacenoKuvar + ", prihvacenoSanker=" + prihvacenoSanker + ", gotovoKuvar="
			+ gotovoKuvar + ", gotovoSanker=" + gotovoSanker + ", odstampano=" + odstampano + "]";
}

}