//! Funciones normales
function greet(name:string): string{ // tipeamos tanto los parametros de la funcion como el retorno
    return `Hola ${name}`
}

const result_1 = greet('ironman')

console.log({result_1})

//! Funciones de flecha o lambdas

const greet_lambda_01 = (name:string):string => {
    return `Hola ${name}`
}

const result_2 = greet_lambda_01('Thor')

console.log({result_2})

//Podemos simplificar la funcion pero cuando lo hacemos tenemos que tomar en cuenta que la funcion de flecha solo debe retornar algo
const greet_lambda_02 = (name:string):string => `Hola ${name}`

const result_3 = greet_lambda_02('Tanos')

console.log({result_3})

//-------------------------------------------------

interface User {
    uid:string;
    username:string;
}

const getUser01 = ():User => {// Para tipear el retorno de una funcion que retorna un objeto se usan las interfaces
    return {
        uid: 'A23-0912',
        username: 'rcarvajal'
    };
}

const user_01 = getUser01();

console.log({user_01})

//Para simplificar una funcion de flecha que retorna un objeto debemos hacer lo siguiente

const getUser02 = ():User => ({ //Lo que se retorna se coloca entre parentecis
        uid: 'A23-0912',
        username: 'rcarvajal'
    })

const user_02 = getUser02();

console.log({user_02})

//! Las funciones de flecha se pueden usar en los callbacks como eln la funcion forEach de un arry

const array_example:number[] = [1,2,3,4,5,6]

array_example.forEach((value)=>console.log({value})) //Tambien podria usar una funcion tradicional, pero es mas facil con una funcion de flecha

array_example.forEach(console.log) //Tambien podemos hacer esto para pasar todos los argumentos a la funcion 
                                   //Hacer esto seria igual que esto (value, index, array) => console.log(value, index, array)