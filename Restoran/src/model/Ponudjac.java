package model;


public class Ponudjac {

	protected int id;
	protected String username;
	protected String password;
	protected String ime;
	protected String prezime;
	protected String nazivKompanije;
	protected String email;
	protected String adresa;
	protected String brojTelefona;
	public Ponudjac(int id, String ime, String prezime, String nazivKompanije, String email, String adresa,
			String brojTelefona, String password) {
		super();
		this.id=id;
		this.ime=ime;
		this.prezime=prezime;
		this.nazivKompanije=nazivKompanije;
		this.email=email;
		this.adresa=adresa;
		this.brojTelefona=brojTelefona;
		this.password=password;
	}
	public Ponudjac(String imePonudjaca, String prezimePonudjaca, String nazivKompanije2, String email2, String adresa2,
			String brojTelefona2, String username2, String loznika) {
		
		super();
		this.ime=imePonudjaca;
		this.prezime=prezimePonudjaca;
		this.nazivKompanije=nazivKompanije2;
		this.email=email2;
		this.adresa=adresa2;
		this.brojTelefona=brojTelefona2;
		this.username=username2;
		this.password=loznika;
	}
	

	public Ponudjac(String password, String ime, String prezime, String nazivKompanije, String email, String adresa,
			String brojTelefona) {
		super();
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.nazivKompanije = nazivKompanije;
		this.email = email;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
	}
	public Ponudjac(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "Ponudjac [id=" + id + ", username=" + username + ", password=" + password + ", ime=" + ime
				+ ", prezime=" + prezime + ", nazivKompanije=" + nazivKompanije + ", email=" + email + ", adresa="
				+ adresa + ", brojTelefona=" + brojTelefona + "]";
	}
	
	
	
}