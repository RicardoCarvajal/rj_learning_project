<%@tag description="loginTemplate" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="user_password" required="true"%>
<%@attribute name="password" required="true"%>
<%@attribute name="name_button_login" required="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

  <body>  
    <div class="container">    
      <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
          <form:form action="salida.do" method="post" modelAttribute="usuario">
          
            <div class="form-group">
              <form:label path="nombre" for="nombre">${user_password}</form:label>
              <form:input path="nombre" type="text" class="form-control" id="nombre" name="nombre" placeholder="${user_password}" />
              
            </div>
            <div class="form-group">
              <form:label path="clave" for="clave">${password}</form:label>
              <form:input path="clave" type="password" class="form-control" id="clave" name="clave" placeholder="${password}" />
              
            </div>
            
            <div class="form-group">
            <form:errors path="*" element="div" class="alert alert-danger " role="alert"/>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" >${name_button_login}</button>
            
          </form:form>
          
        </div>
      </div>
    </div>
    
    
    <jsp:invoke fragment="body_area"/>
  </body>
  
</html>
