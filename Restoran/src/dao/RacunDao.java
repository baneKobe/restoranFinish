package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JeloDao;
import dao.PiceDao;
import dao.KonobarDao;
import dao.RestoranDao;
import dao.PorudzbinaDao;
import model.Jelo;
import model.Konobar;
import model.Pice;
import model.Porudzbina;
import model.Racun;
import model.Restoran;
import util.ConnectionManager;

public class RacunDao {

	public Racun getRacunById(int id){
		Racun racun = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from racun where idRacun=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idRacun = rset.getInt(1);
				int idJelo = rset.getInt(2);
				JeloDao jelDao = new JeloDao();
				Jelo jelo = jelDao.GetJeloById(idJelo);
				int idPice = rset.getInt(3);
				PiceDao picDao =new PiceDao();
				Pice pice = picDao.GetPiceById(idPice);
				int idKonobar = rset.getInt(4);
				KonobarDao konDao = new KonobarDao();
				Konobar konobar = konDao.GetKonobarById(idKonobar);
				int idRestoran = rset.getInt(5);
				RestoranDao resDao = new RestoranDao();
				Restoran restoran = resDao.GetRestoranById(idRestoran);
				int idPorudzbina = rset.getInt(6);
				PorudzbinaDao porDao = new PorudzbinaDao();
				Porudzbina porudzbina = porDao.getPorudzbinaById(idPorudzbina);
				double cijena = rset.getDouble(7);
				racun = new Racun(idRacun, jelo, pice, konobar, restoran, porudzbina, cijena);
			}
		}
		catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			   
			  }
		return racun;
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
	public boolean insertRacun(Racun racun) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO racun (jelo, pice, konobar, restoran,porudzbina,cijena)" 
							+ " values (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1,racun.getJelo().getIdJelo());
			pstmt.setInt(2, racun.getPice().getIdPice());
			pstmt.setInt(3, racun.getKonobar().getIdKonobar());
			pstmt.setInt(4, racun.getRestoran().getIdRest());
			pstmt.setInt(5, racun.getPorudzbina().getIdPorudzbina());
			pstmt.setDouble(6, racun.getCijena());
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("insert");
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
		
	}

}
