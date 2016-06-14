package klaseDejan;

public class Poseta {

	protected String nazivRestorana;
	protected String datum;
	protected String sati;
	protected String duzinaRezervacije;
	protected String korisnik;
	
	public String getNazivRestorana() {
		return nazivRestorana;
	}
	public void setNazivRestorana(String nazivRestorana) {
		this.nazivRestorana = nazivRestorana;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getSati() {
		return sati;
	}
	public void setSati(String sati) {
		this.sati = sati;
	}
	public String getDuzinaRezervacije() {
		return duzinaRezervacije;
	}
	public void setDuzinaRezervacije(String duzinaRezervacije) {
		this.duzinaRezervacije = duzinaRezervacije;
	}
	public String getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}
	@Override
	public String toString() {
		return "Poseta [nazivRestorana=" + nazivRestorana + ", datum=" + datum + ", sati=" + sati
				+ ", duzinaRezervacije=" + duzinaRezervacije + ", korisnik=" + korisnik + "]";
	}
	public Poseta(String nazivRestorana, String datum, String sati, String duzinaRezervacije, String korisnik) {
		super();
		this.nazivRestorana = nazivRestorana;
		this.datum = datum;
		this.sati = sati;
		this.duzinaRezervacije = duzinaRezervacije;
		this.korisnik = korisnik;
	}
	
	
}
