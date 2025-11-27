package tn.essat.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Utilisteur;


public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	HttpSession session= request.getSession();
    	Utilisteur user =(Utilisteur) session.getAttribute("user");
    	if (user==null) {
    		request.getRequestDispatcher("Principal?err=2").forward(request, response);
    		
    	}
		String nom = request.getParameter("nom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		String password2 = BCrypt.hashpw(password, BCrypt.gensalt());
		
		IGestion dao = new GestionImp();
		Utilisteur u = new Utilisteur();
		u.setNom(nom);
		u.setLogin(login);
		u.setPassword(password);
		u.setRole("user");
		
		dao.addUser(u);
		request.getRequestDispatcher ("connexion.jsp").forward(request,response);
				
	}

}
