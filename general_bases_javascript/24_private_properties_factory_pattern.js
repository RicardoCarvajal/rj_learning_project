//Tecnicas para fabricar objetos en JavaScript, generando proteccion para sus atributos

function createStudent({
    name = requieredParam("name"),//para hacer campos obligatorios
    email = requieredParam("email"),
    age = requieredParam("age"),
    twitter,
    instagram,
    facebook,
    approvedCourses = [],
    learningPaths = []
} = {}) {

    //Funcion para indicar cuales son los campos privados 
    const private = {
        _name: name
    }

    //Funcion para indicar cuales son los campos publicos
    const public = {
        email,
        age,
        approvedCourses,
        learningPaths,
        socialMedia: {
            twitter,
            instagram,
            facebook
        },
        changeName(newName) {
            private._name = newName;
        },
        readName() {
            return private._name;
        }
    }

    //Sin embargo, hay una debilidad y es que podriamos modificar las funciones juan.readName y juan.changeName
    //por lo cual debemos solucionar esto de la siguiente manera

    //Con el siguiente codigo evitamos que se puedan modificar las funciones de juan.readName y juan.changeName
    Object.defineProperty(public, "readName", {
        writable: false,
        configurable: false
    });
    Object.defineProperty(public, "changeName", {
        writable: false,
        configurable: false,
    });

    return public
}

function requieredParam(param) {
    throw new Error(param + ' is required');
}

const juan = createStudent(
    {
        name: "Juan",
        email: "juanperez@correo.com",
        age: "23",
        twitter: "juanperez",
        instagram: "@juanperez",
        approvedCourses: ["JavaScript"],
        learningPaths: ["React"]
    }
)

//Como vemos no podemos acceder a los atributos privados directamente, solo podemos modificarlos mediante las funciones publicas como
//juan.changeName("Juan Carlos");
console.log(juan)
juan.name = "Juan Carlos"
juan._name = "Juan Carlos"
console.log("\n"+juan.readName())
juan.changeName("Juan Carlos");
juan.readName = function() {
    return "Juan el Loco"
}
console.log("\n"+juan.readName())
