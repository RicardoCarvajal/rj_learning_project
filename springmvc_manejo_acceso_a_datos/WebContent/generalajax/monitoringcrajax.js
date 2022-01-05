function creaAjax() {
	var objetoAjax = false;
	try {
		/* Para navegadores distintos a internet explorer */
		objetoAjax = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			/* Para explorer */
			objetoAjax = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			objetoAjax = false;
		}
	}

	if (!objetoAjax && typeof XMLHttpRequest !== 'undefined') {
		objetoAjax = new XMLHttpRequest();
	}
	return objetoAjax;
}


function callPageMonitoringCR(page, cap) {
	var object = creaAjax();
	var country = cap.substring(3,5);
	var store = cap.substring(5);
	var capaContenedora = document.getElementById(cap);
	var capaContenedoraload = document.getElementById(cap+"load");
	var url = page + "?country=" + country + "&store=" + store;
	object.open("GET", url, true);
	
	capaContenedoraload.innerHTML = '<h2> <span class="fa fa-refresh loader" aria-hidden="true"></span> Tienda '+store+' </h2>'
		
	object.onreadystatechange = function() {
		if (object.readyState === 4) {

			if (object.status === 200) {
				capaContenedoraload.innerHTML = '<h2> <span class="fa fa-university" aria-hidden="true"></span> Tienda '+store+' </h2>'
				capaContenedora.innerHTML = object.responseText;
			} else {
				alert("Ha ocurrido un problema en el retorno de datos");
			}
		}

	};

	object.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	object.send(null);
}

function callPageMonitoringCRAll(contenedor, stores) {
	var seconds = 1000;
	var country = contenedor.substring(3);
	if (country === "CR") {
		for (var i = 4; i <= stores; i++) {
			setTimeout("callPageMonitoringCR('monitoring.jsp','"
					+ contenedor + i + "')",
					seconds += 3000);
		}
	} else {
		for (var e = 2; e <= stores; e++) {
			setTimeout("callPageMonitoringCR('monitoring.jsp','"
					+ contenedor + e + "')",
					seconds += 3000);
		}
	}
}