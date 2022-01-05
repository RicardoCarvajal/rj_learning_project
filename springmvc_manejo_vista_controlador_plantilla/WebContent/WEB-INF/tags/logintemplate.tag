<%@tag description="loginTemplate" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="hidden"%>
<%@attribute name="indication"%>

<html>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
          <form action="session.jsp" method="post">
            <div class="form-group">
              <label for="user">Usuario</label>
              <input type=text class="form-control" id="user" name="user" placeholder="Usuario" required>
            </div>
            <div class="form-group">
              <label for="pass">Contraseña</label>
              <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña" required>
            </div>
            <div class="form-group">
              <div class="alert " role="alert" ${hidden}> <strong>Ups!</strong> ${indication}</div>
            </div>
            <button type="submit" class="btn btn-primary btn-block" >Ingresar</button>
          </form>
        </div>
      </div>
    </div>
    <jsp:invoke fragment="body_area"/>
  </body>
</html>
