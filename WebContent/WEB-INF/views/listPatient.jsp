<%@page import="com.hospital.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hospital.service.PatientServiceImple"%>
<%@page import="com.hospital.service.IPatientService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
	body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
	body {font-size:16px;}
	.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
	.w3-half img:hover{opacity:1}
</style>
<html>
<%@ include file="../../header.jsp" %>
<body>
		<div class="container-fluid">
		   <div class="container-fluid" style =  "margin-top: 50px;">
		    <div class="row no-gutters">
		      <div class="col-3 bg-white">
		        	<div class=" w3-bar-block w3-light-blue w3-card" style="width:200px;margin-top: 10%;;margin-bottom: 10%">
					  
					  
					  <a href="addPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Add Patient</a>
					  <a href="viewPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">View Patient</a>
					  <a href="updatePatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Update Patient</a>
					  <a href="dischargePatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Discharge Patient</a>
					  <a href="#" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none"> Patient List</a>
					</div>
		      </div>
		      <div class="col-9 w3-light-grey" style = "padding: 15px;border-radius: 10px;height: 700px;">
					<table class="table table-striped">
					    <thead>
					      <tr>
					        <th>ID</th>
					        <th>Name</th>
					        <th>Address</th>
					        <th>DOB</th>
					        <th>Gender</th>
					        <th>Email</th>
					        <th>Join Date</th>
					        <th>Phone Number</th>
					      </tr>
					    </thead>
					     <%
				            IPatientService iPatientService = new PatientServiceImple();
							ArrayList<Patient> arrayList = iPatientService.getPatients();
							
							for(Patient patient : arrayList){
						%>
					    <tbody>
					      <tr>
					        <td><%=patient.getPatientId() %></td>
					        <td><%=patient.getName() %></td>
					        <td><%=patient.getAddress() %></td>
					        <td><%=patient.getDOB() %></td>
					        <td><%=patient.getGender() %> </td>
					        <td><%=patient.getEmail() %></td>
					        <td><%=patient.getJoiningDate() %></td>
					        <td><%=patient.getPhoneNumber() %></td>
					        <td> 
								<form method="POST" action="viewPatientServlet">
								<input type="hidden" name="pid" value="<%=patient.getPatientId() %>"/>
								 <input type="submit" value= "Select Patient" /> 
								 </form>
							</td>	
					      </tr>
					     </tbody>
					  <% } %>  
					  </table>						
		      </div>
		      	
		      </div>
		      
		    </div>
		  </div>
		
<div style = "margin-top:40px;"></div>

<%@ include file="../../footer.jsp" %>
</body>
</html>