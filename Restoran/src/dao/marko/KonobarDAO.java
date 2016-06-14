package dao.marko;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.Konobar;
import model.marko.Restoran;
import util.ConnectionManager;

public class KonobarDAO {

	
	public List<Konobar> prikazSvihKonobara() {
		String query = "select * FROM konobar";
		Statement stmt;
		List<Konobar> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Konobar>();
			while (rset.next()) {

				int idKonobar= rset.getInt(1);
			    String imeKonobar = rset.getString(2);
			    String prezimeKonobar = rset.getString(3);
			    int konfekcijskiBr = rset.getInt(4);
			    String datumRodjenja = rset.getString(5);
			    String velicinaObuce = rset.getString(6);
			    double prihod = rset.getDouble(7);
			    String email = rset.getString(8);
			    String password = rset.getString(9);
			    int idRestoran = rset.getInt(10);
			    RestoranDao resDao = new RestoranDao();
			    Restoran restoran = resDao.GetRestoranById(idRestoran);
				Konobar konobar = new Konobar(idKonobar, imeKonobar, prezimeKonobar, konfekcijskiBr, datumRodjenja,velicinaObuce,prihod,email,password,restoran);
				retVal.add(konobar);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Konobar GetKonobarById(int id) {
		  Konobar konobar = null;
		  try {
		   Connection conn = ConnectionManager.getConnection();
		   String update = "select * from konobar where idKonobar=?";
		   PreparedStatement pstmt = conn.prepareStatement(update);
		   pstmt.setInt(1, id);
		   ResultSet rset = pstmt.executeQuery();
		   if (rset.next()) {
			int idKonobar= rset.getInt(1);
		    String imeKonobar = rset.getString(2);
		    String prezimeKonobar = rset.getString(3);
		    int konfekcijskiBr = rset.getInt(4);
		    String datumRodjenja = rset.getString(5);
		    String velicinaObuce = rset.getString(6);
		    double prihod = rset.getDouble(7);
		    String email = rset.getString(8);
		    String password = rset.getString(9);
		    int idRestoran = rset.getInt(10);
		    RestoranDao resDao = new RestoranDao();
		    Restoran restoran = resDao.GetRestoranById(idRestoran);
		    
		    konobar = new Konobar(idKonobar, imeKonobar, prezimeKonobar, konfekcijskiBr, datumRodjenja,velicinaObuce,prihod,email,password,restoran);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return konobar;
		 }
	
	
	public boolean insertKonobar(Konobar konobar) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO konobar (ime, prezime, konfekcijskiBroj, datumRodjenja,velicinaObuce,email, password,idRest)" 
							+ " values (?, ?, ?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, konobar.getImeKonobar());
			pstmt.setString(2, konobar.getPrezimeKonobar());
			pstmt.setInt(3, konobar.getKonfekcijskiBr());
			pstmt.setString(4, konobar.getDatumRodjenja());
			pstmt.setString(5, konobar.getVelicinaObuce());
			pstmt.setString(6, konobar.getEmail());
			pstmt.setString(7, konobar.getPassword());
			pstmt.setInt(8, konobar.getIdRestoran().getIdRest());
			
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
