package dao.marko;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.marko.Kuvar;
import util.ConnectionManager;

public class KuvarDAO {

	
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
