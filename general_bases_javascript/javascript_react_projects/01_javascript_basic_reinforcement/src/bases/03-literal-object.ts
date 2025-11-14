const superman = {
    firstName: 'Clark',
    lastName: 'Ken',
    age: 60
}

superman.firstName = 'Kal' //Podemos cambiar las propiedades de la costante pero no podemos cambiar el objeto entero ya que el objeto es la costante
superman.lastName = 'El'


const shazam = {
    firstName: 'Billy',
    lastName: 'Batson',
    age: 32
}

console.log(superman,shazam)

// superman = shazam (no podemos hacer esto porque el objeto es la constante)

//! Tambien existe el manejo de objetos por referencia
const ironman = {
    firstName: 'Tonny',
    lastName: 'Stark',
    age: 60
}

const spiderman = ironman

spiderman.firstName = 'Peter' //Aunque solo modificamos las propiedades de la costante spiderman, esto modifica tambien las propiedades de la costante ironman porque ocupan el mismo espacio en memoria
spiderman.lastName = 'Parker'
spiderman.age = 22

console.log(ironman,spiderman)

//! Como rompemos las referencias
const thor = {
    firstName: 'Thor',
    lastName: 'Odinson',
    age: 60,
    phone:{
        code: '+51',
        numbre: 25411255
    }
}

const hulk = {... thor} //con esto puedo ronper la referencia pero solo con los campos que no son objetos, los campos como phone por ser un objeto dentro de un  objeto no rompe esa referencia del objeto anidado

hulk.firstName = 'Bruce' 
hulk.lastName = 'Banner'
hulk.age = 60
hulk.phone.code = '+48'

console.log(thor,hulk)

//! Para poder clonar el objeto y no tener problemas con las referencias anidadas podemos usar la funcion structuredClone

const blackwidow = {
    firstName: 'Natasha',
    lastName: 'Romanoff',
    age: 50,
    phone:{
        code: '+51',
        numbre: 25411255
    }
}

const antman = structuredClone(blackwidow)

antman.firstName = 'Scott' 
antman.lastName = 'Lang'
antman.age = 60
antman.phone.code = '+56'

console.log(blackwidow,antman)

//! En este caso es util tener interfases

interface Person { //Por convencion las interfaces siempre deben ser en upper camel case
    firstname: string;
    lastname: string;
    age: number
    phone?: Phone//El signo de interrogacion indica que este campo de la interface es opcional, adicionalmente puedo tener interfaces anidadas para un mayor orden en mi codigo    
}

interface Phone {
    code: string;
    number: number;
}

const capitanamerica: Person = {
    firstname: "Steve",
    lastname: "Rogers",
    age: 80
}

console.log(capitanamerica)