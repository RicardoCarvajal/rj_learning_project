console.log("LOG")
console.info("INFO")
console.debug("DEBUG")
console.warn("WARN")
console.error("ERROR")

var tabla = [{a:1,b:"z"},{a:2,b:"x"},{a:3,b:"y"}]

console.log(tabla);
console.table(tabla);

console.group("Conversación:")
console.info("Hola")
console.info("Bla Bla Bla Bla....")
console.info("Chao")
console.groupEnd("Conversación:")

console.info("Otro proceso")

for (let index = 0; index < 10; index++) {
    console.count("Intento")    
}
