<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="javax.servlet.http.*"%>

<t:generaltemplate title="${tittle}" date="${message}" nameAplication="${application}">

  <jsp:attribute name="body_area"></jsp:attribute>

</t:generaltemplate>

<t:seeform name_button_seeform="${name_button_seeform}" pos_number_label="${pos_number_label}"></t:seeform>