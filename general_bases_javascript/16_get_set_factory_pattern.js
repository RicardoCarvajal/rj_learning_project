//Tecnicas para fabricar objetos en JavaScript, generando proteccion para sus atributos y usando los metodos
//get y set para modificarlos.


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
        set name(newName) {
            if(newName.length != 0){
                private._name = newName;
            }else{
                console.log("El nombre no puede ser vacio")
            }
        },
        get name() {
            return private._name;
        }
    }

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
//getter y setter.
console.log(juan)
console.log("\n"+juan.name)
juan.name = "Juan Carlos Varon"
juan._name = "Juan Carlos"
console.log("\n"+juan.name)


