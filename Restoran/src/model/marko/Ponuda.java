package model.marko;

public class Ponuda {
	protected int idPonuda;
	protected String naziv;
	protected String kolicina;
	protected Ponudjac ponudjac;
	protected String cena;
	
	public Ponuda(int idPonuda, String naziv, String kolicina, Ponudjac ponudjac) {
		super();
		this.idPonuda = idPonuda;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.ponudjac = ponudjac;
	}


	public Ponuda(String naziv, String kolicina) {
		super();
		this.naziv = naziv;
		this.kolicina = kolicina;
	}







	

	public Ponuda(int idPonuda, String cena) {
		super();
		this.idPonuda = idPonuda;
		this.cena = cena;
	}


	public Ponuda(int idPonuda, String naziv, String kolicina) {
		super();
		this.idPonuda = idPonuda;
		this.naziv = naziv;
		this.kolicina = kolicina;
	}


	


	public Ponuda(String cena) {
		this.cena=cena;
	}


	public Ponuda(int id, String naziv, String kolicina, String cena) {
		super();
		this.idPonuda = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.cena = cena;
	}


	public int getIdPonuda() {
		return idPonuda;
	}

	public void setIdPonuda(int idPonuda) {
		this.idPonuda = idPonuda;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	

	public String getCena() {
		return cena;
	}


	public void setCena(String cena) {
		this.cena = cena;
	}


	public Ponudjac getPonudjac() {
		return ponudjac;
	}


	public void setPonudjac(Ponudjac ponudjac) {
		this.ponudjac = ponudjac;
	}


	@Override
	public String toString() {
		return "Ponuda [idPonuda=" + idPonuda + ", naziv=" + naziv + ", kolicina=" + kolicina + ", ponudjac=" + ponudjac
				+ "]";
	}
	
	
}
