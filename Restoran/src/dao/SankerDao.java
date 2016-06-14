package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Restoran;
import model.Sanker;
import util.ConnectionManager;

public class SankerDao {
	public Sanker GetSankerByEmailAndPassword(String email, String password){
		Sanker sanker = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query ="select idSanker from sanker where email=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				int idMenSis = rset.getInt(1);
				sanker = new Sanker(idMenSis,email, password);
			}
			rset.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return sanker;
	}
	
	public boolean UpdateSankerPassword (String password, int idSanker){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update sanker set password=?, pristup=1 where idSanker=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, idSanker);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateSankerPassword");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
	
	
	
	public Sanker GetSankerByEmail(String email){
		Sanker sanker = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from sanker where email=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idSanker = rset.getInt(1);
				String imeSanker = rset.getString(2);
				String prezimeSanker = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				String mejl = rset.getString(7);
				String password = rset.getString(8);
				int restoran = rset.getInt(9);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(10);
				
				sanker = new Sanker(idSanker, imeSanker, prezimeSanker, konfekcijskiBr, datumRodjenja, velicinaObuce,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return sanker;
	}
	public Sanker GetSankerById(int id){
		Sanker sanker = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from sanker where idSanker=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idSanker = rset.getInt(1);
				String imeSanker = rset.getString(2);
				String prezimeSanker = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				String mejl = rset.getString(7);
				String password = rset.getString(8);
				int restoran = rset.getInt(9);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(10);
				
				sanker = new Sanker(idSanker, imeSanker, prezimeSanker, konfekcijskiBr, datumRodjenja, velicinaObuce,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return sanker;
	}
	public boolean UpdateSanker (String ime, String prezime, int konfekcijskiBr, String datumRodjenja, String velicinaObuce, String email, String password, int idSanker){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update sanker set imeSanker=?, prezimeSanker=?, konfekcijskiBroj=?, datumRodjenja=?, velicinaObuce=?, email=?, password=?  where idSanker=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ime);
			pstmt.setString(2, prezime);
			pstmt.setInt(3, konfekcijskiBr);
			pstmt.setString(4, datumRodjenja);
			pstmt.setString(5, velicinaObuce);
			pstmt.setString(6, email);
			pstmt.setString(7, password);
			pstmt.setInt(8, idSanker);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateSanker");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
		
	}
	
	public boolean insertSanker(Sanker sanker) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO sanker (imeSanker, prezimeSanker, konfekcijskiBroj, datumRodjenja,velicinaObuce,email, password,idRest)" 
					+ " values (?, ?, ?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionManager.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, sanker.getImeSanker());
			pstmt.setString(2, sanker.getPrezimeSanker());
			pstmt.setInt(3, sanker.getKonfekcijskiBr());
			pstmt.setString(4, sanker.getDatumRodjenja());
			pstmt.setString(5, sanker.getVelicinaObuce());
			pstmt.setString(6, sanker.getEmail());
			pstmt.setString(7, sanker.getPassword());
			pstmt.setInt(8, sanker.getIdRestoran().getIdRest());
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
