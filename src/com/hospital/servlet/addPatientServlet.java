package com.hospital.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.ElectiveAdmitPatient;
import com.hospital.model.EmergencyPatient;
import com.hospital.model.Patient;
import com.hospital.model.Payment;
import com.hospital.service.IPatientService;
import com.hospital.service.IPaymentService;
import com.hospital.service.PatientServiceImple;
import com.hospital.service.PaymentServiceImple;

/**
 * Servlet implementation class addPatientServlet
 */
@WebServlet("/addPatientServlet")
public class addPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		if(request.getParameter("type").equals("Emergency")) {
			EmergencyPatient patient = new EmergencyPatient();
			
			//patient basic details
			patient.setName(request.getParameter("pName"));
			patient.setAddress(request.getParameter("pAddress"));
			patient.setDOB(request.getParameter("pdob"));
			patient.setGender(request.getParameter("gender"));
			patient.setEmail(request.getParameter("pemail"));
			patient.setJoiningDate(request.getParameter("pjoindate"));
			patient.setPhoneNumber(request.getParameter("pmobile"));
			patient.setWardNo(request.getParameter("pward"));
			
			//speficfic emergency patient details 
			patient.setCondition(request.getParameter("pcondition"));
			patient.setEmergencyType(request.getParameter("etype"));
			
			
			//patient symptoms
			patient.setSymptoms(request.getParameter("psymtoms"));
			patient.setSinceWhen(request.getParameter("sdate"));
			patient.setDisease(request.getParameter("pdisease"));
			
			IPatientService PServiceinterface = new PatientServiceImple();
			PServiceinterface.addPatient(patient);
						
			String pid = patient.getPatientId();
			Payment payment = new Payment();
			payment.setCompany(request.getParameter("pcompany"));
			payment.setPolicyNo(request.getParameter("policy"));
			payment.setExpireDate(request.getParameter("expire"));
			
			IPaymentService PServiceinterface2 = new PaymentServiceImple();
			PServiceinterface2.addPatientPayment(payment, pid);
			
			request.setAttribute("patient", patient);
			request.setAttribute("payment", payment);
		}else{
			ElectiveAdmitPatient patient = new ElectiveAdmitPatient();
			
			//patient basic details
	  		patient.setName(request.getParameter("pName"));
			patient.setAddress(request.getParameter("pAddress"));
			patient.setDOB(request.getParameter("pdob"));
			patient.setGender(request.getParameter("gender"));
			patient.setEmail(request.getParameter("pemail"));
			patient.setJoiningDate(request.getParameter("pjoindate"));
			patient.setPhoneNumber(request.getParameter("pmobile"));
			patient.setWardNo(request.getParameter("pward"));
			
			//specific Elective Admit Patient details
			patient.setReason(request.getParameter("preason"));
			patient.setDoctorName(request.getParameter("pdoctor"));
			patient.setWardType(request.getParameter("wtype"));
			
			//patient symptoms
			patient.setSymptoms(request.getParameter("psymtoms"));
			patient.setSinceWhen(request.getParameter("sdate"));
			patient.setDisease(request.getParameter("pdisease"));
			
			IPatientService PServiceinterface1 = new PatientServiceImple();
			PServiceinterface1.addPatient(patient);
			
			String pid = patient.getPatientId();
			Payment payment = new Payment();
			payment.setCompany(request.getParameter("pcompany"));
			payment.setPolicyNo(request.getParameter("policy"));
			payment.setExpireDate(request.getParameter("expire"));
			
			IPaymentService PServiceinterface2 = new PaymentServiceImple();
			PServiceinterface2.addPatientPayment(payment, pid);
			
			request.setAttribute("patient", patient);
			request.setAttribute("payment", payment);
		}
		
		
		
		
   		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/listPatient.jsp");
		dispatcher.forward(request, response);
	}
	

}
