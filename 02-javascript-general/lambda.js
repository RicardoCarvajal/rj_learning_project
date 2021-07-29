//1

var suma = (numero1, numero2) => numero1+numero2;

console.log("Primera funcion Suma: ", suma(1,1));

//2
var suma = (numero1, numero2) => console.log("Segunda funcion Suma: ", numero1+numero2);

suma(2,3);

//3
var varias_operaciones = (numero1, numero2) => {

    console.log("Tercera funcion varias_operaciones para los numeros: ",numero1 +" y "+ numero2);

    console.log("Resta: ", numero1-numero2);

    console.log("Suma: ", numero1+numero2);

    console.log("Multiplicación: ", numero1*numero2);

    console.log("Divición: ", numero1/numero2);

}

varias_operaciones(3,3);

//4
var varias_operaciones = (numero1, numero2) => {

    console.log("Cuarta funcion varias_operaciones para los numeros: ",numero1 +" y "+ numero2);

    console.log("Resta: ", numero1-numero2);

    console.log("Suma: ", numero1+numero2);

    console.log("Multiplicación: ", numero1*numero2);

    console.log("Divición: ", numero1/numero2);

    return numero1%numero2;

}

console.log("Retornando residuo: ",varias_operaciones(3,3)); 

//5
var sumas = (numero1, numero2 ,callback) => {

    console.log("Quinta funcion sumas de residuos para los numeros: ",numero1 +" y "+ numero2);

    return numero1 + callback(numero1,numero2);
}

console.log("Suma: ",  sumas(2,3,(numero1,numero2) => numero1%numero2));


