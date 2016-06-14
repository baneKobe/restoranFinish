package model;

public class KartaPica {
	protected int idKarte;
	protected String naziv;
	protected Pice pice;
	protected String nazivPice;
	protected String opisPice;
	protected String cena;
	protected int idPice;
	protected String cijenaPice;
	
	public int getIdPice() {
		return idPice;
	}

	public void setIdPice(int idPice) {
		this.idPice = idPice;
	}

	public String getCijenaPice() {
		return cijenaPice;
	}

	public void setCijenaPice(String cijenaPice) {
		this.cijenaPice = cijenaPice;
	}

	public String getNazivPice() {
		return nazivPice;
	}

	public void setNazivPice(String nazivPice) {
		this.nazivPice = nazivPice;
	}

	public String getOpisPice() {
		return opisPice;
	}

	public void setOpisPice(String opisPice) {
		this.opisPice = opisPice;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public KartaPica(int idKarte, Pice pice) {
		super();
		this.idKarte = idKarte;
		this.pice = pice;
	}
	
	public KartaPica(int idKarte, String naziv, Pice pice) {
		super();
		this.idKarte = idKarte;
		this.naziv = naziv;
		this.pice = pice;
	}



	public KartaPica(int idKarte, String naziv) {
		super();
		this.idKarte = idKarte;
		this.naziv = naziv;
	}

	

	public KartaPica(String nazivPice) {
		super();
		this.nazivPice = nazivPice;
	}

	

	public KartaPica(int idKarte) {
		super();
		this.idKarte = idKarte;
	}

	public KartaPica(int idPice, String nazivPice, String opisPice, String cijenaPice, String nazivKarta) {
		super();
		this.idPice = idPice;
		this.nazivPice = nazivPice;
		this.opisPice = opisPice;
		this.cijenaPice = cijenaPice;
		this.naziv = nazivKarta;
	}

	public int getIdKarte() {
		return idKarte;
	}
	public void setIdKarte(int idKarte) {
		this.idKarte = idKarte;
	}
	public Pice getPice() {
		return pice;
	}
	public void setPice(Pice pice) {
		this.pice = pice;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "KartaPica [idKarte=" + idKarte + ", naziv=" + naziv + ", pice=" + pice + "]";
	}
	
}
