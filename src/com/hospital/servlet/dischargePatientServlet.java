package com.hospital.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.IPatientService;
import com.hospital.service.IPaymentService;
import com.hospital.service.PatientServiceImple;
import com.hospital.service.PaymentServiceImple;

/**
 * Servlet implementation class dischargePatientServlet
 */
@WebServlet("/dischargePatientServlet")
public class dischargePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dischargePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String patientId = request.getParameter("pid");
		
		IPatientService interface1 = new PatientServiceImple();
		interface1.dischargePatient(patientId);
		
		IPaymentService interface2 = new PaymentServiceImple();
		interface2.deletePatientPayment(patientId);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/listPatient.jsp");
		rd.forward(request, response);
	}

}
