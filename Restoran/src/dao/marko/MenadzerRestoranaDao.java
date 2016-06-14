package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.MenadzerRestorana;
import model.marko.Restoran;
import util.ConnectionManager;


public class MenadzerRestoranaDao {
	
	public MenadzerRestorana getManagerByID(int id){
		MenadzerRestorana menadzeri = null;
		  try{
		   Connection conn = ConnectionManager.getConnection();
		   String query = "select * from menadzerrestorana where idMenadzeraRest=?";
		   PreparedStatement pstmt = conn.prepareStatement(query);
		   pstmt.setInt(1, id);
		   ResultSet rset = pstmt.executeQuery();
		   if(rset.next()){
		    int idMenRes = rset.getInt(1);
		    String imeMenRes = rset.getString(2);
		    String prezimeMenRes = rset.getString(3);
		    String jmbg = rset.getString(4);
		    String email = rset.getString(5);
		    String password = rset.getString(6);
		    int idRest = rset.getInt(7);
		    RestoranDao resDao = new RestoranDao();
		    Restoran restoran = resDao.GetRestoranById(idRest);
		    menadzeri = new MenadzerRestorana(idMenRes, imeMenRes, prezimeMenRes, email, jmbg, password, restoran);
		    
		   }
		  }
		  catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return menadzeri;
		 }
	
	public MenadzerRestorana getMenadzerRestByEmail(String mejl){
		MenadzerRestorana menadzeri = null;
		  try{
		   Connection conn = ConnectionManager.getConnection();
		   String query = "select * from menadzerrestorana where email=?";
		   PreparedStatement pstmt = conn.prepareStatement(query);
		   pstmt.setString(1, mejl);
		   ResultSet rset = pstmt.executeQuery();
		   if(rset.next()){
		    int idMenRes = rset.getInt(1);
		    String imeMenRes = rset.getString(2);
		    String prezimeMenRes = rset.getString(3);
		    String email = rset.getString(4);
		    String jmbg = rset.getString(5);
		    String password = rset.getString(6);
		    int idRest = rset.getInt(7);
		    RestoranDao resDao = new RestoranDao();
		    Restoran restoran = resDao.GetRestoranById(idRest);
		    menadzeri = new MenadzerRestorana(idMenRes, imeMenRes, prezimeMenRes, email, jmbg, password,restoran);
		    
		   }
		  }
		  catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return menadzeri;
		 }

	public MenadzerRestorana getManagerByEmailAndPassword(String email,
			String password) {
		MenadzerRestorana menadzeri = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "SELECT idMenadzeraRest FROM menadzerrestorana WHERE email = ? AND lozinka = ?";
			PreparedStatement preparedStatement = conn
					.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rset = preparedStatement.executeQuery();

			if (rset.next()) {
				int id = rset.getInt(1);
				menadzeri = new MenadzerRestorana(id, email, password);
			}
			rset.close();
			preparedStatement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return menadzeri;
	}
	
	public boolean InsertMenadzerRestorana (MenadzerRestorana menres){
		boolean retVal = false;
		try{
			String query = "insert into menadzerrestorana (ime, prezime, JMBG, email, lozinka, restoran) values (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, menres.getImeMenRes());
			pstmt.setString(2, menres.getPrezimeMenRes());
			pstmt.setString(3, menres.getJmbg());
			pstmt.setString(4, menres.getEmail());
			pstmt.setString(4, menres.getEmail());
			pstmt.setString(5, menres.getPassword());
			pstmt.setInt(6, menres.getRestoran().getIdRest());
		
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
			System.out.println("InsertMenadzerRestorana");
		}
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return retVal;
		
	}
	public List <MenadzerRestorana> getAllMenadzerRestorana(){
		String query = "select * from menadzerrestorana";
		Statement stmt;
		List <MenadzerRestorana> retVal = null;
		try{
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<MenadzerRestorana>();
			while (rset.next()) {
				int idMenRes = rset.getInt(1);
				String ime = rset.getString(2);
				String prezime = rset.getString(3);
				String jmbg = rset.getString(4);
				String email = rset.getString(5);
				String password = rset.getString(6);
				int idRest = rset.getInt(7);
				RestoranDao resDao = new RestoranDao();
				Restoran restoran = resDao.GetRestoranById(idRest);
				MenadzerRestorana menRest = new MenadzerRestorana(idMenRes, ime, prezime, jmbg, email, password, restoran);
				retVal.add(menRest);
			}
			rset.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	public boolean UpdateMenadzerRestorana(String ime, String prezime, String jmbg, String email, String password, Restoran restoran, int idMenRes){
		boolean retVal = false;
		try{
		Connection conn = ConnectionManager.getConnection();
		String query = "update menadzerrestorana set ime=?, prezime=?, jmbg=?, email=?, lozinka=?, restoran =? where idMenadzeraRest=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, ime);
		pstmt.setString(2, prezime);
		pstmt.setString(3, jmbg);
		pstmt.setString(4, email);
		pstmt.setString(5, password);
		pstmt.setInt(6, restoran.getIdRest());
		pstmt.setInt(7, idMenRes);
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
			System.out.println("updateMenadzerRestorana");
		}
		pstmt.close();
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	return retVal;
	}

	public boolean DeleteMenadzerRestorana (int idMenRes){
		boolean retVal= false;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "delete from menadzerrestorana where idMenadzeraRest=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idMenRes);
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
			}
			pstmt.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return retVal;
	}
}

