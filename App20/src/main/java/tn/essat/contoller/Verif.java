package tn.essat.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestion;
import tn.essat.model.Utilisteur;


public class Verif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verif() {
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
		IGestion dao= new GestionImp();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		Utilisteur u=dao.getUser(login, password);
		if(u==null) {
			request.getRequestDispatcher("Principale").forward(request, response);
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			if(u.getRole().equals("admin")) {
				request.getRequestDispatcher("espace_admin.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("espace_user.jsp").forward(request, response);
			}
		}
		
			
	}}