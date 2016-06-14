package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Segment;
import model.Sto;
import util.ConnectionManager;

public class StoDao {

public Sto GetStoById(int id){
	Sto sto = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from sto where idSto=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idSto = rset.getInt(1);
			int idSegment = rset.getInt(2);
			SegmentDao segDao = new SegmentDao();
			Segment segment = segDao.GetSegmentById(idSegment);
			sto = new Sto(idSto, segment);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return sto;
}
}
