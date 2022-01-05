<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="javax.servlet.http.*"%>

<t:generaltemplate title="${tittle}" date="${message}" nameAplication="${application}">

  <jsp:attribute name="body_area"></jsp:attribute>

</t:generaltemplate>

<t:logintemplate user_password="${user_password}" password="${password}" name_button_login="${name_button_login}"> 
	
	<jsp:attribute name="body_area"></jsp:attribute>
	
</t:logintemplate>

