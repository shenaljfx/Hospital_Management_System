<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
<html>
<%@ include file="header.jsp" %>
<body>
		<div class="login-form">
    	<form action="logoutServlet" method="post">
        <h2 class="text-center">Do you want logout?</h2>   
        
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Logout</button>
        </div>     
    	</form>
    	</div>
    
      
     <%@ include file="footer.jsp" %>
       
</body>
</html>