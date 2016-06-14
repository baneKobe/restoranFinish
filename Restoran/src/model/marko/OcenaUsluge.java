package model.marko;

public class OcenaUsluge {
	protected int idOcene;
	protected String utisak;
	protected String ocenaJela;
	protected String ocenaPica;
	protected String ocenaRestorana;
	protected Korisnik Korisnik; 
	protected Restoran Restoran;
	protected String ocenjeno;
	public OcenaUsluge(int idOcene, String utisak, String ocenaJela, String ocenaPica, String ocenaRestorana,
			Korisnik korisnik, Restoran restoran, String ocenjeno) {
		super();
		this.idOcene = idOcene;
		this.utisak = utisak;
		this.ocenaJela = ocenaJela;
		this.ocenaPica = ocenaPica;
		this.ocenaRestorana = ocenaRestorana;
		Korisnik = korisnik;
		Restoran = restoran;
		this.ocenjeno = ocenjeno;
	}
	public OcenaUsluge(String utisak, String ocenaJela, String ocenaPica, String ocenaRestorana,
			Korisnik korisnik, Restoran restoran, String ocenjeno) {
		super();
		this.utisak = utisak;
		this.ocenaJela = ocenaJela;
		this.ocenaPica = ocenaPica;
		this.ocenaRestorana = ocenaRestorana;
		Korisnik = korisnik;
		Restoran = restoran;
		this.ocenjeno = ocenjeno;
	}
	public int getIdOcene() {
		return idOcene;
	}
	public void setIdOcene(int idOcene) {
		this.idOcene = idOcene;
	}
	public String getUtisak() {
		return utisak;
	}
	public void setUtisak(String utisak) {
		this.utisak = utisak;
	}
	public String getOcenaJela() {
		return ocenaJela;
	}
	public void setOcenaJela(String ocenaJela) {
		this.ocenaJela = ocenaJela;
	}
	public String getOcenaPica() {
		return ocenaPica;
	}
	public void setOcenaPica(String ocenaPica) {
		this.ocenaPica = ocenaPica;
	}
	public String getOcenaRestorana() {
		return ocenaRestorana;
	}
	public void setOcenaRestorana(String ocenaRestorana) {
		this.ocenaRestorana = ocenaRestorana;
	}
	public Korisnik getKorisnik() {
		return Korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		Korisnik = korisnik;
	}
	public Restoran getRestoran() {
		return Restoran;
	}
	public void setRestoran(Restoran restoran) {
		Restoran = restoran;
	}
	public String getOcenjeno() {
		return ocenjeno;
	}
	public void setOcenjeno(String ocenjeno) {
		this.ocenjeno = ocenjeno;
	}
	@Override
	public String toString() {
		return "OcenaUsluge [idOcene=" + idOcene + ", utisak=" + utisak + ", ocenaJela=" + ocenaJela + ", ocenaPica="
				+ ocenaPica + ", ocenaRestorana=" + ocenaRestorana + ", Korisnik=" + Korisnik + ", Restoran=" + Restoran
				+ ", ocenjeno=" + ocenjeno + "]";
	}
	
		
}
