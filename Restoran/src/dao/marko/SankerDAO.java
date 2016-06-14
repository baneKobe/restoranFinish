package dao.marko;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.marko.Sanker;
import util.ConnectionManager;

public class SankerDAO {

	
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
