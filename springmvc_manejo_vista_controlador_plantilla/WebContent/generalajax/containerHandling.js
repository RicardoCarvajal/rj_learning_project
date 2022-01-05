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

function callPage(page, cap) {
	var obj = creaAjax();
	var capaContenedora = document.getElementById(cap);
	var url = page;
	obj.open("GET", url, true);

	obj.onreadystatechange = function() {
		if (obj.readyState === 4) {
			if (obj.status === 200) {
				capaContenedora.innerHTML = obj.responseText;
			} else {
				alert("Ha ocurrido un problema en el retorno de datos");
			}
		}

	};

	obj.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	obj.send(null);
}

function pageRedirect(page) {
	window.location=page;
}
