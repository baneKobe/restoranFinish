package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.Jelo;
import model.marko.Jelovnik;
import util.ConnectionManager;

public class JelovnikDAO {
	
	
	public List<Jelovnik> prikazSvihJelovnika() {
		String query = "select jelovnik.idJelovnik, jelovnik.naziv, jelo.naziv, jelo.opis,jelo.cijena FROM jelovnik INNER JOIN jelo ON jelovnik.idJelovnik=jelo.idJelovnik";
		Statement stmt;
		List<Jelovnik> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Jelovnik>();
			while (rset.next()) {

				int idJelovnik = rset.getInt(1);
				String naziv = rset.getString(2);
				String nazivJela = rset.getString(3);
				String opisJela = rset.getString(4);
				String cena = rset.getString(5);
				Jelovnik jelovnik = new Jelovnik(idJelovnik, naziv,nazivJela, opisJela,cena);
				retVal.add(jelovnik);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	
	
	public List<Jelovnik> prikazSvihJela() {
		String query = "select jelo.idjelo, jelo.naziv, jelo.opis, jelo.cijena, jelovnik.naziv FROM jelo INNER JOIN jelovnik ON jelo.idJelovnik=jelovnik.idJelovnik";
		Statement stmt;
		List<Jelovnik> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<Jelovnik>();
			while (rset.next()) {

				int idjelo = rset.getInt(1);
				String nazivJela = rset.getString(2);
				String opisJela = rset.getString(3);
				String cenaJela = rset.getString(4);
				String nazivJelovnika = rset.getString(5);
				Jelovnik jelovnik = new Jelovnik(idjelo,nazivJela, opisJela,cenaJela, nazivJelovnika);
				retVal.add(jelovnik);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	
	
	
	public Jelovnik GetJelovnikById(int idJelovnik){
		Jelovnik jelovnik = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from jelovnik where idJelovnik=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idJelovnik);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idJelovnika = rset.getInt(1);
				String naziv = rset.getString(2);
				jelovnik = new Jelovnik(idJelovnika, naziv);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return jelovnik;
	}
	public Jelovnik GetJelovnikIDbyNaziv(String naziv){
		Jelovnik jelo = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from jelovnik where naziv=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, naziv);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idJelovnik = rset.getInt(1);
				String naziv1 = rset.getString(2);
				jelo = new Jelovnik(idJelovnik,naziv1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
	}
	return jelo;
}
	
	
	
	public boolean insertJelovnik(Jelovnik jelovnik) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO jelovnik (naziv)" 
					+ " values (?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, jelovnik.getNaziv());
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
	public boolean getUpdateJelovnik(String idJelovnik, String naziv) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update jelovnik set naziv=? where idJelovnik=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, naziv);
			pstmt.setString(2, idJelovnik);
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
	public boolean deleteJelovnik(int idJelovnik){
		boolean retVal = false;
		try{
			String update = "delete from jelovnik where idJelovnik = ?";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, idJelovnik);
			if(pstmt.executeUpdate() == 1){
				retVal = true;
				System.out.println("delete");
			}
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return retVal;
	}
	public boolean insertJelo(Jelo jelo) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO jelo (naziv, opis, cijena,idJelovnik) values (?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, jelo.getNaziv());
			pstmt.setString(2, jelo.getOpis());
			pstmt.setDouble(3,jelo.getCijena());
			pstmt.setInt(4,jelo.getIdJelovnik().getIdJelovnik());
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
	public Jelo GetJeloById(int id) {
		  Jelo jelo = null;
		  try {
		   Connection conn = ConnectionManager.getConnection();
		   String update = "select * from jelo where idjelo=?";
		   PreparedStatement pstmt = conn.prepareStatement(update);
		   pstmt.setInt(1, id);
		   ResultSet rset = pstmt.executeQuery();
		   if (rset.next()) {
			int idjelo= rset.getInt(1);
		    String naziv = rset.getString(2);
		    String opis = rset.getString(3);
		    double cijena = rset.getDouble(4);
		    int idJelovnik = rset.getInt(5);
		    JelovnikDAO jeloDAO = new JelovnikDAO();
		    Jelovnik jelovnik = jeloDAO.GetJelovnikById(idJelovnik);
		    
		    jelo = new Jelo(idjelo, naziv, opis, cijena, jelovnik);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return jelo;
		 }
	public boolean getUpdateJelo(String idJelo, String naziv,String opis, String cijena) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update jelo set naziv=?, opis=? ,  cijena=? where idjelo=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, naziv);
			pstmt.setString(2,opis);
			pstmt.setString(3,cijena);
			pstmt.setString(4, idJelo);
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
	public boolean deleteJelo(int idJelo){
		boolean retVal = false;
		try{
			String update = "delete from jelo where idjelo = ?";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, idJelo);
			if(pstmt.executeUpdate() == 1){
				retVal = true;
				System.out.println("delete");
			}
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return retVal;
	}



	
	
	
}
