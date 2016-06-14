package dao.marko;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.marko.RestoranNaziv;
import util.ConnectionManager;


public class RestoranNazivDAO {

	public RestoranNaziv getRestoranNazivByID(int id) {
		RestoranNaziv restoranNaziv = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idRestoran,nazivRest,vrstaRest,jelovnik,kartaPica from restoran where idRestoran=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int id1 = rset.getInt(1);
				String nazivRest = rset.getString(2);
				String vrstaRest = rset.getString(3);
				String jelovnik = rset.getString(4);
				String kartaPica = rset.getString(5);
				restoranNaziv = new RestoranNaziv(id1, nazivRest, vrstaRest, jelovnik, kartaPica);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restoranNaziv;
	}
	
	
	
	



	public boolean getUpdateRestoran(int id, String nazivRest,String vrstaRest) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update restoran set nazivRest=?,vrstaRest=? where idRestoran=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, nazivRest);
			pstmt.setString(2, vrstaRest);
			pstmt.setInt(3, id);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("update");
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
		
	}
}
