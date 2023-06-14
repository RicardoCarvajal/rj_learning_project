var persona = {
    nombre:"Ricardo",
    apellido:"Carvajal",
    edad:38,
    tienCorreo:false,
    correo:"rjsudnew@gmail.com",
    datos () {
        console.log(`La persona es ${this.nombre} ${this.apellido} y tiene ${this.edad} de edad`);
    }
    
}

if (typeof(persona.correo) === "undefined"){
    persona.tienCorreo = false;
}else{
    persona.tienCorreo = true;
}

console.log(persona);
console.log(persona.datos());

