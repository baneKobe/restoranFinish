package daoDejan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import klaseDejan.Restoran;
import util.ConnectionManager;

public class RestoranDAO {
	
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
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
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
	
	public Restoran RestoranID(String idRestoran) {
		Restoran restoran = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from restoran where idRestoran=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, idRestoran);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				String naziv = rset.getString(2);
				String vrsta = rset.getString(3);
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
				int idRest= rset.getInt(1);
				restoran = new Restoran(idRest, naziv, vrsta, kartaPica, jelovnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restoran;
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
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
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
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
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
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
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
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
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
	
	public List<Restoran> Posete(int ja) {
		List<Restoran> retVal=null;
		Restoran restoran=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from posete where korisnik=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Restoran>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String nazivRestorana = rset.getString(2);
				Date datum = rset.getDate(3);
				Time sati = rset.getTime(4);
				int duzinaRezervacije=rset.getInt(5);
				int idPosete=rset.getInt(1);
				restoran = new Restoran(idPosete, nazivRestorana, datum, sati, duzinaRezervacije);
				retVal.add(restoran);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean dodajOcenu(String utisak, String ocenaJela, String ocenaPica,
			String ocenaRestorana,String ja,String idRestorana) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO ocenausluge (utisak, ocenaJela, ocenaPica, "
					+ "ocenaRestorana, korisnik, restoran, ocenjeno)"
					+ " values (?,?,?,?,?,?,?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, utisak);
			pstmt.setString(2, ocenaJela);
			pstmt.setString(3, ocenaPica);
			pstmt.setString(4, ocenaRestorana);
			pstmt.setString(5, ja);
			pstmt.setString(6, idRestorana);
			pstmt.setString(7, "1");
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Restoran RestoranIDZaOcenu(String idRestoran) {
		Restoran restoran = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select restoran, ocenjeno from ocenausluge where restoran=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, idRestoran);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				int restoran1 = rset.getInt(1);
				int ocenjeno= rset.getInt(2);
				restoran = new Restoran(restoran1, ocenjeno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restoran;
	}
	
	public List<Restoran> PretragaRestorana(String nazivRest, String vrstaRest) {
		List<Restoran> retVal=null;
		Restoran restoran=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from restoran where nazivRest like ? and vrstaRest like ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Restoran>();
			nazivRest="%"+nazivRest+"%";
			vrstaRest="%"+vrstaRest+"%";
			pstmt.setString(1, nazivRest);
			pstmt.setString(2, vrstaRest);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				int idRestorana = rset.getInt(1);
				String nazivRest1 = rset.getString(2);
				String vrstaRest1 = rset.getString(3);
				int jelovnik = rset.getInt(4);
				int kartaPica = rset.getInt(5);
				restoran = new Restoran(idRestorana, nazivRest1, vrstaRest1, jelovnik, kartaPica);
				retVal.add(restoran);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
}



