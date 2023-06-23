///Inicio de declaracion
async function hola(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Hola, ${nombre}`);
            resolve(nombre);
        }, 1500);
    });

}

async function hablar(nombre) {
    return new Promise((resolve,reject) => {
        setTimeout(() => {
            console.log("Taca taca taca taca....");
            resolve(nombre);
            //reject("Reventando");
        }, 1000);
    });
}

async function chao(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Chao, ${nombre}`);
            resolve();
        }, 1000);
    });
}


async function main() {
    await hola("Ricardo");
    await hablar("Ricardo");
    await hablar("Ricardo");
    await hablar("Ricardo");
    await hablar("Ricardo");
    await hablar("Ricardo");
    await chao("Ricardo");
}

main();