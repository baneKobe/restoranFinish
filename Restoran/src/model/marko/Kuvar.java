package model.marko;

public class Kuvar {

	protected int idKuvar;
	protected String imeKuvar;
	protected String prezimeKuvar;
	protected int konfekcijskiBr;
	protected String datumRodjenja;
	protected String velicinaObuce;
	protected String email;
	protected String password;
	protected Restoran idRestoran;
	protected int pristup;
	
	



	public Kuvar(int idKuvar, String imeKuvar, String prezimeKuvar, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, String email, String password, Restoran idRestoran, int pristup) {
		super();
		this.idKuvar = idKuvar;
		this.imeKuvar = imeKuvar;
		this.prezimeKuvar = prezimeKuvar;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
		this.pristup = pristup;
	}


	public Kuvar(int idKuvar, String email, String password) {
		super();
		this.idKuvar = idKuvar;
		this.email = email;
		this.password = password;
	}


	


	public Kuvar(String imeKuvar, String prezimeKuvar, int konfekcijskiBr, String datumRodjenja, String velicinaObuce,
			String email, String password, Restoran idRestoran) {
		super();
		this.imeKuvar = imeKuvar;
		this.prezimeKuvar = prezimeKuvar;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
	}


	public int getIdKuvar() {
		return idKuvar;
	}


	public void setIdKuvar(int idKuvar) {
		this.idKuvar = idKuvar;
	}


	public String getImeKuvar() {
		return imeKuvar;
	}


	public void setImeKuvar(String imeKuvar) {
		this.imeKuvar = imeKuvar;
	}


	public String getPrezimeKuvar() {
		return prezimeKuvar;
	}


	public void setPrezimeKuvar(String prezimeKuvar) {
		this.prezimeKuvar = prezimeKuvar;
	}


	public int getKonfekcijskiBr() {
		return konfekcijskiBr;
	}


	public void setKonfekcijskiBr(int konfekcijskiBr) {
		this.konfekcijskiBr = konfekcijskiBr;
	}


	public String getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}


	public String getVelicinaObuce() {
		return velicinaObuce;
	}


	public void setVelicinaObuce(String velicinaObuce) {
		this.velicinaObuce = velicinaObuce;
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


	public Restoran getIdRestoran() {
		return idRestoran;
	}


	public void setIdRestoran(Restoran idRestoran) {
		this.idRestoran = idRestoran;
	}


	public int getPristup() {
		return pristup;
	}


	public void setPristup(int pristup) {
		this.pristup = pristup;
	}


	@Override
	public String toString() {
		return "Kuvar [idKuvar=" + idKuvar + ", imeKuvar=" + imeKuvar + ", prezimeKuvar=" + prezimeKuvar
				+ ", konfekcijskiBr=" + konfekcijskiBr + ", datumRodjenja=" + datumRodjenja + ", velicinaObuce="
				+ velicinaObuce + ", email=" + email + ", password=" + password + ", idRestoran=" + idRestoran
				+ ", pristup=" + pristup + "]";
	}

	

	
	
	
}
