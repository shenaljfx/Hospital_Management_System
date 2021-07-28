<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp" %>
<body>
	<center>
	 <div class="card-deck" style = "width: 80%;padding:50px;">
         <div class="card bg-white" style = "border-style:none">
          <img class="card-img-top image" src="images/img14.jpg" alt="Card image" style="width:100%;border-radius:400px;">
          <div class="card-body text-center">
            <a href="addPatient.jsp" class="btn btn-primary middle">Patient Admission</a>
            <h4 class="card-title"><b>Patient Admission</b></h4>
          </div>
        </div>
        <div class="card bg-white" style = "border-style:none">
          <img class="card-img-top image" src="images/img13.png" alt="Card image" style="width:100%;border-radius:400px;">
          <div class="card-body text-center">
            <a href="#" class="btn btn-primary middle">Make Appointment</a>
            <h4 class="card-title"><b>Make Appointment</b></h4>
          </div>
        </div>
      </div> 
      </center>
      
     <%@ include file="footer.jsp" %>
       
</body>
</html>