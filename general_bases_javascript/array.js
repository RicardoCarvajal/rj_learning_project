var frutas = ["manzana", "peras", "naranjas"];

console.log(frutas);

console.log(frutas.length);

console.log(frutas[2]);

var longitud = frutas.push("aguacate"); //añade de ultimo

console.log(frutas);
console.log(longitud);

var ultimo = frutas.pop("aguacate");//elimina el ultimo

console.log(frutas);
console.log(ultimo);

var longitud = frutas.unshift("platano");//añade de primero

console.log(frutas);
console.log(longitud);

var ultimo = frutas.shift("platano");//elimina el primero

console.log(frutas);
console.log(ultimo);

var posicion = frutas.indexOf("naranjas");

console.log(posicion);

var frutasAcumuladas = [["manzana", "peras", "naranjas"],["manzana", "peras", "naranjas"],["manzana", "peras", "naranjas"]];

console.log(frutasAcumuladas);


