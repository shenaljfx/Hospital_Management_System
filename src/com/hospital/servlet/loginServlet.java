package com.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.model.Login;
import com.hospital.service.ILoginService;
import com.hospital.service.LoginServiceImple;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		String eId = request.getParameter("eid");
		
		Login login  = new Login();
		
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		
		ILoginService interface1 = new LoginServiceImple();
		String type = interface1.loginValidation(login, eId);
		
		
		if(type.equals("receptionist")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", login.getUsername());
			session.setAttribute("link", "Receptionist.jsp");
			response.sendRedirect("Receptionist.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
