package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.JelovnikDAO;
import model.marko.Jelo;
import model.marko.Jelovnik;

/**
 * Ovaj servlet mi treba kako ne bih morao da prikazujem listu karti pica pri ubacivanju nove karte pica, njega treba izmeniti...
 */
public class JeloAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JeloAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nazivJela = request.getParameter("nazivJela");
		System.out.println(nazivJela);
		String opis = request.getParameter("opis");
		System.out.println(opis);
		String price = request.getParameter("cena");
		String email = request.getParameter("email");
		System.out.println(price);
		double cena = Double.parseDouble(price);
		
		String naziv = request.getParameter("labela");
		System.out.println(naziv);
		JelovnikDAO jelDAO = new JelovnikDAO();
		Jelovnik jelovnik = jelDAO.GetJelovnikIDbyNaziv(naziv);
		Jelo jelo = new Jelo(nazivJela,opis,cena,jelovnik);
		JelovnikDAO jeloDAO = new JelovnikDAO();
		jeloDAO.insertJelo(jelo);
		response.sendRedirect("UnosJelo.jsp?email="+email);
		System.out.println("insert");
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