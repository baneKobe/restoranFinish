package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.Korisnik;
import model.marko.OcenaUsluge;
import model.marko.Restoran;
import util.ConnectionManager;

public class OcenaUslugeDao {
	public OcenaUsluge getOcenaUslugeByID(int id) {
		OcenaUsluge usluge = null;
	    try{
	     Connection conn = ConnectionManager.getConnection();
	     String query = "select * from ocenausluge where idOcene=?";
	     PreparedStatement pstmt = conn.prepareStatement(query);
	     pstmt.setInt(1, id);
	     ResultSet rset = pstmt.executeQuery();
	     if(rset.next()){
	      int idOcene = rset.getInt(1);
	      String utisak = rset.getString(2);
	      String ocenaJela = rset.getString(3);
	      String ocenaPica = rset.getString(4);
	      String ocenaRestorana = rset.getString(5);
	      int Korisnik = rset.getInt(6);
	      KorisnikDAO korisnikDao = new KorisnikDAO();
	      Korisnik korisnik = korisnikDao.GetKorisnikById(Korisnik);
	      int idRest = rset.getInt(7);
	      RestoranDao resDao = new RestoranDao();
	      Restoran restoran = resDao.GetRestoranById(idRest);
	      String ocenjeno = rset.getString(8);
	      
	      usluge = new OcenaUsluge(idOcene, utisak, ocenaJela, ocenaPica, ocenaRestorana, korisnik, restoran,ocenjeno);
	      
	     }
	    }
	    catch (SQLException e) {
	    
	     e.printStackTrace();
	     
	    }
	    return usluge;
	   }
	public double getProsekJelo(){
		double ocena = 0;
		try{
		Connection conn = ConnectionManager.getConnection();
	    String query = "select AVG(ocenaJela) from ocenausluge";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    
	    ResultSet rset = pstmt.executeQuery();
	    if(rset.next()){
	    	String ocenaJela = rset.getString(1);
	    	ocena = Double.parseDouble(ocenaJela);
	    	
	    }
		}
	    catch (SQLException e) {
		     e.printStackTrace();
		    }
	    return ocena;
	}
	public double getProsekPice(){
		double ocena = 0;
		try{
		Connection conn = ConnectionManager.getConnection();
	    String query = "select AVG(ocenaPica) from ocenausluge";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	   
	    ResultSet rset = pstmt.executeQuery();
	    if(rset.next()){
	    	String ocenaJela = rset.getString(1);
	    	ocena = Double.parseDouble(ocenaJela);
	    	
	    }
		}
	    catch (SQLException e) {
		     e.printStackTrace();
		    }
	    return ocena;
	}
	public double getProsekRestoran(){
		double ocena = 0;
		try{
		Connection conn = ConnectionManager.getConnection();
	    String query = "select AVG(ocenaRestorana) from ocenausluge";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    
	    ResultSet rset = pstmt.executeQuery();
	    if(rset.next()){
	    	String ocenaJela = rset.getString(1);
	    	ocena = Double.parseDouble(ocenaJela);
	    	
	    }
		}
	    catch (SQLException e) {
		     e.printStackTrace();
		    }
	    return ocena;
	}
	
	public List<OcenaUsluge> prikazSvihOcena() {
		String query = "select * FROM ocenausluge";
		Statement stmt;
		List<OcenaUsluge> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<OcenaUsluge>();
			while (rset.next()) {

				int idOcene = rset.getInt(1);
				String utisak = rset.getString(2);
				String ocenaJela = rset.getString(3);
				String ocenaPica = rset.getString(4);
				String ocenaRestorana = rset.getString(5);
				int Korisnik = rset.getInt(6);
			    KorisnikDAO korisnikDao = new KorisnikDAO();
			    Korisnik korisnik = korisnikDao.GetKorisnikById(Korisnik);
			    int idRest = rset.getInt(7);
			    RestoranDao resDao = new RestoranDao();
			    Restoran restoran = resDao.GetRestoranById(idRest);
			    String ocenjeno = rset.getString(8);
				OcenaUsluge usluge = new OcenaUsluge(idOcene, utisak, ocenaJela, ocenaPica, ocenaRestorana, korisnik, restoran,ocenjeno);
				retVal.add(usluge);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	
}
