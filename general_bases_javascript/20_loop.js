var nombres = ["Ricardo", "Emma", "Eimy", "Emily"];

console.log(nombres);

function saludarPersona(nombre) {

    console.log("Lista 1");

    nombre.forEach(element => {
        console.log(`Hola, ${element}`);    
    });

    console.log("Lista 2");

    for (var element of nombre) {
        console.log(`Hola, ${element}`);    
    }

    console.log("Lista 3");
    for (let index = 0; index < nombre.length; index++) {
        console.log(`Hola, ${nombre[index]}`);    
        
    }

    console.log("Lista 4");
    for (var key in nombre) {
        if (Object.hasOwnProperty.call(nombre, key)) {
            var element = nombre[key];
            console.log(`Hola, ${element},${key}`);                
        }
    }

    console.log("Lista 5");
    while (nombre.length > 0) {
        console.log(`Hola, ${nombre[0]}`);   
        nombre.shift();        
    }


}

saludarPersona(nombres);

console.log(nombres);


function solution(estudiantes, deathCount, nuevo) {
   
    var estudiantesTmp = [];

    estudiantes.forEach(element => {
        estudiantesTmp.push(element);
    });

    if(deathCount > 0){

        for (let index = 0; index < deathCount; index++) {
            estudiantesTmp.pop();        
        }

    }

    estudiantesTmp.push(nuevo);

    return estudiantesTmp;

  }

  console.log("Practica 1");
  solution(["Nico", "Zule"], 0, "Santi")
  console.log("Practica 2");
  solution(["Juan", "Juanita", "Daniela"], 1, "Julian");
  console.log("Practica 3");
  solution(["Nath", "Luisa", "Noru"], 2, "Cami")
