package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Konobar;
import model.Restoran;
import util.ConnectionManager;

public class KonobarDao {
	
	public Konobar GetKonobarByEmailAndPassword(String email, String password){
		Konobar konobar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query ="select idKonobar from konobar where email=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				int idMenSis = rset.getInt(1);
				konobar = new Konobar(idMenSis,email, password);
			}
			rset.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return konobar;
	}
	
	public boolean UpdateKonobarPassword (String password, int idKonobar){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update konobar set password=?, pristup=1 where idKonobar=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, idKonobar);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateKonobarPassword");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
	
	
	
	public Konobar GetKonobarByEmail(String email){
		Konobar konobar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from konobar where email=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKonobar = rset.getInt(1);
				String imeKonobar = rset.getString(2);
				String prezimeKonobar = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				double prihod = rset.getDouble(7);
				String mejl = rset.getString(8);
				String password = rset.getString(9);
				int restoran = rset.getInt(10);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(11);
				
				konobar = new Konobar(idKonobar, imeKonobar, prezimeKonobar, konfekcijskiBr, datumRodjenja, velicinaObuce,prihod,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return konobar;
	}
	public Konobar GetKonobarById(int id){
		Konobar konobar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from konobar where idKonobar=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKonobar = rset.getInt(1);
				String imeKonobar = rset.getString(2);
				String prezimeKonobar = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				double prihod = rset.getDouble(7);
				String mejl = rset.getString(8);
				String password = rset.getString(9);
				int restoran = rset.getInt(10);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(11);
				
				konobar = new Konobar(idKonobar, imeKonobar, prezimeKonobar, konfekcijskiBr, datumRodjenja, velicinaObuce,prihod,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return konobar;
	}
	
	public boolean UpdateKonobar (String ime, String prezime, int konfekcijskiBr, String datumRodjenja, String velicinaObuce, String email, String password, int idKonobar){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update konobar set ime=?, prezime=?, konfekcijskiBroj=?, datumRodjenja=?, velicinaObuce=?, email=?, password=?  where idKonobar=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ime);
			pstmt.setString(2, prezime);
			pstmt.setInt(3, konfekcijskiBr);
			pstmt.setString(4, datumRodjenja);
			pstmt.setString(5, velicinaObuce);
			pstmt.setString(6, email);
			pstmt.setString(7, password);
			pstmt.setInt(8, idKonobar);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateKonobar");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
		
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
