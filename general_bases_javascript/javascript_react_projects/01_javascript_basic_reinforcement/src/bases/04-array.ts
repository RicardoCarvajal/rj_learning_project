const example_array_01:number[] = [1,2,3,4]

const example_array_02 = [... example_array_01] //Usamos los corchetes con esos tres puntos para romper el manejo por referencias

const example_array_03 = structuredClone(example_array_01) // Es mejor usar el metodo structureClone para evitar las referencias de los arreglos de tipo objero

example_array_02.push(5) //para añadir elemento al array se usa el metodo push
example_array_03.push(5)
example_array_03.push(6)

console.log({example_array_01,example_array_02,example_array_03})