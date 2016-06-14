package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Kuvar;
import model.Restoran;
import util.ConnectionManager;

public class KuvarDao {

	public Kuvar GetKuvarByEmailAndPassword(String email, String password){
		Kuvar kuvar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query ="select idKuvar from kuvar where email=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				int idMenSis = rset.getInt(1);
				kuvar = new Kuvar(idMenSis,email, password);
			}
			rset.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return kuvar;
	}
	
	public boolean UpdateKuvarPassword (String password, int idKuvar){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update kuvar set password=?, pristup=1 where idKuvar=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, idKuvar);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateKuvarPassword");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
	
	
	
	public Kuvar GetKuvarByEmail(String email){
		Kuvar kuvar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from kuvar where email=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKuvar = rset.getInt(1);
				String imeKuvar = rset.getString(2);
				String prezimeKuvar = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				String mejl = rset.getString(7);
				String password = rset.getString(8);
				int restoran = rset.getInt(9);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(10);
				
				kuvar = new Kuvar(idKuvar, imeKuvar, prezimeKuvar, konfekcijskiBr, datumRodjenja, velicinaObuce,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return kuvar;
	}
	public Kuvar GetKuvarById(int id){
		Kuvar kuvar = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from kuvar where idKuvar=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKuvar = rset.getInt(1);
				String imeKuvar = rset.getString(2);
				String prezimeKuvar = rset.getString(3);
				int konfekcijskiBr = rset.getInt(4);
				String datumRodjenja = rset.getString(5);
				String velicinaObuce = rset.getString(6);
				String mejl = rset.getString(7);
				String password = rset.getString(8);
				int restoran = rset.getInt(9);
				RestoranDao resDao = new RestoranDao();
				Restoran rest = resDao.GetRestoranById(restoran);
				int brPristupa = rset.getInt(10);
				
				kuvar = new Kuvar(idKuvar, imeKuvar, prezimeKuvar, konfekcijskiBr, datumRodjenja, velicinaObuce,mejl,password,rest,brPristupa);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return kuvar;
	}
	public boolean UpdateKuvar (String ime, String prezime, int konfekcijskiBr, String datumRodjenja, String velicinaObuce, String email, String password, int idKuvar){
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update kuvar set imeKuvar=?, prezimeKuvar=?, konfekcijskiBroj=?, datumRodjenja=?, velicinaObuce=?, email=?, password=?  where idKuvar=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ime);
			pstmt.setString(2, prezime);
			pstmt.setInt(3, konfekcijskiBr);
			pstmt.setString(4, datumRodjenja);
			pstmt.setString(5, velicinaObuce);
			pstmt.setString(6, email);
			pstmt.setString(7, password);
			pstmt.setInt(8, idKuvar);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("updateKuvar");
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
		
	}
	
	public boolean insertKuvar(Kuvar kuvar) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO kuvar (imeKuvar, prezimeKuvar, konfekcijskiBroj, datumRodjenja,velicinaObuce,email, password,idRest)" 
					+ " values (?, ?, ?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionManager.getConnection();


			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, kuvar.getImeKuvar());
			pstmt.setString(2, kuvar.getPrezimeKuvar());
			pstmt.setInt(3, kuvar.getKonfekcijskiBr());
			pstmt.setString(4, kuvar.getDatumRodjenja());
			pstmt.setString(5, kuvar.getVelicinaObuce());
			pstmt.setString(6, kuvar.getEmail());
			pstmt.setString(7, kuvar.getPassword());
			pstmt.setInt(8, kuvar.getIdRestoran().getIdRest());



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
