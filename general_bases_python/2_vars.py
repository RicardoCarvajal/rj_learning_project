#Por lo visto las variables en python son debilmente tipadas, es decir que no se puede cambiar el tipo de dato de una variable.

var_name = "Juan"
print(var_name)

var_age = 23
print(var_age)

#Sobrescribiendo el valor de una variable
var_name = "Maria"
print(var_name)

#Tambien podemos manejar una entrada en consola facilmente
#cabe destacar que la funcion input() retorna siempre un string aun que se le pase un numero o un booleano
var_name = input("Ingrese su nombre: ")
print(var_name)