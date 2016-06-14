package servletiDejan;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pozovi
 */
public class Pozovi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pozovi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail =request.getParameter("email");
		String ja = request.getParameter("email2");
		String sifra = request.getParameter("sifra");
		
		String idRestoran = request.getParameter("idRestoran");
		String idJelovnik = request.getParameter("idJelovnik");
		String idKarte = request.getParameter("idKarte");
		
		String naziv = request.getParameter("naziv");
		String datum = request.getParameter("datum");
		String vreme = request.getParameter("vreme");
		String sati = request.getParameter("sati");
		String sto = request.getParameter("sto");
		
		final String username = ja;
		final String password = sifra;
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ja));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("Poziv");
			message.setContent("http://localhost:8080/Restoran/verify2.jsp?sto="+sto+"&naziv="+naziv+"&email="+mail+"&datum="+datum+
					"&vreme="+vreme+"&sati="+sati+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran,"text/html;");
			Transport.send(message);
			response.sendRedirect("rezervacijaRestorana3.jsp?sto="+sto+"&naziv="+naziv+"&email="+ja+"&datum="+datum+
					"&vreme="+vreme+"&sati="+sati+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odgovor=1");
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
