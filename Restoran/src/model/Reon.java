package model;

public class Reon {
protected int idReon;
protected Segment segment;
protected int brojStolova;
protected Konobar konobar;
public Reon(int idReon, Segment segment, int brojStolova, Konobar konobar) {
	super();
	this.idReon = idReon;
	this.segment = segment;
	this.brojStolova = brojStolova;
	this.konobar = konobar;
}

public int getIdReon() {
	return idReon;
}

public void setIdReon(int idReon) {
	this.idReon = idReon;
}

public Segment getSegment() {
	return segment;
}

public void setSegment(Segment segment) {
	this.segment = segment;
}

public int getBrojStolova() {
	return brojStolova;
}

public void setBrojStolova(int brojStolova) {
	this.brojStolova = brojStolova;
}

public Konobar getKonobar() {
	return konobar;
}

public void setKonobar(Konobar konobar) {
	this.konobar = konobar;
}

@Override
public String toString() {
	return "Reon [idReon=" + idReon + ", segment=" + segment + ", brojStolova=" + brojStolova + ", konobar=" + konobar
			+ "]";
}

}
