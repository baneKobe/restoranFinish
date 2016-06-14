package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.KartaPica;
import model.Pice;
import util.ConnectionManager;

public class PiceDao {

public Pice GetPiceById(int id){
	Pice pice = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from pice where idPice=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idPice = rset.getInt(1);
			String naziv = rset.getString(2);
			String opis = rset.getString(3);
			double cijena = rset.getDouble(4);
			int idKarte = rset.getInt(5);
			KartaPicaDAO karDao = new KartaPicaDAO();
			KartaPica karta = karDao.GetKartaPicaById(idKarte);
			pice = new Pice(idPice, naziv, opis, cijena, karta);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return pice;
}
public Pice GetPiceByNaziv(String naz){
	Pice pice = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from pice where naziv=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, naz);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idPice = rset.getInt(1);
			String naziv = rset.getString(2);
			String opis = rset.getString(3);
			double cijena = rset.getDouble(4);
			int idKarte = rset.getInt(5);
			KartaPicaDAO karDao = new KartaPicaDAO();
			KartaPica karta = karDao.GetKartaPicaById(idKarte);
			pice = new Pice(idPice, naziv, opis, cijena, karta);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
		  return pice;
}
}
