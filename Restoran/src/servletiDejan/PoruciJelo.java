package servletiDejan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.JelovnikDAO;
import klaseDejan.PorudzbinaJ;

/**
 * Servlet implementation class PoruciJelo
 */
public class PoruciJelo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoruciJelo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String nazivR = request.getParameter("naziv");
		String nazivJ = request.getParameter("nazivJela1");
		String datum = request.getParameter("datum");
		String vreme = request.getParameter("vreme");
		String sati = request.getParameter("sati");
		String sto = request.getParameter("sto");
		
		String idRestoran = request.getParameter("idRestoran");
		String idJelovnik = request.getParameter("idJelovnik");
		String idKarte = request.getParameter("idKarte");
		String ja = request.getParameter("ja");
		
		JelovnikDAO jelovnikDAO = new JelovnikDAO();
		PorudzbinaJ pj = new PorudzbinaJ(nazivR, nazivJ, datum, vreme, sati, sto);
		jelovnikDAO.poruciJelo(pj);
		
		response.sendRedirect("rezervacijaRestorana4.jsp?naziv="+nazivR+"&email="+email+"&datum="+datum+
				"&vreme="+vreme+"&sati="+sati+"&sto="+sto+"&ja="+ja+"&idJelovnik="+idJelovnik+"&idKarte="+idKarte+
				"&idRestoran="+idRestoran+"&odgovor=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
