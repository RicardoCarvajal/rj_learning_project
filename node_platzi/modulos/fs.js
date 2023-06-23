const fs = require('fs').promises;

async function leer(ruta) {
    try {
        var file = await fs.readFile(ruta);
        console.log(file.toString());
    } catch (error) {
        console.log("no se pudo leer");
    }
}

async function escribir(ruta, contenido) {
    try {
        await fs.writeFile(ruta,contenido);
        console.log("escrito");
    } catch (error) {
        console.log("no se pudo escribir");
    }
}

async function borra(ruta) {
    try {
        await fs.unlink(ruta);
        console.log("borrado");
    } catch (error) {
        console.log("no se pudo borra");
    }
    
}

async function main() {
    await borra(__dirname + "/archivo.txt");
    await escribir(__dirname + "/archivo.txt", "nuevo archivo 2");   
    await leer(__dirname + "/archivo.txt"); 
}

main();







