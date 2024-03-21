//En este archivo podemos ver como usar las clases para usarlas dentro de otras clases
//y de esta manera generar una abstraccion en el codigo.
//Adicionalmente hacemos brevemente del uso de los metodos get y set en la clase school
//a fin de desmostrar su uso

class Student{

    constructor({
        name,
        age,
        coursesApproved = [],
        schools = []
    }){
        this.name = name;
        this.age = age;
        this.coursesApproved = coursesApproved;
        this.schools = schools; 
    }

    approveCourse(course){
        this.coursesApproved.push(course);
    }

    addSchool(school){
        this.schools.push(school);
    }
}

class School{
    constructor({
        name,
        courses = [],
    }){
        this._name = name;
        this.courses = courses;
    }

    addCourses(course){             
        this.courses.push(course);
    }

    //Realmente podriamos acceder al atributo sin estos metodos
    //pero digamos que tendria que ser como una convencion entre
    //un equipo, acceder al atributo por sus metodos set and get

    get name(){
        return this._name;
    }   

    set name(newName){
        this._name = newName;
    }
}


class Course{
    constructor({
        name,
        classes = [],
    }){
        this.name = name;
        this.classes = classes;
    }

    addClasses(clazz){
        this.classes.push(clazz);
    }
}

class Clazz{
    constructor({
        name,
        difficulty
    }){
        this.name = name;
        this.difficulty = difficulty;
    }
}

const classJavaScript1 = new Clazz({
    name: "Tipos de datos en javascript",
    difficulty: "basico"
});


const classJavaScript2 = new Clazz({
    name: "Ciclos en javascript",
    difficulty: "Medio"
});


const classJavaScript3 = new Clazz({
    name: "Objetos en javascript",
    difficulty: "Medio"
});

const classJavaScript4 = new Clazz({
    name: "Clase en javascript",
    difficulty: "Avanzado"
});

const classJavaScript5 = new Clazz({
    name: "Funciones en javascript",
    difficulty: "Avanzado"
})

const courseJavaScript = new Course({
    name: "Javascript Basico",
    classes: [classJavaScript1, classJavaScript2, classJavaScript3, classJavaScript4, classJavaScript5]
});

const classCss1 = new Clazz({
    name: "CSS primeros pasos",
    difficulty: "basico"
});

const classCss2 = new Clazz({
    name: "CSS maquetado",
    difficulty: "Medio"
});

const courseCss = new Course({
    name: "CSS Basico",
    classes: [classCss1, classCss2]
});

const classEnv = new Clazz({
    name: "Configuracion de ambiente de desarrollo web",
    difficulty: "Basico"
});


courseJavaScript.addClasses(classEnv);
courseCss.addClasses(classEnv);

const schoolDevWeb = new School({
    name: "Escuela de programacion web",
    courses: [courseJavaScript, courseCss]
});

//Usando get y set para cambiar el nombre de la escuela y consultar el cambio
console.log(schoolDevWeb)
console.log("Modificando nombre de escuela")
schoolDevWeb.name = "Escuela de Desarrollo Web"
console.log(schoolDevWeb.name)

const ricardo = new Student({
    name: "Ricardo",
    age: 25,
    coursesApproved: ["Javascript Basico"],
    schools: [schoolDevWeb]
});


ricardo.approveCourse("CSS Basico");

console.log("DATOS DE ESTUDIANTE\n");
console.log(ricardo);
console.log("\nDATOS DE ESCUELA\n");
ricardo.schools.forEach(school => {
    school.courses.forEach(course => {
        console.log(`${course.name.toUpperCase()} cantidad de clases (${course.classes.length}):`);
        course.classes.forEach(clazz => {
            console.log(`     -${clazz.name}`);
        });
    });
});

let nombre = "ricardo carvajal fuentes";