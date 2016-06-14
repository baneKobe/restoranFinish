package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.marko.Jelovnik;
import model.marko.KartaPica;
import model.marko.Restoran;
import util.ConnectionManager;

public class RestoranDao {

	public boolean InsertRestoran (Restoran restoran){
		boolean retVal = false;
		try{
			String query = "insert into Restoran (nazivRest, vrstaRest, jelovnik, kartapica) values (?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, restoran.getNazivRest());
			pstmt.setString(2, restoran.getVrstaRest());
			pstmt.setInt(3,restoran.getJelovnik().getIdJelovnik());
			pstmt.setInt(4, restoran.getKartapica().getIdKarte());
		
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
		}
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return retVal;
		
	}
	
	public Restoran GetRestoranById(int idRest){
		Restoran rest = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from restoran where idRestoran=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idRest);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				rest = new Restoran (idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return rest;
	}
	
	public Restoran GetRestoranByNaziv(String naziv){
		Restoran rest = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from restoran where nazivRest=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, naziv);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				rest = new Restoran (idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return rest;
	}
}

