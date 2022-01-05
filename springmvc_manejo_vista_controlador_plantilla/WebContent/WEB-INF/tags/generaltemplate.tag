<!DOCTYPE html>
<%@tag description="generalTemplate" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="nameAplication" required="true"%>
<%@attribute name="date" required="true"%>
<%@attribute name="user"%>
<%@attribute name="messageUser"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="body_area" fragment="true"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="bootstrap/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="bootstrap/styleBootstrapMod.css" rel="stylesheet" media="screen">
		<link href="generalcss/elementsEffects.css" rel="stylesheet" media="screen">
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" media="screen">
		<script src="bootstrap/bootstrap.min.js" type="text/javascript"></script>
		<script src="jquery/jquery.min.js" type="text/javascript"></script>
		<script src="generalajax/containerHandling.js" type="text/javascript"></script>
		<title>${title}</title>
		<jsp:invoke fragment="head_area"/>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand">
						<span class="fa fa-play" aria-hidden="true"></span>${nameAplication}
						<small>${title}</small>
					</a>
				</div>
				<div class="navbar-right container-fluid">
					<h6>Dia ${date} ${messageUser}<strong>${user}</strong></h6>
				</div>
			</div>
		</nav>
		<jsp:invoke fragment="body_area"/>
	</body>
</html>
