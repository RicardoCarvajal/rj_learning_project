//! La destructuracion es desarmar un elemento

const person_01 = {
    name: 'Ricardo',
    age: 41,
    key: 'developer'
}

const name = person_01.name;
const age = person_01.age;
const key = person_01.key;

console.log({name,age,key})

// En las lineas anteriores hicimos una destructuracion manual por asi decirlo, pero podemos hacer esto de una manera mas simplificada

const person_02 = {
    name: 'Emily',
    age: 34,
    key: 'dancer'
}

const {name: emily_name,age: emily_age,key: emily_key} = person_02

console.log({emily_name,emily_age,emily_key})

//Tambien podemos hacer destructuracion de otra manera

interface Hero {
    name:string;
    hability:string;
    age:number;
    rank?:number;
}

const useContext = ({age,hability,name,rank = 0}:Hero) => { //Puedo hacer la destructuracion directamente en la declaracion de la funcion, podemos como lo vemos con la variable rank colocar defaults en los parametros de mi funcion
    // {age,hability,name,rank} = hero podriamos desestructurar aca si son muchos campos
    return {
        KeyName: name,
        info: {
            age_old: age, //Cuando el campo del objeto y el campo que queremos asignar podemos hacer esto y no age: age
            hability,
        },
        rank
    }
}

const ironman:Hero = {
    name: "Tony Stark",
    hability: "Fly",
    age: 50,
    rank: 100
}

const {rank,KeyName, info:{age_old}} = useContext(ironman)

console.log({rank,KeyName,age_old})