//Objeto literal
var ricardo = {
    //Como podemos ver podemos tener un objeto con diferentes tipos de datos 
    //Tambien podemos tener un objeto dentro de otro objeto
    //Incluso podemos tener un objeto dentro de un array
    nombre:"Ricardo",
    apellido:"Carvajal",
    edad:38,
    tienCorreo:false,
    correo:"rjsudnew@gmail.com",
    datos () {
        console.log(`La persona es ${this.nombre} ${this.apellido} y tiene ${this.edad} de edad`);
    },
    cursosAprobados: ["JavaScript","HTML","CSS"],
    aprobarCurso(curso){
        this.cursosAprobados.push(curso);
    }
}

// Usando typeof para verificar si un campo no esta definido
if (typeof(ricardo.correo) === "undefined"){
    //Acsedemos al atributo del objeto y le asignamos un valor
    ricardo.tienCorreo = false;
}else{
    ricardo.tienCorreo = true;
}

//Accediendo al atributo cursosAprobados y 
//agregando un elemento al array con el metodo push del prototipo array
ricardo.cursosAprobados.push("React");

//Sin embargo, tambien podemos usar un meodo creado dentro del objeto
//para poder hacer lo mismo

ricardo.aprobarCurso("React Native");

console.log(ricardo);
console.log(ricardo.datos());

//Objeto prototipos
function Persona(nombre,apellido,edad,cursosAprobados){
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.cursosAprobados = cursosAprobados;
    this.aprobarCursos = function(curso){
        this.cursosAprobados.push(curso);
    }
}

// Creamos una instancia del prototipo Persona
var ricardo = new Persona("Ricardo","Carvajal",38,["JavaScript","HTML","CSS"]);
ricardo.aprobarCursos("React");
console.log(ricardo);