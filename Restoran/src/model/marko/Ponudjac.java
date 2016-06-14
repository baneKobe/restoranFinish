package model.marko;


public class Ponudjac {

	protected int id;
	protected String ime;
	protected String prezime;
	protected String nazivKompanije;
	protected String email;
	protected String password;
	protected String adresa;
	protected String brojTelefona;
	
	public Ponudjac(int id, String ime, String prezime, String nazivKompanije, String email, String password,
			String adresa, String brojTelefona) {
		super();
		this.id=id;
		this.ime=ime;
		this.prezime=prezime;
		this.nazivKompanije=nazivKompanije;
		this.email=email;
		this.password=password;
		this.adresa=adresa;
		this.brojTelefona=brojTelefona;
	}


	public Ponudjac(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	


	public Ponudjac(String ime, String prezime, String nazivKompanije, String email, String password, String adresa,
			String brojTelefona) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.nazivKompanije = nazivKompanije;
		this.email = email;
		this.password = password;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getNazivKompanije() {
		return nazivKompanije;
	}
	public void setNazivKompanije(String nazivKompanije) {
		this.nazivKompanije = nazivKompanije;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	@Override
	public String toString() {
		return "Ponudjac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", nazivKompanije=" + nazivKompanije
				+ ", email=" + email + ", password=" + password + ", adresa=" + adresa + ", brojTelefona="
				+ brojTelefona + "]";
	}
	
	
	
	
}