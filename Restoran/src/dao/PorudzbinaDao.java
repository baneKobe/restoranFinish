package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Jelo;
import model.Korisnik;
import model.Pice;
import model.Porudzbina;
import model.Restoran;
import model.Segment;
import model.Sto;
import model.Termin;
import util.ConnectionManager;

public class PorudzbinaDao {

	public Porudzbina getPorudzbinaById(int id){
		Porudzbina porudzbina = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from porudzbina where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idPorudzbine = rset.getInt(1);
				int idPice = rset.getInt(2);
				PiceDao piceDao = new PiceDao();
				Pice pice = piceDao.GetPiceById(idPice);
				int idJelo = rset.getInt(3);
				JeloDao jelDao = new JeloDao();
				Jelo jelo = jelDao.GetJeloById(idJelo);
				int kolicinaPica = rset.getInt(4);
				int kolicinaJela = rset.getInt(5);
				double cijena = rset.getDouble(6);
				int idKorisnik = rset.getInt(7);
				KorisnikDAO korDao = new KorisnikDAO();
				Korisnik korisnik = korDao.GetKorisnikById(idKorisnik);
				int idTermin = rset.getInt(8);
				TerminDao terDao = new TerminDao();
				Termin termin = terDao.GetTerminById(idTermin);
				int idSegment = rset.getInt(9);
				SegmentDao segDao = new SegmentDao();
				Segment segment = segDao.GetSegmentById(idSegment);
				int idSto = rset.getInt(10);
				StoDao stoDao = new StoDao();
				Sto sto = stoDao.GetStoById(idSto);
				int idRest = rset.getInt(11);
				RestoranDao resDao = new RestoranDao();
				Restoran restoran = resDao.GetRestoranById(idRest);
				int prihvacenoKuvar = rset.getInt(12);
				int prihvacenoSanker = rset.getInt(13);
				int gotovoKuvar = rset.getInt(14);
				int gotovoSanker = rset.getInt(15);
				int odstampano = rset.getInt(16);
				porudzbina = new Porudzbina(idPorudzbine, pice, jelo, kolicinaPica, kolicinaJela, cijena, korisnik, termin, segment, sto, restoran,prihvacenoKuvar, prihvacenoSanker, gotovoKuvar, gotovoSanker, odstampano);
			}
		}
		  catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return porudzbina;
		}
		
	public List <Porudzbina> getAllPorudzbina(){
		String query = "select * from porudzbina";
		Statement stmt;
		List <Porudzbina> retVal = null;
		try{
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Porudzbina>();
			while (rset.next()) {
				int idPorudzbine = rset.getInt(1);
				int idPice = rset.getInt(2);
				PiceDao piceDao = new PiceDao();
				Pice pice = piceDao.GetPiceById(idPice);
				int idJelo = rset.getInt(3);
				JeloDao jelDao = new JeloDao();
				Jelo jelo = jelDao.GetJeloById(idJelo);
				int kolicinaPica = rset.getInt(4);
				int kolicinaJela = rset.getInt(5);
				double cijena = rset.getDouble(6);
				int idKorisnik = rset.getInt(7);
				KorisnikDAO korDao = new KorisnikDAO();
				Korisnik korisnik = korDao.GetKorisnikById(idKorisnik);
				int idTermin = rset.getInt(8);
				TerminDao terDao = new TerminDao();
				Termin termin = terDao.GetTerminById(idTermin);
				int idSegment = rset.getInt(9);
				SegmentDao segDao = new SegmentDao();
				Segment segment = segDao.GetSegmentById(idSegment);
				int idSto = rset.getInt(10);
				StoDao stoDao = new StoDao();
				Sto sto = stoDao.GetStoById(idSto);
				int idRest = rset.getInt(11);
				RestoranDao resDao = new RestoranDao();
				Restoran restoran = resDao.GetRestoranById(idRest);
				int prihvacenoKuvar = rset.getInt(12);
				int prihvacenoSanker = rset.getInt(13);
				int gotovoKuvar = rset.getInt(14);
				int gotovoSanker = rset.getInt(15);
				int odstampano = rset.getInt(16);
				Porudzbina porudzbina = new Porudzbina(idPorudzbine, pice, jelo, kolicinaPica, kolicinaJela, cijena, korisnik, termin, segment, sto,restoran, prihvacenoKuvar, prihvacenoSanker, gotovoKuvar, gotovoSanker, odstampano);
				retVal.add(porudzbina);
			}
			rset.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	public boolean UpdatePorudzbina(Pice pice, Jelo jelo, int kolicinaPica, int kolicinaJela, double cijena, int idPorudzbine){
		boolean retVal = false;
		try{
		Connection conn = ConnectionManager.getConnection();
		String query = "update porudzbina set nazivPica=?, nazivJela=?, kolicinaPica=?, kolicinaJela=?, cena=? where idPorudzbine=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, pice.getIdPice());
		pstmt.setInt(2, jelo.getIdJelo());
		pstmt.setInt(3, kolicinaPica);
		pstmt.setInt(4, kolicinaJela);
		pstmt.setDouble(5, cijena);
		pstmt.setInt(6, idPorudzbine);
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
			System.out.println("updateMenadzerRestorana");
		}
		pstmt.close();
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	return retVal;
	}
	public boolean KuvarAccept(int idPorudzbina){
		boolean retVal = false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "update porudzbina set prihvacenoKuvar=1 where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPorudzbina);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Kuvar prihvatio ponudu");
			}
			pstmt.close();
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
		return retVal;
	}
	public boolean SankerAccept(int idPorudzbina){
		boolean retVal = false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "update porudzbina set prihvacenoSanker=1 where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPorudzbina);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Sanker prihvatio ponudu");
			}
			pstmt.close();
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
		return retVal;
	}
	public boolean KuvarGotovo(int idPorudzbina){
		boolean retVal = false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "update porudzbina set gotovoKuvar=1 where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPorudzbina);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Kuvar zavrsio porudzbinu");
			}
			pstmt.close();
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
		return retVal;
	}
	public boolean SankerGotovo(int idPorudzbina){
		boolean retVal = false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "update porudzbina set gotovoSanker=1 where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPorudzbina);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Sanker zavrsio porudzbinu");
			}
			pstmt.close();
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
		return retVal;
	}
	public boolean OdstampanRacun(int idPorudzbina){
		boolean retVal = false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "update porudzbina set odstampano=1 where idPorudzbine=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPorudzbina);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Racun je formiran");
			}
			pstmt.close();
		}
	catch (Exception ex) {
		ex.printStackTrace();
	}
		return retVal;
	}
}

