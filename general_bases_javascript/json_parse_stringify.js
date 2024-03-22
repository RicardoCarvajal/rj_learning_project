//En esta ocacion usaremos JSON.parse y JSON.stringify para copiar objetos 
//que tienen a su vez objetos dentro. Sin que el manejo por referencia en memoria
//nos afecte

const object1 = {
    a: 'a',
    b: 'b',
    c: {
        d: 'd', e: 'e'
    }
}

//Creamos un string a partir del objeto object1 con stringify
const stringObject = JSON.stringify(object1);

//Creamos un objeto a partir del string con parse
const object2 = JSON.parse(stringObject);

console.log("Visualizando inicio de objetos")
console.log(object1);
console.log(object2);

object2.a = 'aaaaaaaa';
object2.c.d = 'dddddddd'; 

console.log("\nResultados luego de modificar el objeto numero 2")
console.log(object1);
console.log(object2);

//Vemos entonces que usando JSON.parse y JSON.stringify podemos copiar objetos
//sin que el manejo por referencia en memoria nos afecte

//Sin embargo tiene una debilidad, JSON.parse y JSON.stringify no pueden manejar los metodos
//o funciones que estan dentro de un objeto, por lo que si tenemos un objeto1 que contiene
//un metodo, esto no se podra copiar en un objeto2, lo omitira.