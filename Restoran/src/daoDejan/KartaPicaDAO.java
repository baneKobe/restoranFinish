package daoDejan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseDejan.Pice;
import klaseDejan.PorudzbinaP;
import util.ConnectionManager;

public class KartaPicaDAO {
	
	public List<Pice> GetKartaPicaByID(String idKarte) {
		List<Pice> retVal=null;
		Pice kartapica=null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "select * from pice where idKarte=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			retVal = new ArrayList<Pice>();
			pstmt.setString(1, idKarte);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				String naziv = rset.getString(2);
				String opis = rset.getString(3);
				Double cena = rset.getDouble(4);
				int idKarte1 = rset.getInt(5);
				kartapica = new Pice(naziv, opis, cena, idKarte1);
				retVal.add(kartapica);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean poruciPice(PorudzbinaP p) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO porudzbinapice (nazivR, nazivP, datum, vreme, sati, sto)"
					+ " values (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, p.getNazivR());
			pstmt.setString(2, p.getNazivP());
			pstmt.setString(3, p.getDatum());
			pstmt.setString(4, p.getVreme());
			pstmt.setString(5, p.getSati());
			pstmt.setString(6, p.getSto());
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
