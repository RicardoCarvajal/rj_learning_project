//Tecnicas para fabricar objetos en JavaScript

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
    return {
        name,
        email,
        age,
        approvedCourses,
        learningPaths,
        socialMedia: {
            twitter,
            instagram,
            facebook
        }
    }
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

console.log(juan)

