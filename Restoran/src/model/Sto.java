package model;

public class Sto {
protected int idSto;
protected Segment segment;

public Sto(int idSto, Segment segment) {
	super();
	this.idSto = idSto;
	this.segment = segment;
}

public int getIdSto() {
	return idSto;
}

public void setIdSto(int idSto) {
	this.idSto = idSto;
}

public Segment getSegment() {
	return segment;
}

public void setSegment(Segment segment) {
	this.segment = segment;
}

@Override
public String toString() {
	return "Sto [idSto=" + idSto + ", segment=" + segment + "]";
}

}
