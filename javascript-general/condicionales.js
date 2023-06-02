// Operador ternario como sustitucion del if (no muy recomendable)

/*
? esto es igual a entonces
: esto es igual a sino
*/

var numero = 1;

var resultado = numero === 1 ? "Si es uno":"no es uno";

console.log(resultado);


// switch

var article = 'computadora';

switch (article) {
    case 'computadora':
        console.log("Con mi computadora puedo programar usando JavaScript");
        break;

    case 'celular':
        console.log("En mi celular puedo aprender usando la app de Platzi");
        break;

    case 'cable':
        console.log("¡Hay un cable en mi bota!");
        break;

    default:
        console.log("Artículo no encontrado");
        break;
}