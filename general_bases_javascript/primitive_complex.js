// Los datos primitivos son inmutables lo que quiere
// decir que no se pueden cambiar.
// Por lo cual si necesitamos usarlos dentro de una 
// funcion no podremos modificarlos por referencia
// sino quetendriamos que tener un return el cual nos de otro valos

let personPrimitive = 'Ricardo'

console.log('Antes de usar la funcion = ' + personPrimitive);

function changePrimitive(params) {
    params = "juan";
}

changePrimitive(personPrimitive);

console.log('Luego de usar la funcion = ' + personPrimitive);

// Los tipos de datos complejos como los objetos
// son mutables lo que quiere decir, que sus valores
// pueden ser modificados por referencia.

let personObject = {
    nombre: "Ricardo"   
}   

console.log('Antes de usar la funcion = ' + personObject.nombre);

function changeObject(Object) {
    Object.nombre = "juan";
}

changeObject(personObject);

console.log('Luego de usar la funcion = ' + personObject.nombre);