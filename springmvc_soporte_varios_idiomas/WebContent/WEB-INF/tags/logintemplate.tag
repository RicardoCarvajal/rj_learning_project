<%@tag description="loginTemplate" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>

  <body>  
    <div class="container">    
      <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
          <form:form action="salida.do" method="post" modelAttribute="usuario">
          
            <div class="form-group">
              <form:label path="nombre" for="nombre"><spring:message code="user_label"></spring:message></form:label>
              <form:input path="nombre" type="text" class="form-control" id="nombre" name="nombre" placeholder="${user_password}" />
              
            </div>
            <div class="form-group">
              <form:label path="clave" for="clave"><spring:message code="pass_label"></spring:message></form:label>
              <form:input path="clave" type="password" class="form-control" id="clave" name="clave" placeholder="${password}" />
              
            </div>
            
            <div class="form-group">
            <form:errors path="*" element="div" class="alert alert-danger " role="alert"/>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block" ><spring:message code="butt_label"></spring:message></button>
            
          </form:form>
          
        </div>
      </div>
    </div>
    
    
    <jsp:invoke fragment="body_area"/>
  </body>
  
</html>
