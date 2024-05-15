#Estructura de conjuntos en Python

#Se pueden modificar
#No tienen orden
#No se permiten duclicados

country = {"col", "mex", "bol","bol"}
# La diferencia con el diccionario es que no tiene clave valor
#Automaticamente elimina los elementos duplicados
print(country)
print(type(country))

numbers = {1,2,3,1,2,3}
print(numbers)
print(type(numbers))

#Tambien puedo combinar los tipos de datos
types = {1,2,3,False,"hola"}
print(types)
print(type(types))

#Crear un conjunto a partir de un string
word = "Hola"
setWord = set(word)
print(setWord)
print(type(setWord))

#Crear un conjunto a partir de una tupla
tupla = (1,2,3,1,2,3)
setTupla = set(tupla)
print(setTupla)
print(type(setTupla))

#Crear un conjunto a partir de una lista
lista = [1, 2, 3, 1, 2, 3]
setLista = set(lista)
print(setLista)
print(type(setLista))
#Los puedo pasar de nuevo a una lista
lista = list(setLista)
print(lista)
print(type(lista))
