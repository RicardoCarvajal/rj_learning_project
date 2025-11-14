//!var ya no se debe usar esta obsoleto
//!utilizamos let para las variables
//!y const para las constantes

const firstname: string = "Ricardo" //Si deseamos ver el tipo de datos de las constantes debemos hacerlos explicitamente de esta manera, con let no es necesario
const lastname: string = "Carvajal"

console.log(firstname, lastname)
const containsLetterR = firstname.includes('R')

let diceNumber = 5
diceNumber = 3

console.log({containsLetterR, diceNumber, firstname, lastname})