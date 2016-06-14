package model.marko;

public class Korisnik {

	protected String username;
	protected String lozinka;
	protected String prezime;
	protected String email;
	protected int idKor;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdKor() {
		return idKor;
	}
	public void setIdKor(int idKor) {
		this.idKor = idKor;
	}
	
	@Override
	public String toString() {
		return "Korisnik [username=" + username + ", lozinka=" + lozinka + ", prezime=" + prezime
				+ ", email=" + email + ", idKor=" + idKor + "]";
	}
	
	public Korisnik(String username, String lozinka, String prezime, String email) {
		super();
		this.username = username;
		this.lozinka = lozinka;
		this.prezime = prezime;
		this.email = email;
	}
	
	public Korisnik(String email, String lozinka, int idKor) {
		super();
		this.email = email;
		this.lozinka = lozinka;
		this.idKor = idKor;
	}
	public Korisnik(String username, String lozinka, String prezime, String email, int idKor) {
		super();
		this.username = username;
		this.lozinka = lozinka;
		this.prezime = prezime;
		this.email = email;
		this.idKor = idKor;
	}
	
	
}