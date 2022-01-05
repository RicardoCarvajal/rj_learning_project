<!DOCTYPE html>
<%@tag description="generalTemplate" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="date" required="true"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="body_area" fragment="true"%>
<html lang="en">
	<head>
		<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
		<link href="<spring:theme code='stylesheet'/>" rel="stylesheet" media="screen"/>
		<title>Practica</title>
		<jsp:invoke fragment="head_area"/>
	</head>
	<body>
		
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Tabla CR400.CAJA</a>
		      <p class="navbar-text navbar-right">Dia <a href="#" class="navbar-link">${date}</a></p>
		    </div>
		    <ul class="nav navbar-nav navbar-right">
		    	<li><a href=""><strong>Temas</strong></a></li>
        		<li><a href="?mytheme=fushia">Fushia</a></li>
        		<li><a href="?mytheme=alert">Alerta</a></li>
      		</ul>
		  </div>
		</nav>
		
		<script src="/static/jquery/3.2.0/jquery.min.js"></script>
		<script src="/static/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<jsp:invoke fragment="body_area"/> 
	</body>
</html>
