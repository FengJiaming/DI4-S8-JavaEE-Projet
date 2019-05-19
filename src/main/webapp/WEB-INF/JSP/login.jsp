<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="row">
      <div class=" mx-auto">
            <div class="card-body">
                <h5 class="card-title text-center">Sign In</h5>
                <form class="form-signin" action="login" method="post" >
                  <div class="form-label-group">
                    <input type="email" id="inputlogin" class="form-control" placeholder="login" required autofocus name="email">
                    <label for="inputlogin">login</label>
                  </div>

                  <div class="form-label-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
                    <label for="inputPassword">Password</label>
                  </div>

                 
                  <button class="btn btn-lg btn-dark btn-block text-uppercase" type="submit">Sign in</button>
                  <hr class="my-4">
                </form>
                <c:if test="${ !empty name }"><p class="alert alert-danger"><c:out value="login or password doesn't exist" /></p></c:if>
            </div>
      </div>
</div>