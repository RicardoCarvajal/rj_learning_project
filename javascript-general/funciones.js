//DECLARATIVA (a ellas se le aplica hoisting), es decir que la podemos usar primero y declarar despues

//Asi

function miFuncion1(){
 return 3;
}

miFuncion1();

//Y asi es lo mismo

miFuncion1();

function miFuncion1(){
    return 3;
   }

//EXPRESION o ANONIMAS

var miFuncion2 = function (a,b) {
    return a+b;
}

miFuncion2(2,3);



   
   