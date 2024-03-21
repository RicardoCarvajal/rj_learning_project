 //Ejemplo de herencia y polimorfismo en javaScript extendiendo de clase padre

 class Student{

    constructor({
        name,
        age,
        coursesApproved = []
    }){
        this.name = name;
        this.age = age;
        this.coursesApproved = coursesApproved; 
    }

    printCommentStudet(comment){
        const commentStudent = new Comment({
            comment,
            student: this.name,
        });

        commentStudent.printComment();

    }
}

class Course{
    constructor({
        name,
        isFree,
        lang
    }){
        this.name = name;
        this.isFree = isFree;
        this.lang = lang;        
    }

}

class Comment{
    constructor({
        comment,
        student,
        typeStudent = "Normal"
    }){
        this.comment = comment;
        this.student = student;
        this.typeStudent = typeStudent;
    }

    printComment(){
        console.log(`tipo de estudiante ${this.typeStudent}`);
        console.log(`comentario del estudiante ${this.student}`);
        console.log(this.comment);
    }
}

class StudentFree extends Student{
    constructor(props){
        super(props);
    }

    approveCourse(course){
        if (course.isFree && course.lang === "spanish") {
            this.coursesApproved.push(course);
        } else {
            console.error(`El curso ${course.name} debe ser gratuito y solo puede añadir cursos en español`);
        }
        
    }

}

class StudentBasic extends Student{
    constructor(props){
        super(props);
    }

    approveCourse(course){
        if (course.lang === "spanish") {
            this.coursesApproved.push(course);
        } else {
            console.error(`El curso ${course.name} debe ser en español`);
        }
        
    }   

}

class StudentExpert extends Student{
    constructor(props){
        super(props);
    }

    approveCourse(course){
        this.coursesApproved.push(course);
    }

    //Haciendo polimorfismo en javaScript extendiendo de clase padre y sobreescribiendo el metodo
    //printCommentStudet dandole asi varias formas a este 
    printCommentStudet(comment){
        const commentStudent = new Comment({
            comment,
            student: this.name, 
            typeStudent: "Expert"  //Esto es un polimorfismo, esto es un ejemplo de polimorfismo en javaScript extendiendo de clase padre
        });

        commentStudent.printComment();

    }

}


const student = new StudentBasic({  
    name: "Juan",
    age: 20,
    coursesApproved: []
});

student.approveCourse(new Course({
    name: "CSS Basico",
    isFree: true,
    lang: "english"
}));

student.printCommentStudet("Muy bueno el curso gracias por el aporte");

console.log(student);
console.log(student.__proto__);