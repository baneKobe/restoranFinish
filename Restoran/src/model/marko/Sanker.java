package model.marko;

public class Sanker {
	protected int idKSanker;
	protected String imeSanker;
	protected String prezimeSanker;
	protected int konfekcijskiBr;
	protected String datumRodjenja;
	protected String velicinaObuce;
	protected String email;
	protected String password;
	protected Restoran idRestoran;
	protected int pristup;

	

	public Sanker(int idKSanker, String imeSanker, String prezimeSanker, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, String email, String password, Restoran idRestoran, int pristup) {
		super();
		this.idKSanker = idKSanker;
		this.imeSanker = imeSanker;
		this.prezimeSanker = prezimeSanker;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
		this.pristup = pristup;
	}

	public Sanker(int idKSanker, String email, String password) {
		super();
		this.idKSanker = idKSanker;
		this.email = email;
		this.password = password;
	}

	

	public Sanker(String imeSanker, String prezimeSanker, int konfekcijskiBr, String datumRodjenja,
			String velicinaObuce, String email, String password, Restoran idRestoran) {
		super();
		this.imeSanker = imeSanker;
		this.prezimeSanker = prezimeSanker;
		this.konfekcijskiBr = konfekcijskiBr;
		this.datumRodjenja = datumRodjenja;
		this.velicinaObuce = velicinaObuce;
		this.email = email;
		this.password = password;
		this.idRestoran = idRestoran;
	}

	public int getIdKSanker() {
		return idKSanker;
	}

	public void setIdKSanker(int idKSanker) {
		this.idKSanker = idKSanker;
	}

	public String getImeSanker() {
		return imeSanker;
	}

	public void setImeSanker(String imeSanker) {
		this.imeSanker = imeSanker;
	}

	public String getPrezimeSanker() {
		return prezimeSanker;
	}

	public void setPrezimeSanker(String prezimeSanker) {
		this.prezimeSanker = prezimeSanker;
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
		return "Sanker [idKSanker=" + idKSanker + ", imeSanker=" + imeSanker + ", prezimeSanker=" + prezimeSanker
				+ ", konfekcijskiBr=" + konfekcijskiBr + ", datumRodjenja=" + datumRodjenja + ", velicinaObuce="
				+ velicinaObuce + ", email=" + email + ", password=" + password + ", idRestoran=" + idRestoran
				+ ", pristup=" + pristup + "]";
	}

	

	
	
	
}
