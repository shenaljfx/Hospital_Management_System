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
    	<form action="loginServlet" method="post">
        <h2 class="text-center">Log in</h2>   
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Employee Id" required="required" name = "eid">
        </div>    
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Username" required="required" name = "username">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" required="required" name = "password">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox" name = "remember" vlaue = "remeberme"> Remember me</label>
            
        </div>        
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
	</div>	  
      
     <%@ include file="footer.jsp" %>
       
</body>
</html>