<%@tag description="generalTemplate" pageEncoding="UTF-8"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="body_area" fragment="true"%>

<!DOCTYPE html>

<html>
	<head>
		<jsp:invoke fragment="head_area"/>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" >
<!-- 		<meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 		<link href="bootstrap/bootstrap.min.css" rel="stylesheet"> -->
<!-- 		<link href="bootstrap/styleBootstrapMod.css" rel="stylesheet"> -->
<!-- 		<link href="generalcss/elementsEffects.css" rel="stylesheet"> -->
<!-- 		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- 		<script src="bootstrap/bootstrap.min.js" type="text/javascript"></script> -->
<!-- 		<script src="jquery/jquery.min.js" type="text/javascript"></script> -->
<!-- 		<script src="generalajax/containerHandling.js" type="text/javascript"></script> -->

		<title>Practica</title>
	</head>
	<body>
	
		<nav class="navbar navbar-light bg-light">
  			<span class="navbar-brand mb-0 h1">Validacion de formularios</span>
		</nav>
		
		<jsp:invoke fragment="body_area"/>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" ></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	</body>
</html>
