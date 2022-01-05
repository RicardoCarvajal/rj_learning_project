<%@tag description="seeform" pageEncoding="UTF-8"%>
<%@attribute name="body_area" fragment="true"%>
<%@attribute name="cajaList" required="true"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

  <body>
  
    <table class="table">
    	
    	<thead>
    		<tr>
    			<th scope="col">ID</th>
    			<th scope="col">IP</th>
    			<th scope="col">TIPO</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    		<core:forEach var="caja" items="${cajaList}">
	    		<tr>
	    			<th scope="row">${caja.id}</th>
	    			<td>${caja.ip}</td>
	    			<td>${caja.tipoCaja}</td>
	    		</tr>
    		</core:forEach>
    	</tbody>
    	
    </table>
    
    <jsp:invoke fragment="body_area"/>
    
  </body>
  
</html>
