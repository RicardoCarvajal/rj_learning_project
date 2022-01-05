<%@tag description="loginTemplate" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="user_password" required="true"%>
<%@attribute name="password" required="true"%>
<%@attribute name="name_button_login" required="true"%>

<html>

  <body>
  
    <div class="container">    
      <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
          <form action="consultController.do" method="post">
            <div class="form-group">
              <label for="user">${user_password}</label>
              <input type=text class="form-control" id="user" name="user" placeholder="${user_password}" required>
            </div>
            <div class="form-group">
              <label for="pass">${password}</label>
              <input type="password" class="form-control" id="pass" name="pass" placeholder="${password}" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block" >${name_button_login}</button>
          </form>
        </div>
      </div>
    </div>
    
    <jsp:invoke fragment="body_area"/>
    
  </body>
  
</html>
