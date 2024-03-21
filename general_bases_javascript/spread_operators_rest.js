// Spread operator -- operador de propagación
// Es una forma de expandir o descomponer un arreglo o un objeto

let person = {name: 'Juan', age: 25};
let country = 'MX';
let data = {id: 1, ...person, country};

console.log(data);

// rest

function sum(num, ...values) {
    console.log(values);
    console.log(num + values[0]);
    return num + values[0];
}

sum(1, 1, 2, 3);