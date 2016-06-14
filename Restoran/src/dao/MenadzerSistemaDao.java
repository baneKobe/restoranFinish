package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MenadzerSistema;
import model.Restoran;
import util.ConnectionManager;
public class MenadzerSistemaDao {
	public MenadzerSistema GetMenadzerSistemaByEmailAndPassword(String email, String password){
		MenadzerSistema mensis = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "SELECT idMenadzerSistema FROM menadzersistema WHERE email = ? AND password = ?";
			PreparedStatement preparedStatement = conn
					.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rset = preparedStatement.executeQuery();

			if (rset.next()) {
				int idMenSis = rset.getInt(1);
				mensis = new MenadzerSistema(idMenSis,email, password);
			}
			rset.close();
			preparedStatement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mensis;
		}
	
	public MenadzerSistema GetMenadzerSistemaById(int idMenSis){
		MenadzerSistema mensis = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from menadzersistema where idMenadzerSistema=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idMenSis);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idMenSistema = rset.getInt(1);
				String imeMenSis = rset.getString(2);
				String prezimeMenSis = rset.getString(3);
				String emailMenSis = rset.getString(4);
				String jmbg = rset.getString(5);
				String password = rset.getString(6);
				mensis = new MenadzerSistema(idMenSistema, imeMenSis, prezimeMenSis, emailMenSis, jmbg, password);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return mensis;
	}
	
	public MenadzerSistema GetMenadzerSistemaByEmail(String email){
		MenadzerSistema mensis = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from menadzersistema where email=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idMenSistema = rset.getInt(1);
				String imeMenSis = rset.getString(2);
				String prezimeMenSis = rset.getString(3);
				String emailMenSis = rset.getString(4);
				String jmbg = rset.getString(5);
				String password = rset.getString(6);
				mensis = new MenadzerSistema(idMenSistema, imeMenSis, prezimeMenSis, emailMenSis, jmbg, password);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return mensis;
	}
	public boolean UpdateMenadzerSistema(String ime, String prezime, String email, String jmbg, String password, int idMenSis){
		boolean retVal = false;
		try{
		Connection conn = ConnectionManager.getConnection();
		String query = "update menadzersistema set imeMenadzera=?, prezimeMenadzera=?,  email=?, jmbg=?, password=? where idMenadzerSistema=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, ime);
		pstmt.setString(2, prezime);
		pstmt.setString(3, email);
		pstmt.setString(4, jmbg);
		pstmt.setString(5, password);
		pstmt.setInt(6, idMenSis);
		if (pstmt.executeUpdate() == 1) {
			retVal = true;
			System.out.println("updateMenadzerSistema");
		}
		pstmt.close();
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	return retVal;
	}
	}

