package tn.essat.contoller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisteur;

/**
 * Servlet implementation class Emprunterlv
 */
public class Emprunterlv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emprunterlv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

    	HttpSession session= request.getSession();
    	Utilisteur user =(Utilisteur) session.getAttribute("user");
    	if (user==null) {
    		request.getRequestDispatcher("Principal?err=2").forward(request, response);
    		
    	}
        int id = Integer.parseInt(request.getParameter("id"));
        IGestion dao = new GestionImp();
        Livre lv = dao.getLivreById(id);
        LocalDate d = LocalDate.now();
        Emprunt em = new Emprunt();
        em.setLv(lv);
        em.setDate_emprunt(d);
        em.setUser(user);

        dao.addEmprunt(em);

        request.getRequestDispatcher("PreCat").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
