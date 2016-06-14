package dao.marko;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.marko.Jelo;
import model.marko.Konobar;
import model.marko.Pazar;
import model.marko.Pice;
import model.marko.Restoran;
import util.ConnectionManager;

public class PazarDao {
	public Pazar getPazarByID(int id) {
		Pazar pazar = null;
	    try{
	     Connection conn = ConnectionManager.getConnection();
	     String query = "select * from racun where idracun=?";
	     PreparedStatement pstmt = conn.prepareStatement(query);
	     pstmt.setInt(1, id);
	     ResultSet rset = pstmt.executeQuery();
	     if(rset.next()){
	      int idracun = rset.getInt(1);
	      int Jelo = rset.getInt(2);
	      JelovnikDAO jelovnikDao = new JelovnikDAO();
	      Jelo jelo = jelovnikDao.GetJeloById(Jelo);
	      int Pice = rset.getInt(3);
	      KartaPicaDAO kartaDao = new KartaPicaDAO();
	      Pice pice = kartaDao.GetPiceById(Pice);
	      int Konobar = rset.getInt(4);
	      KonobarDAO konobarDao = new KonobarDAO();
	      Konobar konobar = konobarDao.GetKonobarById(Konobar);
	      int idRest = rset.getInt(5);
	      RestoranDao resDao = new RestoranDao();
	      Restoran restoran = resDao.GetRestoranById(idRest);
	      double cijena = rset.getDouble(6);
	      
	      
	      pazar = new Pazar(idracun,jelo,pice,konobar,restoran,cijena);
	      
	     }
	    }
	    catch (SQLException e) {
	    
	     e.printStackTrace();
	     
	    }
	    return pazar;
	   }
	
	
	
	
	public double getPazarKonobar(int idKonobar){
		double prihod = 0;
		try{
		Connection conn = ConnectionManager.getConnection();
	    String query = "select SUM(cijena) from racun where konobar=?";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setInt(1,idKonobar);
	    ResultSet rset = pstmt.executeQuery();
	    if(rset.next()){
	    	String cijena = rset.getString(1);
	    	prihod = Double.parseDouble(cijena);
	    }
		}
	    catch (SQLException e) {
		     e.printStackTrace();
		    }
	    return prihod;
	}
	
	public double getSumaPazar(int idRestoran){
		double prihod = 0;
		try{
		Connection conn = ConnectionManager.getConnection();
	    String query = "select SUM(cijena) from racun where restoran=?";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setInt(1,idRestoran);
	    ResultSet rset = pstmt.executeQuery();
	    if(rset.next()){
	    	String cijena = rset.getString(1);
	    	prihod = Double.parseDouble(cijena);
	    }
		}
	    catch (SQLException e) {
		     e.printStackTrace();
		    }
	    return prihod;
	}
	
	
}
