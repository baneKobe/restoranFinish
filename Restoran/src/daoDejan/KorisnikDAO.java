package daoDejan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseDejan.Korisnik;
import util.ConnectionManager;

public class KorisnikDAO {

	public boolean dodajKorisnika(Korisnik korisnik) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO korisnik (username, prezime, email, lozinka)"
					+ " values (?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, korisnik.getUsername());
			pstmt.setString(2, korisnik.getPrezime());
			pstmt.setString(3, korisnik.getEmail());
			pstmt.setString(4, korisnik.getLozinka());
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean Aktivirano(String email) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update korisnik set aktivirano=? where email=?";
			int aktivirano=1;
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, aktivirano);
			pstmt.setString(2, email);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean OdbijenoAktiviranje(String email) {
		  boolean retVal = false;
		  try {
		   String update = "DELETE FROM korisnik WHERE email=?";
		   Connection conn = ConnectionManager.getConnection();
		   PreparedStatement pstmt = conn.prepareStatement(update);
		   pstmt.setString(1, email);
		   if (pstmt.executeUpdate() == 1) {
		    retVal = true;
		   }
		   pstmt.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return retVal;
		 }
	
	public Korisnik LoginKorisnik(String email, String lozinka) {
		Korisnik korisnik = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "SELECT idKor FROM korisnik WHERE email = ? AND lozinka = ? and aktivirano=1";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, lozinka);
			ResultSet rset = preparedStatement.executeQuery();
			if (rset.next()) {
				int idKor = rset.getInt(1);
				korisnik = new Korisnik(email, lozinka, idKor);
			}
			rset.close();
			preparedStatement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return korisnik;
	}
	
	
	public Korisnik KorisnikEmail(String email) {
		Korisnik korisnik = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from korisnik where email=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				String username = rset.getString(2);
				String lozinka = rset.getString(5);
				String prezime = rset.getString(3);
				String email1 = rset.getString(4);
				int idKor= rset.getInt(1);
				korisnik = new Korisnik(username, lozinka, prezime, email1, idKor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return korisnik;
	}
	
	public boolean IzmeniKorisnika(String username, String prezime, String email, String lozinka, int idKor) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update korisnik set username=?, prezime=?, email=?, lozinka=? where idKor=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, username);
			pstmt.setString(2, prezime);
			pstmt.setString(3, email);
			pstmt.setString(4, lozinka);
			pstmt.setInt(5, idKor);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Korisnik> PretragaKorisnika(String username, String prezime) {
		List<Korisnik> retVal=null;
		Korisnik korisnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from korisnik where username like ? and prezime like ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Korisnik>();
			username="%"+username+"%";
			prezime="%"+prezime+"%";
			pstmt.setString(1, username);
			pstmt.setString(2, prezime);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String username1 = rset.getString(2);
				String lozinka = rset.getString(5);
				String prezime1 = rset.getString(3);
				String email1 = rset.getString(4);
				int idKor= rset.getInt(1);
				korisnik = new Korisnik(username1, lozinka, prezime1, email1, idKor);
				retVal.add(korisnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Korisnik KorisnikId(String id) {
		Korisnik korisnik = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from korisnik where idKor=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, id);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				String username = rset.getString(2);
				String lozinka = rset.getString(5);
				String prezime = rset.getString(3);
				String email1 = rset.getString(4);
				int idKor= rset.getInt(1);
				korisnik = new Korisnik(username, lozinka, prezime, email1, idKor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return korisnik;
	}
	
	
}