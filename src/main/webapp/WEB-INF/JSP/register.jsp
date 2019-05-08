<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <form class="form-signin" action="register" method="post">  
    <input type="text" id="LastName" class="form-control" placeholder="LastName" required autofocus name="LastName">
    <input type="text" id="firstname" class="form-control" placeholder="FirstName" required autofocus name="FirstName">
    <input type="tel" id="Phone" class="form-control "  placeholder="PhoneNumber" required autofocus name="PhoneNNumber">
    <input type="text" id="Street" class="form-control" placeholder="Street" required autofocus name="Street">
    <input type="text" id="City" class="form-control" placeholder="City" required autofocus name="City">
    <input type="text" id="State" class="form-control" placeholder="State" required autofocus name="State">
    <input type="text" id="name" class="form-control" placeholder="ZipCode" required autofocus name="ZipCode">
    <input type="text" id="Country" class="form-control" placeholder="Country" required autofocus name="Country">
    <input type="text" id="Password" class="form-control" placeholder="Password" required autofocus name="Password">
    <input type="email" id="email" class="form-control" placeholder="email" required autofocus name="email">
    
    <input type="submit" value="register" class="btn btn-lg btn-dark btn-block text-uppercase">  
    </form> 
    <c:if test="${ !empty name }"><p class="alert alert-danger"><c:out value="register failed" /></p></c:if>
</div>
