package model.marko;

public class MenadzerSistema {
protected int idMenSis;
protected String imeMenSis;
protected String prezimeMenSis;
protected String emailMenSis;
protected String jmbgMenSis;
protected String passwordMenSis;

public MenadzerSistema(int idMenSis, String imeMenSis, String prezimeMenSis, String emailMenSis, String jmbgMenSis,
		String passwordMenSis) {
	super();
	this.idMenSis = idMenSis;
	this.imeMenSis = imeMenSis;
	this.prezimeMenSis = prezimeMenSis;
	this.emailMenSis = emailMenSis;
	this.jmbgMenSis = jmbgMenSis;
	this.passwordMenSis = passwordMenSis;
}



public MenadzerSistema(int idMenSis, String emailMenSis, String passwordMenSis) {
	super();
	this.idMenSis = idMenSis;
	this.emailMenSis = emailMenSis;
	this.passwordMenSis = passwordMenSis;
}



public MenadzerSistema() {
	super();
}



public int getIdMenSis() {
	return idMenSis;
}



public void setIdMenSis(int idMenSis) {
	this.idMenSis = idMenSis;
}



public String getImeMenSis() {
	return imeMenSis;
}



public void setImeMenSis(String imeMenSis) {
	this.imeMenSis = imeMenSis;
}



public String getPrezimeMenSis() {
	return prezimeMenSis;
}



public void setPrezimeMenSis(String prezimeMenSis) {
	this.prezimeMenSis = prezimeMenSis;
}



public String getEmailMenSis() {
	return emailMenSis;
}



public void setEmailMenSis(String emailMenSis) {
	this.emailMenSis = emailMenSis;
}



public String getJmbgMenSis() {
	return jmbgMenSis;
}



public void setJmbgMenSis(String jmbgMenSis) {
	this.jmbgMenSis = jmbgMenSis;
}



public String getPasswordMenSis() {
	return passwordMenSis;
}



public void setPasswordMenSis(String passwordMenSis) {
	this.passwordMenSis = passwordMenSis;
}



@Override
public String toString() {
	return "MenadzerSistema [idMenSis=" + idMenSis + ", imeMenSis=" + imeMenSis + ", prezimeMenSis=" + prezimeMenSis
			+ ", emailMenSis=" + emailMenSis + ", jmbgMenSis=" + jmbgMenSis + ", passwordMenSis=" + passwordMenSis
			+ "]";
}


}
