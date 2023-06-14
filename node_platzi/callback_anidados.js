///Inicio de declaracion
function hola(nombre, callBackDeHola) {
    setTimeout(() => {
        console.log(`Hola, ${nombre}`);
        callBackDeHola(nombre);
    }, 1000);
}


function hablar(callBackHablar) {
    setTimeout(() => {
        console.log("Taca taca taca taca....");
        callBackHablar();
    }, 1000);
}

function conversacion (nombre, veces, callBackDeConversacion) {
    if(veces > 0){
        hablar(() => {
            conversacion(nombre,--veces,callBackDeConversacion);
        });
    }else{
        chao(nombre, callBackDeConversacion);
    }
}

function chao(nombre, callBackDeChao) {
    setTimeout(() => {
        console.log(`Chao, ${nombre}`);
        callBackDeChao();
    }, 1000);
}


///Inicio de llamado
console.log("Iniciando proceso");

hola("Ricardo", (nombre) => {
    conversacion(nombre, 3, () => {
        console.log(`Termino el proceso ${nombre}`);
    });
});



//callBackHell
/*
hola("Ricardo",(nombre) => {
    hablar(()=>{
        hablar(()=>{
            hablar(()=>{
                chao(nombre,() => {
                    console.log(`Termino el proceso ${nombre}`);
                });
            });
        });
    });
});
*/