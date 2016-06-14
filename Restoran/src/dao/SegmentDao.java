package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Restoran;
import model.Segment;
import util.ConnectionManager;

public class SegmentDao {

public Segment GetSegmentById(int id){
	Segment segment = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from segment where idSegment=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idSegment = rset.getInt(1);
			String naziv = rset.getString(2);
			int idRestoran = rset.getInt(3);
			RestoranDao resDao = new RestoranDao();
			Restoran restoran = resDao.GetRestoranById(idRestoran);
			segment = new Segment(idSegment, naziv, restoran);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return segment;
}
}
