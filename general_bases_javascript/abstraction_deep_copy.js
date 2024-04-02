const studentBase = {
    name: undefined,
    age: undefined,
    email: undefined,
    approvedCourses: undefined,
    learningPaths: undefined,
    socialMedia: {
        twitter: undefined,
        instagram: undefined,
        facebook: undefined
    }
}


//funcion para ver si algo es un objeto
function isObject(subject) {
    return typeof subject == 'object';
}

//funcion para ver si algo es un array
function isArray(subject) {
    return Array.isArray(subject);
}

function deepCopy(subject) {
    let copySubject;

    const subjectIsArray = isArray(subject);

    const subjectIsObject = isObject(subject);

    if (subjectIsArray) {
        copySubject = [];
    }
    else if (subjectIsObject) {
        copySubject = {};
    }else{
        return subject;
    }

    for (key in subject) {
        const keyIsObject = isObject(subject[key]);

        if (keyIsObject) {
            copySubject[key] = deepCopy(subject[key]);
        } else {
            if (subjectIsArray) {
                copySubject.push(subject[key]);
            } else {
                copySubject[key] = subject[key];
            }
        }
    }

    return copySubject;
}

//Copiando objeto base para hacer una "nueva instancia" del objeto con un objeto basa
const juan = deepCopy(studentBase);

//Protegiendo los campos del objeto para que no sean borrados
Object.seal(juan);

//Se comprueba que el objeto no sea un objeto al cual se puedan modificar los campos
console.log(Object.isSealed(juan));

console.log(juan);

//Pero esta forma de crear nevos objetos es un poco tediosa ya que no nos permite asignar los valores con un
//constructor, sino que se debe hacer propiedad por propiedad.