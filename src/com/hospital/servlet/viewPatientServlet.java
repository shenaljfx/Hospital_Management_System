package com.hospital.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Patient;
import com.hospital.service.IPatientService;
import com.hospital.service.IPaymentService;
import com.hospital.service.PatientServiceImple;
import com.hospital.service.PaymentServiceImple;

/**
 * Servlet implementation class viewPatientServlet
 */
@WebServlet("/viewPatientServlet")
public class viewPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String patientId = request.getParameter("pid");
		
		IPatientService iPatientService1 = new PatientServiceImple();
		Patient patient = iPatientService1.getPatientByID(patientId);
		
		IPatientService iPatientService2 = new PatientServiceImple();
		String symptom[] = new String[4];
		
		symptom = iPatientService2.getSymptoms(patientId);
		
		IPaymentService iPatientService3 = new PaymentServiceImple();
		String payment[] = new String[4];
		
		payment = iPatientService3.getPaymentDetails(patientId);
		
		request.setAttribute("payment", payment);
		request.setAttribute("symptoms", symptom);
		request.setAttribute("patient", patient);
		
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/patientProfile.jsp");
		rd.forward(request, response);
	}

}
