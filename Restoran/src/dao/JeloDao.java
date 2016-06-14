package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Jelo;
import model.Jelovnik;
import util.ConnectionManager;

public class JeloDao {

public Jelo GetJeloById(int id){
	Jelo jelo = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from jelo where idJelo=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idJelo = rset.getInt(1);
			String naziv = rset.getString(2);
			String opis = rset.getString(3);
			double cijena = rset.getDouble(4);
			int idJelovnik = rset.getInt(5);
			JelovnikDAO jelDao = new JelovnikDAO();
			Jelovnik jelovnik = jelDao.GetJelovnikById(idJelovnik);
			jelo = new Jelo(idJelo, naziv, opis, cijena, jelovnik);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return jelo;
}

public Jelo GetJeloByNaziv(String naz){
	Jelo jelo = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from jelo where naziv=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, naz);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idJelo = rset.getInt(1);
			String naziv = rset.getString(2);
			String opis = rset.getString(3);
			double cijena = rset.getDouble(4);
			int idJelovnik = rset.getInt(5);
			JelovnikDAO jelDao = new JelovnikDAO();
			Jelovnik jelovnik = jelDao.GetJelovnikById(idJelovnik);
			jelo = new Jelo(idJelo, naziv, opis, cijena, jelovnik);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return jelo;
}
}
