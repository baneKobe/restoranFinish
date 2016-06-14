package klaseDejan;

public class PorudzbinaP {

	protected String nazivR;
	protected String nazivP;
	protected String datum;
	protected String vreme;
	protected String sati;
	protected String sto;
	public String getNazivR() {
		return nazivR;
	}
	public void setNazivR(String nazivR) {
		this.nazivR = nazivR;
	}
	public String getNazivP() {
		return nazivP;
	}
	public void setNazivP(String nazivP) {
		this.nazivP = nazivP;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public String getSati() {
		return sati;
	}
	public void setSati(String sati) {
		this.sati = sati;
	}
	public String getSto() {
		return sto;
	}
	public void setSto(String sto) {
		this.sto = sto;
	}
	@Override
	public String toString() {
		return "PorudzbinaP [nazivR=" + nazivR + ", nazivP=" + nazivP + ", datum=" + datum + ", vreme=" + vreme
				+ ", sati=" + sati + ", sto=" + sto + "]";
	}
	public PorudzbinaP(String nazivR, String nazivP, String datum, String vreme, String sati, String sto) {
		super();
		this.nazivR = nazivR;
		this.nazivP = nazivP;
		this.datum = datum;
		this.vreme = vreme;
		this.sati = sati;
		this.sto = sto;
	}
	
	
}
