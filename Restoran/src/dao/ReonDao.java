package dao;

import model.Konobar;
import model.Reon;
import model.Restoran;
import model.Segment;
import dao.SegmentDao;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReonDao {
public Reon getReonByKonobar(int idKon){
	Reon reon = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from reon where konobar=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idKon);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idReon = rset.getInt(1);
			int idSegment = rset.getInt(2);
			SegmentDao segDao = new SegmentDao();
			Segment segment = segDao.GetSegmentById(idSegment);
			int brojStolova = rset.getInt(3);
			int idKonobar = rset.getInt(4);
			KonobarDao konDao = new KonobarDao();
			Konobar konobar = konDao.GetKonobarById(idKonobar);
			reon = new Reon(idReon, segment, brojStolova, konobar);
		}
	}catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
	return reon;
}
}
