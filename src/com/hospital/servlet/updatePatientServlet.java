package com.hospital.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Patient;
import com.hospital.model.Payment;
import com.hospital.service.IPatientService;
import com.hospital.service.IPaymentService;
import com.hospital.service.PatientServiceImple;
import com.hospital.service.PaymentServiceImple;

/**
 * Servlet implementation class updatePatientServlet
 */
@WebServlet("/updatePatientServlet")
public class updatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Patient patient = new Patient();
		
		String patientId = request.getParameter("pid");
		patient.setName(request.getParameter("pName"));
		patient.setAddress(request.getParameter("pAddress"));
		patient.setEmail(request.getParameter("pemail"));
		patient.setPhoneNumber(request.getParameter("pmobile"));
		patient.setWardNo(request.getParameter("pward"));
		
		IPatientService patientInterface = new PatientServiceImple();
		patientInterface.updatePatient(patientId, patient);
		
		Payment payment = new Payment();
		
		payment.setCompany(request.getParameter("pcompany"));
		payment.setPolicyNo(request.getParameter("policy"));
		payment.setExpireDate(request.getParameter("expire"));
		
		IPaymentService paymentInterface = new PaymentServiceImple();
		paymentInterface.updatePatientPayment(patientId, payment);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/listPatient.jsp");
		rd.forward(request, response);
	}

}
