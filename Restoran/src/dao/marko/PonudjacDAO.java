package dao.marko;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.marko.Ponudjac;
import util.ConnectionManager;



public class PonudjacDAO {

	public Ponudjac getPonudjacByEmailAndPassword(String email,
			String password) {
		Ponudjac ponudjac = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			String selectSQL = "SELECT idPon FROM ponudjac WHERE email = ? AND lozinka = ?";
			PreparedStatement preparedStatement = conn
					.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rset = preparedStatement.executeQuery();

			if (rset.next()) {
				int id = rset.getInt(1);
				ponudjac= new Ponudjac(id, email, password);
			}
			rset.close();
			preparedStatement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ponudjac;
	}

	
	
	
	
	public boolean insertPonudjac(Ponudjac ponudjac) {
		boolean retVal = false;
		try {
			String update = "INSERT INTO ponudjac (imePonudjaca, prezimePonudjaca, nazivKompanije,email ,lozinka,adresa,brojTelefona)" 
					+ " values (?, ?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionManager.getConnection();



			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ponudjac.getIme());
			pstmt.setString(2, ponudjac.getPrezime());
			pstmt.setString(3, ponudjac.getNazivKompanije());
			pstmt.setString(4, ponudjac.getEmail());
			pstmt.setString(5, ponudjac.getPassword());
			pstmt.setString(6, ponudjac.getAdresa());
			pstmt.setString(7, ponudjac.getBrojTelefona());
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
	
	public Ponudjac getPonudjacByID(String id) {
		Ponudjac ponudjac = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idPon,imePonudjaca,prezimePonudjaca,nazivKompanije,email,lozinka,adresa,brojTelefona from ponudjac where idPon=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, id);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int id1 = rset.getInt(1);
				String ime = rset.getString(2);
				String prezime = rset.getString(3);
				String nazivKompanije = rset.getString(4);
				String email = rset.getString(5);
				String password = rset.getString(6);
				String adresa = rset.getString(7);
				String brojTelefona = rset.getString(8);

				ponudjac = new Ponudjac(id1, ime, prezime, nazivKompanije, email, password, adresa,brojTelefona);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ponudjac;
	}
	
	public boolean getUpdatePonudjac(String id, String ime, String prezime, String nazivKompanije, String Email,
			String Adresa, String brojTelefona, String password) {
		boolean retVal = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			String update = "update ponudjac set imePonudjaca=?, prezimePonudjaca=?, nazivKompanije=?, email=?, lozinka=?, adresa=?, brojTelefona=? where idPon=?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, ime);
			pstmt.setString(2, prezime);
			pstmt.setString(3, nazivKompanije);
			pstmt.setString(4, Email);
			pstmt.setString(5, password);
			pstmt.setString(6, Adresa);
			pstmt.setString(7, brojTelefona);
			pstmt.setString(8, id);
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





	public Ponudjac getPonudjacByEmail(String email) {
		Ponudjac ponudjac = null;
		try{
			Connection conn = ConnectionManager.getConnection();
			String update = "select idPon,imePonudjaca,prezimePonudjaca,nazivKompanije,email,lozinka,adresa,brojTelefona from ponudjac where email=?";
			System.out.println(update);
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, email);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()){
				int id1 = rset.getInt(1);
				String ime = rset.getString(2);
				String prezime = rset.getString(3);
				String nazivKompanije = rset.getString(4);
				String email1 = rset.getString(5);
				String password = rset.getString(6);
				String adresa = rset.getString(7);
				String brojTelefona = rset.getString(8);
				
				ponudjac=new Ponudjac( id1,  ime,  prezime,  nazivKompanije,  email1,  password,
						 adresa,  brojTelefona);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ponudjac;
	}
}
