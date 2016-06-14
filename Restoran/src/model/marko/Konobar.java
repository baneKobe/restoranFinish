package model.marko;

public class Konobar {
	protected int idKonobar;
	protected String imeKonobar;
	protected String prezimeKonobar;
	protected int konfekcijskiBr;
	protected String datumRodjenja;
	protected String velicinaObuce;
	protected double prihod;
	protected String email;
	protected String password;
	protected Restoran idRestoran;
	protected int brPristupa;



	public Konobar(int idKonobar, String imeKonobar, String prezimeKonobar, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, double prihod, String email, String password, Restoran idRestoran, int brPristupa) {
		super();
		this.idKonobar = idKonobar;
		this.imeKonobar = imeKonobar;
		this.prezimeKonobar = prezimeKonobar;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.prihod = prihod;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
		this.brPristupa = brPristupa;
	}
	
	




	public Konobar(int idKonobar, String imeKonobar, String prezimeKonobar, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, double prihod, String email, String password, Restoran idRestoran) {
		super();
		this.idKonobar = idKonobar;
		this.imeKonobar = imeKonobar;
		this.prezimeKonobar = prezimeKonobar;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.prihod = prihod;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
	}






	public Konobar(String imeKonobar, String prezimeKonobar, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, String email, String password, Restoran idRestoran) {
		super();
		this.imeKonobar = imeKonobar;
		this.prezimeKonobar = prezimeKonobar;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
	}






	public Konobar(int idKonobar, String email, String password) {
		super();
		this.idKonobar = idKonobar;
		this.email = email;
		this.password = password;
	}

	public int getIdKonobar() {
		return idKonobar;
	}

	public void setIdKonobar(int idKonobar) {
		this.idKonobar = idKonobar;
	}

	public String getImeKonobar() {
		return imeKonobar;
	}

	public void setImeKonobar(String imeKonobar) {
		this.imeKonobar = imeKonobar;
	}

	public String getPrezimeKonobar() {
		return prezimeKonobar;
	}

	public void setPrezimeKonobar(String prezimeKonobar) {
		this.prezimeKonobar = prezimeKonobar;
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

	public double getPrihod() {
		return prihod;
	}

	public void setPrihod(double prihod) {
		this.prihod = prihod;
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

	public int getBrPristupa() {
		return brPristupa;
	}

	public void setBrPristupa(int brPristupa) {
		this.brPristupa = brPristupa;
	}

	@Override
	public String toString() {
		return "Konobar [idKonobar=" + idKonobar + ", imeKonobar=" + imeKonobar + ", prezimeKonobar=" + prezimeKonobar
				+ ", konfekcijskiBr=" + konfekcijskiBr + ", datumRodjenja=" + datumRodjenja + ", velicinaObuce="
				+ velicinaObuce + ", prihod=" + prihod + ", email=" + email + ", password=" + password + ", idRestoran="
				+ idRestoran + ", brPristupa=" + brPristupa + "]";
	}


	
}
