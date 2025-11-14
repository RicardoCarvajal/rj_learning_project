//! La destructuracion es desarmar un elemento

const heroNames: string[] = ['ironman','thor','hulk','spiderman'] 

const [H1, H2] = heroNames //En la destructuracion de arrays si importa el orden de los elementos

const [,,H3] = heroNames //Por lo tanto si queremos solo un elemanto del array debemos respetar su posicion delimitandolo con una coma

console.log({H1,H2,H3})

// Tambien podemos hacer la destructuracion con el retorno de una funcion teniendo algo semejante a una tupla

const returnArrayHeroFunction = () => {
    return ['ironman',100] as const //Las palabras as const indican que la funcion siempre retornara un strin en su primer valor y un numero en el segundo valor
}

const [name, capability] = returnArrayHeroFunction()

console.log({name,capability})