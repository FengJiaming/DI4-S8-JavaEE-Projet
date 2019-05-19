<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<div class="container">
    <form class="form-signin" action="add_store" method="post">  
        
        <input type="text" id="Name" class="form-control" placeholder="Name"  autofocus name="Name">
        <input type="email" id="email" class="form-control" placeholder="email" required autofocus name="email">
        
        <input type="text" id="Lattitude" class="form-control" placeholder="Lattitude"  autofocus name="Lattitude">
        <input type="text" id="Longitude" class="form-control" placeholder="Longitude"  autofocus name="Longitude">
        
       
        
        <input type="tel" id="Phone" class="form-control "  placeholder="PhoneNumber"  autofocus name="PhoneNNumber">
        <input type="text" id="Street" class="form-control" placeholder="Street"  autofocus name="Street">
        <input type="text" id="City" class="form-control" placeholder="City"  autofocus name="City">
        <input type="text" id="State" class="form-control" placeholder="State"  autofocus name="State">
        <input type="text" id="name" class="form-control" placeholder="ZipCode"  autofocus name="ZipCode">
        <input type="text" id="Country" class="form-control" placeholder="Country"  autofocus name="Country">
        
        
        
       

        <input type="submit" value="add_store" class="btn btn-lg btn-dark btn-block text-uppercase">  
    </form> 
    <c:if test="${ !empty name }"><p class="alert alert-danger"><c:out value="register failed" /></p></c:if>
</div>

