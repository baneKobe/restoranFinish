package model;

public class MenadzerRestorana {
	protected int idMenRes;
	protected String imeMenRes;
	protected String prezimeMenRes;
	protected String email;
	protected String jmbg;
	protected String password;
	protected Restoran restoran;
	
	
	
	public MenadzerRestorana(String imeMenRes, String prezimeMenRes, String email, String jmbg, String password,
			Restoran restoran) {
		super();
		this.imeMenRes = imeMenRes;
		this.prezimeMenRes = prezimeMenRes;
		this.email = email;
		this.jmbg = jmbg;
		this.password = password;
		this.restoran = restoran;
	}

	public MenadzerRestorana(int idMenRes, String imeMenRes, String prezimeMenRes, String email, String jmbg,
			String password, Restoran restoran) {
		super();
		this.idMenRes = idMenRes;
		this.imeMenRes = imeMenRes;
		this.prezimeMenRes = prezimeMenRes;
		this.email = email;
		this.jmbg = jmbg;
		this.password = password;
		this.restoran = restoran;
	}

	public MenadzerRestorana(int idMenRes, String imeMenRes, String prezimeMenRes, String email, String jmbg,
			String password) {
		super();
		this.idMenRes = idMenRes;
		this.imeMenRes = imeMenRes;
		this.prezimeMenRes = prezimeMenRes;
		this.email = email;
		this.jmbg = jmbg;
		this.password = password;
	}

	public MenadzerRestorana(int idMenRes, String email, String password) {
		super();
		this.idMenRes = idMenRes;
		this.email = email;
		this.password = password;
	}
	
	

	public MenadzerRestorana(String imeMenRes, String prezimeMenRes, String email, String jmbg, String password) {
		super();
		this.imeMenRes = imeMenRes;
		this.prezimeMenRes = prezimeMenRes;
		this.email = email;
		this.jmbg = jmbg;
		this.password = password;
	}

	public int getIdMenRes() {
		return idMenRes;
	}

	public void setIdMenRes(int idMenRes) {
		this.idMenRes = idMenRes;
	}

	public String getImeMenRes() {
		return imeMenRes;
	}

	public void setImeMenRes(String imeMenRes) {
		this.imeMenRes = imeMenRes;
	}

	public String getPrezimeMenRes() {
		return prezimeMenRes;
	}

	public void setPrezimeMenRes(String prezimeMenRes) {
		this.prezimeMenRes = prezimeMenRes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	@Override
	public String toString() {
		return "MenadzerRestorana [idMenRes=" + idMenRes + ", imeMenRes=" + imeMenRes + ", prezimeMenRes="
				+ prezimeMenRes + ", email=" + email + ", jmbg=" + jmbg + ", password=" + password + ", restoran="
				+ restoran + "]";
	}

	
	
	
}
