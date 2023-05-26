//La coercion es la conversion del tipo de datos de un valor de manera implicita o explicita


//Implicita

var a = 4 + "7";

typeof a;

console.log(a);//resultado 47 (convierte el 4 de tipo numerico a string implicitamente y hace una concatenacion)

var b = 4 * "7";

typeof b;

console.log(b);//resultado 28 (convierte el 7 de tipo string a numerico implicitamente y hace una multiplicacion)

//Explicita

var c = 20;

typeof c;

var d = String(c);//Forzamos con una convercion explicita el valor numerico a string

typeof d;

var e = Number(d);//Explicitamente hacemos la convecion contraria

typeof e;
