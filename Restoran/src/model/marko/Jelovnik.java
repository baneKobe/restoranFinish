package model.marko;

public class Jelovnik {

	protected int idJelovnik;
	protected String nazivJelovnika;
	protected Jelo jelo;
	protected String nazivJela;
	protected String opisJela;
	protected String cena;
	protected int idjelo;
	protected String cenaJela;
	
	


	public int getIdjelo() {
		return idjelo;
	}


	public void setIdjelo(int idjelo) {
		this.idjelo = idjelo;
	}


	public String getCenaJela() {
		return cenaJela;
	}


	public void setCenaJela(String cenaJela) {
		this.cenaJela = cenaJela;
	}


	public Jelovnik(int idJelovnik, Jelo jelo) {
		super();
		this.idJelovnik = idJelovnik;
		this.jelo = jelo;
	}
	
	
	public Jelovnik(int idJelovnik, String naziv, Jelo jelo) {
		super();
		this.idJelovnik = idJelovnik;
		this.nazivJelovnika = naziv;
		this.jelo = jelo;
	}


	


	public Jelovnik(int idJelovnik, String naziv) {
		super();
		this.idJelovnik = idJelovnik;
		this.nazivJelovnika = naziv;
	}


	


	public Jelovnik(String naziv) {
		super();
		this.nazivJelovnika = naziv;
	}




	public Jelovnik(int idjelo, String nazivJela, String opisJela, String cenaJela, String nazivJelovnika) {
		super();
		this.idjelo = idjelo;
		this.nazivJela = nazivJela;
		this.opisJela = opisJela;
		this.cenaJela = cenaJela;
		this.nazivJelovnika = nazivJelovnika;
	}


	public int getIdJelovnik() {
		return idJelovnik;
	}
	public void setIdJelovnik(int idJelovnik) {
		this.idJelovnik = idJelovnik;
	}
	public Jelo getJelo() {
		return jelo;
	}
	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}


	public String getNaziv() {
		return nazivJelovnika;
	}


	public void setNaziv(String naziv) {
		this.nazivJelovnika = naziv;
	}


	


	public String getNazivJelovnika() {
		return nazivJelovnika;
	}


	public void setNazivJelovnika(String nazivJelovnika) {
		this.nazivJelovnika = nazivJelovnika;
	}




	public String getNazivJela() {
		return nazivJela;
	}


	public void setNazivJela(String nazivJela) {
		this.nazivJela = nazivJela;
	}


	public String getOpisJela() {
		return opisJela;
	}


	public void setOpisJela(String opisJela) {
		this.opisJela = opisJela;
	}


	public String getCena() {
		return cena;
	}


	public void setCena(String cena) {
		this.cena = cena;
	}


	@Override
	public String toString() {
		return "Jelovnik [idJelovnik=" + idJelovnik + ", naziv=" + nazivJelovnika + ", jelo=" + jelo + "]";
	}

	
	
	
}
