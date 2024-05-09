#manejo de listas en python

numbers_alternative = [1,2,3,4]
numbers = [1,2,3,4]
print(numbers)
print(type(numbers))

#Puedo tener listas de diferentes tipos

types = [2,True,4,"hola"]
print(types)
print(type(types))

#Podemos buscar entre los elementos de una lista de la siguiente manera

print(types[1])

#Asi tambien puedo modificar los elementos de una lista

types[1] = False

print(types)

#Tambien podemos buscar valores de los elementos de la siguiente manera

print(False in types)#Busaca si existe este valor booleano dentro de la lista
print(2 in types)#Busca si existe el valor 2 en la lista

#Metodos fe listas

#Append agregar al final de la lista

numbers.append(18)

print(numbers)

#Insert agregar en una posicion en la lista

numbers.insert(0,23)#En primer parametro es la posicion en donde lo quiero guardar y el segundo parametro es el dato que quiero guardar

print(numbers)

#Fucionar dos listas

new_numbers_list = numbers + numbers_alternative

print(new_numbers_list)

#Saber en que posicion esta un valor, retorna la primera posicion con la cual coincide el valor

print(new_numbers_list.index(2))

#Remover el valor de una lista
new_numbers_list.remove(23)

print(new_numbers_list)

#Remover el ultimo elemento de la lista
new_numbers_list.pop()

print(new_numbers_list)

#Con pop tambien puedo eliminar una pocicion indicada
new_numbers_list.pop(2)

print(new_numbers_list)

#Cambiar en reversa el orden del array

new_numbers_list.reverse()

print(new_numbers_list)

#Ordenar la lista esto sirve para todo tipo de datos, los ordena por defecto en orden asendente, pero cuando tenemos listas con tipos de valores 
#combinados el metodo dara un error

new_numbers_list.sort()

print(new_numbers_list)

