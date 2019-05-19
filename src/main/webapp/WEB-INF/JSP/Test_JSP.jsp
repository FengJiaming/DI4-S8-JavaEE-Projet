<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<div class="container-fluid">
    <div class="text-center">           
      <div class="col-lg-6">
        <h2>Password show / hide click</h2> 
        <div class="input-group">
          <input type="password" class="form-control pwd" value="iamapassword">
          <span class="input-group-btn">
            <button class="btn btn-default reveal" type="button">
                <i class="glyphicon glyphicon-eye-open"></i>
            </button>
          </span>          
        </div>
      </div>
    </div>  
    <div class="container-fluid"><br/>
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert"
                  aria-label="close">×</a>
                <strong>Success!</strong> It is working as we expected.
            </div>
        
        <p>Heart icon: <span class="glyphicon glyphicon-heart"></span></p>  
        
        
            
        </div>
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


    
</div>
