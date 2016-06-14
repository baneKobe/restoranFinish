package dao.marko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.marko.KartaPica;
import model.marko.Pice;
import util.ConnectionManager;

public class KartaPicaDAO {
	
	public List<KartaPica> prikazSvihKarataPica() {
		String query = "select kartapica.idKarta, kartapica.naziv, pice.naziv, pice.opis,pice.cijena FROM kartapica INNER JOIN pice ON kartapica.idKarta=pice.idKarte";
		Statement stmt;
		List<KartaPica> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<KartaPica>();
			while (rset.next()) {

				int idKarta = rset.getInt(1);
				String naziv = rset.getString(2);
				String nazivPice = rset.getString(3);
				String opisPice = rset.getString(4);
				String cena = rset.getString(5);
				KartaPica kartaPica = new KartaPica(idKarta, naziv,nazivPice, opisPice,cena);
				retVal.add(kartaPica);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<KartaPica> prikazSvihKartiPica() {
		String query = "select pice.idPice, pice.naziv, pice.opis, pice.cijena, kartapica.naziv FROM pice INNER JOIN kartapica ON pice.idKarte = kartapica.idKarta;";
		Statement stmt;
		List<KartaPica> retVal = null;
		try {
			stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(query);
			retVal = new ArrayList<KartaPica>();
			while (rset.next()) {

				int idPice = rset.getInt(1);
				String nazivPice = rset.getString(2);
				String opisPice = rset.getString(3);
				String cijenaPice = rset.getString(4);
				String nazivKarta = rset.getString(5);
				KartaPica kartaPica = new KartaPica(idPice, nazivPice, opisPice, cijenaPice, nazivKarta);
				retVal.add(kartaPica);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public KartaPica GetKartaPicaById(int idKarte){
		KartaPica karta = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from kartapica where idKarta=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idKarte);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKarta = rset.getInt(1);
				String naziv = rset.getString(2);
				karta = new KartaPica(idKarta, naziv);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return karta;
	}

	public boolean insertKartaPica(KartaPica kartaPica) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO kartapica (naziv)" 
					+ " values (?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, kartaPica.getNaziv());
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
	
	public boolean getUpdateKartaPica(String idKarte, String naziv) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update kartapica set naziv=? where idKarta=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, idKarte);
			pstmt.setString(2, naziv);
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
	public boolean getUpdatePica(String id, String naziv, String opis, String cena) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update pice set naziv=?, opis=?, cijena=? where idPice=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, naziv);
			pstmt.setString(2, opis);
			pstmt.setString(3, cena);
			pstmt.setString(4, id);
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
	
	public boolean deleteKartaPica(int idKarta){
		boolean retVal = false;
		try{
			String update = "delete from kartapica where idKarta = ?";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, idKarta);
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

	
	public boolean insertPice(Pice pice) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO pice (naziv, opis, cijena,idKarte) values (?, ?, ?, ?)";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, pice.getNaziv());
			pstmt.setString(2, pice.getOpis());
			pstmt.setDouble(3,pice.getCijena());
			pstmt.setInt(4,pice.getIdKart().getIdKarte());
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
	public boolean getUpdatePice(String idPice, String naziv,String opis, double cijena) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update pice set naziv=?,set opis=? , set cijena=? where idKarta=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, naziv);
			pstmt.setString(2,opis);
			pstmt.setDouble(3,cijena);
			pstmt.setString(4, idPice);
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
	public boolean deletePice(int idPice){
		boolean retVal = false;
		try{
			String update = "delete from pice where idPice = ?";
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, idPice);
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
	public KartaPica GetKartaPicaIDbyNaziv(String naziv){
		KartaPica karta = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String query = "select * from kartapica where naziv=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, naziv);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int idKarta = rset.getInt(1);
				String naziv1 = rset.getString(2);
				karta = new KartaPica(idKarta,naziv1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
	}
	return karta;
	}
	public Pice GetPiceById(int id) {
		  Pice pice = null;
		  try {
		   Connection conn = ConnectionManager.getConnection();
		   String update = "select * from pice where idPice=?";
		   PreparedStatement pstmt = conn.prepareStatement(update);
		   pstmt.setInt(1, id);
		   ResultSet rset = pstmt.executeQuery();
		   if (rset.next()) {
			int idPice= rset.getInt(1);
		    String naziv = rset.getString(2);
		    String opis = rset.getString(3);
		    double cijena = rset.getDouble(4);
		    int idKart = rset.getInt(5);
		    KartaPicaDAO kartaDAO = new KartaPicaDAO();
		    KartaPica kartaPica = kartaDAO.GetKartaPicaById(idKart);
		    
		    pice = new Pice(idPice,naziv,opis,cijena,kartaPica);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return pice;
		 }
	
	
}
