//Los elementos estaticos de una clase nos ayudan a 
//acceder a los metodos y propiedades de la clase
//sin necesidad de instanciar un objeto de la clase
//incluso el prototipo padre Object tiene sus propios
//metodos y propiedades estaticas las cuales podemos
//utilizar.

class Hola{

    constructor({
        nombre,
        apellido,
        saludo        
    }){
        this.nombre = nombre
        this.apellido = apellido
        this.saludo = saludo
    }

    saludar(){
        if(this.nombre !== undefined && this.apellido !== undefined && this.saludo !== undefined){
            return `Hola, ${this.saludo} ${this.nombre} ${this.apellido}`
        }else{
            return "Hola"
        }
    }

    //Metodo estatico para acceder a los metodos de la clase sin 
    //necesidad de instanciarla.
    static saludar(){
        return "Hola"
    }
}

const hola = new Hola({
    nombre: "Juan",
    apellido: "Perez",
    saludo: "Buenos Dias"
});

//Usando metodo no estatico
console.log(hola.saludar());

//Usando metodo estatico
console.log(Hola.saludar());

//Algo interesante es que podemos usar el metodo estatico
//key del prototipo padre Object para acceder pasando como
//argumento una clase y el nos dira cuales son los atributos de 
//la clase, tambien podriamos usarla con objetos literales.

console.log(Object.keys(hola));

//Los metodos estaticos mas importante del prototipo
//padre Object son:

console.log(Object.keys(hola));
console.log(Object.getOwnPropertyNames(hola));
console.log(Object.entries(hola));
console.log(Object.getOwnPropertyDescriptors(hola));

//Todos estos metodos nos dan informacion
//del objeto que le estamos pasando como argumento.
//sin embargo, el que mas nos da detalles es el metodo
//getOwnPropertyDescriptors.

//Ahora bien tenemos un metodo estatico de Object
//que nos permite modificar las propiedades de un objeto

console.log(hola);

Object.defineProperty(hola, "saludoGrande", {
    value: "Buenos Dias esperon todos pasen un excelente dia super mundial",
    writable: true, //Permite editar la propiedad si esta en true, sino no lo podemos hacer, esta propiedad se puede usar para encapsular en javascript, no importa el valor de esta propiedad siempre nos dejara eliminar el atributo con delete hola.saludoGrande
    enumerable: true, //Esta propiedad si esta en false el comportamiento que trae es que con el metodo Object.keys no se muestra, pero con los otros como Object.getOwnPropertyNames si se muestra, no importa el valor de esta propiedad siempre nos dejara eliminar el atributo con delete hola.saludoGrande y tambien nos dejara modificar el atributo 
    configurable: true //Si esta propiedad esta en false no podremos eliminar el atributo con delete hola.saludoGrande
});

console.log(hola);

//Hay otros metodos de utilidad como seal y freeze
//el primero configura todas los atributos de un objeto con la propiedad configurable en false

Object.seal(hola);
console.log(Object.getOwnPropertyDescriptors(hola));

//El segundo lo mismo pero con la propiedad writable en false tambien
Object.freeze(hola);
console.log(Object.getOwnPropertyDescriptors(hola));