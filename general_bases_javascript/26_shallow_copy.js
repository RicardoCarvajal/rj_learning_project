//De la siguiente manera podemos copiar un objeto sin que la modificacion
//de uno afecte al objeto copiado y biceversa
//sin embargo esta manera no abarca cuando tenemos un objeto dentro de esos objetos
const object1 = {
    a: 'a',
    b: 'b',
    c: {
        d: 'd', e: 'e'
    }
}

const object2 = {}

//Con esta manera copiamos el objeto object1 en object2
for (prop in object1) {
    object2[prop] = object1[prop]
}

//Con esta manera copiamos el objeto object1 en object3 (una segunda manera)
const object3 = Object.assign({},object1);

//Con esta manera copiamos el objeto object1 en object4 (una tercera manera)
const object4 = Object.create(object1);

console.log("Visualizando inicio de objetos")
console.log(object1);
console.log(object2);
console.log(object3);
console.log(object4.__proto__);//El objeto 1 se copia dentro de __proto__ del objeto 4

object2.a = 'aaaaaaaa';//Esto solo afecta al objeto 2
object2.c.d = 'dddddddd'; //Esto afectara todos los objetos

console.log("\nResultados luego de modificar el objeto numero 2")
console.log(object1);
console.log(object2);
console.log(object3);
console.log(object4.__proto__);

//Como vemos por esta via no se puede solucionar el tema del copiado por referencia de un objeto dentro de un objeto
//Para esto se debe usar JSON.parse y JSON.stringify

