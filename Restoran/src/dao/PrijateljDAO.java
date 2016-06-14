package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Korisnik;
import util.ConnectionManager;

public class PrijateljDAO {
	
	public List<Korisnik> PrikazPrijatelja(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean DodajPrijatelja(String id, int ja) {
		boolean retVal = false;
		KorisnikDAO korDAO=new KorisnikDAO();
		Korisnik korisnik=korDAO.KorisnikId(id);
		try {
			String update = "INSERT INTO prijatelji (idPrijatelj, imePrijatelja, prezimePrijatelja, email, korisnik)"
					+ " values (?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(5, ja);
			pstmt.setString(2, korisnik.getUsername());
			pstmt.setString(3, korisnik.getPrezime());
			pstmt.setString(4, korisnik.getEmail());
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean IzbrisiPrijatelja(String idp, int ja) {
		  boolean retVal = false;
		  int id = Integer.parseInt(idp);
		  try {
		   String update = "DELETE FROM prijatelji WHERE idPrijatelj=? AND korisnik=?";
		   Connection conn = ConnectionManager.getConnection();
		   PreparedStatement pstmt = conn.prepareStatement(update);
		   pstmt.setInt(1, id);
		   pstmt.setInt(2, ja);
		   if (pstmt.executeUpdate() == 1) {
		    retVal = true;
		   }
		   pstmt.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return retVal;
		 }
	
	public List<Korisnik> SortiranjePrijateljaPoImenuASC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by imePrijatelja asc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> SortiranjePrijateljaPoImenuDESC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by imePrijatelja desc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> SortiranjePrijateljaPoPrezimenuASC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by prezimePrijatelja asc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> SortiranjePrijateljaPoPrezimenuDESC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by prezimePrijatelja desc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> SortiranjePrijateljaPoEmailASC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by email asc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> SortiranjePrijateljaPoEmailDESC(int ja) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from prijatelji where korisnik=? order by email desc";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			pstmt.setInt(1, ja);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String imePrijatelja = rset.getString(2);
				String prezimePrijatelja = rset.getString(3);
				String email = rset.getString(4);
				int idPrijatelj=rset.getInt(1);
				korisnik = new Korisnik(imePrijatelja, prezimePrijatelja, email, idPrijatelj, ja);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

}
