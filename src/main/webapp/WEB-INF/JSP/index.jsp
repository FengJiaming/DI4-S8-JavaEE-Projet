<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" /> 
<!DOCTYPE html> 

<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>application</title> 
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" /> 
        <script src="${cp}/resources/js/js.js"></script> 
        
        <link rel='stylesheet' type="text/css" href='${cp}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
        <script src="${cp}/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head> 
    <body> 
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-up">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>" >Home</a>
	  <ul class="navbar-nav float-right">
	    <li class="nav-item " >
	      <a class="nav-link" href="<%=request.getContextPath()+"/login"%>">login</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()+"/register"%>">register</a>
	    </li>
	  </ul>
	</nav>
        <div class="container"><br/>
            <div class="alert alert-success">         
                <strong>Success!</strong> It is working as we expected.
            </div>
            <h1>${cp}</h1> 
            <h4>Spring 5 Web MVC via Annotations</h4> 
            Spring says: <span class="blue">${msg}</span> 
            User id: <span class="blue">${userId}</span> 
            User name: <span class="blue">${userName}</span> 
            <br /> 
            <br /> 
            <a href="javascript:void(0)" onclick="test()">Click to test JS</a> 
            
        </div>
    </body> 
</html>