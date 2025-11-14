const firstname: string = 'Ricardo'
const lastname: string = "O 'Neal" //Cuando tenemos un nombre con apostrofe podemos solventar esto colocando el texto con doble comillas
const fullName: string = `El nombre ${firstname} ${lastname}` //Tambien podemos usar templates literales en los string 

let texWelcome = `
Bienvenidos a las bases de Javascript
Con Typescript
` //Tambien puedo crear texto multilinea con los template strings

console.log({firstname,lastname})
console.log({fullName})
console.log({texWelcome})

