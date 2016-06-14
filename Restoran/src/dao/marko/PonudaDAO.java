package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.Namirnice;
import model.marko.Ponuda;
import model.marko.Ponudjac;
import util.ConnectionManager;

public class PonudaDAO {
	public boolean insertPonuda(Ponuda ponuda) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO namirnicepica (naziv,kolicina)" 
					+ " values (?,?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ponuda.getNaziv());
			pstmt.setString(2, ponuda.getKolicina());
			
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
	
	public Namirnice getNamirniceByID(String id) {
		Namirnice namirnice = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idNamirnicaPica,naziv,kolicina from namirnicepica where idNamirnicaPica=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int id1 = rset.getInt(1);
				String naziv = rset.getString(2);
				String kolicina = rset.getString(3);

				namirnice = new Namirnice(id1, naziv, kolicina);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namirnice;
	}
	
	public boolean insertPonudaPonudjaca(Ponuda ponuda) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO ponuda (naziv,kolicina,cena)" 
					+ " values (?,?,?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ponuda.getNaziv());
			pstmt.setString(2, ponuda.getKolicina());
			pstmt.setString(3, ponuda.getCena());
			
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
	public boolean insertCenaPonude(int id,String cena) {
		boolean retVal = false;
		try {
			String update = "update namirnicepica set cena=? where idNamirnicaPica=?";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, cena);
			pstmt.setInt(2, id);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("update");
				retVal = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
		
	}
	public List<Namirnice> prikazSvihNamirnica() {
		String query = "select * FROM namirnicepica";
		Statement stmt;
		List<Namirnice> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Namirnice>();
			while (rset.next()) {

				int idNamirnicaPica = rset.getInt(1);
				String naziv = rset.getString(2);
				String kolicina = rset.getString(3);
				String cena = rset.getString(4);
				Namirnice namirnice = new Namirnice(idNamirnicaPica, naziv,kolicina,cena);
				retVal.add(namirnice);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	public boolean getUpdateNamirnica(String idNamirnicaPica, String naziv,String kolicina) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update namirnicepica set naziv=?, kolicina=?  where idNamirnicaPica=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, naziv);
			pstmt.setString(2,kolicina);
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
	public Ponuda getPonudaByID(int id) {
		Ponuda ponuda = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idPonuda,naziv,kolicina,ponudjac from ponuda where idPonuda=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int id1 = rset.getInt(1);
				String naziv = rset.getString(2);
				String kolicina = rset.getString(3);

				ponuda = new Ponuda(id1, naziv, kolicina);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ponuda;
	}
		
	public boolean updatePonuda(String id, String cena) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update ponuda set cena=? where idPonuda=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, id);
			pstmt.setString(2,cena);
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
	
	public Ponuda getCenaByID(String cena) {
		Ponuda ponuda = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idPonuda,cena from ponuda where idPonuda=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1,cena);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idPonuda = rset.getInt(1);
				String cena1 = rset.getString(2);
				ponuda = new Ponuda(idPonuda, cena1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ponuda;
	}

	public Ponuda getPonuda(String idNamirnice) {
		Ponuda ponuda = null;
		try{
		Connection conn = ConnectionManager.getConnection();
		String selectSQL = "SELECT * FROM ponuda WHERE idPonuda = ?";
		PreparedStatement preparedStatement = conn
				.prepareStatement(selectSQL);
		preparedStatement.setString(1, idNamirnice);
		ResultSet rset = preparedStatement.executeQuery();

		if (rset.next()) {
			int id = rset.getInt(1);
			String naziv = rset.getString(2);
			String kolicina = rset.getString(3);
			String cena = rset.getString(5);
			
			ponuda= new Ponuda(id, naziv, kolicina,cena);
		}
		rset.close();
		preparedStatement.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}

		
		return ponuda;
	}
}
