#Estructura de control tuplas 
#Las tuplas son como listas pero son inmutables
#En una tupla solo puedo hacer la declaracion de los elementos pero no puedo agregar elementos y no van a pode ser modificadas 
#y tampoco cuenta con los metodos de listas 
#Sin embargo si tiene algunos metodos para la busqueda de elementos
#Creo que se puede tambien usar cuando se necesita una especie de enum

numbes = (1,2,3,4,5,6,7,8,9,10,2,2)
string = ("Hola", "Mundo")

print(numbes)
print(type(numbes))

print(string)
print(type(string))

#Buscando la primera posicion de una tupla
print(string[0])

#Buscando la ultima posicion de una tupla
print(string[-1])

#Buscando la posicion de un valor en una tupla 
print(string.index("Hola"))

#Buscando cuantes veces se repite un valor en una tupla
print(numbes.count(2))

#Convertir una tupla en una lista
list = list(string)
print(list)
print(type(list))

list.append("Ricardo")
print(list)

#Ahora podemos modificar una lista en una tupla
tupla = tuple(list)
print(tupla)
print(type(tupla))