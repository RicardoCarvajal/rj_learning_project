function generar() {
    console.log("Inicio de funcion");
    try {
        generaError();
    } catch (error) {
        console.log(error.message);
        console.log("Se rompio funcion");
    }
    console.log("Fin de funcion");
}

function generaError() {
    return 3 + z;
}


function generaErrorAsincrono() {
    setTimeout(() => {
        try {
            return 3 + z;
        } catch (error) {
            console.log(error.message);
            console.log("Se rompio funcion asincrona");
        }
    }, 3000);
}


console.log("Inicio de proceso");
try {
    generar();
    generaErrorAsincrono();
} catch (error) {
    console.log(error.message);
    console.log("Se rompio");
}
console.log("Fin de proceso");