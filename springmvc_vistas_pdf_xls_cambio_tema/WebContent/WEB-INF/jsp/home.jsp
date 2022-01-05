<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generaltemplate date="${date}">

  <jsp:attribute name="body_area"></jsp:attribute>

</t:generaltemplate>

<div class="container">

	<h1 class="display-1">Bienvenido</h1>
	    
	<a href="viewTableController.do" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Ingresar</a>
	
</div>
