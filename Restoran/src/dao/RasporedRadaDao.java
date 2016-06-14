package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Konobar;
import model.Kuvar;
import model.RasporedRada;
import model.Sanker;
import dao.KonobarDao;
import util.ConnectionManager;

public class RasporedRadaDao {
public RasporedRada getRasporedRadaKonobar(int idKonobar){
	RasporedRada raspored = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena,"
				+"cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena,"
				+"konobar from rasporedrada where konobar=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idKonobar);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idRasporedRada = rset.getInt(1);
			String ponPoc = rset.getString(2);
			String ponKraj = rset.getString(3);
			String ponSmjena = rset.getString(4);
			String utoPoc = rset.getString(5);
			String utoKraj = rset.getString(6);
			String utoSmjena = rset.getString(7);
			String srePoc = rset.getString(8);
			String sreKraj = rset.getString(9);
			String sreSmjena = rset.getString(10);
			String cetPoc = rset.getString(11);
			String cetKraj = rset.getString(12);
			String cetSmjena = rset.getString(13);
			String petPoc = rset.getString(14);
			String petKraj = rset.getString(15);
			String petSmjena = rset.getString(16);
			String subPoc = rset.getString(17);
			String subKraj = rset.getString(18);
			String subSmjena = rset.getString(19);
			String nedPoc = rset.getString(20);
			String nedKraj = rset.getString(21);
			String nedSmjena = rset.getString(22);
			int idKon = rset.getInt(23);
			KonobarDao konDao = new KonobarDao();
			Konobar konobar = konDao.GetKonobarById(idKon);
			raspored = new RasporedRada(idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena, cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena, konobar);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
	return raspored;
}

public RasporedRada getRasporedRadaKuvar(int idKuvar){
	RasporedRada raspored = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena,"
				+"cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena,"
				+"kuvar from rasporedrada where kuvar=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idKuvar);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idRasporedRada = rset.getInt(1);
			String ponPoc = rset.getString(2);
			String ponKraj = rset.getString(3);
			String ponSmjena = rset.getString(4);
			String utoPoc = rset.getString(5);
			String utoKraj = rset.getString(6);
			String utoSmjena = rset.getString(7);
			String srePoc = rset.getString(8);
			String sreKraj = rset.getString(9);
			String sreSmjena = rset.getString(10);
			String cetPoc = rset.getString(11);
			String cetKraj = rset.getString(12);
			String cetSmjena = rset.getString(13);
			String petPoc = rset.getString(14);
			String petKraj = rset.getString(15);
			String petSmjena = rset.getString(16);
			String subPoc = rset.getString(17);
			String subKraj = rset.getString(18);
			String subSmjena = rset.getString(19);
			String nedPoc = rset.getString(20);
			String nedKraj = rset.getString(21);
			String nedSmjena = rset.getString(22);
			int idKuv = rset.getInt(23);
			KuvarDao kuvDao = new KuvarDao();
			Kuvar kuvar = kuvDao.GetKuvarById(idKuv);
			raspored = new RasporedRada(idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena, cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena, kuvar);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
	return raspored;
}
public RasporedRada getRasporedRadaSanker(int idSanker){
	RasporedRada raspored = null;
	try{
		Connection conn = ConnectionManager.getConnection();
		String query = "select idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena,"
				+"cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena,"
				+"sanker from rasporedrada where sanker=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idSanker);
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()){
			int idRasporedRada = rset.getInt(1);
			String ponPoc = rset.getString(2);
			String ponKraj = rset.getString(3);
			String ponSmjena = rset.getString(4);
			String utoPoc = rset.getString(5);
			String utoKraj = rset.getString(6);
			String utoSmjena = rset.getString(7);
			String srePoc = rset.getString(8);
			String sreKraj = rset.getString(9);
			String sreSmjena = rset.getString(10);
			String cetPoc = rset.getString(11);
			String cetKraj = rset.getString(12);
			String cetSmjena = rset.getString(13);
			String petPoc = rset.getString(14);
			String petKraj = rset.getString(15);
			String petSmjena = rset.getString(16);
			String subPoc = rset.getString(17);
			String subKraj = rset.getString(18);
			String subSmjena = rset.getString(19);
			String nedPoc = rset.getString(20);
			String nedKraj = rset.getString(21);
			String nedSmjena = rset.getString(22);
			int idSank = rset.getInt(23);
			SankerDao sankDao = new SankerDao();
			Sanker sanker = sankDao.GetSankerById(idSank);
			raspored = new RasporedRada(idRasporedRada, ponPoc, ponKraj, ponSmjena, utoPoc, utoKraj, utoSmjena, srePoc, sreKraj, sreSmjena, cetPoc, cetKraj, cetSmjena, petPoc, petKraj, petSmjena, subPoc, subKraj, subSmjena, nedPoc, nedKraj, nedSmjena, sanker);
		}
	}
	catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  }
	return raspored;
}
}
