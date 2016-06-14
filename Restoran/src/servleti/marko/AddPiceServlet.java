package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KartaPicaDAO;
import model.marko.KartaPica;
import model.marko.Pice;

/**
 * Ovaj servlet mi treba kako ne bih morao da prikazujem listu karti pica pri ubacivanju nove karte pica, njega treba izmeniti...
 */
public class AddPiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nazivPica = request.getParameter("nazivPica");
		System.out.println(nazivPica);
		String opis = request.getParameter("opis");
		System.out.println(opis);
		String price = request.getParameter("cena");
		System.out.println(price);
		String email = request.getParameter("email");
		double cena = Double.parseDouble(price);
		
		String naziv = request.getParameter("labela");
		System.out.println(naziv);
		KartaPicaDAO kartDAO = new KartaPicaDAO();
		KartaPica karta = kartDAO.GetKartaPicaIDbyNaziv(naziv);
		Pice pice = new Pice(nazivPica,opis,cena,karta);
		KartaPicaDAO kartaDAO = new KartaPicaDAO();
		kartaDAO.insertPice(pice);
		response.sendRedirect("UnosPica.jsp?email="+email);
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