package model;

public class RasporedRada {
protected int idRasporedRada;
protected String ponPoc;
protected String ponKraj;
protected String ponSmjena;
protected String utoPoc;
protected String utoKraj;
protected String utoSmjena;
protected String srePoc;
protected String sreKraj;
protected String sreSmjena;
protected String cetPoc;
protected String cetKraj;
protected String cetSmjena;
protected String petPoc;
protected String petKraj;
protected String petSmjena;
protected String subPoc;
protected String subKraj;
protected String subSmjena;
protected String nedPoc;
protected String nedKraj;
protected String nedSmjena;
protected Konobar konobar;
protected Kuvar kuvar;
protected Sanker sanker;
public RasporedRada(int idRasporedRada, String ponPoc, String ponKraj, String ponSmjena, String utoPoc, String utoKraj,
		String utoSmjena, String srePoc, String sreKraj, String sreSmjena, String cetPoc, String cetKraj,
		String cetSmjena, String petPoc, String petKraj, String petSmjena, String subPoc, String subKraj,
		String subSmjena, String nedPoc, String nedKraj, String nedSmjena, Konobar konobar, Kuvar kuvar,
		Sanker sanker) {
	super();
	this.idRasporedRada = idRasporedRada;
	this.ponPoc = ponPoc;
	this.ponKraj = ponKraj;
	this.ponSmjena = ponSmjena;
	this.utoPoc = utoPoc;
	this.utoKraj = utoKraj;
	this.utoSmjena = utoSmjena;
	this.srePoc = srePoc;
	this.sreKraj = sreKraj;
	this.sreSmjena = sreSmjena;
	this.cetPoc = cetPoc;
	this.cetKraj = cetKraj;
	this.cetSmjena = cetSmjena;
	this.petPoc = petPoc;
	this.petKraj = petKraj;
	this.petSmjena = petSmjena;
	this.subPoc = subPoc;
	this.subKraj = subKraj;
	this.subSmjena = subSmjena;
	this.nedPoc = nedPoc;
	this.nedKraj = nedKraj;
	this.nedSmjena = nedSmjena;
	this.konobar = konobar;
	this.kuvar = kuvar;
	this.sanker = sanker;
}
public RasporedRada(int idRasporedRada, String ponPoc, String ponKraj, String ponSmjena, String utoPoc, String utoKraj,
		String utoSmjena, String srePoc, String sreKraj, String sreSmjena, String cetPoc, String cetKraj,
		String cetSmjena, String petPoc, String petKraj, String petSmjena, String subPoc, String subKraj,
		String subSmjena, String nedPoc, String nedKraj, String nedSmjena, Konobar konobar) {
	super();
	this.idRasporedRada = idRasporedRada;
	this.ponPoc = ponPoc;
	this.ponKraj = ponKraj;
	this.ponSmjena = ponSmjena;
	this.utoPoc = utoPoc;
	this.utoKraj = utoKraj;
	this.utoSmjena = utoSmjena;
	this.srePoc = srePoc;
	this.sreKraj = sreKraj;
	this.sreSmjena = sreSmjena;
	this.cetPoc = cetPoc;
	this.cetKraj = cetKraj;
	this.cetSmjena = cetSmjena;
	this.petPoc = petPoc;
	this.petKraj = petKraj;
	this.petSmjena = petSmjena;
	this.subPoc = subPoc;
	this.subKraj = subKraj;
	this.subSmjena = subSmjena;
	this.nedPoc = nedPoc;
	this.nedKraj = nedKraj;
	this.nedSmjena = nedSmjena;
	this.konobar = konobar;
}
public RasporedRada(int idRasporedRada, String ponPoc, String ponKraj, String ponSmjena, String utoPoc, String utoKraj,
		String utoSmjena, String srePoc, String sreKraj, String sreSmjena, String cetPoc, String cetKraj,
		String cetSmjena, String petPoc, String petKraj, String petSmjena, String subPoc, String subKraj,
		String subSmjena, String nedPoc, String nedKraj, String nedSmjena, Kuvar kuvar) {
	super();
	this.idRasporedRada = idRasporedRada;
	this.ponPoc = ponPoc;
	this.ponKraj = ponKraj;
	this.ponSmjena = ponSmjena;
	this.utoPoc = utoPoc;
	this.utoKraj = utoKraj;
	this.utoSmjena = utoSmjena;
	this.srePoc = srePoc;
	this.sreKraj = sreKraj;
	this.sreSmjena = sreSmjena;
	this.cetPoc = cetPoc;
	this.cetKraj = cetKraj;
	this.cetSmjena = cetSmjena;
	this.petPoc = petPoc;
	this.petKraj = petKraj;
	this.petSmjena = petSmjena;
	this.subPoc = subPoc;
	this.subKraj = subKraj;
	this.subSmjena = subSmjena;
	this.nedPoc = nedPoc;
	this.nedKraj = nedKraj;
	this.nedSmjena = nedSmjena;
	this.kuvar = kuvar;
}
public RasporedRada(int idRasporedRada, String ponPoc, String ponKraj, String ponSmjena, String utoPoc, String utoKraj,
		String utoSmjena, String srePoc, String sreKraj, String sreSmjena, String cetPoc, String cetKraj,
		String cetSmjena, String petPoc, String petKraj, String petSmjena, String subPoc, String subKraj,
		String subSmjena, String nedPoc, String nedKraj, String nedSmjena, Sanker sanker) {
	super();
	this.idRasporedRada = idRasporedRada;
	this.ponPoc = ponPoc;
	this.ponKraj = ponKraj;
	this.ponSmjena = ponSmjena;
	this.utoPoc = utoPoc;
	this.utoKraj = utoKraj;
	this.utoSmjena = utoSmjena;
	this.srePoc = srePoc;
	this.sreKraj = sreKraj;
	this.sreSmjena = sreSmjena;
	this.cetPoc = cetPoc;
	this.cetKraj = cetKraj;
	this.cetSmjena = cetSmjena;
	this.petPoc = petPoc;
	this.petKraj = petKraj;
	this.petSmjena = petSmjena;
	this.subPoc = subPoc;
	this.subKraj = subKraj;
	this.subSmjena = subSmjena;
	this.nedPoc = nedPoc;
	this.nedKraj = nedKraj;
	this.nedSmjena = nedSmjena;
	this.sanker = sanker;
}
public int getIdRasporedRada() {
	return idRasporedRada;
}
public void setIdRasporedRada(int idRasporedRada) {
	this.idRasporedRada = idRasporedRada;
}
public String getPonPoc() {
	return ponPoc;
}
public void setPonPoc(String ponPoc) {
	this.ponPoc = ponPoc;
}
public String getPonKraj() {
	return ponKraj;
}
public void setPonKraj(String ponKraj) {
	this.ponKraj = ponKraj;
}
public String getPonSmjena() {
	return ponSmjena;
}
public void setPonSmjena(String ponSmjena) {
	this.ponSmjena = ponSmjena;
}
public String getUtoPoc() {
	return utoPoc;
}
public void setUtoPoc(String utoPoc) {
	this.utoPoc = utoPoc;
}
public String getUtoKraj() {
	return utoKraj;
}
public void setUtoKraj(String utoKraj) {
	this.utoKraj = utoKraj;
}
public String getUtoSmjena() {
	return utoSmjena;
}
public void setUtoSmjena(String utoSmjena) {
	this.utoSmjena = utoSmjena;
}
public String getSrePoc() {
	return srePoc;
}
public void setSrePoc(String srePoc) {
	this.srePoc = srePoc;
}
public String getSreKraj() {
	return sreKraj;
}
public void setSreKraj(String sreKraj) {
	this.sreKraj = sreKraj;
}
public String getSreSmjena() {
	return sreSmjena;
}
public void setSreSmjena(String sreSmjena) {
	this.sreSmjena = sreSmjena;
}
public String getCetPoc() {
	return cetPoc;
}
public void setCetPoc(String cetPoc) {
	this.cetPoc = cetPoc;
}
public String getCetKraj() {
	return cetKraj;
}
public void setCetKraj(String cetKraj) {
	this.cetKraj = cetKraj;
}
public String getCetSmjena() {
	return cetSmjena;
}
public void setCetSmjena(String cetSmjena) {
	this.cetSmjena = cetSmjena;
}
public String getPetPoc() {
	return petPoc;
}
public void setPetPoc(String petPoc) {
	this.petPoc = petPoc;
}
public String getPetKraj() {
	return petKraj;
}
public void setPetKraj(String petKraj) {
	this.petKraj = petKraj;
}
public String getPetSmjena() {
	return petSmjena;
}
public void setPetSmjena(String petSmjena) {
	this.petSmjena = petSmjena;
}
public String getSubPoc() {
	return subPoc;
}
public void setSubPoc(String subPoc) {
	this.subPoc = subPoc;
}
public String getSubKraj() {
	return subKraj;
}
public void setSubKraj(String subKraj) {
	this.subKraj = subKraj;
}
public String getSubSmjena() {
	return subSmjena;
}
public void setSubSmjena(String subSmjena) {
	this.subSmjena = subSmjena;
}
public String getNedPoc() {
	return nedPoc;
}
public void setNedPoc(String nedPoc) {
	this.nedPoc = nedPoc;
}
public String getNedKraj() {
	return nedKraj;
}
public void setNedKraj(String nedKraj) {
	this.nedKraj = nedKraj;
}
public String getNedSmjena() {
	return nedSmjena;
}
public void setNedSmjena(String nedSmjena) {
	this.nedSmjena = nedSmjena;
}
public Konobar getKonobar() {
	return konobar;
}
public void setKonobar(Konobar konobar) {
	this.konobar = konobar;
}
public Kuvar getKuvar() {
	return kuvar;
}
public void setKuvar(Kuvar kuvar) {
	this.kuvar = kuvar;
}
public Sanker getSanker() {
	return sanker;
}
public void setSanker(Sanker sanker) {
	this.sanker = sanker;
}
@Override
public String toString() {
	return "RasporedRada [idRasporedRada=" + idRasporedRada + ", ponPoc=" + ponPoc + ", ponKraj=" + ponKraj
			+ ", ponSmjena=" + ponSmjena + ", utoPoc=" + utoPoc + ", utoKraj=" + utoKraj + ", utoSmjena=" + utoSmjena
			+ ", srePoc=" + srePoc + ", sreKraj=" + sreKraj + ", sreSmjena=" + sreSmjena + ", cetPoc=" + cetPoc
			+ ", cetKraj=" + cetKraj + ", cetSmjena=" + cetSmjena + ", petPoc=" + petPoc + ", petKraj=" + petKraj
			+ ", petSmjena=" + petSmjena + ", subPoc=" + subPoc + ", subKraj=" + subKraj + ", subSmjena=" + subSmjena
			+ ", nedPoc=" + nedPoc + ", nedKraj=" + nedKraj + ", nedSmjena=" + nedSmjena + ", konobar=" + konobar
			+ ", kuvar=" + kuvar + ", sanker=" + sanker + "]";
}

}
