package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.Statement;
import java.util.ArrayList;


import model.Jelovnik;
import model.KartaPica;
import model.Restoran;
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
	
	public List<Restoran> prikazSvihRestorana() {
		String query = "select * from restoran";
		Statement stmt;
		List<Restoran> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Restoran>();
			while (rset.next()) {

				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				Restoran restoran = new Restoran(idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				retVal.add(restoran);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	
	public List<Restoran> SortiranjeRestoranaPoNazivuASC() {
		String query = "select * from restoran order by nazivRest asc";
		Statement stmt;
		List<Restoran> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Restoran>();
			while (rset.next()) {

				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				Restoran restoran = new Restoran(idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				retVal.add(restoran);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Restoran> SortiranjeRestoranaPoNazivuDESC() {
		String query = "select * from restoran order by nazivRest desc";
		Statement stmt;
		List<Restoran> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Restoran>();
			while (rset.next()) {

				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				Restoran restoran = new Restoran(idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				retVal.add(restoran);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	
	public List<Restoran> SortiranjeRestoranaPoVrstiASC() {
		String query = "select * from restoran order by vrstaRest asc";
		Statement stmt;
		List<Restoran> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Restoran>();
			while (rset.next()) {

				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				Restoran restoran = new Restoran(idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				retVal.add(restoran);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Restoran> SortiranjeRestoranaPoVrstiDESC() {
		String query = "select * from restoran order by vrstaRest desc";
		Statement stmt;
		List<Restoran> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Restoran>();
			while (rset.next()) {

				int idRestorana = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				int idJelovnik = rset.getInt(4);
				JelovnikDAO jelDao = new JelovnikDAO();
				Jelovnik jelovnik =jelDao.GetJelovnikById(idJelovnik);
				int idKarta = rset.getInt(5);
				KartaPicaDAO karDao = new KartaPicaDAO ();
				KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
				Restoran restoran = new Restoran(idRestorana, nazivRest, vrstaRest, jelovnik, kartaPica);
				retVal.add(restoran);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean UpdateRestoran(String naziv, String vrsta, Jelovnik jelovnik, KartaPica kartaPica, int idRestorana){
		boolean retVal = false;
		try{
		Connection conn = ConnectionManager.getConnection();
		String query = "update restoran set nazivRest=?, vrstaRest=?, jelovnik=?, kartaPica=? where idRestoran=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, naziv);
		pstmt.setString(2, vrsta);
		pstmt.setInt(3, jelovnik.getIdJelovnik());
		pstmt.setInt(4, kartaPica.getIdKarte());
		pstmt.setInt(5, idRestorana);
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
			System.out.println("updateRestoran");
		}
		pstmt.close();
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	return retVal;
	}
	
	public boolean DeleteRestoran (int idRestoran){
		boolean retVal= false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "delete from restoran where idRestoran=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idRestoran);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
	
	
	
}


