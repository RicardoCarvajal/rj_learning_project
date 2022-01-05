<%@tag description="seeform" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="pos_number_label" required="true"%>
<%@attribute name="name_button_seeform" required="true"%>

<html>

  <body>
  
    <div class="container">    
      <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
          <form action="resultadoConsultaController.do" method="post">
            <div class="form-group">
              <label for="user">${pos_number_label}</label>
              <input type=text class="form-control" id="number" name="number" placeholder="${pos_number_label}" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block" >${name_button_seeform}</button>
          </form>
        </div>
      </div>
    </div>
    
    <jsp:invoke fragment="body_area"/>
    
  </body>
  
</html>
