package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.PonudaDAO;
import dao.marko.PonudjacDAO;
import model.marko.Ponuda;
import model.marko.Ponudjac;

/**
 * Servlet implementation class SacuvajOdabraneServlet
 */
public class SacuvajOdbijeneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajOdbijeneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNamirnice = request.getParameter("idNamirnice");
		
		PonudaDAO ponudaDAO = new PonudaDAO();
		Ponuda ponuda = ponudaDAO.getPonuda(idNamirnice);
		
		
		String naziv = ponuda.getNaziv();
		String cena= ponuda.getCena();
		String kolicina = ponuda.getKolicina();
		String email= request.getParameter("email");
		request.getRequestDispatcher("NeodabranePonude.jsp?naziv="+naziv+"&cena="+cena+"&kolicina="+kolicina+"&email="+email).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
