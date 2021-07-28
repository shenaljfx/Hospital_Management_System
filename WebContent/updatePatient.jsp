<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style>
	body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
	body {font-size:16px;}
	.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
	.w3-half img:hover{opacity:1}
</style>
<html>
<%@ include file="header.jsp" %>
<body>
		<div class="container-fluid">
		   <div class="container-fluid" style =  "margin-top: 50px;">
		    <div class="row no-gutters">
		      <div class="col-3 bg-white">
		        	<div class=" w3-bar-block w3-light-blue w3-card" style="width:200px;margin-top: 10%;;margin-bottom: 10%">
					  
					  
					  <a href="addPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Add Patient</a>
					  <a href="viewPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">View Patient</a>
					  <a href="#" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Update Patient</a>
					  <a href="dischargePatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none">Discharge Patient</a>
					  <a href="listPatient.jsp" class="w3-bar-item w3-button   w3-bottombar w3-hover-border-blue" style="padding-top: 30px;text-decoration:none"> Patient List</a>
					</div>
		      </div>
		      <div class="col-9 w3-light-grey" style = "padding: 15px;border-radius: 10px;">
		      		 <form method = "post" action = "updatePatientServlet">
		      			 
		      			<div class="w3-container w3-blue" style = "width: 20%;height:45px">
						  <h4>Update Patient</h4>
						</div>
						  <div class="form-row">
						  	<div class="col-md-2 mb-3">
						      <label>Patient Id</label>
						      <input type="text" class="form-control" name = "pid" required>
						    </div>
						    <div class="col-md-2 mb-3">
						      <label>Patient Name</label>
						      <input type="text" class="form-control" name = "pName">
						    </div>
						    <div class="col-md-2 mb-3">
						      <label>Address</label>
						      <input type="text" class="form-control"  name = "pAddress">
						    </div>
						   <div class="col-md-2 mb-3">
						      <label>Email</label>
						      <input type="email" class="form-control" name = "pemail">
						    </div>
						    <div class="col-md-2 mb-3">
						      <label>Phone</label>
						      <input type="text" class="form-control"  name = "pmobile">
						    </div>
						  </div>
						 <div class="w3-container w3-blue" style = "width: 20%;height:45px">
							  <h4>Update Ward</h4>
							</div>
						  <div class="form-row">
						     <div class="col-md-2 mb-3">
						      <label>Ward No</label>
						      <select class="custom-select" name = "pward">
						        <option selected disabled value="">Choose...</option>
						        <option value = "W001">1 - Cardiology</option>
						        <option value = "W002">2 - Surgical</option>
						        <option value = "W003">3 - Maternity</option>
						        <option value = "W004">4 - Emergency</option>
						        <option value = "W005">5 - Neurology</option>
						      </select>
						    </div>
						  </div>
						  <div class="w3-container w3-blue" style = "width: 20%;height:45px">
							  <h4>Update Insurance</h4>
							</div>
						  <div class = "form-row">
						  	<div class="col-md-2 mb-3">
						      <label>Company</label>
						      <select class="custom-select" name = "pcompany">
						        <option selected disabled value="">Choose...</option>
						        <option>Janashakthi</option>
						        <option>Union</option>
						        <option>Other</option>
						      </select>
						    </div>
						    <div class="col-md-2 mb-3">
						      <label>Policy No</label>
						      <input type="text" class="form-control"  name = "policy">
						    </div>
						    <div class="col-md-2 mb-3">
						      <label>Expiry Date</label>
						      <input type="date" class="form-control"  name = "expire">
						    </div>
						  </div>
						  
						  <button class="btn btn-primary" type="submit">Update</button>
						</form>
		      		</div>
		      	
		      </div>
		      
		    </div>
		  </div>
		</div>
<div style = "margin-top:40px;"></div>

<%@ include file="footer.jsp" %>
</body>
</html>