package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JeloDao;
import dao.KonobarDao;
import dao.PiceDao;
import dao.PorudzbinaDao;
import dao.RacunDao;
import dao.RestoranDao;
import model.Jelo;
import model.Konobar;
import model.Pice;
import model.Porudzbina;
import model.Racun;
import model.Restoran;

/**
 * Servlet implementation class InsertRacun
 */
public class InsertRacun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRacun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		int idJelo = Integer.parseInt(request.getParameter("jelo"));
		JeloDao jelDao = new JeloDao();
		Jelo jelo = jelDao.GetJeloById(idJelo);
		int idPice = Integer.parseInt(request.getParameter("pice"));
		PiceDao picDao = new PiceDao();
		Pice pice = picDao.GetPiceById(idPice);
		int idKonobar = Integer.parseInt(request.getParameter("konobar"));
		KonobarDao konDao = new KonobarDao();
		Konobar konobar = konDao.GetKonobarById(idKonobar);
		int idRestoran = Integer.parseInt(request.getParameter("restoran"));
		RestoranDao resDao = new RestoranDao ();
		Restoran restoran = resDao.GetRestoranById(idRestoran);
		int idPorudzbine = Integer.parseInt(request.getParameter("idPorudzbina"));
		PorudzbinaDao porDao = new PorudzbinaDao();
		Porudzbina porudzbina = porDao.getPorudzbinaById(idPorudzbine);
		porDao.OdstampanRacun(idPorudzbine);
		double cijena = Double.parseDouble(request.getParameter("cijena"));
		Racun racun = new Racun(jelo, pice, konobar, restoran, porudzbina, cijena);
		RacunDao racDao = new RacunDao();
		racDao.insertRacun(racun);
		response.sendRedirect("FormiranjeRacuna.jsp?email="+email);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
