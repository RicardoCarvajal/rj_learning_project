//Como todo node es monohilo se tienen que tener mucho cuidado, porque a la hora de que reviente algo parara toda la aplicacion 
// Node maneja un hilo principal que gestiona todo a travez de un pool thread lo que lo hace asincrono y rapido, pero
// todo eso se maneja desde un solo hilo principal


console.log("Hola mundo node");

var i = 1;
setInterval(function () {
    
    console.log("Ejecutando: " + i);
    if(i === 5){
        var result = 5 + z;// Aca forzamos el erro para demostrar que se cae todo si hay un error fatal en nuestra aplicacion
    }
    i++;

},3000);

var e = 1;
setInterval(function () {
    
    console.log("Ejecutando otro: " + e);
    
    e++;

},1000);


console.log("Hola mundo node otra vez");