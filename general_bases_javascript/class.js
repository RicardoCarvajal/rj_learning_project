//Las clases en javascript tambien son prototipos pero simplemente
//con otra sintaxis

class StudentA{

    constructor(name, age, cursosAprobados){
        this.name = name;
        this.age = age;
        this.cursosAprobados = cursosAprobados;
    }

    aprobarCurso(curso){
        this.cursosAprobados.push(curso);
    }

}

const ricardo = new StudentA("Ricardo", 25, ["Javascript a profundidad"]);

ricardo.aprobarCurso("React priperos pasos");

console.log(ricardo);

//Tambien podemos usar una sintaxis diferente para la definicion de los parametros
//del constructor de la clase

class StudentB{

    constructor({
        name,
        age,
        cursosAprobados
    }){
        this.name = name;
        this.age = age;
        this.cursosAprobados = cursosAprobados;
    }

    aprobarCurso(curso){
        this.cursosAprobados.push(curso);
    }
}

// Por argumento solo se pasa un objeto, el cual tiene los atributos necesarios sin importar el orden
//esto cual facilita el trabajo


const emily = new StudentB({
    age: 25,
    name: "Emily",
    cursosAprobados: ["Javascript a profundidad"]
});

emily.aprobarCurso("ES6 a fondo");

console.log(emily);