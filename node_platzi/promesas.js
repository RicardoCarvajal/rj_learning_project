///Inicio de declaracion
function hola(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Hola, ${nombre}`);
            resolve(nombre);
        }, 1500);
    });

}

function hablar(nombre) {
    return new Promise((resolve,reject) => {
        setTimeout(() => {
            console.log("Taca taca taca taca....");
            resolve(nombre);
            //reject("Reventando");
        }, 1000);
    });
}

function chao(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Chao, ${nombre}`);
            resolve();
        }, 1000);
    });
}

///Inicio de llamado
console.log("Iniciando proceso");

hola("Ricardo")
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(chao)
    .then(() => {console.log(`Terminando proceso`);})
    .catch(error => {
        console.error("Fatal error");
        console.error(error);
    })

