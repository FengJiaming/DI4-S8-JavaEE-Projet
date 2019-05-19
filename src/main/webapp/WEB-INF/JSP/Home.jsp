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
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head> 
    <body> 
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>" >Home</a>
	  <ul class="nav navbar-nav">
              <li class="nav-item ">
                    <a class="nav-link " href=<%=request.getContextPath()+"/view_store"%>>stores</a>
                    
             </li>
            <c:if test="${sessionScope.name == null}">
                <li class="nav-item " >
                  <a class="nav-link" href="<%=request.getContextPath()+"/login"%>">login</a>
                </li>
            </c:if>
	    
             <li class="nav-item ">
                    <a class="nav-link " href=<%=request.getContextPath()+"/register"%>>register</a>
                    
             </li>
             <li class="nav-item ">
                    <a class="nav-link " ><c:out value="<%=request.getSession().getAttribute("name")%>" /></a>
                    
             </li>
             <c:if test="${sessionScope.name != null}">
             <li class="nav-item ">
                     <a class="nav-link " href=<%=request.getContextPath()+"/logout"%>>logout</a>
                      
             </li>
            </c:if>
             <li class="nav-item ">
                    <a class="nav-link " href=<%=request.getContextPath()+"/test"%>>test</a>
                    
             </li>
             
	  </ul>
            
	</nav>
    </body>
</html>
