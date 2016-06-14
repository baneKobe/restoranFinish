package daoDejan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseDejan.Jelo;
import klaseDejan.PorudzbinaJ;
import util.ConnectionManager;

public class JelovnikDAO {
	
	public List<Jelo> GetJelovnikByID(String idJelovnik) {
		List<Jelo> retVal=null;
		Jelo jelovnik=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from jelo where idJelovnik=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Jelo>();
			pstmt.setString(1, idJelovnik);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String naziv = rset.getString(2);
				String opis = rset.getString(3);
				Double cena = rset.getDouble(4);
				int idJelovnik1 = rset.getInt(5);
				jelovnik = new Jelo(naziv, opis, cena, idJelovnik1);
				retVal.add(jelovnik);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean poruciJelo(PorudzbinaJ j) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO porudzbinahrana (nazivR, nazivJ, datum, vreme, sati, sto)"
					+ " values (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, j.getNazivR());
			pstmt.setString(2, j.getNazivJ());
			pstmt.setString(3, j.getDatum());
			pstmt.setString(4, j.getVreme());
			pstmt.setString(5, j.getSati());
			pstmt.setString(6, j.getSto());
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
