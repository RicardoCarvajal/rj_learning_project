//El deep copy es una tecnica que podemos utilizar para
//copiar objetos que contengan objetos dentro de ellos y metodos
//sin que nos afecte el tema de el manejos de objetos por referencia
//y la omicion de los metodos dentro de los objetos.

const object1 = {
    a: 'a',
    b: 'b',
    c: {
        d: 'd', e: 'e'
    },
    editLetterA(){
        this.a = 'A';
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

const object2 = deepCopy(object1);

console.log("Visualizando inicio de objetos")
console.log(object1);
console.log(object2);

object2.a = 'aaaaaaaa';
object2.c.d = 'dddddddd'; 

console.log("\nResultados luego de modificar el objeto numero 2")
console.log(object1);
console.log(object2);
