// En javascript, los parámetros por defecto son valores que se asignan cuando no se especifica un valor.
// Ellos estan disponibles desde ECMAScript 6.

function newUser(name = 'Ricardo', age = '40', country = 'VE') {
    console.log(name, age, country);
}

newUser();
newUser('Juan', '25', 'CO');