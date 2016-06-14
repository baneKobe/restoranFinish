package klaseDejan;


public class PorudzbinaJ {

	protected String nazivR;
	protected String nazivJ;
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
	public String getNazivJ() {
		return nazivJ;
	}
	public void setNazivJ(String nazivJ) {
		this.nazivJ = nazivJ;
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
		return "PorudzbinaJ [nazivR=" + nazivR + ", nazivJ=" + nazivJ + ", datum=" + datum + ", vreme=" + vreme
				+ ", sati=" + sati + ", sto=" + sto + "]";
	}
	public PorudzbinaJ(String nazivR, String nazivJ, String datum, String vreme, String sati, String sto) {
		this.nazivR = nazivR;
		this.nazivJ = nazivJ;
		this.datum = datum;
		this.vreme = vreme;
		this.sati = sati;
		this.sto = sto;
	}
	
	
	
	
}
