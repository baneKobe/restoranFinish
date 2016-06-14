package model.marko;

public class Jelo {
	protected int idJelo;
	protected String naziv;
	protected String opis;
	protected double cijena;
	protected Jelovnik idJelovnik;

	public Jelo(int idJelo, String naziv, String opis, double cijena, Jelovnik idJelovnik) {
		super();
		this.idJelo = idJelo;
		this.naziv = naziv;
		this.opis = opis;
		this.cijena = cijena;
		this.idJelovnik = idJelovnik;
	}

	

	public Jelo(String naziv, String opis, double cijena, Jelovnik idJelovnik) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cijena = cijena;
		this.idJelovnik = idJelovnik;
	}





	



	public Jelo(int idjelo, String naziv, String opis, double cijena, int idJelovnik) {
		// TODO Auto-generated constructor stub
	}



	public int getIdJelo() {
		return idJelo;
	}

	public void setIdJelo(int idJelo) {
		this.idJelo = idJelo;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public Jelovnik getIdJelovnik() {
		return idJelovnik;
	}

	public void setIdJelovnik(Jelovnik idJelovnik) {
		this.idJelovnik = idJelovnik;
	}

	@Override
	public String toString() {
		return "Jelo [idJelo=" + idJelo + ", naziv=" + naziv + ", opis=" + opis + ", cijena=" + cijena + ", idJelovnik="
				+ idJelovnik + "]";
	}

	
	
}
