package model;

public class Segment {
protected int idSegment;
protected String nazivSegment;
protected Restoran restoran;

public Segment(int idSegment, String nazivSegment, Restoran restoran) {
	super();
	this.idSegment = idSegment;
	this.nazivSegment = nazivSegment;
	this.restoran = restoran;
}

public Segment(String nazivSegment, Restoran restoran) {
	super();
	this.nazivSegment = nazivSegment;
	this.restoran = restoran;
}

public int getIdSegment() {
	return idSegment;
}

public void setIdSegment(int idSegment) {
	this.idSegment = idSegment;
}

public String getNazivSegment() {
	return nazivSegment;
}

public void setNazivSegment(String nazivSegment) {
	this.nazivSegment = nazivSegment;
}

public Restoran getRestoran() {
	return restoran;
}

public void setRestoran(Restoran restoran) {
	this.restoran = restoran;
}

@Override
public String toString() {
	return "Segment [idSegment=" + idSegment + ", nazivSegment=" + nazivSegment + ", restoran=" + restoran + "]";
}


}
