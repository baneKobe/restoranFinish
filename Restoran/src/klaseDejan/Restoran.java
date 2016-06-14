package klaseDejan;

import java.sql.Time;
import java.util.Date;

public class Restoran {

	protected int idRestorana;
	protected String nazivRest;
	protected String vrstaRest;
	protected int jelovnik;
	protected int kartaPica;
	protected Date datum;
	protected Time sati;
	protected int duzinaRezervacije;
	protected int ocenaRestorana;
	protected int ocenaJela;
	protected int ocenaPica;
	protected int ocenjeno;

	public int getOcenaJela() {
		return ocenaJela;
	}
	public void setOcenaJela(int ocenaJela) {
		this.ocenaJela = ocenaJela;
	}
	public int getOcenaPica() {
		return ocenaPica;
	}
	public void setOcenaPica(int ocenaPica) {
		this.ocenaPica = ocenaPica;
	}
	public int getOcenjeno() {
		return ocenjeno;
	}
	public void setOcenjeno(int ocenjeno) {
		this.ocenjeno = ocenjeno;
	}
	public Restoran(int ocenaJela, int ocenaPica, int ocenaRestorana) {
		super();
		this.ocenaJela = ocenaJela;
		this.ocenaPica = ocenaPica;
		this.ocenaRestorana = ocenaRestorana;
	}
	public int getOcenaRestorana() {
		return ocenaRestorana;
	}
	public void setOcenaRestorana(int ocenaRestorana) {
		this.ocenaRestorana = ocenaRestorana;
	}
	public int getDuzinaRezervacije() {
		return duzinaRezervacije;
	}
	public void setDuzinaRezervacije(int duzinaRezervacije) {
		this.duzinaRezervacije = duzinaRezervacije;
	}
	public Time getSati() {
		return sati;
	}
	public void setSati(Time sati) {
		this.sati = sati;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getIdRestorana() {
		return idRestorana;
	}
	public void setIdRestorana(int idRestorana) {
		this.idRestorana = idRestorana;
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
	public int getJelovnik() {
		return jelovnik;
	}
	public void setJelovnik(int jelovnik) {
		this.jelovnik = jelovnik;
	}
	public int getKartaPica() {
		return kartaPica;
	}
	public void setKartaPica(int kartaPica) {
		this.kartaPica = kartaPica;
	}
	@Override
	public String toString() {
		return "Restoran [idRestorana=" + idRestorana + ", nazivRest=" + nazivRest + ", vrstaRest=" + vrstaRest
				+ ", jelovnik=" + jelovnik + ", kartaPica=" + kartaPica + "]";
	}
	public Restoran(int idRestorana, String nazivRest, String vrstaRest, int jelovnik, int kartaPica) {
		super();
		this.idRestorana = idRestorana;
		this.nazivRest = nazivRest;
		this.vrstaRest = vrstaRest;
		this.jelovnik = jelovnik;
		this.kartaPica = kartaPica;
	}
	
	public Restoran(int idRestorana, String nazivRest, Date datum, Time sati, int duzinaRezervacije) {
		super();
		this.idRestorana = idRestorana;
		this.nazivRest = nazivRest;
		this.datum = datum;
		this.sati=sati;
		this.duzinaRezervacije=duzinaRezervacije;
	}
	public Restoran(int idRestorana, int ocenjeno) {
		super();
		this.idRestorana = idRestorana;
		this.ocenjeno = ocenjeno;
	}
	
	
}
