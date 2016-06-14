package daoDejan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import klaseDejan.Poseta;
import util.ConnectionManager;

public class PosetaDAO {

	public boolean posetaRestorana(Poseta p) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO posete (nazivRestorana, datum, sati, duzinaRezervacije, korisnik)"
					+ " values (?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, p.getNazivRestorana());
			pstmt.setString(2, p.getDatum());
			pstmt.setString(3, p.getSati());
			pstmt.setString(4, p.getDuzinaRezervacije());
			pstmt.setString(5, p.getKorisnik());
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
}
