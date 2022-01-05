<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="javax.servlet.http.*"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<t:generaltemplate date="${date}">

  <jsp:attribute name="body_area"></jsp:attribute>

</t:generaltemplate>

<html>
	

  <body>
  
 <div style="padding: 10px; border: 1px solid gray;">
    <a href="pdf.do">PDF</a>
    <a href="xls.do">XLS</a>
</div>

<div class="container">
  
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
    
    </div>
    
  </body>
  
</html>