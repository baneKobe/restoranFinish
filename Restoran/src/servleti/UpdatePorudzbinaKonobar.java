package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JeloDao;
import dao.PiceDao;
import dao.PorudzbinaDao;
import model.Jelo;
import model.Pice;

/**
 * Servlet implementation class UpdatePorudzbinaKonobar
 */
public class UpdatePorudzbinaKonobar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePorudzbinaKonobar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		int idPorudzbine= Integer.parseInt(request.getParameter("idPorudzbina"));
		String jeloNaziv = request.getParameter("jelo");
		JeloDao jelDao = new JeloDao();
		Jelo jelo = jelDao.GetJeloByNaziv(jeloNaziv);
		int jid = jelo.getIdJelo();
		String piceNaziv = request.getParameter("pice");
		PiceDao picDao = new PiceDao();
		Pice pice = picDao.GetPiceByNaziv(piceNaziv);
		int pid = pice.getIdPice();
		
		
		int kolicinaPica = Integer.parseInt(request.getParameter("kolicinaPica"));
		int kolicinaJela = Integer.parseInt(request.getParameter("kolicinaJela"));
		double cijena = Double.parseDouble(request.getParameter("cijena"));
		PorudzbinaDao porDao = new PorudzbinaDao();
		porDao.UpdatePorudzbina(pice, jelo, kolicinaPica, kolicinaJela, cijena, idPorudzbine);
		response.sendRedirect("UpdatePorudzbinaKonobar.jsp?email="+email+"&izmenjeno=1"+"&id="+idPorudzbine);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
