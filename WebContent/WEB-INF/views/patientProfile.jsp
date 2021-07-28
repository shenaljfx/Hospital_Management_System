<%@page import="com.hospital.model.Patient"%>
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
					  <a href="listPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none"> Patient List</a>
					</div>
		      </div>
		      <%
		      	Patient patient = (Patient)request.getAttribute("patient");
		      	String symptom[]  = new String[4];
		      	symptom = (String[])request.getAttribute("symptoms");
		      	
		      	String payment[]  = new String[4];
		      	payment = (String[])request.getAttribute("payment");
		      %>
		      
		      <div class="col-9 w3-light-grey" style = "padding: 15px;border-radius: 10px;">
		      		    <form method="post">
			                <div class="row">
			                    <div class="col-md-6">
			                        <div class="profile-head">
			                                    <h4 class = "text-primary" style = "font-weight: bold;">
			                                        <%out.println(patient.getName());%>
			                                    </h4>
			                                    <h6>
			                                        <%out.println(patient.getWardNo()); %> 
			                                    </h6>
			                                    
			                            <ul class="nav nav-tabs nav-pills" id="myTab" role="tablist">
			                                <li class="nav-item">
			                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
			                                </li>
			                                <li class="nav-item">
			                                    <a class="nav-link" id="symptoms-tab" data-toggle="tab" href="#symptoms" role="tab" aria-controls="symptoms" aria-selected="false">Symptoms</a>
			                                </li>
			                                <li class="nav-item">
			                                    <a class="nav-link" id="Insurance-tab" data-toggle="tab" href="#Insurance" role="tab" aria-controls="Insurance" aria-selected="false">Insurance</a>
			                                </li>
			                            </ul>
			                        </div>
			                    </div>
			                    <div class="col-md-2">
			                        <a href="updatePatient.jsp" class="w3-bar-item w3-button w3-blue" style = "text-decoration: none">Edit Profile</a>
			                    </div>
			                </div>
			                <div class="row">
			                   
			                    <div class="col-md-8">
			                        <div class="tab-content profile-tab" id="myTabContent">
			                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Patient Id</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getPatientId()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Patient Name</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getName()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Gender</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getGender()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Address</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getAddress()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Phone</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getPhoneNumber()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Email</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getEmail()); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Join Date</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(patient.getJoiningDate()); %></p>
			                                            </div>
			                                        </div>
			                            </div>
			                            <div class="tab-pane fade" id="symptoms" role="tabpanel" aria-labelledby="symptoms-tab">
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Symptoms</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(symptom[1]); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Since when</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(symptom[2]); %></p>
			                                            </div>
			                                        </div>
			                                         <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Disease</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(symptom[3]); %></p>
			                                            </div>
			                                        </div> 
			                            </div>
			                            <div class="tab-pane fade" id="Insurance" role="tabpanel" aria-labelledby="Insurance-tab">
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Company</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(payment[1]); %></p>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Policy Number</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(payment[2]); %></p>
			                                            </div>
			                                        </div>
			                                         <div class="row">
			                                            <div class="col-md-6">
			                                                <label>Expire date</label>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <p><%out.println(payment[3]); %></p>
			                                            </div>
			                                        </div> 
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </form>  
		      </div>
		      	
		      </div>
		      
		    </div>
		  </div>
		
<div style = "margin-top:40px;"></div>

<%@ include file="../../footer.jsp" %>
</body>
</html>
