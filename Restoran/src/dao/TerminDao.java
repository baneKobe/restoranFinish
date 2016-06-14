package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Korisnik;
import model.Segment;
import model.Sto;
import model.Termin;
import util.ConnectionManager;

public class TerminDao {

public Termin GetTerminById(int id){
	Termin termin = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from termin where idTermin=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idTermin = rset.getInt(1);
			String datum = rset.getString(2);
			String vrijeme = rset.getString(3);
			String trajanje = rset.getString(4);
			int idKorisnik = rset.getInt(5);
			KorisnikDAO korDao = new KorisnikDAO();
			Korisnik korisnik = korDao.GetKorisnikById(idKorisnik);
			int idSegment = rset.getInt(6);
			SegmentDao segDao = new SegmentDao();
			Segment segment = segDao.GetSegmentById(idSegment);
			int idSto = rset.getInt(7);
			StoDao stoDao = new StoDao();
			Sto sto = stoDao.GetStoById(idSto);
			termin = new Termin(idTermin, datum, vrijeme, trajanje, korisnik, segment, sto);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return termin;
}
}
