<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/custom.css">

    <title>MEDIPLUS HOSPITALS</title>
  </head>


<div class="w3-containert">
      <div style = "" class="w3-bar w3-border w3-blue">
      	<%
      		String user = (String)session.getAttribute("username");
      		
      		if(user != null && !user.isEmpty()){ %>
      			<a href="logout.jsp" style = "float:right" class="w3-bar-item w3-button nav-link">Logged@<%out.println(user); %></a>
       		<%}else{ %>
      			<a href="login.jsp" style = "float:right" class="w3-bar-item w3-button nav-link">SIGN IN</a>
      			
      		<%} %>
      		
      	
      	
      </div>
    </div>

    <div class="w3-bar w3-white w3-wide w3-padding w3-card">
      <p class="w3-bar-item nav-link" style="font-size:30px">Mediplus</p>
   <!-- Float links to the right. Hide them on small screens -->
       <div class="w3-right w3-hide-small" style="font-size:18px">
           <a href="index.jsp" class="w3-bar-item w3-button nav-link">Home</a>
           <a href="#about" class="w3-bar-item w3-button nav-link">About</a>
           <a href="#Department" class="w3-bar-item w3-button nav-link">Department</a>
           <a href="#Doctors" class="w3-bar-item w3-button nav-link">Doctor</a>
           
           <%
           	String link = (String)session.getAttribute("link");
           
           	if(link != null && !link.isEmpty()){ %>
           		<a href="<%out.println(link); %>" style = "float:right" class="w3-bar-item w3-button nav-link">My Portal</a>
           	<%} %>
           
           
       </div>
    </div>